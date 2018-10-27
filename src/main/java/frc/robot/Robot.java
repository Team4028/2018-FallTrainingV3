/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.util.BeakUtilities;
import frc.robot.util.DataLogger;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  // create instance of singelton Subsystems
  private static final String ROBOT_NAME = "2019-FallTrainingV3-CMD BASED";

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

  // ==============================================================================================
  // Autonomous Mode
  // ==============================================================================================

   /**
   * This method run 1x when the robot is enabled in auton mode
   */
  @Override
  public void autonomousInit() 
  {
   // m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  // ==============================================================================================
  // Telop Mode
  // ==============================================================================================
  
  /**
  * This method run 1x when the robot is enabled in telop mode
  */
  @Override
  public void teleopInit() 
  {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  // ==============================================================================================
  // Test Mode
  // ==============================================================================================
  
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {
  }

  // ==============================================================================================
  // Special Methods
  // ==============================================================================================
  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
  }

}