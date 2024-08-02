<%@page import="com.bankcustomer.request.CreateCustomer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%--<%@ page import="com.bankcustomer.request.*" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <center>
            <div style='float: right;'><a href="index.jsp">Log out</a></div>
            <table border="1">
                <caption>User Page</caption>
                <thead>
                    <tr style="background-color:teal">
                        <th>Customer Account No</th>
                        <th>Full Name</th>
                        <th>Gender</th>
                        <th>Account Type</th>
                        <th>Id Proof</th>
                        <th>Mobile No</th>
                        <th>Email Id</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                            List l = (List) request.getAttribute("users");
                            if (l != null) {
                                Iterator it = l.iterator();
                                while (it.hasNext()) {
                                    CreateCustomer user = (CreateCustomer) it.next();
                                    String customerAccountNo = user.getCustomerAccountNo();
                                    String fullname = user.getFullName();
                                    String gender = user.getGender();
                                    String accountType = user.getAccountType();
                                    String idproof = user.getIdproof();
                                    String mobileNo = user.getMobileNo();
                                    String emailId = user.getEmailId();
                        %>
                    <tr style="background-color:yellow">
                        <td><%=customerAccountNo%></td>
                        <td><%=fullname%></td>
                        <td><%=gender%></td>
                        <td><%=accountType%></td>
                        <td><%=idproof%></td>
                        <td><%=mobileNo%></td>
                        <td><%=emailId%></td>
                        <td><a href="UserController?action=edit&customerAccountNo=<%=customerAccountNo%>">Update</a></td>
                        <td><a href="UserController?action=delete&customerAccountNo=<%=customerAccountNo%>">Delete</a></td>
                        <%
                                }
                            }
                        %>
                    </tr>
                </tbody>
            </table>
                    <p><a href="registerCutomers.jsp">Add User</a></p>
        </center>
    </body>
</html>