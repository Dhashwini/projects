<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.bankcustomer.DbUtil.DbUtil"%>
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

        <body>
            <h3>BANK LOGIN- ADMIN</h3>

            <form id="loginAction" action="ChangePwd" method="POST">
                <table align="center" cellpadding = "10">


                    <%
                        String customerAccountNo = request.getParameter("customerAccountNo");

                    %>

                    <!----- First Name ---------------------------------------------------------->
                    <tr>
                        <td>USER ID</td>
                        <td><input type="text" name="userId" maxlength="30" value="<%=customerAccountNo%>" readonly="true"/>
                        </td>
                    </tr>

                    <!----- Last Name ---------------------------------------------------------->
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" maxlength="30"/>
                        </td>
                    </tr>

                    <!----- Submit and Reset ------------------------------------------------->
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Submit">
                            <input type="reset" value="Reset">
                        </td>
                    </tr>
                </table>

            </form>

        </body>
    </html>
    <!-- partial -->

</body>
</html>
