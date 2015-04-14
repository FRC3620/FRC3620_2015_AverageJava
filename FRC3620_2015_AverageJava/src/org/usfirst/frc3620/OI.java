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

import org.usfirst.frc3620.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton toggleGyroAssist;
    public Joystick driverJoystick;
    public JoystickButton liftUpButton;
    public JoystickButton pneumaticsbutton;
    public JoystickButton liftDownButton;
    public JoystickButton takeInButton;
    public JoystickButton dumpOutButton;
    public JoystickButton removeStackButton;
    public JoystickButton canGrabButton;
    public JoystickButton bottomTakeIn;
    public JoystickButton bottomWheelsOut;
    public Joystick operatorJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        operatorJoystick = new Joystick(1);
        
        bottomWheelsOut = new JoystickButton(operatorJoystick, 6);
        bottomWheelsOut.whileHeld(new bottomDumpOut());
        bottomTakeIn = new JoystickButton(operatorJoystick, 5);
        bottomTakeIn.whileHeld(new bottomIntake());
        canGrabButton = new JoystickButton(operatorJoystick, 8);
        canGrabButton.whenPressed(new canGrabToggle());
        removeStackButton = new JoystickButton(operatorJoystick, 7);
        removeStackButton.whenPressed(new removeStack());
        dumpOutButton = new JoystickButton(operatorJoystick, 3);
        dumpOutButton.whileHeld(new dumpOut());
        takeInButton = new JoystickButton(operatorJoystick, 2);
        takeInButton.whileHeld(new takeIn());
        liftDownButton = new JoystickButton(operatorJoystick, 1);
        liftDownButton.whenPressed(new liftDown());
        pneumaticsbutton = new JoystickButton(operatorJoystick, 9);
        pneumaticsbutton.whenPressed(new intakeOpenClose());
        liftUpButton = new JoystickButton(operatorJoystick, 4);
        liftUpButton.whenPressed(new liftUp());
        driverJoystick = new Joystick(0);
        
        toggleGyroAssist = new JoystickButton(driverJoystick, 8);
        toggleGyroAssist.whenPressed(new toggleTeleOpAssist());

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("GitTestCommandAgain", new GitTestCommandAgain());

        SmartDashboard.putData("liftManual", new liftManual());

        SmartDashboard.putData("pushIn", new pushIn());

        SmartDashboard.putData("pushOut", new pushOut());

        SmartDashboard.putData("Autonomous Move", new AutonomousMove());

        SmartDashboard.putData("DriveArcadeCommand", new DriveArcadeCommand());

        SmartDashboard.putData("liftUp", new liftUp());

        SmartDashboard.putData("liftDown", new liftDown());

        SmartDashboard.putData("takeIn", new takeIn());

        SmartDashboard.putData("dumpOut", new dumpOut());

        SmartDashboard.putData("intakeStop", new intakeStop());

        SmartDashboard.putData("intakeOpenClose", new intakeOpenClose());

        SmartDashboard.putData("autonomous", new autonomous());

        SmartDashboard.putData("removeStack", new removeStack());

        SmartDashboard.putData("toggleTeleOpAssist", new toggleTeleOpAssist());

        SmartDashboard.putData("AutonomousToteFinder", new AutonomousToteFinder());

        SmartDashboard.putData("ResetDriveEncoders", new ResetDriveEncoders());

        SmartDashboard.putData("AutonomousTurn", new AutonomousTurn());

        SmartDashboard.putData("intakeOpen", new intakeOpen());

        SmartDashboard.putData("intakeClose", new intakeClose());

        SmartDashboard.putData("resetGyro", new resetGyro());

        SmartDashboard.putData("canGrabToggle", new canGrabToggle());

        SmartDashboard.putData("bottomIntake", new bottomIntake());

        SmartDashboard.putData("bottomDumpOut", new bottomDumpOut());

        SmartDashboard.putData("bothIntakeStop", new bothIntakeStop());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriverJoystick() {
        return driverJoystick;
    }

    public Joystick getOperatorJoystick() {
        return operatorJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

