/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Arrays;
import java.util.List;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

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

    leftMotorSlave.set(ControlMode.Follower, RobotMap.LEFTMOTORMASTER);
    rightMotorSlave.set(ControlMode.Follower, RobotMap.RIGHTMOTORMASTER);

    leftMotorMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    rightMotorMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    

    setupPid(leftMotorMaster);
    setupPid(rightMotorMaster);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    leftMotorMaster.set(ControlMode.PercentOutput, leftSpeed);
    rightMotorMaster.set(ControlMode.PercentOutput, rightSpeed);
  }

  public void arcade(double speed, double turn) {
    double leftSpeed = speed - turn;
    double rightSpeed = speed + turn;

    List<Double> power = Arrays.asList(leftSpeed, rightSpeed);
                                          
    double max = power.stream().map(p -> Math.abs(p)).max((a, b) -> {
        Double difference = a - b;
        return difference.intValue();
    }).get();

    if (max > 1) {
        leftSpeed /= max;
        rightSpeed /= max;
    }

    tankDrive(leftSpeed, rightSpeed);
  }

  public void setupPid(TalonSRX motor) {
    motor.selectProfileSlot(0, 0);
    motor.config_kP(RobotMap.KPID_LOOP_IDX, RobotMap.kP);
    motor.config_kI(RobotMap.KPID_LOOP_IDX, RobotMap.kI);
    motor.config_kD(RobotMap.KPID_LOOP_IDX, RobotMap.kD);
    motor.config_kF(RobotMap.KPID_LOOP_IDX, RobotMap.kF);
    motor.configClosedloopRamp(5);
  }
}
