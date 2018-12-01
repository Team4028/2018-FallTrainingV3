
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class LimitSwitchMotor extends Subsystem { 
   
    private DigitalInput _forwardlimitSwitch;
    private TalonSRX _controlMotor;
    private DigitalInput _reverseLimitSwitch;

    private LimitSwitchMotor() {
    
         _forwardlimitSwitch = new DigitalInput(RobotMap.FORWARD_LIMIT_SWITCH_DIO_PORT);
         _reverseLimitSwitch = new DigitalInput(RobotMap.REVERSE_LIMIT_SWITCH_DIO_PORT);
         _controlMotor = new TalonSRX(RobotMap.CONTROL_MOTOR_CAN_ADDRESS);

    
    }
    
    public void setMotorSpeed(ControlMode percentoutput, double speed) {

        _controlMotor.set(ControlMode.PercentOutput, speed);

    }

    /*public void runMotorWithLimitSwitch(){

        if(LimitSwitch() == false){
           
            setMotorSpeed(.1);
        }else{
            setMotorSpeed(-.1);
        }
    }*/
    

    private static LimitSwitchMotor _instance = new LimitSwitchMotor();


    public static LimitSwitchMotor getInstance(){
        return _instance;
	}
   
    public boolean LimitSwitch(){
         
        return _forwardlimitSwitch.get();
    }

    public void runMotor(double motorSpeed){

        if(_forwardlimitSwitch.get() == true){

            setMotorSpeed(ControlMode.PercentOutput, motorSpeed);

        }else if(_reverseLimitSwitch.get() == false){

            setMotorSpeed(ControlMode.PercentOutput, motorSpeed * -1.0);

        }else{

            setMotorSpeed(ControlMode.PercentOutput, 0.0);
        }


        


    }
    
    @Override
    protected void initDefaultCommand(){

    }
} 

 






