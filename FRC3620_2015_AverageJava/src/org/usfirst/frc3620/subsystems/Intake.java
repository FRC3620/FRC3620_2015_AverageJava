// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3620.subsystems;

import org.usfirst.frc3620.Robot;
import org.usfirst.frc3620.RobotMap;
import org.usfirst.frc3620.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Intake extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController intakeMotor2 = RobotMap.intakeIntakeMotor2;
    SpeedController intakeMotor1 = RobotMap.intakeIntakeMotor1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new intakeStop());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void takeIn()
    {
    	intakeMotor1.set(-1);
    	intakeMotor2.set(1);
    }
    public void dumpOut()
    {
    	intakeMotor2.set(-1);
    	intakeMotor1.set(1);
    }
    public void intakeStop()
    {
    	intakeMotor1.set(0);
    	intakeMotor2.set(0);
    }
}

