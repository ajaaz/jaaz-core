package eu.jaaz.portal.core;

import java.util.LinkedList;
import java.util.List;

public class SiteInfo {
	
	List<String> languages = new LinkedList<String>();
	String id;
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void addLangauge(String code)
	{
		languages.add(code);
	}
}
