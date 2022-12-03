<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<%@include file="partials/header.jspf"%>

<body>
<header>
    <%@include file="partials/navbar.jspf"%>
</header>

<br>
<br>
<br>
<br>
<div class="container" style="margin-top:25px">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">



            <form:form modelAttribute="category" method="post" action="add" cssClass="form" >

                <div class="form-group">
                    <label>Category Name</label>
                    <form:input path="categoryName" cssClass="form-control" id="name" />
                </div>
                <div class="form-group">
                    <label>Category Status</label>
                    <form:select path="categoryStatus" cssClass="form-control">
                        <form:option value="1">Aktif</form:option>
                        <form:option value="0">Pasif</form:option>
                    </form:select>

                </div>
                <br>
                <button type="submit" class="btn btn-primary">Save</button>
            </form:form>


        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>
</html>