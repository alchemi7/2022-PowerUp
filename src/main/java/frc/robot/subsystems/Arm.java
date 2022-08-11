package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase{
    private VictorSPX armMotor;
    PeriodicIO pIO = new PeriodicIO();
    public class PeriodicIO{
        private double speed;
    }

    public Arm(VictorSPX armMotor){
        this.armMotor = armMotor;
    }

    @Override
    public void periodic(){
        this.armMotor.set(ControlMode.PercentOutput, this.pIO.speed);
    }

    public void setSpeed(double speed){
        this.pIO.speed = speed;   
    }
}
