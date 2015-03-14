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
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 Order of autonomous
 1. Squeeze
 2. Up
 3. Forward
 4. Down (Just a little)
 5. Release
 6. Down
 7. Squeeze
 8. Up
 9. Turn 90 degrees right
 10. Forward
 11. Drop
 12. Release
 */
public class autonomous extends CommandGroup {
    
    public  autonomous() {
    	
    	
    	
    	addSequential(new intakeClose());  //Squeeze
    	addSequential(new WaitCommand(.5));
    	addSequential(new autoLiftTo(15)); //Up
    	addSequential(new AutoMove(1.4, 0.6)); //Forward
    	addSequential(new AutoLiftToNoWait(8));  //down just a little
    	addSequential(new WaitCommand(.5));
    	//addSequential(new intakeOpen());  //release
    	//addSequential(new autoLiftTo(0));
    	//addSequential(new intakeClose()); //squeeze
    	//addSequential(new autoLiftTo(2.5)); //up
    	addSequential(new AutonomousTurn(-75)); //Turn 90 degrees left
    	addSequential(new AutoMove(10, 1)); //forward
    	//addSequential(new autoLiftTo(0)); //drop
    	addSequential(new AutonomousTurn(75));
    	addSequential(new WaitCommand(.5));
    	addSequential(new intakeOpen()); //release
    	addSequential(new autoLiftTo(10));
    	addSequential(new AutoMove(-.5, 1));
    	
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
}
