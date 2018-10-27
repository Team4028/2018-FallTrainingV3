package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
//#endregion
import frc.robot.subsystems.Climber;

/**
 * This command implements support for toggling the position of the Climber Servo
 */
public class Climber_ToggleClimberServo extends Command 
{
    private Climber _climber = Climber.getInstance();
	
    public Climber_ToggleClimberServo() {
        // Use requires() here to declare subsystem dependencies
        requires(_climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	setTimeout(4);  // set 4 second timeout
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
        System.out.println("Here");
    	_climber.toggleClimberServo();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
      return true;
    	// either we get to target position or we timed out
   	 	//return _climber.getIsServoInPosition() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}