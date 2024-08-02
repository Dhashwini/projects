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
public class CustomerLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private BankActionDao dao;

    public CustomerLogin() {
        super();
        dao = new BankActionDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateCustomer user = new CreateCustomer();
        String forward = "";
        String customerid = request.getParameter("customerID");
        String password = request.getParameter("password");
        int a = dao.customerlogin(customerid, password);
        if (a == 0) {
            forward = "login.jsp";
        } else {
            forward = "customerdashboard.jsp";
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        request.setAttribute("users", dao.getAllID(customerid));
        view.forward(request, response);

    }
}
