package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.interfaces.ISubsystem;
import frc.robot.models.LogDataBE;

import frc.robot.RobotMap;

/**
 * An example subsystem. Use this as a template.
 */
public class Climber extends Subsystem implements ISubsystem {
  // define class level working variables

  TalonSRX climberCan;


  // TODO: Is there a better name for these positions?
  enum ServoPosition { POSITION_0, POSITION_1 };

  ServoPosition servoPosition;

  Servo servo;

  // =====================================================================================
  // Define Singleton Pattern
  // =====================================================================================
  private static Climber _instance = new Climber();

  public static Climber getInstance() {
    return _instance;
  }

  // private constructor for singleton pattern
  private Climber() {
    climberCan = new TalonSRX(RobotMap.CLIMBER_CAN_ADDRESS);
    servo = new Servo(RobotMap.CLIMBER_SERVO_PWM_ADDRESS);
    servoPosition = ServoPosition.POSITION_0;
  }

  // =====================================================================================
  // Public Methods
  // =====================================================================================
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  // =====================================================================================
  // Special Methods for ISubsystem
  // =====================================================================================
  @Override
  public void updateLogData(LogDataBE logData) {
    // logData.AddData("Carriage: LimitSwitch",
    // String.valueOf(get_isCubeInCarriage()));
  }

  @Override
  public void updateDashboard() {
    // SmartDashboard.putString("State: Carriage",
    // get_carriageWheelsState().toString());
  }

  public void runClimberMotor(double climberMotorSpeed) {
    // TODO: Consider limiting climberMotorSpeed to some range for safety
    climberCan.set(ControlMode.PercentOutput, climberMotorSpeed);
  }

  public void toggleClimberServo() {
    if (servoPosition == ServoPosition.POSITION_0) {
      servoPosition = ServoPosition.POSITION_1;
      servo.set(1.0);
    } else if (servoPosition == ServoPosition.POSITION_1) {
      servoPosition = ServoPosition.POSITION_0;
      servo.set(0.0);
    } else {
      // TODO: Throw appropriate error if another starting servo position is found
      System.err.println("Unknown starting servo position");
    }
  }
}
