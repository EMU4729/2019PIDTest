/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static int LEFTMOTORMASTER = 4;
  public static int LEFTMOTORSLAVE = 3;
  public static int RIGHTMOTORMASTER = 2;
  public static int RIGHTMOTORSLAVE = 1;

  public static int LEFT_JOYSTICK_Y_AXIS = 1;
  public static int RIGHT_JOYSTICK_Y_AXIS = 5;
  public static int LEFT_JOYSTICK_X_AXIS = 0;
  public static int RIGHT_JOYSTICK_X_AXIS = 4;

  public static final int KPID_LOOP_IDX = 0;

  public static final double kP = 1;
	public static final double kI = 2;
	public static final double kD = 3;
	public static final double kF = 4;
}