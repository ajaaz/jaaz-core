package eu.jaaz.portal.core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */

public class RootServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RootServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI().substring(request.getContextPath().length());
		if(url.equals("/"))
		{
			response.sendRedirect("/portal");
			return;
		}
		if(url.startsWith("/portal"))
		{
			SiteManager manager = SiteManager.getSiteManager(request.getSession().getServletContext());
			Site site = manager.lookup(request.getServerName());
			request.setAttribute("site", site);
			
			if(!"DEV".equals(System.getProperty("jaaz.mode"))&&!request.getServerName().equals(site.getDomain()))
			{
				String redirect = request.getScheme()+"://"+site.getDomain()+"/"+
						request.getRequestURI().substring(request.getContextPath().length());
				response.sendRedirect(redirect);
				return;
			}
			
			renderPage(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("skin", "default");
		request.getRequestDispatcher("/skin/default/layout.jsp").include(request, response);
	}
}
