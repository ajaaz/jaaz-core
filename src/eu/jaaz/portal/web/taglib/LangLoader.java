package eu.jaaz.portal.web.taglib;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LangLoader {
	
	static Map<String, Properties> locales = new HashMap<String, Properties>();
	static Map<String, Properties> webLocales = new HashMap<String, Properties>();
	
	
	
	public synchronized static  void init(String lang)
	{
		if(lang == null)
			lang = "en";
		if(locales.containsKey(lang))
			return;
		
		Properties defLocale = new Properties();
		try {
			if(lang.equals("en"))				
				defLocale.load(new InputStreamReader(LangTag.class.getResourceAsStream("/lang/server.properties"), Charset.forName("UTF-8")));
			else
				defLocale.load(new InputStreamReader(LangTag.class.getResourceAsStream("/lang/server."+lang+".properties"), Charset.forName("UTF-8")));
		}
		catch(Exception e)
		{
			System.err.println("Unable to load default server locales for lang "+lang+"!");
			return;
		}
		locales.put(lang, defLocale);
		

		Properties defWebLocale = new Properties();
		try {
			if(lang.equals("en"))
				defWebLocale.load(new InputStreamReader(LangTag.class.getResourceAsStream("/lang/web.properties"), Charset.forName("UTF-8")));
			else
				defWebLocale.load(new InputStreamReader(LangTag.class.getResourceAsStream("/lang/web."+lang+".properties"), Charset.forName("UTF-8")));
		}
		catch(Exception e)
		{
			System.err.println("Unable to load default web locales for lang "+lang+"!");
			return;
		}
		webLocales.put(lang, defWebLocale);	
		
	}
	
	public static Properties getWebLocale(String lang)
	{
		init(lang);
		return webLocales.get(lang);
	}
	
	public static Properties getLocale(String lang)
	{
		init(lang);
		return locales.get(lang);
	}
}
