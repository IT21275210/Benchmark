package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05930")
public class BenchmarkTest05930 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		String bar;
		String guess = "ABC";
		char switchTarget = guess.charAt(2);
		
		// Simple case statement that assigns param to bar on conditions 'A' or 'C'
		switch (switchTarget) {
		  case 'A':
		        bar = param;
		        break;
		  case 'B': 
		        bar = "bobs_your_uncle";
		        break;
		  case 'C':
		  case 'D':        
		        bar = param;
		        break;
		  default:
		        bar = "bobs_your_uncle";
		        break;
		}
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}