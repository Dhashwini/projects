<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.bankcustomer.request.CreateCustomer"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Bank Login Form</title>
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>
        <!-- partial:index.partial.html -->
    <html>
        <head>
            <title>Bank Login Form</title>

        </head>

        <%
            List l = (List) request.getAttribute("users");
            if (l != null) {
                Iterator it = l.iterator();
                while (it.hasNext()) {
                    CreateCustomer user = (CreateCustomer) it.next();
                    String customerAccountNo = user.getCustomerAccountNo();
                  
        %>

        <body>
            <h3>CUSTOMER DASHBOARD LOGIN</h3>

            <form id="loginAction" action="customerdashboard.jsp" method="POST">
                <table align="center" cellpadding = "10">

                    <!----- Submit and Reset ------------------------------------------------->
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="CUSTOMER DASHBOARD" >
                        </td>
                    </tr>
                </table>

            </form>

            <br>
            <form >
                <table align="center" cellpadding = "10">

                    <!----- Submit and Reset ------------------------------------------------->
                    <tr>
                        <td colspan="2" align="center">
                            <a href="lastTranscation.jsp?customerAccountNo=<%=customerAccountNo%>" type="submit" value="CUSTOMER LAST TRANSCATIOn" >
                        </td>
                    </tr>
                </table>

            </form>
            <%
                    }
                }
            %>
        </body>
    </html>
    <!-- partial -->

</body>
</html>
