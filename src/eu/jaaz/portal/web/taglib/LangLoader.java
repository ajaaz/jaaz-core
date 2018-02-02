package eu.jaaz.portal.web.taglib;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LangLoader {
	
	static Map<String, Properties> locales = new HashMap<String, Properties>();
	static Map<String, Properties> webLocales = new HashMap<String, Properties>();
	
	static boolean initialized = false;
	
	public synchronized static  void init()
	{
		if(initialized )
			return;
		
		Properties defLocale = new Properties();
		try {
			defLocale.load(LangTag.class.getResourceAsStream("/lang/server.properties"));
		}
		catch(Exception e)
		{
			System.err.println("Unable to load default server locales!");
			return;
		}
		locales.put("en", defLocale);
		

		Properties defWebLocale = new Properties();
		try {
			defWebLocale.load(LangTag.class.getResourceAsStream("/lang/web.properties"));
		}
		catch(Exception e)
		{
			System.err.println("Unable to load default web locales!");
			return;
		}
		webLocales.put("en", defWebLocale);	
		
		initialized = true;
	}
	
	public static Properties getWebLocale(String lang)
	{
		return webLocales.get("en");
	}
	
	public static Properties getLocale(String lang)
	{
		return locales.get("en");
	}
}
