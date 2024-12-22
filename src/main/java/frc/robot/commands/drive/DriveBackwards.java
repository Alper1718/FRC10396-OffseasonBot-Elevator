// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drive.Drive;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveBackwards extends SequentialCommandGroup {
  /** Creates a new DriveBackwards. */
  private double seconds;

  private Drive drive;

  public DriveBackwards(Drive drive, double seconds) {
    this.drive = drive;
    this.seconds = seconds;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new RunCommand(() -> drive.driveArcade(-0.5, 0), drive).withTimeout(seconds));
  }
}
