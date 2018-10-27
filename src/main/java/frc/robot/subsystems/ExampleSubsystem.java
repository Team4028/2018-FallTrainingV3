/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.interfaces.ISubsystem;
import frc.robot.models.LogDataBE;

/**
 * An example subsystem.  Use this as a template.
 */
public class ExampleSubsystem extends Subsystem implements ISubsystem 
{
  // define class level working variables

	//=====================================================================================
	// Define Singleton Pattern
	//=====================================================================================
	private static ExampleSubsystem _instance = new ExampleSubsystem();
	
	public static ExampleSubsystem getInstance() {
		return _instance;
	}
	
	// private constructor for singleton pattern
  private ExampleSubsystem()
  {

  }

  //=====================================================================================
	// Public Methods
	//=====================================================================================
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  //=====================================================================================
	// Special Methods for ISubsystem
	//=====================================================================================
  @Override
  public void updateLogData(LogDataBE logData) 
  {
		//logData.AddData("Carriage: LimitSwitch", String.valueOf(get_isCubeInCarriage()));
  }

  @Override
  public void updateDashboard() 
  {
		//SmartDashboard.putString("State: Carriage", get_carriageWheelsState().toString());
  }
}
