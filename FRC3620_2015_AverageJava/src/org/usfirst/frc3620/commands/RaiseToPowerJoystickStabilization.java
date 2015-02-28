package org.usfirst.frc3620.commands;

public class RaiseToPowerJoystickStabilization extends JoystickStabilization {


	

	 @Override
	public JoystickPosition stabilizeJoystick(double x, double y)
	{
		double rX = x;
		double move = y;
		
		 double m2 = Math.abs(move * move);
	        if (move < 0) {
	            m2 = -m2; //left Y
	        }
	        double r3 = Math.sqrt(Math.abs(rX * rX * rX));
	        if (rX < 0) {
	            r3 = -r3; //right X
	        }
		
			//System.out.println ("A: " + rX + " " + move + " " + m2 + " " + r3);
			
        
        
		JoystickPosition returnValue = new JoystickPosition(r3, m2);
		
		return returnValue;
		
		
	}
}
