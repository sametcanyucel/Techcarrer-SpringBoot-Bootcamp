<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="tr">
<head>
    <%@include file="partials/header.jspf"%>
</head>
<body data-bs-spy="scroll" data-bs-target="#navbar-example" data-bs-offset="82">
<header>
    <%@include file="partials/navbar.jspf"%>
</header>
<main>
    <div class="container">
        <div class="row mainmargin">
            <div class="single-post col-md-8">
                <a href="/"><i class="fa-solid fa-caret-left fa-xl" style="color: black"></i></a>
                <h2 class="underscore">${blog.blogTittle}</h2>
                <div class="post-meta">
                    <span><i class="far fa-user"></i> Posted by ${blog.blogWriter}</span><span><i class="far fa-calendar"></i>${blog.blogDate}</span><span><span><i class="fa fa-square"> ${blog.categoryName}</i></span></span>
                </div>
                <img src="/img/${blog.blogImages}" alt="">
                <p>${blog.blogContent}</p>




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
