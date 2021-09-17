package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SuperVillain mudman = new SuperVillain("Mud Man", "Mud armor", 500);
		
		//HttpSession is an interface that provides us with the functionality to store user info across our application
		HttpSession session = request.getSession();
		
		// this session can be retrieved later by a seperate servlet 
		session.setAttribute("the-villain", mudman);
		
		PrintWriter out = response.getWriter();
		
		out.write(new ObjectMapper().writeValueAsString(mudman));
		
		out.println("Mudman is on the loose and the session is set");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Capture the input from the HTTP post request and create a Java object 
		String name = request.getParameter("name");
		String superpower = request.getParameter("superpower");
		double bounty = Double.parseDouble(request.getParameter("bounty"));
		
		// 2. Convert the capture params into an object by passing it thru the Supervilian consturctor
		SuperVillain villain = new SuperVillain(name, superpower, bounty);
		// 3. grab the HttpSession from the request obj
		HttpSession session = request.getSession();
		// 4 and send the custom villain to the session
		session.setAttribute("the-villain", villain);
		// 5. print to the screen that the villain obj has been set to the session
		PrintWriter out = response.getWriter();
		
		out.write(new ObjectMapper().writeValueAsString(villain));
		
		out.println(villain.getName() + " is on the loose and the session is set");
		
		// now we have to create a servlet to retreive the session
	}

}
