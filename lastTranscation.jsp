<%@page import="com.bankcustomer.DbUtil.DbUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
                        <th>lastavailablebalance</th>
                        <th>transferamount</th>
                        <th>availablebalance</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                            String lastavailablebalance = null;
                             String transferamount = null;
                             String availablebalance = null;
                            String customerAccountNo = request.getParameter("customerAccountNo");
                            PreparedStatement pstmt = DbUtil.getConnection().prepareStatement("select * from transcation where CustomerId=?");
                            pstmt.setString(1, customerAccountNo);
                            ResultSet rs = pstmt.executeQuery();
                            while (rs.next()) {
                                lastavailablebalance = rs.getString("lastavailableBalance");
                                transferamount = rs.getString("transferamount");
                                availablebalance = rs.getString("availablebalance");
                            
                        %>
                    <tr style="background-color:yellow">
                        <td><%=customerAccountNo%></td>
                        <td><%=rs.getString("lastavailableBalance")%></td>
                        <td><%=rs.getString("transferamount")%></td>
                        <td><%=rs.getString("availablebalance")%></td>                       
                    </tr>
                    <%
                        }
                %>
                </tbody>
            </table>
        </center>
    </body>
</html>