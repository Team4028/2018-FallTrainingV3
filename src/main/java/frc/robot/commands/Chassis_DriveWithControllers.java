package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Chassis;
import frc.robot.util.BeakXboxController.Thumbstick;

public class Chassis_DriveWithControllers extends Command 
{
  private Thumbstick _leftThumbstick;
  private Thumbstick _rightThumbstick;
  private Chassis _chassis = Chassis.getInstance();
  
  public Chassis_DriveWithControllers(Thumbstick leftThumbstick, Thumbstick rightThumbstick) 
  {
    requires(_chassis);
    setInterruptible(true);
    _leftThumbstick = leftThumbstick;
    _rightThumbstick = rightThumbstick;
    
  }

  
  @Override
  protected void initialize() {
  }


  @Override
  protected void execute() 
  {
    _chassis.setMotorSpeed(_leftThumbstick.getY(), _rightThumbstick.getX());
  }

  
  @Override
  protected boolean isFinished() 
  {
    return false;
  }

  
  @Override
  protected void end() 
  {
  }

  @Override
  protected void interrupted() 
  {
  }
}
