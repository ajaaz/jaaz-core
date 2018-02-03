package eu.jaaz.portal.web;

import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import eu.jaaz.portal.core.Site;
import eu.jaaz.portal.core.SiteManager;
import eu.jaaz.portal.web.taglib.LangLoader;

/**
 * Servlet implementation class LocaleServlet
 */

public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType( "application/javascript; charset=utf-8" );
		
		String lang = (String)request.getSession().getAttribute("lang");
		// TODO Auto-generated method stub
		Writer out = response.getWriter();
		
		Properties locale = LangLoader.getWebLocale(lang);
		out.append("var jLang = ");
		
		Gson gsonObject = new Gson();		
		out.append(gsonObject.toJson(locale));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
