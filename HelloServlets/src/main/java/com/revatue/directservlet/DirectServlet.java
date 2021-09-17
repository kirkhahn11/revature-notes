package com.revatue.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

public class DirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// This method will handle incoming HTTP requests to the server, and we can send back requests upon receiving a GET request 
		response.setContentType("text/html");
		
		/**
		 * PrintWriter is an object that prints text data to a character stream which we can call
		 * on the response object 
		 */
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>The Servlet is talking directly to the client</h1></body></html>");
		
		System.out.println("Context Example: " + getServletContext().getInitParameter("contextExample"));
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("application/json");
		
		// step 1. Create a hardcoded SuperVillain object
		SuperVillain vill = new SuperVillain("The Penguin", "money", 40);
		
		// step 2. send the SuperVillain object in the form of JSON to the browser
		response.getWriter().write(new ObjectMapper().writeValueAsString(vill));
	}

}
