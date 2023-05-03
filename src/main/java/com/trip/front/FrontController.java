package com.trip.front;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trip.controller.AttractionController;
import com.trip.controller.UserController;

@WebServlet("/")
public class FrontController extends HttpServlet {

    AttractionController acon;
    UserController ucon;

    public FrontController() {
        acon = new AttractionController();
        ucon = new UserController();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        // client에서 server로 보내는 한글처리
        request.setCharacterEncoding("utf-8");

        String reqString = request.getServletPath();

        if (reqString.equals("/searchAttraction")) { // 관광명소 검색
            acon.searchAttraction(request, response);
        } else if (reqString.equals("/attractionList")) { // 주소 별 관광지 리스트
            acon.showAttractionList(request, response);
        } else if (reqString.equals("/loginForm")) { // 주소 별 관광지 리스트
            ucon.loginForm(request, response);
        } else if (reqString.equals("/login")) { // 주소 별 관광지 리스트
            ucon.login(request, response);
        } else if (reqString.equals("/signupForm")) { // 주소 별 관광지 리스트
            ucon.signUpForm(request, response);
        } else if (reqString.equals("/signUp")) { // 주소 별 관광지 리스트
            ucon.signUp(request, response);
        } else if (reqString.equals("/userInfo")) { // 주소 별 관광지 리스트
            ucon.detail(request, response);
        } else if (reqString.equals("/modifyForm")) { // 주소 별 관광지 리스트
            ucon.modifyForm(request, response);
        } else if (reqString.equals("/modify")) { // 주소 별 관광지 리스트
            ucon.modify(request, response);
        } else if (reqString.equals("/delete")) { // 주소 별 관광지 리스트
            ucon.delete(request, response);
        } else if (reqString.equals("/detail")) { // attraction 상세 정보
            acon.attractionDetail(request, response);
        } else if (reqString.equals("/logout")) { // attraction 상세 정보
            ucon.logout(request, response);
        }else {
            acon.index(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
