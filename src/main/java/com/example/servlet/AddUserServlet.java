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

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    //write your code here!

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  ServletException,IOException{
        String path = "jsp/add.jsp";
        //String path = "/add";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        try {
            requestDispatcher.forward(req, resp);
        }
        catch(ServletException | IOException e){
            e.printStackTrace();
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html");

        String f_name = req.getParameter("firstName");
        String l_name = req.getParameter("lastName");

        User user = new User(f_name, l_name);
        Warehouse.getInstance().addUser(user);

        req.setAttribute("user", user);

        try {
            resp.sendRedirect("/add");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
