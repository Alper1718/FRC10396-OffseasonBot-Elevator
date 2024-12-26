package frc.robot.commands.elevator;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.elevator.ElevatorSensorsIO;
import frc.robot.subsystems.elevator.ElevatorSubsystem;

public class pid extends Command {
  private final ElevatorSubsystem elevatorSubsystem;
  private final ElevatorSensorsIO subsystem; 
  private final PIDController pid = new PIDController(0.5, 0.1, 0.1);

  public pid(ElevatorSensorsIO sensorsIO, double setpoint, ElevatorSubsystem elevator) {
    this.elevatorSubsystem = elevator;
    this.subsystem = sensorsIO;
    pid.setSetpoint(setpoint);
  }

  @Override
  public void initialize() {
    System.out.print("PID Start.");
  }

  @Override
  public void execute() {
    elevatorSubsystem.Move(pid.calculate(subsystem.getNEOEncoderPosition()));
    System.out.println(subsystem.getNEOEncoderPosition());
    System.out.println(subsystem.getCANCoderPosition());
  }

  @Override
  public void end(boolean interrupted) {;
    System.out.println("PID End.");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
