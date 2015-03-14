package org.usfirst.frc3620.commands;

public class SlewLimitJoystickStabilization extends JoystickStabilization {

	double outputx = 0.0;
	double outputy = 0.0;
	@Override
	public JoystickPosition stabilizeJoystick(double x, double y)
	{
		double joystickx = x;
		double joysticky = y;
		boolean valuex;
		boolean valuey;
		
		if( x > 0.2 || x < -0.2)
		{
			//System.out.println("valuex is true");
			valuex = true;
		}
		else
		{
			//System.out.println("valuex is false");
			outputx = 0;
			valuex = false;
		}
		
		if(valuex)
		{
			double error = joystickx - outputx;
			outputx += error * 0.035;
			//System.out.println("patrick");
		}
		
		
		if( y > 0.2 || y < -0.2)
		{
			valuey = true;
		}
		else
		{
			outputy = 0;
			valuey = false;
		}
		
		if(valuey)
		{
			double error = joysticky - outputy;
			outputy += error * 0.055;
			//System.out.println("ved");
		}
		
        
        
		JoystickPosition returnValue = new JoystickPosition(outputx, outputy);
		
		return returnValue;
		
		
	}

}
