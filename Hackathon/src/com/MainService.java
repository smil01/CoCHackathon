package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainService
 */
@WebServlet("/service")
public class MainService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		request.setAttribute("list", ProblemDAO.getDao().selectAll());
		
		UserDTO user = (UserDTO)request.getSession().getAttribute("user");
		if(user == null) {
			request.getSession().setAttribute("user", new UserDTO("홍길동", "010-7500-0000", "testUser", "test123", "test@daum.net"));
		}
		
		dispatcher.forward(request, response);
	}
}
