<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Clear blog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/main.css">
    <script src="https://kit.fontawesome.com/06a36a20cf.js" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="partials/navbar.jspf" %>
<main>

    <i class="fa-solid fa-bars"></i>

    <i class="fa-sharp fa-solid fa-bars"></i>
    <div class="container">

        <div class="row mainmargin">
            <div class="blog col-md-8">
                <div class="all-posts">
                    <h2 class="underscore">Bloglar</h2>
                    <c:forEach items="${blogs}" var="entity">
                        <div class="post-item">
                            <div class="post-img"><img src="/img/${entity.blogImages}" width="400" height="300" alt="">
                            </div>
                            <div class="post-main-info" style="padding-right: 75px">
                                <p class="post-title">${entity.blogTittle}</p>
                                <div class="post-meta">

                                    <span><i class="fa fa-square"> ${entity.categoryName}</i></span>
                                </div>
                                <div class="post-meta">
                                    <span><i class="far fa-user"></i> Posted by ${entity.blogWriter}</span><span><i
                                        class="far fa-calendar"></i> ${entity.blogDate}</span>
                                </div>
                                <div><b>${entity.blogLongTittle}</b></div>

                                <div class="post-meta"><a href="/blog/${entity.blogId}" class="main-button">Bloga Git</a></div>
                            </div>

                        </div>
                    </c:forEach>
                </div>

            </div>
            <div class="sidebar col-md-4">

                <div class="recent-posts pt-5">
                    <h4 class="mb-3">Kategoriler</h4>
                    <c:forEach items="${categories}" var="entity">
                        <div class="post-item">
                            <a href="/blogs/${entity.categoryId}" class="post-title">${entity.categoryName}</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

</main>


</body>
</html>