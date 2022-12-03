<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@include file="partials/header.jspf"%>
<body>
<header>
    <%@include file="partials/navbar.jspf"%>
</header>
<main>
    </br>
    </br>
<div class="container" style="margin-top:25px">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">


            <form:form modelAttribute="blog" method="post" action="add" cssClass="form" enctype="multipart/form-data">

                <div class="mb-3">
                    <label>Yazar İsmi</label>
                    <form:input path="blogWriter" cssClass="form-control" id="blogWriter"/>
                    <form:errors path="blogWriter" cssClass="error"/>
                </div>



                <div class="mb-3">
                    <label>Blog Category</label>
                   <form:select path="categoryId" cssClass="form-control">
                       <c:forEach items="${categories}" var="entity">
                          <form:option value="${entity.categoryId}">${entity.categoryName}</form:option>
                       </c:forEach>
                   </form:select>
                </div>
                <div class="mb-3">
                    <label>Blog Images</label>
                    <form:input path="blogImages" cssClass="form-control" type="file"   name="blogImages"/>
                </div>
                <div class="mb-3">
                    <label>Blog Date</label>
                    <form:input path="blogDate" cssClass="form-control" type="date" id="blogDate"/>
                </div>
                <div class="mb-3">
                    <label>Blog Başlık</label>
                    <form:input path="blogTittle" cssClass="form-control" id="blogTittle"/>
                </div>

                <div class="mb-3">
                    <label>Blog Uzun Başlık</label>
                    <form:input path="blogLongTittle" cssClass="form-control" id="blogLongTittle"/>
                </div>
                <div class="mb-3">
                    <label>Blog İçerik</label>
                    <form:textarea path="blogContent" style="height: 10rem;" cssClass="form-control" id="blogContent"/>
                </div>

                <button class="main-button"  type="submit">Blog Ekle</button>
            </form:form>

        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</main>
</body>
</html>