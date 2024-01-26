<%--
  Created by IntelliJ IDEA.
  User: ajim
  Date: 1/25/24
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<body>
    <h1>Yo this page works bro</h1>
    <%

        String[] names = (String[]) request.getAttribute("names");
        if(names != null){
        for(String name : names){
            System.out.println(name);
        %>
       <li> <%= name %> </li>
    <% } }%>
    <h3>${names}</h3>

<%--- These are comments in JSP

    how to outpug variables
    <%= name %>

    output a value that was as an attribute
    <h3>${names}</h3>

    Notation to run a scriplet in JSP
    <% %>
---%>
</body>
</html>
