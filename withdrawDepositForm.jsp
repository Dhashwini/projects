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
            <h3>Withdraw/Deposit</h3>

            <form id="TransferFund" action="TransferFund" method="POST">
                <table align="center" cellpadding = "10">

                    <%
                        String customerAccountNo = request.getParameter("customerAccountNo");
                        String balanceAmount = request.getParameter("balanceAmount");
                    %>

                    <td><input type="hidden" name="customerAccountNo" value="<%=customerAccountNo%>"/>
                    <td><input type="hidden" name="balanceAmount" value="<%=balanceAmount%>"/>
                        <!----- First Name ---------------------------------------------------------->
                    <tr>
                        <td>Amount</td>
                        <td><input type="text" name="Amount" maxlength="30"/>
                        </td>
                    </tr>

                    <!----- Gender ----------------------------------------------------------->
                    <tr>
                        <td>Withdraw/Deposit</td>
                        <td>
                            Withdraw <input type="radio" name="transfer" value="Withdraw" />
                            Deposit <input type="radio" name="transfer" value="Deposit" />
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
