// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.drive.Drive;

public class JoystickDrive extends Command {
  private final Drive drive;

  private double kSpeed = 1.0;
  private Joystick controller;

  private final SlewRateLimiter speedLimiter = new SlewRateLimiter(DriveConstants.kSpeedRateLimit);
  private final SlewRateLimiter rotLimiter = new SlewRateLimiter(DriveConstants.kRotRateLimit);

  /** Creates a new JoystickDrive. */
  public JoystickDrive(Drive drive, Joystick controller) {
    this.drive = drive;
    this.controller = controller;

    addRequirements(drive);
  }

  @Override
  public void initialize() {}

  private double applyDeadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      // Scale the output to account for the deadband region
      return (value - Math.copySign(deadband, value)) / (1.0 - deadband);
    } else {
      return 0.0;
    }
  }

  @Override
  public void execute() {
    if (controller.getRawButton(5)) kSpeed = DriveConstants.slowSpeedMultiplier;
    else kSpeed = 1.0;
    drive.driveArcade(
        speedLimiter.calculate(applyDeadband(controller.getRawAxis(1) * kSpeed, 0.05)),
        rotLimiter.calculate(applyDeadband(controller.getRawAxis(2) * kSpeed, 0.05)));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
