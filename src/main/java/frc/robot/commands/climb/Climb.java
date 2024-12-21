// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.climber.Climber;

public class Climb extends Command {
  /** Creates a new Climb. */
  private boolean up;
  private Climber climber;

  public Climb(Climber subsystem, Boolean up) {
    this.climber = subsystem;
    this.up = up;
    addRequirements(subsystem);

  }


  @Override
  public void initialize() {
  }


  @Override
  public void execute() {

    climber.climb(up);
    
  }


  @Override
  public void end(boolean interrupted) {

    climber.stop();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
