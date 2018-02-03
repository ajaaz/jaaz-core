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
				
		parseLanguages(e, s);
		
		buildSiteInfo(s);
		return s;
	}
	
	void parseLanguages(Element e, Site s)
	{
		Element langs = e.element("languages");
		
		if(langs==null)
		{
			Debug.debug("Found no languages. Assuming English as default!");
			
			Language lang = new Language();
			lang.setDefaultLanguge(true);
			lang.setCode("en");
			
			s.addLangauge(lang);
			return;
		}
		
		List<Element> languages = langs.elements("lang");
		
		Language first = null;
		boolean defaultSet = false;
		
		for(Element l: languages)
		{
			String code = l.attributeValue("code");
			String def = l.attributeValue("default");
			
			Language langObj = new Language();
			langObj.setCode(code);
			if("true".equals(def))
			{
				defaultSet = true;
				langObj.setDefaultLanguge(true);
			}
			else
				langObj.setDefaultLanguge(false);
		
			if(first == null)
				first = langObj;
			s.addLangauge(langObj);
			
			String txt = "Addedd language "+langObj.getCode();
			if(langObj.isDefaultLanguge())
				txt +=" (default)";
			
			Debug.debug(txt);
		}
		
		if(first != null && !defaultSet)
		{
			Debug.debug("Set language "+first.getCode()+" as default");
		}
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
	
	protected void buildSiteInfo(Site s)
	{
		SiteInfo info = new SiteInfo();
		info.setId(s.getId());
		
		List<Language> langs = s.getLanguages();
		for(Language l: langs)
		{
			info.addLangauge(l.getCode());
		}
		s.setInfo(info);
	}
}
