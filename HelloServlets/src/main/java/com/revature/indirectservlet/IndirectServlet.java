package com.revature.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndirectServlet
 */
public class IndirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// init() is abstracted away
	// tomcat involkes the init() when the url is hit
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// let's redirect the user to some seperate static resource 
		// when we use sendRedirect a new request is created and redirected to a seperate resource
//		response.sendRedirect("http://localhost:8080/HelloServlets/dirserv");
		
		// We can use either the top or bottom methods 
		
		response.sendRedirect("http://localhost:8080/HelloServlets/somepage.html"); //we can redirect the user to a seperate page.
		
		System.out.println("Config Example: " + getServletConfig().getInitParameter("configExample"));
	}

	// What is the difference between sendRedirect() and forward() from the RequestDispatcher?
	// sendRedirect uses a different resource and changes the url
	// when you forward it the url stays the same
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rdis = request.getRequestDispatcher("/dirserv");
		
		rdis.forward(request, response);
		
	}

}
