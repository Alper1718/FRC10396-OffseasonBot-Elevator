// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.elevator;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.RelativeEncoder;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSensorsIO extends SubsystemBase {
  private final CANcoder cancoder;
  private final RelativeEncoder neoencoder;

  public ElevatorSensorsIO(CANcoder cancoder, RelativeEncoder neoEncoder) {
    this.cancoder = cancoder;
    this.neoencoder = neoEncoder;
  }

  public double getCANCoderPosition(){
    return cancoder.getPosition().getValue();
  }

  public double getNEOEncoderPosition(){
    return neoencoder.getPosition() * Constants.ElevatorConstants.GEAR_REDUCTION;
  }

  public void resetEncoders(){
    neoencoder.setPosition(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Elevator Neo Encoder:", getNEOEncoderPosition());
  }
}
