package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserService
 */
@WebServlet("/UserService")
public class UserService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		request.getSession().setAttribute("user", new UserDTO(request.getParameter("modal2_name"), request.getParameter("modal2_number"), request.getParameter("modal2_id"), request.getParameter("modal2_pw"), request.getParameter("modal_email")));
		
		request.getSession().setAttribute("msg", request.getParameter("modal2_name") + "님의 정보가 수정되었습니다.");
		response.sendRedirect("/service");
	}

}
