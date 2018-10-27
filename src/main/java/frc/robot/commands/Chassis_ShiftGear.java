package frc.robot.commands;

//#region  == Define Imports ==

import edu.wpi.first.wpilibj.command.Command;
//#endregion
import frc.robot.subsystems.Chassis;

/**
 * This command implements support for Shifting Gears on the Drive Chassis
 */
public class Chassis_ShiftGear extends Command 
{
	
	private Chassis _chassis = Chassis.getInstance();

    public Chassis_ShiftGear() {
        // Use requires() here to declare subsystem dependencies
        requires(Chassis.getInstance());
        setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      if(!_chassis.getIsHighGear) {
      _chassis.setHighGear();
      } else {
        _chassis.setLowGear();
      }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
