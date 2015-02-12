package org.usfirst.frc3620;

import java.util.Date;

public class VisionData {
		double imageHeight;
		double imageWidth;
		long whenRecieved;
		Boolean seen;
		Double x, y, xlimit, xLimit, missing;
		Date when;

		@Override
		public String toString() {
			return "VisionData [imageHeight=" + imageHeight + ", imageWidth="
					+ imageWidth + ", seen=" + seen + ", x=" + x + ", y=" + y
					+ ", xlimit=" + xlimit + ", xLimit=" + xLimit
					+ ", missing=" + missing + ", when=" + when + "]";
		}

		public double getImageWidth() {
			return imageWidth;
		}

		public long getWhenRecieved() {
			return whenRecieved;
		}

		public double getX() {
			return x;
		}
		
		public boolean isSeen()
		{
			return seen;
		}
	}