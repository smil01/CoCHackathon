package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadService
 */
@WebServlet("/UploadService")
public class UploadService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String content = request.getParameter("img_content");
		String writer = request.getParameter("img_writer");
		String machine = request.getParameter("img_machine");
		String gps = request.getParameter("img_gps");
		String addr = request.getParameter("img_addr");
		String time = request.getParameter("img_time");
		String src = request.getParameter("img_src");

		if (ProblemDAO.getDao().insert(new ProblemDTO(content, writer, machine, gps, addr, time, src))
				&& ProblemDAO.getDao().top() != 0) {
			request.getSession().setAttribute("msg", writer + "님의 접수가 완료되었습니다. \\n접수번호 : " + ProblemDAO.getDao().top());
		} else {
			request.getSession().setAttribute("msg", writer + "님의 접수에 실패하였습니다. \\n관리자 번호 : 010-7552-0440");
		}
		request.getSession().setAttribute("link", "#services");
		response.sendRedirect("/service");
	}

}
