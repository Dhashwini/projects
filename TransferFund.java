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
public class TransferFund extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private BankActionDao dao;

    public TransferFund() {
        super();
        dao = new BankActionDao();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateCustomer user = new CreateCustomer();
        String forward = "";
        String customerAccountNo = request.getParameter("customerAccountNo");
        String transfer = request.getParameter("transfer");
        int balanceAmount = Integer.parseInt(request.getParameter("balanceAmount"));
        int amount = Integer.parseInt(request.getParameter("Amount"));
        int finalamount = 0;
        if (transfer.equalsIgnoreCase("Withdraw")) {
            finalamount = balanceAmount - amount;
            if (finalamount < 0) {
                RequestDispatcher view = request.getRequestDispatcher("insufficentfund.jsp");
                view.forward(request, response);
            } else {
                dao.insertDepositWithDrawAmount(balanceAmount, finalamount,amount, customerAccountNo);
                dao.updateDepositWithDrawAmount(balanceAmount, finalamount,amount, customerAccountNo);
            }

        } else if (transfer.equalsIgnoreCase("Deposit")) {
            finalamount = balanceAmount + amount;
            dao.insertDepositWithDrawAmount(balanceAmount, finalamount,amount, customerAccountNo);
            dao.updateDepositWithDrawAmount(balanceAmount, finalamount,amount, customerAccountNo);
            
        }
      
        forward = "customerdashboard.jsp";
        RequestDispatcher view = request.getRequestDispatcher(forward);
        request.setAttribute("users", dao.getAllID(customerAccountNo));
        view.forward(request, response);

    }

}
