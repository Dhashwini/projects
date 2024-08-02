/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankcustomer.action;

import com.bankcustomer.Dao.BankActionDao;
import com.bankcustomer.request.CreateCustomer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MVR-PC
 */
public class ChangePwd extends HttpServlet {

     private BankActionDao dao;

    public ChangePwd() {
        super();
        dao = new BankActionDao();

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String customerAccountNo = request.getParameter("userId");
         String password = request.getParameter("password");
        dao.updatepwd(password, customerAccountNo);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);

    }
}
