// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ArmTeleop;
import frc.robot.commands.DriveTeleop;
import frc.robot.commands.ElevatorTeleop;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GrabberTeleop;
import frc.robot.constants.ArmConstants;
import frc.robot.constants.DriveConstants;
import frc.robot.constants.ElevatorConstants;
import frc.robot.constants.GrabberConstants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  // private final Joystick mainController = new Joystick(0);
  private final XboxController xbox = new XboxController(0);
  private SmartDashboard board;
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    this.chadler.registerSubsystem(this.m_grabber, this.m_drive, this.m_elevator);
    this.m_grabber.setDefaultCommand(
        new GrabberTeleop(this.m_grabber, xbox::getXButton, xbox::getLeftBumper, xbox::getRightBumper, GrabberConstants.sensor));
    this.m_drive.setDefaultCommand(
        new DriveTeleop(this.m_drive, xbox::getRightX, xbox::getLeftY));
    this.m_elevator.setDefaultCommand(
      new ElevatorTeleop(this.m_elevator, xbox::getLeftTriggerAxis, xbox::getRightTriggerAxis));
    configureButtonBindings();
    this.m_arm.setDefaultCommand(
      new ArmTeleop(this.m_arm, xbox::getYButton, xbox::getBButton));
  }
  

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  }
  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  private CommandScheduler chadler = CommandScheduler.getInstance();

  private Grabber m_grabber = new Grabber(
      GrabberConstants.leftIntake,
      GrabberConstants.rightIntake,
      GrabberConstants.mainSolenoid);

  private Drivetrain m_drive = new Drivetrain(
      DriveConstants.leftMaster,
      DriveConstants.rightMaster,
      DriveConstants.leftFollow1,
      DriveConstants.leftFollow2,
      DriveConstants.rightFollow1,
      DriveConstants.rightFollow2);

  private Elevator m_elevator = new Elevator(
      ElevatorConstants.leftMaster,
      ElevatorConstants.rightMaster,
      ElevatorConstants.leftFollower ,
      ElevatorConstants.rightFollower);
  private Arm m_arm = new Arm(
      ArmConstants.ArmMaster);
}
