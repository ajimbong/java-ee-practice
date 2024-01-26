<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <%@include file="head.jsp" %>
<body>
    <h1>Update Record</h1>
    <div>
        <div>
            <div>
            </div>
            <div class="item">
                <%
                // Get the values for the particular ID
                %>
                <form action="/update" method="post">
                    <div class="item">
                        <label>First Name:</label>
                        <input type="text" name="fname" value="<%= "Output the fName" %>" required="">
                    </div>

                    <div class="item">
                        <label>Last Name:</label>
                        <input type="text" name="lname" value="<%= "Output the lName" %>"  required="">
                    </div>

                    <div class="item">
                        <label>Password:</label>
                        <input type="password" name="password"  value="<%= "Output the Password" %>"  required="">
                    </div>

                    <input type="hidden" name="id" value="<%= "Output the ID" %>">

            </div>
            <div class="div-btns">
                <button type="submit" name="save" > Save </button>
                <button> <a href="/result" >Cancel</a></button>
            </div>
        </div>
    </div>
</body>
</html>