<%--
  Created by IntelliJ IDEA.
  User: Lethal Muriel
  Date: 23/08/2022
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- jstl permette di implementare logica attraverso i tag, altrimenti dovrei usare codice Java --%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.icons">

    <title>Bacheca</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <link href="./customcss/general.css" rel="stylesheet">

</head>
<body>
<%-- INIZIO TOASTS REACTIONS--%>
<div class="position-fixed top-0 end-0 p-3" style="z-index: 11">
    <div id="succesReaction" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <img src="..." class="rounded me-2" alt="...">
            <strong class="me-auto">Ok!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Reazione aggiunta correttamente.
        </div>
    </div>
</div>

<div class="position-fixed top-0 end-0 p-3" style="z-index: 11">
    <div id="failureReaction" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <span>⚠️ </span>
            <strong class="me-auto">Ops!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Non è stato possibile aggiungere la reazione.
        </div>
    </div>
</div>
<%-- FINE TOASTS REACTIONS--%>
<%-- INIZIO TOASTS STORY--%>
<div class="position-fixed top-0 end-0 p-3" style="z-index: 11">
    <div id="successRemove" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <img src="..." class="rounded me-2" alt="...">
            <strong class="me-auto">Ok!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Storia rimossa correttamente.
        </div>
    </div>
</div>

<div class="position-fixed top-0 end-0 p-3" style="z-index: 11">
    <div id="failureRemove" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <span>⚠️ </span>
            <strong class="me-auto">Ops!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Non è stato possibile rimuovere la storia.
        </div>
    </div>
</div>
<%-- FINE TOASTS STORY--%>
<header>
    <div class="bg-dark collapse show" email="navbarHeader" style="">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <h4 class="text-white">Le tue storie preferite! </h4>
                </div>
                <div class="col-sm-4 offset-md-1 py-4">
                    <h4 class="text-white">Azioni</h4>
                    <ul class="list-unstyled">
                        <li><a href="${pageContext.request.contextPath}/Bacheca" class="text-white">Bacheca</a></li>
                        <c:if test="${not empty user}"> <!-- se l'utente è loggato -->
                            <li><a href="${pageContext.request.contextPath}/logout" class="text-white">Disconnettimi</a></li>
                            <li><a href="${pageContext.request.contextPath}/eliminazione" class="text-white">Elimina il mio account</a></li>
                        </c:if>

                        <c:if test="${empty user}"> <!-- se l'utente non è loggato -->
                            <li><a href="${pageContext.request.contextPath}/login" class="text-white">Login</a></li>
                            <li><a href="${pageContext.request.contextPath}/registrazione" class="text-white">Registrati</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
            <a href="#" class="navbar-brand d-flex align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
                <strong> Storie salvate</strong>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="true" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
</header>

<main role="main">

    <section class="jumbotron text-center">
        <div class="container">
            <h1 class="jumbotron-heading">Storie salvate</h1>
            <p class="lead text-muted">Salva le tue storie preferite per evitare di perderle!</p>

        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row">
                <c:forEach items="${stories}" var="story"> <!-- da dove se lo va a prenedere??? (attributo nella request)-->
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <strong>@ <c:out value = "${story.username}"> </c:out></strong>
                            <img class="card-img-top" data-src="https://source.unsplash.com/random" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="https://source.unsplash.com/random" data-holder-rendered="true">
                            <div class="card-body">
                                <p class="card-text"> <c:out value = "${story.contenuto}"> </c:out></p>

                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary" value="${story.id}" onclick="sendReaction(this.value)"> <c:out value = "${story.NReazioni}"> </c:out> ❤️</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary" value="${story.id}" onclick="unsendPost(this.value)">❤️</button>
                                    </div>
                                    <small class="text-muted"><c:out value = "${story.dataCreazione}"> </c:out></small>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</main>
<!-- QUESTA E' LA NAVBAR DI SOTTO -->

<div class=" collapse" email="navbarBottom" style="">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
                <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
                <ul class="list-unstyled">

                </ul>
            </div>
        </div>
    </div>
</div>


<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>

    </div>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<svg xmlns="http://www.w3.org/2000/svg" width="449" height="225" viewBox="0 0 449 225" preserveAspectRatio="none" style="display: none; visibility: hidden; position: absolute; top: -100%; left: -100%;"><defs><style type="text/css"></style></defs><text x="0" y="22" style="font-weight:bold;font-size:22pt;font-family:Arial, Helvetica, Open Sans, sans-serif">Thumbnail</text></svg>

<script>
    function sendReaction(storyID){
        $.post("Reaction",
            {
                storyId: storyID,
            },
            function(msg){
                var toastSuccess = document.getElementById('succesReaction')
                var toast = new bootstrap.Toast(toastSuccess)
                toast.show()
            })
            .fail(function(msg){
                var toastFail = document.getElementById('failureReaction')
                var toast = new bootstrap.Toast(toastFail)
                toast.show()
            })
    }



    function unsendPost(storyID){
        $.post("RimuoviPostSalvati",
            {
                storyId: storyID,
            },
            function(msg){
                var toastSuccess = document.getElementById('successRemove')
                var toast = new bootstrap.Toast(toastSuccess)
                toast.show()
            })
            .fail(function(msg){
                var toastFail = document.getElementById('failureRemove')
                var toast = new bootstrap.Toast(toastFail)
                toast.show()
            })
    }

</script>

</body>
</html>