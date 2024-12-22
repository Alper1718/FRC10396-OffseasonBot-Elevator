// Copyright 2021-2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final Mode currentMode = Mode.REAL;

  public boolean isSIM() {
    return currentMode == Mode.SIM;
  }

  public static enum Mode {
    /** Running on a real robot. */
    REAL,

    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }

  public static class ClimbConstants {

    public static final int motorID = 2;
    public static final NeutralMode neutralMode = NeutralMode.Brake;
    public static final boolean reversed = true;
    public static final double downSpeed = 0.3;
    public static final double upSpeed = 0.8;
    public static final String climbUpSpeed = null;
  }

  public static class DriveConstants {

    public static final int leftMasterID = 1;
    public static final int leftSlaveID = 3;
    public static final int rightMasterID = 4;
    public static final int rightSlaveID = 5;

    public static final boolean leftMasterReversed = true;
    public static final boolean leftSlaveReversed = true;
    public static final boolean rightMasterReversed = false;
    public static final boolean rightSlaveReversed = false;

    public static final NeutralMode neutralMode = NeutralMode.Coast;
    public static final double kSpeedRateLimit = 6;
    public static final double kRotRateLimit = 6;
  }

  public static class IntakeConstants {

    public static final int motorID = 0;
    public static final int sensorID = 0;
    public static final NeutralMode neutralMode = NeutralMode.Brake;
    public static final boolean reversed = true;

    public static final double intakeSpeed = -0.5;
    public static final double shootSpeed = 1;
    public static final double rumbleStrength = 0.3;
  }
}
