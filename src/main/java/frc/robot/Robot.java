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
import frc.robot.commands.Infeed_ArmPos;
import frc.robot.commands.Infeed_Homing;
import frc.robot.commands.Infeed_Homing;
import frc.robot.models.LogDataBE;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Infeed;
import frc.robot.subsystems.LimitSwitchMotor;
import frc.robot.util.MovingAverage;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

// #endregion

/**
 * The VM is configured to automatically run this class
 */
public class Robot extends TimedRobot 
{
	private static final String ROBOT_NAME = "2018 PowerUp (ECLIPSE)-CMD BASED";
	
	// create instance of singelton Subsystems
	private Dashboard _dashboard = Dashboard.getInstance();
	
	//private Carriage _carriage = Carriage.getInstance();
	//private Chassis _chassis = Chassis.getInstance();
	private Climber _climber = Climber.getInstance();
	private LimitSwitchMotor _limitSwitchMotor = LimitSwitchMotor.getInstance();
	private Infeed _infeed = Infeed.getInstance();
	private Chassis _chassis = Chassis.getInstance();
	//private Elevator _elevator = Elevator.getInstance();
	//private Infeed _infeed = Infeed.getInstance();
	private OI _oi = OI.getInstance();
	MovingAverage _scanTimeSamples;
	//private SwitchableCameraServer _camera = SwitchableCameraServer.getInstance();

	
	// class level working variables
	private frc.robot.util.DataLogger _dataLogger = null;
	private String _buildMsg = "?";
	
	
 	long _lastScanEndTimeInMSec = 0;
 	long _lastDashboardWriteTimeMSec;
 	//MovingAverage _scanTimeSamples;
 	
	/**
	 * This function is run when the robot is first started up and should be used for any initialization code.
	 */
	@Override
	public void robotInit() {

		_limitSwitchMotor = LimitSwitchMotor.getInstance();
		_scanTimeSamples = new MovingAverage (50);

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();

	}

	/**
	 * This method runs 1x when the robot enters auton mode
	 */
	@Override
	public void autonomousInit() {
		
		Infeed_Homing homeCMD = new Infeed_Homing(false);
		homeCMD.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(_limitSwitchMotor.LimitSwitch());
 		// ============= Refresh Dashboard =============
		outputAllToDashboard();
		
		// ============= Optionally Log Data =============
		logAllData();

		//_limitSwitchMotor.runMotorWithLimitSwitch();
	   // _limitSwitchMotor.runMotor(0.4);		

	}

	/**
	 * This method runs 1x when the robot enters telop mode
	 */
	@Override
	public void teleopInit() {
		Infeed_Homing homeCMD = new Infeed_Homing(false);
		homeCMD.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(_limitSwitchMotor.LimitSwitch());
 		// ============= Refresh Dashboard =============
		outputAllToDashboard();
		
		// ============= Optionally Log Data =============
		logAllData();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {}
	private void outputAllToDashboard() {
		// limit spamming
    	long scanCycleDeltaInMSecs = new Date().getTime() - _lastScanEndTimeInMSec;
    	// add scan time sample to calc scan time rolling average
    	_scanTimeSamples.add(new BigDecimal(scanCycleDeltaInMSecs));
    	
    	if((new Date().getTime() - _lastDashboardWriteTimeMSec) > 100) {
    		// each subsystem should add a call to a outputToSmartDashboard method
    		// to push its data out to the dashboard

    		_infeed.updateDashboard(); 
	    	
    		// write the overall robot dashboard info
	    	SmartDashboard.putString("Robot Build", _buildMsg);
	    	
	    	BigDecimal movingAvg = _scanTimeSamples.getAverage();
	    	DecimalFormat df = new DecimalFormat("####");
	    	SmartDashboard.putString("Scan Time (2 sec roll avg)", df.format(movingAvg) + " mSec");
    		// snapshot last time
    		_lastDashboardWriteTimeMSec = new Date().getTime();
    	}
    	
    	// snapshot when this scan ended
    	_lastScanEndTimeInMSec = new Date().getTime();
	}

  	/** Method for Logging Data to the USB Stick plugged into the RoboRio */
	private void logAllData() { 
		// always call this 1st to calc drive metrics
    	if(_dataLogger != null) {    	
	    	// create a new, empty logging class
        	LogDataBE logData = new LogDataBE();
	    	
	    	// ask each subsystem that exists to add its data
	    	_infeed.updateLogData(logData);
			
	    	_dataLogger.WriteDataLine(logData);
    	}
	}
}