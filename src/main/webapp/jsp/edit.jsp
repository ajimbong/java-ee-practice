<%@ page import="dev.ajim.jee.Person" %>
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
                    Person person = (Person) request.getAttribute("person");
                %>
                <form action="/update" method="POST">
                    <div class="item">
                        <label>First Name:</label>
                        <input type="text" name="fname" value="<%= person.fname() %>" required="">
                    </div>

                    <div class="item">
                        <label>Last Name:</label>
                        <input type="text" name="lname" value="<%= person.lname() %>"  required="">
                    </div>

                    <div class="item">
                        <label>Password:</label>
                        <input type="password" name="password"  value="<%= person.pass() %>"  required="">
                    </div>

                    <input type="hidden" name="id" value="<%= person.id() %>">

                    </div>
            <div class="div-btns">
                <button type="submit" name="save" > Save </button>
                <button> <a href="/person" >Cancel</a></button>
            </div>
        </div>
    </div>
</body>
</html>