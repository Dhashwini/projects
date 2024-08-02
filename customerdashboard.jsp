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
                        <th>User Id</th>
                        <th>DOB</th>
                        <th>Full Name</th>
                        <th>Gender</th>
                        <th>Account Type</th>
                        <th>Id Proof Type</th>
                        <th>Id Proof</th>
                        <th>Mobile No</th>
                        <th>Email Id</th>
                        <th>Address</th>
                        <th>Account Balance</th>
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
                                    String idproofType = user.getIdProofType();
                                    String mobileNo = user.getMobileNo();
                                    String emailId = user.getEmailId();
                                    String dob = user.getDob();
                                    String userId = user.getUserId();
                                    String address = user.getAddress();
                                    String balanceAmount = user.getInitialBalance();
                        %>
                    <tr style="background-color:yellow">
                        <td><%=customerAccountNo%></td>
                        <td><%=userId%></td>
                        <td><%=dob%></td>
                        <td><%=fullname%></td>
                        <td><%=gender%></td>
                        <td><%=accountType%></td>
                        <td><%=idproof%></td>
                        <td><%=idproofType%></td>
                        <td><%=mobileNo%></td>
                        <td><%=emailId%></td>
                        <td><%=address%></td>
                        <td><%=balanceAmount%></td>
                        <td><a href="withdrawDepositForm.jsp?customerAccountNo=<%=customerAccountNo%>&&balanceAmount=<%=balanceAmount%>">WithDraw</a></td>
                        <td><a href="withdrawDepositForm.jsp?customerAccountNo=<%=customerAccountNo%>&&balanceAmount=<%=balanceAmount%>">Deposit</a></td>
                        </tr>
                </tbody>
            </table>
                        <br><br>
                        <td><a href="lastTranscation.jsp?customerAccountNo=<%=customerAccountNo%>">Last Transcation History</a></td>
                        <td><a href="changepwd.jsp?customerAccountNo=<%=customerAccountNo%>">Change Password</a></td>
                <%
                        }
                    }
                %>
                
        </center>
</body>
</html>