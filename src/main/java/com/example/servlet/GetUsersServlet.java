package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Set<User> users = Warehouse.getInstance().getUsers();
        req.setAttribute("users", users);
        String path = "jsp/users.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        try{
            requestDispatcher.forward(req, resp);
        }catch (ServletException e){
            e.printStackTrace();
        }
//        try {
//            resp.sendRedirect("/users");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
    //write your code here!
}
