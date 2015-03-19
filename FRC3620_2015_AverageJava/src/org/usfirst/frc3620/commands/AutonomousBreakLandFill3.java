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
public class AutonomousBreakLandFill3 extends CommandGroup {
    
    public  AutonomousBreakLandFill3() {
    	addSequential(new AutoLiftToNoWait(36));
    	addSequential(new AutoMove(4.25, 1));
    	addSequential(new AutonomousTurn(135));
    	//addSequential(new AutonomousStrafe(1, 1.0));
    	//addSequential(new AutoMove(1, 1));
    	addSequential(new AutonomousTurn(-70));
    	//addSequential(new AutonomousTurn(-45));
    	addSequential(new AutoMove(2, 1));
    	addSequential(new AutonomousTurn(45));
    	//addSequential(new AutonomousTurn(-45));
    	addSequential(new AutoMove(-1.0, 1.0));
    	addSequential(new AutonomousTurn(-25));
    	addSequential(new AutoMove(2, 1));
    	addSequential(new AutonomousTurn(45));
    	addSequential(new AutoMove(3.0, 1.0));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
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
