package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Climber;
import frc.robot.util.BeakXboxController.Thumbstick;

/**
 * This command implements support for toggling the position of the Climber Servo
 */
public class Climber_RunClimberMotor extends Command 
{
    private Climber _climber = Climber.getInstance();
    Thumbstick _thumbstick;
    
    public Climber_RunClimberMotor(Thumbstick thumbstick) {
        // Use requires() here to declare subsystem dependencies
        requires(_climber);

        _thumbstick = thumbstick;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	setTimeout(4);  // set 4 second timeout
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    
        double motorSpeed = _thumbstick.getY();
        System.out.println("Running climber motor with speed " + motorSpeed);
    	_climber.runClimberMotor(motorSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // We always want to run execute() in this command, so always indicate
        // that the command is not finished
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}