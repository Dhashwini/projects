/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankcustomer.action;

import com.bankcustomer.Dao.BankActionDao;
import com.bankcustomer.request.CreateCustomer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MVR-PC
 */
public class LoginAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private BankActionDao dao;

    public LoginAction() {
        super();
        dao = new BankActionDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateCustomer user = new CreateCustomer();
        String forward = "";
        user.setUserId(request.getParameter("userId"));
        user.setPassword(request.getParameter("password"));
        int a = dao.login(user);
        if (a == 0) {
            forward = "login.jsp";
        } else {
            forward = "listuser.jsp";
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        request.setAttribute("users", dao.getAlluser());
        view.forward(request, response);

    }

}
