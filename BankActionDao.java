/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankcustomer.Dao;

import com.bankcustomer.DbUtil.DbUtil;
import com.bankcustomer.request.CreateCustomer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MVR-PC
 */
public class BankActionDao {

    private Connection connection;

    private static final long LIMIT = 10000000000L;
    private static long last = 0;

    public BankActionDao() {
        connection = DbUtil.getConnection();
    }

    public void deleteUser(String customerAccountNo) {
        try {

            PreparedStatement pstmt = connection.prepareStatement("delete from users where customerAccountNo=?");
            pstmt.setString(1, customerAccountNo);
            pstmt.executeUpdate();
            System.out.println("Deleted SuccessFully");
        } catch (Exception e) {
            System.out.println("Error while Deleting" + e);
            e.printStackTrace();
        }
    }

    public List<CreateCustomer> getAlluser() {

        List<CreateCustomer> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                CreateCustomer user = new CreateCustomer();
                user.setUserId(rs.getString("userId"));
                user.setFullName(rs.getString("fullName"));
                user.setDob(rs.getString("dob"));
                user.setEmailId(rs.getString("emailId"));
                user.setMobileNo(rs.getString("mobileNo"));
                user.setIdproof(rs.getString("idproof"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setAccountType(rs.getString("accountType"));
                user.setInitialBalance(rs.getString("initialBalance"));
                user.setCustomerAccountNo(rs.getString("customerAccountNo"));
                list.add(user);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }
    
    public List<CreateCustomer> getAllID(String customerAccountNo) {

        List<CreateCustomer> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where customerAccountNo='"+customerAccountNo+"'");
            while (rs.next()) {
                CreateCustomer user = new CreateCustomer();
                user.setUserId(rs.getString("userId"));
                user.setFullName(rs.getString("fullName"));
                user.setDob(rs.getString("dob"));
                user.setEmailId(rs.getString("emailId"));
                user.setMobileNo(rs.getString("mobileNo"));
                user.setIdproof(rs.getString("idproof"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setAccountType(rs.getString("accountType"));
                user.setInitialBalance(rs.getString("initialBalance"));
                user.setCustomerAccountNo(rs.getString("customerAccountNo"));
                list.add(user);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }

    public void addUser(CreateCustomer user) {
        UUID randomUUID = UUID.randomUUID();
        try {
            PreparedStatement pstmt = connection.prepareStatement("insert into users(fullname,dob,emailId,mobileNo,idproof,gender,address,accountType,initialBalance,customerAccountNo,password,IdProofType,status,userId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, user.getFullName());
            pstmt.setString(2, user.getDob());
            pstmt.setString(3, user.getEmailId());
            pstmt.setString(4, user.getMobileNo());
            pstmt.setString(5, user.getIdproof());
            pstmt.setString(6, user.getGender());
            pstmt.setString(7, user.getAddress());
            pstmt.setString(8, user.getAccountType());
            pstmt.setString(9, user.getInitialBalance());
            pstmt.setString(10, String.valueOf(getID()));//customer account no
            pstmt.setString(11, randomUUID.toString());//generate random password
            pstmt.setString(12, user.getIdProofType());
            pstmt.setString(13, "active");
            pstmt.setString(14, user.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception occurred" + e);
            e.printStackTrace();
        }

    }

    public void updateUser(CreateCustomer user, String customerAccountNo) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("update users set fullname=?,dob=?,emailId=?,mobileNo=?,gender=?,address=?,accountType=? where customerAccountNo=?");
            pstmt.setString(1, user.getFullName());
            pstmt.setString(2, user.getDob());
            pstmt.setString(3, user.getEmailId());
            pstmt.setString(4, user.getMobileNo());
            pstmt.setString(5, user.getGender());
            pstmt.setString(6, user.getAddress());
            pstmt.setString(7, user.getAccountType());
            pstmt.setString(8, customerAccountNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public List<CreateCustomer> getAlluserbyid(String customerAccountNo) {

        List<CreateCustomer> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("select * from users where customerAccountNo=?");
            pstmt.setString(1, customerAccountNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CreateCustomer user = new CreateCustomer();
                user.setUserId(rs.getString("userId"));
                user.setFullName(rs.getString("fullName"));
                user.setDob(rs.getString("dob"));
                user.setEmailId(rs.getString("emailId"));
                user.setMobileNo(rs.getString("mobileNo"));
                user.setIdproof(rs.getString("idproof"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setAccountType(rs.getString("accountType"));
                user.setInitialBalance(rs.getString("initialBalance"));
                user.setCustomerAccountNo(rs.getString("customerAccountNo"));
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int login(CreateCustomer user) {
        int count = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Admin");
            while (rs.next()) {
                if ((rs.getString("userId")).equals(user.getUserId()) && rs.getString("password").equals(user.getPassword())) {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;

    }
    
    public int customerlogin(String customerid, String password) {
        int count = 0;
        try {
            
            PreparedStatement pstmt = DbUtil.getConnection().prepareStatement("select * from users where customerAccountNo='"+customerid+"' and password='"+password+"'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("result executed after query" +rs.getString("customerAccountNo"));
//                if ((rs.getString("customerID")).equals(user.getCustomerAccountNo()) && rs.getString("password").equals(user.getPassword())) {
                    count++;
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;

    }
    
     public void insertDepositWithDrawAmount(int balanceAmount, int amounttranfered, int amount, String customerAccountNo) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("insert into transcation(lastavailableBalance,transferamount,availablebalance,CustomerId) values(?,?,?,?)");
            pstmt.setInt(1, balanceAmount);
            pstmt.setInt(2, amount);
            pstmt.setInt(3, amounttranfered);
            pstmt.setString(4, customerAccountNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception update Failed"+e);
            e.printStackTrace();
        }

    }
    
    public void updateDepositWithDrawAmount(int balanceAmount, int amounttranfered, int amount, String customerAccountNo) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("update users set initialBalance='"+amounttranfered+"' where customerAccountNo='"+customerAccountNo+"'");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception update Failed"+e);
            e.printStackTrace();
        }

    }
    
     public void updatepwd(String password, String customerAccountNo) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("update users set password='"+password+"' where customerAccountNo='"+customerAccountNo+"'");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception update Failed"+e);
            e.printStackTrace();
        }

    }

    public static long getID() {
        // 10 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if (id <= last) {
            id = (last + 1) % LIMIT;
        }
        return last = id;
    }

}
