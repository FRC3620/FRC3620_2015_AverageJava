package org.usfirst.frc3620;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class EventLogging {
	public enum Level {
		TRACE(java.util.logging.Level.FINEST), //
		DEBUG(java.util.logging.Level.FINE), //
		INFO(java.util.logging.Level.INFO), //
		WARN(java.util.logging.Level.WARNING), //
		ERROR(java.util.logging.Level.SEVERE);

		java.util.logging.Level julLevel;

		Level(java.util.logging.Level _julLevel) {
			julLevel = _julLevel;
		}

	}

	static public org.slf4j.Logger getLogger(Class<?> clazz, Level l)
	{
		return getLogger(clazz.getName(), l);
	}

	static public org.slf4j.Logger getLogger(String sClazz, Level l)
	{
		java.util.logging.Logger julLogger = java.util.logging.Logger
				.getLogger(sClazz);
		julLogger.setLevel(l.julLevel);

		org.slf4j.Logger rv = org.slf4j.LoggerFactory.getLogger(sClazz);
		return rv;
	}

	private static boolean setupDone = false;

	public static void setup(File logDirectory)
	{
		if (!setupDone)
		{
			synchronized (EventLogging.class)
			{
				if (!setupDone)
				{
					Logger rootLogger = Logger.getLogger("");
					Handler[] handlers = rootLogger.getHandlers();
					for (Handler handler : handlers)
					{
						rootLogger.removeHandler(handler);
					}

					Handler h = new ConsoleHandler();
					h.setFormatter(new FormatterForFileHandler());
					h.setLevel(java.util.logging.Level.ALL);
					rootLogger.addHandler(h);

					h = new MyFileHandler(logDirectory);
					h.setFormatter(new FormatterForFileHandler());
					h.setLevel(java.util.logging.Level.ALL);
					rootLogger.addHandler(h);

					setupDone = true;
				}
			}
		}
	}

	static class MyFileHandler extends StreamHandler {
		File logDirectory;
		FileOutputStream fileOutputStream = null;

		public MyFileHandler(File logDirectory) {
			super();
			this.logDirectory = logDirectory;
		}

		@Override
		public void publish(LogRecord arg0)
		{
			if (fileOutputStream == null)
			{
				synchronized (this)
				{
					if (fileOutputStream == null)
					{
						String timestampString = LogTimestamp
								.getTimestampString();
						if (timestampString != null)
						{
							File logFile = new File(logDirectory,
									timestampString + ".log");
							try
							{
								fileOutputStream = new FileOutputStream(logFile);
								setOutputStream(fileOutputStream);
							} catch (IOException ex)
							{
								ex.printStackTrace(System.err);
							}

						}
					}
				}
			}
			if (fileOutputStream != null)
			{
				super.publish(arg0);
				flush();
			}
		}

	}

	static class FormatterForFileHandler extends java.util.logging.Formatter {
		//
		// Create a DateFormat to format the logger timestamp.
		//
		private final DateFormat df = new SimpleDateFormat(
				"yyyy/MM/dd hh:mm:ss.SSS");

		public String format(LogRecord record)
		{
			StringBuilder builder = new StringBuilder(1000);
			// DateFormat objects are not thread-safe....
			synchronized (df) 
			{
				builder.append(df.format(new Date(record.getMillis()))).append(" ");
			}
			builder.append("[").append(record.getLoggerName())
					.append("] ");
			builder.append(record.getLevel()).append(" - ");
			builder.append(formatMessage(record));
			builder.append("\n");
			return builder.toString();
		}

		public String getHead(Handler h)
		{
			return super.getHead(h);
		}

		public String getTail(Handler h)
		{
			return super.getTail(h);
		}
	}

}
