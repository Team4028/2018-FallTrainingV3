/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
// #region Import Statements
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.util.BeakUtilities;
import frc.robot.util.DataLogger;

import java.util.Date;

// #endregion

/**
 * The VM is configured to automatically run this class
 */
public class Robot extends TimedRobot 
{
  // create instance of singelton Subsystems
  private static final String ROBOT_NAME = "2019-FallTrainingV3-CMD BASED";

  private OI _oi = OI.getInstance();
  
	// class level working variables
	private DataLogger _dataLogger = null;
	private String _buildMsg = "?";

  // ==============================================================================================
  // Robot StartUp
  // ==============================================================================================

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() 
  {
    _buildMsg = BeakUtilities.WriteBuildInfoToDashboard(ROBOT_NAME);
  }

  // ==============================================================================================
  // Robot Disabled
  // ==============================================================================================

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() 
  {
  }

  @Override
  public void disabledPeriodic() 
  {
    Scheduler.getInstance().run();
  }

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {}
}