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
            <h3>BANK CUSTOMER REGISTRATION FORM</h3>

            <form id="UserController" action="UserController" method="POST">
                <table align="center" cellpadding = "10">

                    <!----- First Name ---------------------------------------------------------->
                    <tr>
                        <td>USER ID</td>
                        <td><input type="text" name="userid" maxlength="30"/>
                        </td>
                    </tr>   

                    <!----- First Name ---------------------------------------------------------->
                    <tr>
                        <td>FULL NAME</td>
                        <td><input type="text" name="fullName" maxlength="30"/>
                        </td>
                    </tr>

                    <!----- Date Of Birth -------------------------------------------------------->
                    <tr>
                        <td>DATE OF BIRTH</td>
                        <td><input type="date" name="dob" maxlength="30"/>
                        <td>

                            <!----- Email Id ---------------------------------------------------------->
                    <tr>
                        <td>EMAIL ID</td>
                        <td><input type="text" name="emailId" maxlength="100" /></td>
                    </tr>

                    <!----- Mobile Number ---------------------------------------------------------->
                    <tr>
                        <td>MOBILE NUMBER</td>
                        <td>
                            <input type="text" name="mobileNo" maxlength="10" />
                            (10 digit number)
                        </td>
                    </tr>

                    <!----- Id Proof -------------------------------------------------------->
                    <tr>
                        <td>ID PROOF</td>

                        <td>
                            <select name="IdProofType" id="IdProof_Type">
                                <option value="ADHAR">ADHAR CARD</option>
                                <option value="DRIVING">DRIVING LICENSE</option>
                                <option value="VOTER">VOTER ID</option>
                            </select>

                            <input type="text" name="idproof" maxlength="100" />
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

                    <!----- Address ---------------------------------------------------------->
                    <tr>
                        <td>ADDRESS <br /><br /><br /></td>
                        <td><textarea name="address" rows="4" cols="30"></textarea></td>
                    </tr>

                    <!----- Account Type ----------------------------------------------------------->
                    <tr>
                        <td>Account Type</td>
                        <td>
                            Savings <input type="radio" name="accountType" value="Savings" />
                            Current <input type="radio" name="accountType" value="Current" />
                        </td>
                    </tr>

                    <!----- Initial Balance ---------------------------------------------------------->
                    <tr>
                        <td>INITIAL BALANCE</td>
                        <td>
                            <input type="text" name="initialBalance" maxlength="10" />
                            <input type="hidden" name="action" maxlength="10" value="create"/>
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
