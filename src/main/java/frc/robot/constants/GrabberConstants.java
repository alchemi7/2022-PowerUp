package frc.robot.constants;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.constants.Constants;


public class GrabberConstants {
    public static final VictorSPX leftIntake = new VictorSPX(Constants.leftIntake);
    public static final VictorSPX rightIntake = new VictorSPX(Constants.rightIntake);
    public static final DoubleSolenoid mainSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
    public static final DigitalInput sensor = new DigitalInput(4);
}
