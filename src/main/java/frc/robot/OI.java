/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.Climber_RunClimberMotor;
import frc.robot.commands.Climber_ToggleClimberServo;
import frc.robot.util.BeakXboxController;
import frc.robot.util.BeakXboxController.Thumbstick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
  // working object
  BeakXboxController _driverGamePad;
  BeakXboxController _operatorGamepad;

	//=====================================================================================
	// Define Singleton Pattern
	//=====================================================================================
	private static OI _instance = new OI();
	
	public static OI getInstance() {
		return _instance;
	}
	
	// private constructor for singleton pattern
  public OI() {
    _driverGamePad = new BeakXboxController(RobotMap.DRIVERS_STATION_DRIVER_GAMEPAD_USB_PORT);
		_operatorGamepad = new BeakXboxController(RobotMap.DRIVERS_STATION_OPERATOR_GAMEPAD_USB_PORT);
		
		Thumbstick rightStick = _operatorGamepad.rightStick;

		_operatorGamepad.a.whenPressed(new Climber_ToggleClimberServo());
		_operatorGamepad.rightStick.whenActive(new Climber_RunClimberMotor(rightStick));
		_operatorGamepad.rightStick.whenReleased(new Climber_RunClimberMotor(rightStick));
  }
}
