package eu.jaaz.portal.core;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class SiteManager {

	static SiteManager manager;	
	ServletContext context;
	
	HashMap<String, Site> sites = new HashMap<String, Site>();
	Site defaultSite;
	HashMap<String, Site> domains = new HashMap<String,Site>();
	
	public Site getDefaultSite()
	{
		return defaultSite;
	}
	
	private SiteManager(ServletContext context)
	{
		this.context = context;
	}
	
	public static synchronized SiteManager getSiteManager(ServletContext context)
	{
		
		if(manager == null)
		{
			manager = new SiteManager(context);
			try {
				manager.init();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Debug.error("Unable to initialize Site Manager: "+e);
				e.printStackTrace();
				
			}
		}
		return manager;
	}
	
	void init() throws DocumentException, MalformedURLException
	{
		Debug.debug("Initializing Site Manager");
		SAXReader sax = new SAXReader();
		Document doc = sax.read(context.getResource("/WEB-INF/sites.xml"));
		List<Element> elements = doc.getRootElement().elements("site");
		Debug.debug("Found "+elements.size()+" sites. Parsing...");
		for(Element e: elements)
		{
			Site s = parseSite(e);
			sites.put(s.getId(),s);
		}
	}
	
	Site parseSite(Element e)
	{		
		Site s = new Site(e.attributeValue("id"));
		if("true".equals(e.attributeValue("default")))
			this.defaultSite = s;	
		
		String domain = e.attributeValue("domain");
		domains.put(domain.toLowerCase(), s);
		s.setDomain(domain);
		
		List<Element> domainList = e.elements("domain");
		for(Element dom: domainList)		
			domains.put(dom.attributeValue("name").toLowerCase(), s);
				
		return s;
	}
	
	public Site lookup(String domain)
	{
		domain = domain.toLowerCase();
		if(domain.startsWith("www."))
			domain = domain.substring(4);
		Site s = domains.get(domain);
		if(s==null)
			return defaultSite;
		return s;
	}
}
