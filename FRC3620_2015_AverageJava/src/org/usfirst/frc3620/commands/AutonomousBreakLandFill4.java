// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3620.commands;
import org.usfirst.frc3620.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousBreakLandFill4 extends CommandGroup {
    
    public  AutonomousBreakLandFill4()
    {
    	addParallel(new bothBottomRight());
    	addSequential(new driveAndLiftlandFillBreakUp());
    }

	@Override
	protected void initialize()
	{
		Robot.commandInitialized(this);
		super.initialize();
	}

	@Override
	protected void end()
	{
		Robot.commandEnded(this);
		super.end();
	}

	@Override
	protected void interrupted()
	{
		Robot.commandInterrupted(this);
		super.interrupted();
	}
}
