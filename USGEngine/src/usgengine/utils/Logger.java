package usgengine.utils;

import java.io.PrintStream;
import java.util.Date;

public class Logger {

	private static PrintStream out = System.out;
	private static final boolean DEBUG_MODE = true;

	private Logger() {
	}

	public static void error(Throwable e) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();

		out.println("[" + "ERROR" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + e.getMessage());

		e.printStackTrace(out);
	}

	public static void error(String message) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();

		out.println("[" + "ERROR" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + message);
	}

	public static void error(String message, String error) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();

		out.println("[" + "ERROR" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + message);
		out.println("[" + "ERROR" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + error);
	}

	public static void error(String message, Throwable e) {
		error(message, e.getMessage());
	}

	public static void warn(String message) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();

		out.println("[" + "WARNING" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + message);
	}
	
	public static void warn(String message, String warn) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();

		out.println("[" + "WARNING" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + message);
		out.println("[" + "WARNING" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + warn);
	}

	public static void warn(Throwable e) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();

		out.println("[" + "WARNING" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + e.getMessage());

		e.printStackTrace(out);
	}
	
	public static void warn(String message, Throwable e) {
		warn(message, e.getMessage());
	}
	public static void info(String message) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();

		out.println("[" + "INFO" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + message);
	}

	public static void debug(String message) {
		if (DEBUG_MODE) {
			StackTraceElement[] elements = Thread.currentThread().getStackTrace();

			out.println("[" + "INFO" + "] " + "[" + new Date() + "] " + "[" + elements[2].getClassName() + "] " + message);
		}
	}

}
