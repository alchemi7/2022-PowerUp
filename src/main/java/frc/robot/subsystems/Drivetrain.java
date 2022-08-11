package frc.robot.subsystems;

import javax.sound.sampled.SourceDataLine;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.opencv.core.Point;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public class Drivetrain extends SubsystemBase {
    private TalonFX leftMaster;
    private TalonFX rightMaster;
    private VictorSPX leftFollow1;
    private VictorSPX leftFollow2;
    private VictorSPX rightFollow1;
    private VictorSPX rightFollow2;
    private PeriodicIO pIO = new PeriodicIO();

    public class PeriodicIO{
        private double rightVelo;
        private double leftVelo;
    }

    public Drivetrain(TalonFX lMaster, TalonFX rMaster, VictorSPX lFollow1, VictorSPX lFollow2, VictorSPX rFollow1, VictorSPX rFollow2) {
        this.leftMaster = lMaster;
        this.rightMaster = rMaster;
        this.leftFollow1 = lFollow1;
        this.leftFollow2 = lFollow2;
        this.rightFollow1 = rFollow1;
        this.rightFollow2 = rFollow2;
    }

    @Override
    public void periodic() {
        this.rightMaster.set(ControlMode.PercentOutput, pIO.rightVelo);
        this.leftMaster.set(ControlMode.PercentOutput, pIO.leftVelo);
    }

    public void setVelocities(double rightVel, double leftVel){
        this.pIO.rightVelo = rightVel;
        this.pIO.leftVelo = leftVel;
    }

}