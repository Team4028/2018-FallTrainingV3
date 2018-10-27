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
  // =============================
  // Talon Motor Controllers
  // =============================
  //public static final int CHASSIS_LEFT_DRIVE_MASTER_TALON_CAN_BUS_ID = 5;

  // =============================
  // PWM Ports
  // =============================
  //public static final int SHOOTER_SLIDER_LINEAR_SERVO_PWM_PORT = 9;

  // =============================
  // Solenoids (PCM Controller)
  // =============================
  //public static final int CHASSIS_GEARBOX_SHIFTER_HIGH_GEAR_PCM_PORT = 1;

  // =============================
  // Digital I/O
  // =============================
  //public static final int CUBE_IN_POSITION_LIMIT_SWITCH_DIO_PORT = 0;

  // =============================
  // Analog Ports
  // =============================
	//public static final int STORED_PRESSURE_SENSOR_AIO_PORT = 0;	
  
  // =============================
  // NavX (on Roborio)
  // =============================
	//public static final SPI.Port NAVX_PORT = Port.kMXP;

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
