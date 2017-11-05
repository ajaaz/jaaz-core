package eu.jaaz.portal.core;

public class Debug {
	
	public static void debug(String debug)
	{
		System.out.println("DEBUG: " +debug);
	}
	
	public static void error(String error)
	{
		System.err.println("ERROR: "+error);
	}
}
