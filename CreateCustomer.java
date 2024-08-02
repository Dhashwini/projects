/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankcustomer.request;

/**
 *
 * @author MVR-PC
 */
public class CreateCustomer {
    
    private String userId;
    private String fullName;
    private String gender;
    private String address;
    private String dob;
    private String emailId;
    private String mobileNo;
    private String idproof;
    private String IdProofType;
    private String accountType;
    private String initialBalance;
    private String password;
    private String customerAccountNo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getIdproof() {
        return idproof;
    }

    public void setIdproof(String idproof) {
        this.idproof = idproof;
    }

    public String getIdProofType() {
        return IdProofType;
    }

    public void setIdProofType(String IdProofType) {
        this.IdProofType = IdProofType;
    }
    
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(String initialBalance) {
        this.initialBalance = initialBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerAccountNo() {
        return customerAccountNo;
    }

    public void setCustomerAccountNo(String customerAccountNo) {
        this.customerAccountNo = customerAccountNo;
    }

    @Override
    public String toString() {
        return "CreateCustomer{" + "userId=" + userId + ", fullName=" + fullName + ", gender=" + gender + ", address=" + address + ", dob=" + dob + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", idproof=" + idproof + ", accountType=" + accountType + ", initialBalance=" + initialBalance + ", password=" + password + ", customerAccountNo=" + customerAccountNo + '}';
    }
   
}
