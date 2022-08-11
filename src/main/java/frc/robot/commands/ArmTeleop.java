package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmTeleop extends CommandBase{    
    private BooleanSupplier YButton;
    private BooleanSupplier BButton;
    private Arm m_arm;
    private double speed;

    public ArmTeleop(Arm m_arm, BooleanSupplier YButton, BooleanSupplier BButton){
        this.YButton = YButton;
        this.BButton = BButton;
        this.m_arm = m_arm;
        addRequirements(m_arm);
    }
    @Override
    public void initialize() {}

    @Override
    public void execute() {
        if(this.YButton.getAsBoolean()){
            this.speed = -0.4;
        } else if(this.BButton.getAsBoolean()){
            this.speed = 0.4;
        }
        this.m_arm.setSpeed(this.speed);
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
