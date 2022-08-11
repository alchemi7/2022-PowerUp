package frc.robot.subsystems;

import javax.sound.sampled.SourceDataLine;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private TalonFX leftMaster;
    private TalonFX rightMaster;
    private VictorSPX leftFollower;
    private VictorSPX rightFollower;
    private PeriodicIO pIO = new PeriodicIO();

    public class PeriodicIO{
        private double leftSpeed;
        private double rightSpeed;
    }

    public Elevator(TalonFX leftMaster,TalonFX rightMaster, VictorSPX leftFollower,VictorSPX rightFollower){
        this.leftMaster = leftMaster;
        this.rightMaster = rightMaster;
        this.leftFollower = leftFollower;
        this.rightFollower = rightFollower;
    }

    @Override
    public void periodic(){
        this.rightMaster.set(ControlMode.PercentOutput, this.pIO.rightSpeed);
        this.leftMaster.set(ControlMode.PercentOutput,this.pIO.leftSpeed);
    }

    public void setSpeeds(double speed) {
        this.pIO.leftSpeed = speed;
        this.pIO.rightSpeed = speed;
    }   
}
