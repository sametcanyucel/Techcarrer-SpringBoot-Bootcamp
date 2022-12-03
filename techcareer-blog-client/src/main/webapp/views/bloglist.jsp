<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@include file="partials/header.jspf"%>
<body>
<header>
    <%@include file="partials/navbar.jspf"%>
</header>

<table style="margin-top: 100px" class="table table-bordered">
    <thead>
    <tr>
        <th>#</th>
        <th>Blog Yazarı</th>
        <th>Blog Adı</th>
        <th>Blog Kategorisi</th>
        <th>Blog Statüsü</th>





    </tr>
    </thead>
    <tbody>
    <c:forEach items="${blogs}" var="entity">
        <tr>
            <td>${entity.blogId}</td>
            <td>${entity.blogWriter}</td>
            <td>${entity.blogTittle}</td>
            <td>${entity.categoryName}</td>
            <td>${entity.blogStatus}</td>
            <td><a href="/setblogpassive/${entity.blogId}"><button class="btn btn-danger">Pasif</button></a><a href="/setblogactive/${entity.blogId}"><button style="margin-left: 10px" class="btn btn-success">Aktif</button></a></td>


        </tr>
    </c:forEach>

    </tbody>
</table>



</body>
</html>