package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.models.LogDataBE;

public class Infeed extends Subsystem {

    private static final double leftSpeed = -.2;
    private static final double rightSpeed = -.2;
    
	private TalonSRX _infeedLeftMotor;
    private TalonSRX _infeedRightMotor;
    private Boolean _isLeftArmHomed = false;
    private Boolean _isRightArmHomed = false;
    private static final double INFEED_MOTION_MAGIC_F = 0.3354098361;
    private static final double INFEED_MOTION_MAGIC_P = 1.5;
    private static final double INFEED_MOTION_MAGIC_I = 0;
    private static final double INFEED_MOTION_MAGIC_D = 0;
    private static final int MAX_V = 3000;
    private static final int MAX_A = 2000;
    private static final double DEGREES_TO_NATIVE_UNITS_CONVERSION = (4096/360);


    private Infeed(){

        _infeedLeftMotor = new TalonSRX (RobotMap.LEFT_SWITCHBLADE_MOTOR_CAN_ADDRESS);
        _infeedLeftMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0);
        _infeedLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        _infeedLeftMotor.setSelectedSensorPosition(0, 0, 0);
        _infeedLeftMotor.config_kF(0, INFEED_MOTION_MAGIC_F, 0);
        _infeedLeftMotor.config_kP(0, INFEED_MOTION_MAGIC_P, 0);
        _infeedLeftMotor.config_kI(0, INFEED_MOTION_MAGIC_I, 0);
        _infeedLeftMotor.config_kD(0, INFEED_MOTION_MAGIC_D, 0);
        _infeedLeftMotor.configMotionAcceleration(MAX_A, 0);
        _infeedLeftMotor.configMotionCruiseVelocity(MAX_V, 0);


        _infeedRightMotor = new TalonSRX (RobotMap.RIGHT_SWITCHBLADE_MOTOR_CAN_ADDRESS);
        _infeedRightMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0);
        _infeedRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        _infeedRightMotor.setSelectedSensorPosition(0, 0, 0);
        _infeedRightMotor.setInverted(true);
        _infeedRightMotor.config_kF(0, INFEED_MOTION_MAGIC_F, 0);
        _infeedRightMotor.config_kP(0, INFEED_MOTION_MAGIC_P, 0);
        _infeedRightMotor.config_kI(0, INFEED_MOTION_MAGIC_I, 0);
        _infeedRightMotor.config_kD(0, INFEED_MOTION_MAGIC_D, 0);
        _infeedRightMotor.configMotionAcceleration(MAX_A, 0);
        _infeedRightMotor.configMotionCruiseVelocity(MAX_V, 0);

        
    }

    private static Infeed _instance = new Infeed();
	
    public static Infeed getInstance() {
		return _instance;
    }
    
    public void setMotorSpeed(ControlMode percentoutput, double speed) {
        _infeedLeftMotor.set(ControlMode.PercentOutput, leftSpeed);
        _infeedRightMotor.set(ControlMode.PercentOutput, rightSpeed);
        
    }

     //=====================================================
    //set left arm home set
    //=====================================================


    public int getLeftMotorPosNU(){
        return _infeedLeftMotor.getSelectedSensorPosition(0);
    }

    //=====================================================
    //set right arm home set
    //=====================================================
   

    public int getRightMotorPosNU(){
        return _infeedRightMotor.getSelectedSensorPosition(0);
    }


    //=====================================================
    //set both arms home set
    //=====================================================
    public boolean isHomeFinished(){

        return (_isLeftArmHomed && _isRightArmHomed);
    }

    public void homeArms(){

        //right arm home
        if (_infeedRightMotor.getSensorCollection().isRevLimitSwitchClosed() == false ){

            _infeedRightMotor.set(ControlMode.PercentOutput, 0);
            _infeedRightMotor.setSelectedSensorPosition(0, 0, 0);
            _isRightArmHomed = true;

        } else if(!_isRightArmHomed){
            _infeedRightMotor.set(ControlMode.PercentOutput, -.2); 
        }

        //left arm home
        if ( _infeedLeftMotor.getSensorCollection().isRevLimitSwitchClosed() == false ){
        
            _infeedLeftMotor.set(ControlMode.PercentOutput, 0);
            _infeedLeftMotor.setSelectedSensorPosition(0, 0, 0);
            _isLeftArmHomed = true;

        } else if(!_isLeftArmHomed){
            _infeedLeftMotor.set(ControlMode.PercentOutput, -.2);
        }
    }

    public void resetZeroState() {
        _isLeftArmHomed = false;
        _isRightArmHomed = false;

    }

    public void setArmPosDeg(double targetPosDeg){
        double targetPosNU = targetPosDeg * DEGREES_TO_NATIVE_UNITS_CONVERSION;
        _infeedLeftMotor.set(ControlMode.MotionMagic, targetPosNU);
        _infeedRightMotor.set(ControlMode.MotionMagic, targetPosNU);

    }
	
	private double nativeUnitsToDegrees(double nativeUnitsMeasure) {
		double degrees = nativeUnitsMeasure / DEGREES_TO_NATIVE_UNITS_CONVERSION;
		return degrees;
    }
    
    private double DegreesTonativeUnits(double nativeUnitsMeasure) {
		double nativeUnits = nativeUnitsMeasure * DEGREES_TO_NATIVE_UNITS_CONVERSION;
		return nativeUnitsMeasure;
	}

  

	public void updateDashboard() {
        
        //left side pos and home
        SmartDashboard.putNumber("Infeed:LeftArmPosDEG", nativeUnitsToDegrees(getLeftMotorPosNU()));
        SmartDashboard.putBoolean("Infeed:isLeftArmHomed", _isLeftArmHomed);
        SmartDashboard.putNumber("Infeed:LeftArmPosNU", getLeftMotorPosNU());
       

        
        //right side pos and home
        SmartDashboard.putBoolean("Infeed:isRightArmHomed", _isRightArmHomed);
        SmartDashboard.putNumber("Infeed:RightArmPosDEG", nativeUnitsToDegrees(getRightMotorPosNU()));
        SmartDashboard.putNumber("Infeed:RightArmPosNU", getRightMotorPosNU());

	}

	public void updateLogData(LogDataBE logData) {
	}

    @Override
    public void initDefaultCommand() {
        
    }

}