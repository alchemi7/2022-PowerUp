package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grabber;

public class GrabberTeleop extends CommandBase {
    private Grabber m_grabber;
    private BooleanSupplier xButton;
    private BooleanSupplier leftBumper;
    private BooleanSupplier rightBumper;
    private boolean sensorState;
    private DigitalInput sensor;

    public GrabberTeleop(Grabber grabber, BooleanSupplier xButton, BooleanSupplier leftBumper,
            BooleanSupplier rightBumper, DigitalInput sensorInput) {
        this.m_grabber = grabber;
        this.xButton = xButton;
        this.leftBumper = leftBumper;
        this.rightBumper = rightBumper;
        this.sensor = sensorInput;
        addRequirements(m_grabber);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        this.m_grabber.setSolenoid(this.xButton.getAsBoolean());
        if (this.rightBumper.getAsBoolean() && this.leftBumper.getAsBoolean()) {
            this.m_grabber.setRollers(0.0);
        } else if (this.rightBumper.getAsBoolean()) {
            this.m_grabber.setRollers(1.0);
        } else if (this.leftBumper.getAsBoolean()) {
            this.m_grabber.setRollers(-1.0);
        } else {
            this.m_grabber.setRollers(0.0);
        }
        this.m_grabber.setSensor(this.sensor.get());
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
