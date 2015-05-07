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

import java.io.File;
import java.io.IOException;
import java.util.TimeZone;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usfirst.frc3620.UDPReciever;
import org.usfirst.frc3620.commands.*;
import org.usfirst.frc3620.subsystems.*;

import com.ni.vision.VisionException;
import com.ni.vision.VisionException;

import edu.wpi.first.wpilibj.Preferences;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;
	public static OI oi;
	
	public static Preferences preferences;
	static private RobotMode currentRobotMode = RobotMode.INIT, previousRobotMode;
	PowerDistributionPanel pdp;
	
	DriverStation driverStation = DriverStation.getInstance();
	
	static Logger logger = LoggerFactory.getLogger(Robot.class);
	
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static LiftPID liftPID;;
    public static Drive drive;
    public static pneumatics pneumatics;
    public static Intake intake;
    public static encoderSubsystem encoderSubsystem;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	DataLogger dataLogger;
	
	CameraServer cameraServer;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		// Set dataLogger and Time information
		TimeZone.setDefault(TimeZone.getTimeZone("America/Detroit"));
		
		File logDirectory = null;
		if (logDirectory == null) logDirectory = findLogDirectory(new File("/u"));
		if (logDirectory == null) logDirectory = findLogDirectory(new File("/v"));
		if (logDirectory == null) logDirectory = findLogDirectory(new File("/x"));
		if (logDirectory == null) logDirectory = findLogDirectory(new File("/y"));
		if (logDirectory == null) {
			logDirectory = new File("/home/lvuser/logs");
		    if (!logDirectory.exists())
		    {
			    logDirectory.mkdir();
		    }
		}
		if (logDirectory != null && logDirectory.isDirectory())
		{
			String logMessage = String.format("Log directory is %s\n", logDirectory);
			System.out.print (logMessage);
			EventLogging.writeToDS(logMessage);
			EventLogging.setup(logDirectory);
			dataLogger = new DataLogger(logDirectory);
			dataLogger.setMinimumInterval(1000);
		}

		logger.info ("Starting robotInit");
		
		preferences = Preferences.getInstance();
		
		RobotMap.init();

		if (false) // turn off UDPReciver
			try
			{
				new UDPReciever().start();
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        liftPID = new LiftPID();
        drive = new Drive();
        pneumatics = new pneumatics();
        intake = new Intake();
        encoderSubsystem = new encoderSubsystem();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();
		Robot.pneumatics.checkForPneumatics();
		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autonomousCommand = new autonomous();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		// Check for pneumatics
		System.out.println("havePneumatics " + Robot.pneumatics.havePneumatics);
		if (Robot.pneumatics.havePneumatics)
		{
			RobotMap.pneumaticsCompressor1.start();
		}

		pdp = new PowerDistributionPanel();
		
		try
		{
			// startup camera server
			cameraServer = CameraServer.getInstance();
			// 25 seems to be less laggy than 50. 10 does not seem to be much
			// better lag wise
			// then 25, and is really poor quality.
			cameraServer.setQuality(25);
			// the camera name (ex "cam0") can be found through the roborio web
			// interface
			cameraServer.startAutomaticCapture("cam0");
		} catch (VisionException ex)
		{
			logger.error("Unable to load vision");
		}
		
		new VideoFeeder(); // start sending data to the raspberry PI

		// startup camera server
		try{
			cameraServer = CameraServer.getInstance();

			// 25 seems to be less laggy than 50. 10 does not seem to be much better lag wise
			// then 25, and is really poor quality.
			cameraServer.setQuality(25);
			//the camera name (ex "cam0") can be found through the roborio web interface
			cameraServer.startAutomaticCapture("cam0");
		}catch(VisionException vision)
		{
			System.out.println("no camera");
		}
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit()
	{
        allInit(RobotMode.DISABLED);
	}

	@Override
	public void disabledPeriodic()
	{
		allBeginningOfPeriodic();
		Scheduler.getInstance().run();
		allEndOfPeriodic();
	}

	@Override
	public void autonomousInit()
	{
		String witchAutonomous = Robot.preferences.getString(PreferencesNames.AUTONOMOUS_CHOICE, "sarned if I know, dabnabbit");
		if(witchAutonomous.equals(PreferencesNames.AUTONOMOUS_CHOICE_TOTE_AND_BIN)){
			autonomousCommand = new autonomous(); // tote and bin auto
		}
		else if(witchAutonomous.equals(PreferencesNames.AUTONOMOUS_CHOICE_MOVE_ONLY)){
			
			autonomousCommand = new AutonomousMoveOnly();

		}
		else if(witchAutonomous.equals(PreferencesNames.AUTONOMOUS_CHOICE_LAND_FILL_1))
		{
			autonomousCommand = new AutonomousBreakLandFill1();
		}
		
		else if(witchAutonomous.equals(PreferencesNames.AUTONOMOUS_CHOICE_LAND_FILL_3))
		{
			autonomousCommand = new AutonomousBreakLandFill3();
		}
		else if(witchAutonomous.equals(PreferencesNames.AUTONOMOUS_CHOICE_LAND_FILL_4))
		{
			autonomousCommand = new AutonomousBreakLandFill4();
		}
		else if(witchAutonomous.equals(PreferencesNames.AUTONOMOUS_CHOICE_LAND_FILL_5))
		{
			autonomousCommand = new AutonomousBreakLandFill5();
		}
		else
		{
			autonomousCommand = new AutonomousDoNothing();//does nothing
		}
		//autonomousCommand = new AutonomousDoNothing();
		allInit(RobotMode.AUTONOMOUS);
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		logger.info("Using autonomous {} from '{}' (prefs said '{}' )", autonomousCommand, PreferencesNames.AUTONOMOUS_CHOICE, witchAutonomous);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic()
	{
		allBeginningOfPeriodic();
		Scheduler.getInstance().run();
		allEndOfPeriodic();
	}

	@Override
	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		Robot.pneumatics.openCanArms();
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		// the cancel was *deliberately* before this!
		allInit(RobotMode.TELEOP);
		dumpPreferences();
		Robot.drive.setJoyStabalType(preferences.getString(PreferencesNames.JOY_STABAL_CHOICE, "xx"));
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic()
	{
		allBeginningOfPeriodic();
		Scheduler.getInstance().run();
		Robot.drive.isTurning();
		allEndOfPeriodic();
	}

	@Override
	public void testInit()
	{
		allInit(RobotMode.TEST);
	}
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic()
	{
		allBeginningOfPeriodic();
		LiveWindow.run();
		allEndOfPeriodic();
	}
	
	void allInit (RobotMode newMode)
	{
		previousRobotMode = currentRobotMode;
		currentRobotMode = newMode;
		
		logger.info("Moving from {} to {}, position = {}, FMS = {}", previousRobotMode, currentRobotMode, driverStation.getAlliance() + " " + driverStation.getLocation(), driverStation.isFMSAttached());
		
		// if anyone needs to know about mode changes, let
		// them know here.
		Robot.drive.allInit(newMode);
	}

	/**
	 * This gets called at the beginning of any *periodic().
	 * We're putting this here "just in case".
	 */
	void allBeginningOfPeriodic() {
		//
	}

	/**
	 * This gets called at the end of any *periodic().
	 * We're putting this here "just in case".
	 */
	void allEndOfPeriodic()
	{
		if (dataLogger.shouldLogData())
		{
			// fololowing two lijnes added 3/17/2015 DEW
			dataLogger.addDataItem("robotMode", currentRobotMode.toString());
			dataLogger.addDataItem("robotModeInt", currentRobotMode.ordinal());
			
			dataLogger.addDataItem("rightDriveCurrent", pdp.getCurrent(1));
			dataLogger.addDataItem("rightDriveMotorPower", RobotMap.driveSpeedController3.get());
			dataLogger.addDataItem("leftDriveCurrent", pdp.getCurrent(14));
			dataLogger.addDataItem("leftDriveMotorPower", RobotMap.driveSpeedController2.get());
			dataLogger.addDataItem("liftMotorCurrent", pdp.getCurrent(15));
			dataLogger.addDataItem("compressorCurrent", pneumatics.getCompressorCurrent());
			dataLogger.saveDataItems();
		}
		drive.getGyroAngle();
		SmartDashboard.putNumber("GyroAngle", drive.gyroAngle);
		//encoderSubsystem.getLeftEncoder();
		//SmartDashboard.putNumber("Left encoder. Inches traveled.",
				//encoderSubsystem.getleftEncoder().);
		//encoderSubsystem.getRightEncoder();
		SmartDashboard.putNumber("Left encoder. Inches traveled.",
				encoderSubsystem.getLeftEncoder());
		SmartDashboard.putNumber("Lift encoder", liftPID.liftEncoderValue());
		SmartDashboard.putNumber("Setpoint for lift: ", Robot.liftPID.getSetpoint());
		SmartDashboard.putNumber("DriveEncoder: ", Robot.encoderSubsystem.getRightEncoder());
		SmartDashboard.putBoolean("limit top", Robot.liftPID.limitTop());
		SmartDashboard.putBoolean("limit Bottom", Robot.liftPID.limitBottom());
		if (Robot.pneumatics.havePneumatics)
		{
			//System.out.println(String.format("switch=%s, couurent=%f",
					//RobotMap.pneumaticsCompressor1.getPressureSwitchValue(),
					//RobotMap.pneumaticsCompressor1.getCompressorCurrent()));
		}
		
		double d = liftPID.liftEncoderValue();
		double setPoint = liftPID.getPIDController().getSetpoint();
		double motorPower = RobotMap.liftPIDliftMotor.get();
		//System.out.printf("setpoint = %f, position = %f, pwoer = %f\n", setPoint, liftPosition, motorPower);
		//System.out.println("condition: " + Robot.liftPID.getCondition());
		
	}
	
	public static RobotMode getCurrentRobotMode() {
		return currentRobotMode;
	}
	
	public static RobotMode getPreviousRobotMode() {
		return previousRobotMode;
	}
	
	public static void commandInitialized(Object o) {
		logger.info("Command init: {}", o);
	}

	public static void commandEnded(Object o) {
		logger.info("Command end:  {}", o);
	}

	public static void commandInterrupted(Object o) {
		logger.info("Command interrupt: {}", o);
	}
	
	public File findLogDirectory (File root) {
		// does the root directory exist?
		if (!root.isDirectory()) return null;
		
		File logDirectory = new File(root, "logs");
		if (!logDirectory.isDirectory()) return null;
		
		return logDirectory;
	}

	public static void dumpPreferences()
	{
		for(Object a: preferences.getKeys())
		{
			System.out.println(a + "=" + preferences.getString((String) a, "foobar"));
		}
	}

}
