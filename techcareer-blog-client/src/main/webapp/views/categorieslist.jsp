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
        <th>Kategori Adı</th>
        <th>Kategori Statusu</th>
        <th>Pasif Et</th>
        <th>Sil</th>




    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="entity">
        <tr>
            <td>${entity.categoryId}</td>
            <td>${entity.categoryName}</td>
            <td>${entity.categoryStatus}</td>
            <td><a href="/setpasive/${entity.categoryId}"><button class="btn btn-danger">Pasif</button></a><a href="/setactive/${entity.categoryId}"><button style="margin-left: 10px" class="btn btn-success">Aktif</button></a></td>
            <td><a href="/deletecategory/${entity.categoryId}"><button class="btn btn-danger">Sil</button></a></td>


        </tr>
    </c:forEach>

    </tbody>
</table>
<a href="/category/add"><button class="btn btn-primary">Yeni Ekle</button></a>


</body>
</html>