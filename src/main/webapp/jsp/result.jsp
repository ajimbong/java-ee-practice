<%@ page import="dev.ajim.jee.Person" %>
<%@ page import="java.util.ArrayList" %>
<!--- TODO: Write a servlet that will use this as a template to to output all the users-->

<!-- ALSO use head.jsp as a base-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="head.jsp" %>

<h2>Results</h2>
<div class="table">
<table border = "1px solid black" borderCollapse="collapse">
    <tr>
        <th>ID</th>
        <th>FIRST NAME</th>
        <th>LAST NAME</th>
        <th>PASSWORD</th>
        <th></th>
        <th></th>
    </tr>
    
    <%
        // retrieve the data from the servlet
        ArrayList<Person> people = (ArrayList<Person>) request.getAttribute("people");

        for (Person person : people){


        // and loop over it
    %>

<tr>
    <td><%= person.id() %></td>
    <td><%= person.fname() %></td>
    <td><%= person.lname() %></td>
    <td><%= person.lname() %></td>
    <td><a href="/update?id=<%= person.id() %>"> UPDATE </a></td>
    <td><a class="btnDelete" href="/delete?id=<%= person.id() %>" name="delete"> DELETE </a></td>
</tr>
<% } %>
</table>

<div class="div-btns">
    <button> <a href="../index.html"> Add </a></button>
</div>
</div>

<script>
    let delBtns = document.querySelectorAll(".btnDelete")

    delBtns.forEach(deleteFunc)

    function deleteFunc(el){
        el.addEventListener('click', e =>{
        if(!confirm("Are you sure want to delete this item ?")){
            e.preventDefault();
        }
    })
    }
</script>