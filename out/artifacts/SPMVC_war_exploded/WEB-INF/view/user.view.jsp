<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.dao.UserDao" %>
<%@ page import="app.models.User" %>
<%@ page import="java.util.List" %>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp"/>
<link href="mystyle.css" rel="stylesheet">

<h1 style="text-align :center">All User</h1>
<% UserDao dao=new UserDao();
    List<User> users=dao.getAllUser();
    request.setAttribute("users", users);
%>
<div class="container">
    <a href="/user/create" class="AddUser"> Add New User </a> <br><br>

    <table >
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>City</th>
            <th>Edit</th>
            <th >Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.getId()}</td>
                <td>${u.getName()}</td>
                <td>${u.getEmail()}</td>
                <td>${u.getPhone()}</td>
                <td>${u.getCity()}</td>
                <td  class="edit"><a href="/user/edit?id=${u.getId() }" class="edit">Edit</a></td>
                <td  class="delete"><a href="/user/delete?id=${u.getId() }" class="delete">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<jsp:include page="footer.jsp"></jsp:include>
