// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climber;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants.ClimbConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.subsystems.intake.IntakeIO.IntakeIOInputs;

/** Add your docs here. */
public class ClimberIOVictorSPX implements ClimberIO{

    public final VictorSPX climber = new VictorSPX(ClimbConstants.motorID);
    private double appliedPercent;


  public ClimberIOVictorSPX(){
    climber.setInverted(ClimbConstants.reversed);
    climber.setNeutralMode(ClimbConstants.neutralMode);
  }

  @Override
  public void updateInputs(ClimberIOInputs inputs) {
    inputs.appliedPercent = appliedPercent;
  }

  @Override
  public void runClimber(double percent) {
    appliedPercent = percent;
    climber.set(VictorSPXControlMode.PercentOutput, percent);
  }

  @Override
  public void stop() {
    appliedPercent = 0;
    climber.set(VictorSPXControlMode.PercentOutput, 0);
  }
}
