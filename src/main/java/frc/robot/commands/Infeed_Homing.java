package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Infeed;
import frc.robot.subsystems.LimitControlSwitch;


public class Infeed_Homing extends Command {

    private Infeed _infeed = Infeed.getInstance();
    private boolean _isForceRezero;

    public Infeed_Homing(Boolean isForceRezero ) {
        // Use requires() here to declare subsystem dependencies
        requires(_infeed);
        setInterruptible(false);
        _isForceRezero = isForceRezero;
        
    }


    @Override
    protected void initialize() {
     if(_isForceRezero == true){
         _infeed.resetZeroState();
     } 
  }


    protected void execute() {
        _infeed.homeArms();
        System.out.println("Here");

        
       
    }


    @Override
    protected boolean isFinished() {
        return _infeed.isHomeFinished();
    }

    @Override
    protected void end(){
    }
  
    @Override
    protected void interrupted(){
    }


}



