package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LimitControlSwitch;


public class LimitSwitch_Motor extends Command {
    
    private LimitControlSwitch _limitControlSwitch = LimitControlSwitch.getInstance();

    public LimitSwitch_Motor() {
        // Use requires() here to declare subsystem dependencies
        requires(_limitControlSwitch);
    }

    protected void execute() {    	
        
        System.out.println("Here");
    	_limitControlSwitch.setMotorSpeed(-.3);
    }


   
   
    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end(){
    }
  
    @Override
    protected void interrupted(){
    }


}
