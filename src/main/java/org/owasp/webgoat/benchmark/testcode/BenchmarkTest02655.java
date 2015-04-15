package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02655")
public class BenchmarkTest02655 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map72046 = new java.util.HashMap<String,Object>();
		map72046.put("keyA-72046", "a_Value"); // put some stuff in the collection
		map72046.put("keyB-72046", param.toString()); // put it in a collection
		map72046.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map72046.get("keyB-72046"); // get it back out
		bar = (String)map72046.get("keyA-72046"); // get safe value back out
		
		
		response.getWriter().write(bar);
	}
}