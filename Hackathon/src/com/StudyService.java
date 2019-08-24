package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Util.AI_Classification_Server_To;

@WebServlet("/StudyService")
public class StudyService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String savePath = request.getServletContext().getRealPath("upload");

		MultipartRequest multi = new MultipartRequest(request, savePath, 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());
		String fileName = multi.getFilesystemName("camera");

		JsonObject map = Photo.getInfo(savePath + "\\" +fileName);
		
		if(map==null) {
			
		} else {
			///////////////////////////////딥러닝자리///////////////////////////////////
			map.addProperty("content", AI_Classification_Server_To.getClassification(fileName));
			////////////////////////////////////////////////////////////////////////
			map.addProperty("writer", "오대근");
			map.addProperty("src", "./upload/" + fileName);
		}
		System.out.println("restAPI 작동 결과 : " + map);
		response.getWriter().println(map);
	}

}
