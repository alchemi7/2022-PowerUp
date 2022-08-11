package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ElevatorTeleop extends CommandBase {
    private Elevator m_elevator;
    private DoubleSupplier rightTrigger;
    private DoubleSupplier leftTrigger;
    private double speed;
    private double speedMultiplier = 0.5;
    private Encoder encoder;


    public ElevatorTeleop(Elevator elevator, DoubleSupplier leftTrigger, DoubleSupplier rightTrigger){
        this.m_elevator = elevator;
        this.leftTrigger = leftTrigger;
        this.rightTrigger = rightTrigger;
        this.encoder = new Encoder(0,1);
        addRequirements(m_elevator);
    }

    @Override
    public void initialize() {

    }
  
    @Override
    public void execute() {
        double down = this.rightTrigger.getAsDouble()*-1;
        double up = this.leftTrigger.getAsDouble();
        this.speed = up + down;
        this.m_elevator.setSpeeds(this.speed*this.speedMultiplier);
    }
  
    @Override
    public void end(boolean interrupted) {

    }
  
    @Override
    public boolean isFinished() {
      return false;
    }
}
