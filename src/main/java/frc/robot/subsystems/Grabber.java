package frc.robot.subsystems;
import javax.sound.sampled.SourceDataLine;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Grabber extends SubsystemBase{
    private VictorSPX leftIntake;
    private VictorSPX rightIntake;
    private DoubleSolenoid mainSolenoid;
    private PeriodicIo pIO = new PeriodicIo();
    private boolean sensorState;
    
    private class PeriodicIo{
        private boolean solenoidState;
        private double velocity;
        private boolean sensorState;
    }

    public Grabber(VictorSPX left, VictorSPX right, DoubleSolenoid solenoid){
        this.leftIntake = left;
        this.rightIntake = right;
        this.mainSolenoid = solenoid;
        this.sensorState = false;
    }


    @Override
    public void periodic(){
        this.leftIntake.set(ControlMode.PercentOutput, pIO.velocity);
        this.rightIntake.set(ControlMode.PercentOutput, pIO.velocity);
        this.sensorState = this.pIO.sensorState;
        if(this.pIO.solenoidState){
            this.mainSolenoid.set(Value.kForward);
        } else{
            this.mainSolenoid.set(Value.kReverse);
        }
        SmartDashboard.putBoolean("Sensor", this.getSensorState());
    }

    public void setRollers(double vel){
        this.pIO.velocity = vel;
    }

    public void setSolenoid(boolean state){
        this.pIO.solenoidState = state;
    }

    public void setSensor(boolean state){
        this.pIO.sensorState = state;
    }

    public boolean getSensorState(){
        return !this.sensorState;
    }
}

