package org.usfirst.frc3620.commands;

public class RaiseToPowerJoystickStabilization extends JoystickStabilization {

	@Override
	public JoystickPosition stabilizeJoystick(double x, double y)
	{
		double y2 = Math.abs(y * y);
		if (y < 0)
		{
			y2 = -y2; // left Y
		}
		double x2 = Math.sqrt(Math.abs(x * x * x));
		if (x < 0)
		{
			x2 = -x2; // right X
		}
		JoystickPosition returnValue = new JoystickPosition(x2, y2);
		return returnValue;
	}
}
