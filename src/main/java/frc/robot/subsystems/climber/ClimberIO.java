// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climber;

import org.littletonrobotics.junction.AutoLog;

/** Add your docs here. */
public interface ClimberIO {

  @AutoLog
  public static class ClimberIOInputs {
    public double appliedPercent = 0.0;
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(ClimberIOInputs inputs) {}

  public default void runClimber(double voltage) {}

  public default void stop() {}
}
