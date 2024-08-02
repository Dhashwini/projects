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
public class UserControllerUpdate extends HttpServlet {
    
    private BankActionDao dao;
    private String VIEW_DELETE = "listuser.jsp";
    
     public UserControllerUpdate() {
        super();
        dao = new BankActionDao();
    }


     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreateCustomer user = new CreateCustomer();
        user.setFullName(request.getParameter("fullName"));
        user.setGender(request.getParameter("gender"));
        user.setAccountType(request.getParameter("accountType"));
        user.setAddress(request.getParameter("address"));
        user.setDob(request.getParameter("dob"));
        user.setEmailId(request.getParameter("emailId"));
        user.setIdproof(request.getParameter("idproof"));
        user.setIdProofType(request.getParameter("IdProofType"));
        user.setInitialBalance(request.getParameter("initialBalance"));
        user.setMobileNo(request.getParameter("mobileNo"));
        user.setUserId(request.getParameter("userid"));
        String customerAccountNo = request.getParameter("customerAccountNo");
        String action = request.getParameter("action");
      
       dao.updateUser(user, customerAccountNo);
        
        RequestDispatcher view = request.getRequestDispatcher(VIEW_DELETE);
        request.setAttribute("users", dao.getAlluser());
        view.forward(request, response);
    }


}
