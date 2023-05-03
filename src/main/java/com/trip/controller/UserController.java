package com.trip.controller;

import com.trip.dto.User;
import com.trip.model.service.UserService;
import com.trip.model.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController {

    UserService service;

    public UserController() {
        service = new UserServiceImpl();
    }

    public void loginForm(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/login.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void login(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        
        User user = new User();
        user.setId(request.getParameter("id"));
        user.setPw(request.getParameter("pw"));
        boolean flag = service.signIn(user);

        if(flag){
            HttpSession session = request.getSession();

            if (session.getAttribute("user") == null) {
                session.setAttribute("user",user);
            }
            try {
                response.sendRedirect("/trip");
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("true");
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginForm");
            try {
                requestDispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("false");
        }
    }

    public void signUpForm(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/join.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void signUp(HttpServletRequest request, HttpServletResponse response){

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String email_1 = request.getParameter("email_1");
        String email_2 = request.getParameter("email_2");

        User user = new User(id,pw,name,email_1,email_2);

        service.signUp(user);

        boolean success = service.signUp(user);

        try {
            response.sendRedirect("/trip");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void detail(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session;

        session = request.getSession();

        User user = (User) session.getAttribute("user");

        String id = user.getId();

        User u = service.userDetail(id);

        request.setAttribute("userInfo",u);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/userInfo.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void modifyForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        User u = service.userDetail(user.getId());
        request.setAttribute("userInfo",u);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/userModify.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modify(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String name = request.getParameter("name");
        String id = request.getParameter("id");

        service.modify(name,id);

        try {
            response.sendRedirect("/trip");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String id = request.getParameter("id");
        service.delete(id);
        HttpSession session = request.getSession();
        session.invalidate();

        try {
            response.sendRedirect("/trip");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.invalidate();

        try {
            response.sendRedirect("/trip");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
