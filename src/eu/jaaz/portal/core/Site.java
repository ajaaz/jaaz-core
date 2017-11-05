package eu.jaaz.portal.core;

public class Site {
	
	String id;
	String domain;
	
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
