package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.AI_ReStudy_Server_To;

/**
 * Servlet implementation class UpdateService
 */
@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("modal_num"));
		int state =  Integer.parseInt(request.getParameter("modal_state"));
		String content = request.getParameter("modal_content");
		String writer = request.getParameter("modal_writer");
		String gps = request.getParameter("modal_gps");
		String addr = request.getParameter("modal_addr");
		String time = request.getParameter("modal_time");
		String src = request.getParameter("modal_src");

		if(ProblemDAO.getDao().update(new ProblemDTO(num, content, writer, gps, addr, time, state))) {
			if(state == 2) {
				//////////////////딥러닝 재학습부///////////////////
				AI_ReStudy_Server_To.setReStudy(src.replace("./upload/", ""));
			}
			
			request.getSession().setAttribute("msg", "접수번호 "+ num + "의 처리가 완료되었습니다.");
		} else {
			request.getSession().setAttribute("msg", "접수번호 "+ num + "의 처리가 실패하였습니다.\\n관리자 번호 : 010-7552-0440");
		}
		request.getSession().setAttribute("link", "#services");
		response.sendRedirect("/service");
	}

}
