package com.example.servletand.servlet;


import com.example.servletand.dao.datasource.SimpleDatasource;
import com.example.servletand.dao.impl.UserDaoImpl;
import com.example.servletand.dao.mappers.UserMapper;
import com.example.servletand.model.*;
import com.example.servletand.dao.*;
import com.example.servletand.service.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "mainServlet", value = "/main")
public class MainServlet extends HttpServlet {
    private StudentService service;

    private String message;

    public void init() {
        service = new StudentService(new UserDaoImpl(new UserMapper()), new SimpleDatasource());
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String command = request.getParameter("command");
        List<User> listOfUsers = service.findAll();
//        List<User> listOfUsers = new ArrayList<>();
//        listOfUsers.add(new User(1L, "name" , "surname" , 13));
//        listOfUsers.add(new User(2L, "name2" , "surname2" , 132));
//        listOfUsers.add(new User(3L, "name3" , "surname3" , 133));
        PrintWriter out = response.getWriter();
        if(listOfUsers.size() == 0){
            out.println("<html><body>");
            out.println("<h1>" +  "No elements !" +  "</h1>");
            out.println("</body></html>");
           return;
        }

        out.println("<html><body>");
        for(int i = 0; i < listOfUsers.size(); i++){
            out.println("<h3>" +  listOfUsers.get(i).getName()  + " " +
                     listOfUsers.get(i).getSurname()  + " " +
                     listOfUsers.get(i).getAge() + "</h3>");

        }
        out.println("</body></html>");

//        if(command.equals("add")) response.sendRedirect("/webapp_war_exploded/adding"); //redirecting to AddingSocket
    }

    public void destroy() {
    }

}
