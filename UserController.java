/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankcustomer.action;

import com.bankcustomer.Dao.BankActionDao;
import com.bankcustomer.request.CreateCustomer;
import com.mysql.jdbc.StringUtils;
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
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String INSERT_EDIT = "user.jsp";
    private String VIEW_DELETE = "listuser.jsp";
    private BankActionDao dao;

    public UserController() {
        super();
        dao = new BankActionDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            forward = VIEW_DELETE;
            String customerAccountNo = request.getParameter("customerAccountNo");
            dao.deleteUser(customerAccountNo);
            request.setAttribute("users", dao.getAlluser());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_EDIT;
            String customerAccountNo = request.getParameter("customerAccountNo");
            request.setAttribute("users", dao.getAlluserbyid(customerAccountNo));
        } else if (action.equalsIgnoreCase("listuser")) {
            forward = VIEW_DELETE;
            request.setAttribute("users", dao.getAlluser());
        } else {
            forward = INSERT_EDIT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
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
//        String customerAccountNo = request.getParameter("customerAccountNo");
        String action = request.getParameter("action");
        if (!StringUtils.isNullOrEmpty(user.getUserId()) & action.equalsIgnoreCase("create") ) {
            dao.addUser(user);
        } 
        RequestDispatcher view = request.getRequestDispatcher(VIEW_DELETE);
        request.setAttribute("users", dao.getAlluser());
        view.forward(request, response);
    }

}
