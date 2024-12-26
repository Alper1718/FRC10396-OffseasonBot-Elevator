// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.elevator.ElevatorSubsystem;

public class ElevatorCommand extends Command {
  private final ElevatorSubsystem elevator;

  public ElevatorCommand(ElevatorSubsystem elevator) {
    this.elevator = elevator;
    addRequirements(elevator);
  }

  @Override
  public void initialize() {
    System.out.println("Elevator work");
  }

  @Override
  public void execute() {
    elevator.Move(0.5);
  }

  @Override
  public void end(boolean interrupted) {
    elevator.Move(0);
    System.out.println("elevator end.");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
