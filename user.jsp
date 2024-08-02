<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.bankcustomer.request.CreateCustomer"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Bank Customer Registration Form</title>
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>
        <!-- partial:index.partial.html -->
    <html>
        <head>
            <title>Bank Customer Registration Form</title>

        </head>

        <body>
            <form id="UserControllerUpdate" action="UserControllerUpdate" method="POST">
                <table align="center" cellpadding = "10">


                    <%
                        List l = (List) request.getAttribute("users");
                        System.out.println("print the user objects" + l.toString());
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
                                String userId = user.getUserId();
                                String dob = user.getDob();
                                String address = user.getAddress();
                    %>
                    <!----- First Name ---------------------------------------------------------->
                    <tr>
                        <!--<td>USER ID</td>-->
                        <td><input type="hidden" name="userid" value="<%=userId%>"/>
                        </td>
                    </tr>   

                    <!----- First Name ---------------------------------------------------------->
                    <tr>
                        <!--                        <td>CUSTOMER ACCOUNT NO</td>-->
                        <td><input type="hidden" name="customerAccountNo" value="<%=customerAccountNo%>"/>
                        </td>
                    </tr> 

                    <!----- First Name ---------------------------------------------------------->
                    <tr>
                        <td>FULL NAME</td>
                        <td><input type="text" name="fullName" maxlength="30" value="<%=fullname%>"/>
                        </td>
                    </tr>

                    <!----- Date Of Birth -------------------------------------------------------->
                    <tr>
                        <td>DATE OF BIRTH</td>
                        <td><input type="date" name="dob" maxlength="30" value="<%=dob%>"/>
                        <td>

                            <!----- Email Id ---------------------------------------------------------->
                    <tr>
                        <td>EMAIL ID</td>
                        <td><input type="text" name="emailId" maxlength="100" value="<%=emailId%>"/></td>
                    </tr>

                    <!----- Mobile Number ---------------------------------------------------------->
                    <tr>
                        <td>MOBILE NUMBER</td>
                        <td>
                            <input type="text" name="mobileNo" maxlength="10" value="<%=mobileNo%>"/>
                            (10 digit number)
                        </td>
                    </tr>

                    <!----- Gender ----------------------------------------------------------->
                    <tr>
                        <td>GENDER</td>
                        <td>
                            Male <input type="radio" name="gender" value="Male" />
                            Female <input type="radio" name="gender" value="Female" />
                        </td>
                    </tr>

                    <!----- Id Proof -------------------------------------------------------->
                    <tr>
                        <td>ID PROOF</td>

                        <td>
                            <select name="IdProofType" id="IdProof_Type" value="<%=idproofType%>">
                                <option value="ADHAR">ADHAR CARD</option>
                                <option value="DRIVING">DRIVING LICENSE</option>
                                <option value="VOTER">VOTER ID</option>
                            </select>

                            <input type="text" name="idproof" maxlength="100" value="<%=idproof%>"/>
                        </td>
                    </tr>

                    <!----- Account Type ----------------------------------------------------------->
                    <tr>
                        <td>Account Type</td>
                        <td>
                            Savings <input type="radio" name="accountType" value="Savings" />
                            Current <input type="radio" name="accountType" value="Current" />
                        </td>
                    </tr>

                    <!----- Address ---------------------------------------------------------->
                    <tr>
                        <td>ADDRESS <br /><br /><br /></td>
                        <td><textarea name="address" rows="4" cols="30" value="<%=address%>"></textarea></td>
                    </tr>
                    <input type="hidden" name="action" maxlength="10" value="update"/>
                    <%
                            }
                        }
                    %>
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
