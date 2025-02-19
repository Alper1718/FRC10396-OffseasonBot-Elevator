// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.intake.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AmpSequence extends SequentialCommandGroup {
  private Intake intake;

  public AmpSequence(Intake intake) {
    this.intake = intake;

    addCommands(
        new RunCommand(() -> intake.intake(), intake).withTimeout(0.5),
        new RunCommand(() -> intake.shoot(), intake));
  }
}
