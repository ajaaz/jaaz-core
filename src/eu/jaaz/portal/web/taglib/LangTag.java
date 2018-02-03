package eu.jaaz.portal.web.taglib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LangTag extends SimpleTagSupport {
	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void doTag() throws JspException, IOException {
	    PageContext context = (PageContext)getJspContext();
	    
		String lang = (String) context.getAttribute("lang", context.SESSION_SCOPE);

		  JspWriter out = getJspContext().getOut();
	      
	      Properties p = LangLoader.getWebLocale(lang);
	      String txt = p.getProperty(message);
	      if(txt != null)
	      {
	    	   out.print(txt);
	    	   return;
	      }
	      p = LangLoader.getLocale(lang);
	      txt = p.getProperty(message);
	      if(txt == null)
	    	  out.print(message);
	      else
	    	  out.print(txt);
	 }
}
