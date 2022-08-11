package frc.robot.constants;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class DriveConstants {
    public static final TalonFX leftMaster = new TalonFX(Constants.leftDriveMasterPin);
    public static final TalonFX rightMaster = new TalonFX(Constants.rightDriveMasterPin);
    public static final VictorSPX leftFollow1 = new VictorSPX(Constants.leftDriveSlave1Pin);
    public static final VictorSPX leftFollow2 = new VictorSPX(Constants.leftDriveSlave2Pin);
    public static final VictorSPX rightFollow1 = new VictorSPX(Constants.rightDriveSlave1Pin);
    public static final VictorSPX rightFollow2 = new VictorSPX(Constants.rightDriveSlave2Pin);

    static{
        leftFollow1.follow(leftMaster);
        leftFollow2.follow(leftMaster);
        rightFollow1.follow(rightMaster);
        rightFollow2.follow(rightMaster);
        leftMaster.setInverted(true);
        leftFollow1.setInverted(true);
        leftFollow2.setInverted(true);
    }
}

