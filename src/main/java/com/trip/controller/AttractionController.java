package com.trip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trip.dto.AttractionInfo;
import com.trip.dto.Sido;
import com.trip.model.service.AttractionService;
import com.trip.model.service.AttractionServiceImpl;

public class AttractionController {
	
	AttractionService aservice;
	
	public AttractionController() {
		aservice = new AttractionServiceImpl();
	}

	public void index(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<AttractionInfo> alist = aservice.selectTop8();
		request.setAttribute("attractionList", alist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchAttraction(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<Sido> sidoList = aservice.getSidoList();
		request.setAttribute("sidoList", sidoList);
		
		/*
		ArrayList<AttractionInfo> alist = aservice.searchAttraction();
		request.setAttribute("attractionList", alist);
		*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/searchAttraction.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void showAttractionList(HttpServletRequest request, HttpServletResponse response) {
		String sido_code = request.getParameter("location");
		
		ArrayList<AttractionInfo> alist = aservice.getAttractionListBySidoCode(sido_code);
		request.setAttribute("attractionList", alist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/attractionList.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void attractionDetail(HttpServletRequest request, HttpServletResponse response) {

		String content_id = request.getParameter("content_id");
		AttractionInfo ai = aservice.attractionDetail(content_id);

		request.setAttribute("attraction", ai);

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/attractionDetail.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
