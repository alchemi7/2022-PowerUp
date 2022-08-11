package frc.robot.constants;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ElevatorConstants {
    public static final TalonFX leftMaster = new TalonFX(Constants.leftElevatorMaster);
    public static final TalonFX rightMaster = new TalonFX(Constants.rightElevatorMaster);
    public static final VictorSPX leftFollower = new VictorSPX(Constants.leftElevatorFollower);
    public static final VictorSPX rightFollower = new VictorSPX(Constants.rightElevatorFollower);

    static{
        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);
       // rightMaster.follow(leftMaster);
    }
}
