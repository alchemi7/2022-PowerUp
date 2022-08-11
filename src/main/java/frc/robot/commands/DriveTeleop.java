package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveTeleop extends CommandBase {
    private Drivetrain m_drive;
    private DoubleSupplier rightStick;
    private DoubleSupplier leftStick;
    private double rightSpeed = 0;
    private double leftSpeed = 0;
    private double speedMultiplier = 0.4;

    public DriveTeleop(Drivetrain drivetrain, DoubleSupplier rStick, DoubleSupplier lStick) {
        this.m_drive = drivetrain;
        this.rightStick = rStick;
        this.leftStick = lStick;
        addRequirements(m_drive);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        this.leftSpeed = (this.leftStick.getAsDouble()-this.rightStick.getAsDouble())*this.speedMultiplier;
        this.rightSpeed =  (this.leftStick.getAsDouble()+this.rightStick.getAsDouble())*this.speedMultiplier;
        this.m_drive.setVelocities(this.rightSpeed, this.leftSpeed);
    }

    @Override
    public void end(boolean interrupted){

    }
    
    @Override
    public boolean isFinished(){
        return false;
    }

}