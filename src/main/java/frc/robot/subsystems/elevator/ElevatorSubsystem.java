// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.elevator;


import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
  private final CANSparkFlex motor1;
  private final CANSparkFlex motor2;

  public ElevatorSubsystem(int motor1ID, int motor2ID, int CANcoderID) {
    motor1 = new CANSparkFlex(motor1ID, MotorType.kBrushless);
    motor2 = new CANSparkFlex(motor2ID, MotorType.kBrushless);

    motor2.follow(motor1);
  }

  public void Move(double power){
    motor1.set(power);
  }

  @Override
  public void periodic() {
  }
}
