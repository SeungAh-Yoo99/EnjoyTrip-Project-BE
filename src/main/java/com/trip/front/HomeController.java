package com.trip.front;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trip.controller.AttractionController;

@WebServlet("")
public class HomeController extends HttpServlet {

	AttractionController acon;
	
	public HomeController() {
		acon = new AttractionController();
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		// client에서 server로 보내는 한글처리
		request.setCharacterEncoding("utf-8");
		
		acon.index(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
}
