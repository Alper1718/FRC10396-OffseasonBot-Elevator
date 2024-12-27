// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.elevator;


import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
  private final CANSparkFlex motor1;
  private final CANSparkFlex motor2;
  private final PIDController pidController;
  private final ElevatorSensorsIO sensors;

  public ElevatorSubsystem(int motor1ID, int motor2ID, int CANcoderID, ElevatorSensorsIO sensors) {
    motor1 = new CANSparkFlex(motor1ID, MotorType.kBrushless);
    motor2 = new CANSparkFlex(motor2ID, MotorType.kBrushless);

    motor2.follow(motor1);

    pidController = new PIDController(0.1, 0.0, 0.0); //To be calibrated...
    pidController.setTolerance(0.05);
    this.sensors = sensors;
  }

  public void moveToPosition(double targetPosition) {
    double currentPosition = sensors.getNEOEncoderPosition();
    double pidOutput = pidController.calculate(currentPosition, targetPosition);
    motor1.set(pidOutput);
    if (targetPosition > Constants.ElevatorConstants.MAX_POSITION || targetPosition < Constants.ElevatorConstants.MIN_POSITION) {
      SmartDashboard.putString("Elevator Error", "Target position out of range!");
      return;
    }
  }

  public void move(double power){
    motor1.set(power);
  }

  public boolean atTargetPosition() {
    return pidController.atSetpoint();
  }
  

  @Override
  public void periodic() {
    SmartDashboard.putNumber("PID Error", pidController.getPositionError());
    SmartDashboard.putNumber("Elevator Target Position", pidController.getSetpoint());
  }
}
