/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Chassis extends Subsystem 
{

    private TalonSRX _leftMotorMaster;
    private TalonSRX _leftMotorSlave;

    private TalonSRX _rightMotorMaster;
    private TalonSRX _rightMotorSlave;

    private DoubleSolenoid _shifter;   
    private static final edu.wpi.first.wpilibj.DoubleSolenoid.Value SHIFTER_LOW_GEAR_POS = DoubleSolenoid.Value.kReverse;
    private static final edu.wpi.first.wpilibj.DoubleSolenoid.Value SHIFTER_HIGH_GEAR_POS = DoubleSolenoid.Value.kForward;

    private Chassis()
    {   //left motors set
        _leftMotorMaster = new TalonSRX(RobotMap.LEFT_DRIVE_MASTER_CAN_ADDR);
        _leftMotorSlave = new TalonSRX(RobotMap.LEFT_DRIVE_SLAVE_CAN_ADDR);
        _leftMotorSlave.follow(_leftMotorMaster);
        
        //right motors set
        _rightMotorMaster = new TalonSRX(RobotMap.RIGHT_DRIVE_MASTER_CAN_ADDR);
        _rightMotorSlave = new TalonSRX(RobotMap.RIGHT_DRIVE_SLAVE_CAN_ADDR);
        _rightMotorSlave.follow(_rightMotorMaster);

        _shifter = new DoubleSolenoid(RobotMap.SHIFTER_EXTEND_PCM_PORT,RobotMap.SHIFTER_RETRACT_PCM_PORT);

        
    }
  
	private static Chassis _instance = new Chassis();
	
    public static Chassis getInstance() 
    {
		return _instance;
	}
	
    public void setMotorSpeed (double driveSpeed, double turnSpeed)
    {
        double leftSpeed = (.4 * -driveSpeed ) + (.5 * -turnSpeed);
        double rightSpeed= (.4 * driveSpeed ) + (.5 * -turnSpeed);
        //set the speed for the right chassis motor
        _rightMotorMaster.set(ControlMode.PercentOutput, rightSpeed);
        //set the speed for the left chassis motor
        _leftMotorMaster.set(ControlMode.PercentOutput, leftSpeed);
    }


    public void setHighGear()
    {
        //set the gearbox to high gear
        _shifter.set(Chassis.SHIFTER_HIGH_GEAR_POS);

    }
    public void setLowGear()
    {
        //set the gearbox to low gear
        _shifter.set(Chassis.SHIFTER_LOW_GEAR_POS);
    }

    private synchronized boolean HighGear() 
    {
		return _shifter.get() == SHIFTER_HIGH_GEAR_POS;
	}


  @Override
  public void initDefaultCommand() 
  {
    
  }
}



 