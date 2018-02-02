package eu.jaaz.portal.core;

import java.util.LinkedList;
import java.util.List;

public class Site {
	
	String id;
	String domain;
	List<Language> languages = new LinkedList<Language>();

	public void addLangauge(Language lang)
	{
		this.languages.add(lang);
	}
	
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Site(String id)
	{
		this.id=id;
	}
	
	public String getId()
	{
		return id;
	}
	
}
