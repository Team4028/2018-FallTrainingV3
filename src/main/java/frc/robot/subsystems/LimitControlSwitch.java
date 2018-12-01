package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class LimitControlSwitch extends Subsystem{

    
    //private TalonSRX _controlMotor;
    private VictorSPX _controlMotor;
    private static LimitControlSwitch _instance = new LimitControlSwitch();


    public static LimitControlSwitch getInstance(){
		return _instance;
	}
    
    LimitControlSwitch(){

        _controlMotor = new VictorSPX(RobotMap.LIMIT_CONTROL_MOTOR_CAN_ADDRESS);

        _controlMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0);


    }

    public void setMotorSpeed(double motorSpeed){
        _controlMotor.set(ControlMode.PercentOutput, motorSpeed);
    }

    @Override
    protected void initDefaultCommand() {

    }


}