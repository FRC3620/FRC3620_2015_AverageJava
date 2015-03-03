package org.usfirst.frc3620;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.usfirst.frc3620.EventLogging.Level;

import com.google.gson.Gson;

import edu.wpi.first.wpilibj.DriverStation;

public class VideoFeeder {

	static Logger logger = EventLogging
			.getLogger(VideoFeeder.class, Level.INFO);

	java.util.Timer timer;

	public VideoFeeder() {
		// the 'true' makes the timer a daemon timer, which
		// means the JVM can shutdown regardless of whether or
		// not the timer is cancelled.
		timer = new java.util.Timer("VideoFeeder", true);
		// try to send a packet every 50 milliseconds
		timer.schedule(new VideoFeederTask(), 0, 50);
	}

	class VideoFeederTask extends TimerTask {
		int videoSequence = 0;
		long lastEnabledAt = 0;
		String filename;
		DriverStation driverStation = DriverStation.getInstance();
		Gson gson = new Gson();

		InetAddress recorderInetAddress = null;

		boolean wasRecording = false;

		long lastLookupTime = 0;

		@Override
		public void run()
		{
			long now = System.currentTimeMillis();
			if (recorderInetAddress == null && (now - lastLookupTime) > 2000)
			{
				// if we don't have an IP address for the vision PC, let's try
				// to
				// do the IP lookup every couple seconds or so.
				try
				{
					recorderInetAddress = InetAddress
							.getByName("vision-3620.local");
					logger.info("Sending to {}", recorderInetAddress);
				} catch (UnknownHostException ex)
				{
					// logger.error ("Trouble making the socket {} {}",
					// ex.getMessage(), ex);
				}
				lastLookupTime = now;
			}

			// only go to all this work if we have a destination
			if (recorderInetAddress != null)
			{
				RobotMode robotMode = Robot.getCurrentRobotMode();

				// figure out if we should be recording. record during auto,
				// teleop, and keep recording for another few seconds after
				// coming out
				boolean shouldRecord = false;
				if (robotMode.equals(RobotMode.AUTONOMOUS)
						|| robotMode.equals(RobotMode.TELEOP))
				{
					shouldRecord = true;
					lastEnabledAt = now;
				}
				if (!shouldRecord)
				{
					if (now - lastEnabledAt <= 5000)
						shouldRecord = true;
				}

				if (shouldRecord && filename == null)
				{
					// we are turning on recording
					if (videoSequence == 0)
					{
						filename = LogTimestamp.getTimestampString();
					} else
					{
						filename = LogTimestamp.getTimestampString() + "_"
								+ String.format("%03d", videoSequence);
					}
					filename += ".avi";
					logger.info("recording to {}", filename);
					videoSequence++;
				}

				// if we are not recording, then do not send a filename
				if (!shouldRecord)
					filename = null;

				// log if we are turning off the recording
				if (!shouldRecord && wasRecording)
				{
					logger.info("stopped recording");
				}
				wasRecording = shouldRecord;

				// put together a data packet for the vision PC
				VideoFeedData d = new VideoFeedData();
				d.filename = filename;
				d.time = new Date(now).toString();
				d.joystickx = Robot.drive.getJoystickX(Robot.oi.driverJoystick);
				d.joysticky = Robot.drive.getJoystickY(Robot.oi.driverJoystick);
				d.robotmode = robotMode.name();
				d.position = driverStation.getAlliance().name() + " "
						+ driverStation.getLocation();
				d.voltage = driverStation.getBatteryVoltage();
				d.timeinmatch = driverStation.getMatchTime();

				// make into a JSON message
				String message = gson.toJson(d);
				logger.debug("video: {}", message);
				byte[] b = message.getBytes();

				// and send it
				DatagramSocket datagramSocket;
				try
				{
					datagramSocket = new DatagramSocket();
					DatagramPacket datagramPacket = new DatagramPacket(b,
							b.length, recorderInetAddress, 3620);
					datagramSocket.send(datagramPacket);
				} catch (IOException ex)
				{
					logger.error("Trouble sending to {} {}", recorderInetAddress,
							ex);
					recorderInetAddress = null;
				}
			}
		}

	}

	class VideoFeedData {
		String filename;
		String time;
		Double joystickx, joysticky;
		String robotmode;
		String position;
		Double voltage;
		Double timeinmatch = 0.0;
	}

}
