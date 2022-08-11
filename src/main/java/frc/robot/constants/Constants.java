// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int leftDriveMasterPin = 01;
    public static final int rightDriveMasterPin = 04;
    public static final int rightDriveSlave1Pin = 05;
    public static final int rightDriveSlave2Pin = 06;
    public static final int leftDriveSlave1Pin = 02;
    public static final int leftDriveSlave2Pin = 03;

    public static final int leftIntake = 11;
    public static final int rightIntake = 12;

    public static final int leftElevatorMaster = 9;
    public static final int leftElevatorFollower = 8;
    public static final int rightElevatorMaster = 07;
    public static final int rightElevatorFollower = 10;

    public static final int armMaster = 13;


}
