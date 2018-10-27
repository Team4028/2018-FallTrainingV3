/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{	
	// PCM Can Bus Address
	public static final int PCM_CAN_ADDR = 0;	
	
	// Talons Can Bus Address
	public static final int LEFT_DRIVE_MASTER_CAN_ADDR = 1;
	public static final int LEFT_DRIVE_SLAVE_CAN_ADDR = 2;
	public static final int RIGHT_DRIVE_MASTER_CAN_ADDR = 3;
	public static final int RIGHT_DRIVE_SLAVE_CAN_ADDR = 4;
	public static final int LEFT_SWITCHBLADE_MOTOR_CAN_ADDRESS = 5;
	public static final int RIGHT_SWITCHBLADE_MOTOR_CAN_ADDRESS = 6;
	public static final int ELEVATOR_LIFT_MASTER_CAN_ADDRESS = 7;
	public static final int CARRIAGE_LEFT_CAN_ADDRESS = 8;
	public static final int CARRIAGE_RIGHT_CAN_ADDRESS = 9;
	public static final int RIGHT_INFEED_DRIVE_CAN_ADDRESS = 10;
	public static final int LEFT_INFEED_DRIVE_CAN_ADDRESS = 11;
	public static final int CLIMBER_CAN_ADDRESS = 12;
	
	// DIO Ports
	public static final int CARRIAGE_LIMIT_SWITCH_DIO_PORT = 0;
	
	// Analog Ports
	public static final int STORED_PRESSURE_SENSOR_AIO_PORT = 0;	
	
	// NavX (on Roborio)
	public static final SPI.Port NAVX_PORT = Port.kMXP;
	
	// PWM Ports on RoboRIO
	public static final int CLIMBER_SERVO_PWM_ADDRESS = 0;
	
	// PCM Ports
	public static final int CARRIAGE_SQUEEZE_PCM_PORT = 0;
	public static final int CARRIAGE_WIDE_PCM_PORT = 1;
	public static final int SHIFTER_EXTEND_PCM_PORT = 6;
	public static final int SHIFTER_RETRACT_PCM_PORT = 7;
	public static final int CARRIAGE_FLAP_UP_PCM_PORT = 4;
	public static final int CARRIAGE_FLAP_DOWN_PCM_PORT = 5;

  // =============================
  // Driver/Operator Station
  // =============================
  public static final int DRIVERS_STATION_DRIVER_GAMEPAD_USB_PORT = 0;
  public static final int DRIVERS_STATION_OPERATOR_GAMEPAD_USB_PORT = 1;

  // =============================
  // Onboard Vision Subsystem 
  // =============================
  public static final String VISION_SOCKET_SERVER_IPV4_ADDR = "10.40.28.xxx";
  public static final int VISION_SOCKET_SERVER_PORT = 1234;

  // =============================
	// Logging
	// this is where the USB stick is mounted on the RoboRIO filesystem.  
  // You can confirm by logging into the RoboRIO using WinSCP
  // =============================
	public static final String PRIMARY_LOG_FILE_PATH = "/media/sda1/logging";
	public static final String ALTERNATE_LOG_FILE_PATH = "/media/sdb1/logging";

}
