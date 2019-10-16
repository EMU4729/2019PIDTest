/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX leftMotorSlave;
  public TalonSRX leftMotorMaster;
  public TalonSRX rightMotorSlave;
  public TalonSRX rightMotorMaster;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    leftMotorSlave = new TalonSRX(RobotMap.LEFTMOTORSLAVE);
    leftMotorMaster = new TalonSRX(RobotMap.LEFTMOTORMASTER);
    rightMotorMaster = new TalonSRX(RobotMap.RIGHTMOTORMASTER);
    rightMotorSlave = new TalonSRX(RobotMap.RIGHTMOTORSLAVE);

    leftMotorSlave.changeControlMode(CANTalon.ControlMode.leftMotorMaster);
    leftMotorSlave.Set(leftMotorMaster.getDeviceID());
    rightMotorSlave.changeControlMode(CANTalon.ControlMode.rightMotorMaster);
    rightMotorSlave.set(rightMotorMaster.getDeviceID());
    
  }
}