// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3620;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController liftPIDliftMotor;
    public static DigitalInput liftPIDliftLimitBottom;
    public static DigitalInput liftPIDliftLimitTop;
    public static Encoder liftPIDLiftEncoder;
    public static SpeedController driveSpeedController2;
    public static SpeedController driveSpeedController1;
    public static SpeedController driveSpeedController3;
    public static SpeedController driveSpeedController0;
    public static RobotDrive driveRobotDrive4;
    public static Gyro drivedriveGyro;
    public static Solenoid pneumaticsvalveArm2_1;
    public static Solenoid pneumaticsvalveArm1_1;
    public static Solenoid pneumaticsvalveArm1_2;
    public static Solenoid pneumaticsvalveArm2_2;
    public static Compressor pneumaticsCompressor1;
    public static Solenoid pneumaticsvalveBasiloid_1;
    public static Solenoid pneumaticsvalveBasiloid_2;
    public static SpeedController intakeIntakeMotor2;
    public static SpeedController intakeIntakeMotor1;
    public static Encoder encoderSubsystemleftEncoder;
    public static Encoder encoderSubsystemrightEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        liftPIDliftMotor = new Talon(4);
        LiveWindow.addActuator("LiftPID", "liftMotor", (Talon) liftPIDliftMotor);
        
        liftPIDliftLimitBottom = new DigitalInput(1);
        LiveWindow.addSensor("LiftPID", "liftLimitBottom", liftPIDliftLimitBottom);
        
        liftPIDliftLimitTop = new DigitalInput(0);
        LiveWindow.addSensor("LiftPID", "liftLimitTop", liftPIDliftLimitTop);
        
        liftPIDLiftEncoder = new Encoder(6, 7, false, EncodingType.k1X);
        LiveWindow.addSensor("LiftPID", "LiftEncoder", liftPIDLiftEncoder);
        liftPIDLiftEncoder.setDistancePerPulse(0.00988);
        liftPIDLiftEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        driveSpeedController2 = new Talon(2);
        LiveWindow.addActuator("Drive", "Speed Controller 2", (Talon) driveSpeedController2);
        
        driveSpeedController1 = new Talon(1);
        LiveWindow.addActuator("Drive", "Speed Controller 1", (Talon) driveSpeedController1);
        
        driveSpeedController3 = new Talon(3);
        LiveWindow.addActuator("Drive", "Speed Controller 3", (Talon) driveSpeedController3);
        
        driveSpeedController0 = new Talon(0);
        LiveWindow.addActuator("Drive", "Speed Controller 0", (Talon) driveSpeedController0);
        
        driveRobotDrive4 = new RobotDrive(driveSpeedController0, driveSpeedController2,
              driveSpeedController1, driveSpeedController3);
        
        driveRobotDrive4.setSafetyEnabled(false);
        driveRobotDrive4.setExpiration(0.1);
        driveRobotDrive4.setSensitivity(0.5);
        driveRobotDrive4.setMaxOutput(1.0);

        drivedriveGyro = new Gyro(0);
        LiveWindow.addSensor("Drive", "driveGyro", drivedriveGyro);
        drivedriveGyro.setSensitivity(0.007);
        pneumaticsvalveArm2_1 = new Solenoid(0, 2);
        LiveWindow.addActuator("pneumatics", "valveArm2_1", pneumaticsvalveArm2_1);
        
        pneumaticsvalveArm1_1 = new Solenoid(0, 0);
        LiveWindow.addActuator("pneumatics", "valveArm1_1", pneumaticsvalveArm1_1);
        
        pneumaticsvalveArm1_2 = new Solenoid(0, 1);
        LiveWindow.addActuator("pneumatics", "valveArm1_2", pneumaticsvalveArm1_2);
        
        pneumaticsvalveArm2_2 = new Solenoid(0, 3);
        LiveWindow.addActuator("pneumatics", "valveArm2_2", pneumaticsvalveArm2_2);
        
        pneumaticsCompressor1 = new Compressor(0);
        
        
        pneumaticsvalveBasiloid_1 = new Solenoid(0, 4);
        LiveWindow.addActuator("pneumatics", "valveBasiloid_1", pneumaticsvalveBasiloid_1);
        
        pneumaticsvalveBasiloid_2 = new Solenoid(0, 5);
        LiveWindow.addActuator("pneumatics", "valveBasiloid_2", pneumaticsvalveBasiloid_2);
        
        intakeIntakeMotor2 = new Talon(5);
        LiveWindow.addActuator("Intake", "IntakeMotor2", (Talon) intakeIntakeMotor2);
        
        intakeIntakeMotor1 = new Talon(6);
        LiveWindow.addActuator("Intake", "IntakeMotor1", (Talon) intakeIntakeMotor1);
        
        encoderSubsystemleftEncoder = new Encoder(2, 3, true, EncodingType.k4X);
        LiveWindow.addSensor("encoderSubsystem", "leftEncoder", encoderSubsystemleftEncoder);
        encoderSubsystemleftEncoder.setDistancePerPulse(0.09817477042468103);
        encoderSubsystemleftEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        encoderSubsystemrightEncoder = new Encoder(4, 5, true, EncodingType.k4X);
        LiveWindow.addSensor("encoderSubsystem", "rightEncoder", encoderSubsystemrightEncoder);
        encoderSubsystemrightEncoder.setDistancePerPulse(0.00409061543436171);
        encoderSubsystemrightEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
