<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib
        prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.icons">

    <title>Album example for Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap-4.0.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <!-- <link href="album.css" rel="stylesheet"> -->
 </head>
 <body>

 <header>
     <div class="bg-dark collapse show" email="navbarHeader" style="">
         <div class="container">
             <div class="row">
                 <div class="col-sm-8 col-md-7 py-4">
                     <h4 class="text-white">About</h4>
                     <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
                 </div>
                 <div class="col-sm-4 offset-md-1 py-4">
                     <h4 class="text-white">Contact</h4>
                     <ul class="list-unstyled">
                         <li><a href="#" class="text-white">Follow on Twitter</a></li>
                         <li><a href="#" class="text-white">Like on Facebook</a></li>
                         <li><a href="#" class="text-white">Email me</a></li>
                     </ul>
                 </div>
             </div>
         </div>
     </div>
     <div class="navbar navbar-dark bg-dark box-shadow">
         <div class="container d-flex justify-content-between">
             <a href="#" class="navbar-brand d-flex align-items-center">
                 <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
                 <strong>Album</strong>
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
             <h1 class="jumbotron-heading">Album example</h1>
             <p class="lead text-muted">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don't simply skip over it entirely.</p>
             <p>
                 <a href="#" class="btn btn-primary my-2">Main call to action</a>
                 <a href="#" class="btn btn-secondary my-2">Secondary action</a>
             </p>
         </div>
     </section>

     <div class="album py-5 bg-light">
         <div class="container">
                 <div class="row">
                     <c:forEach items="${stories}" var="story">
                     <div class="col-md-4">
                         <div class="card mb-4 box-shadow">
                             <img class="card-img-top" data-src="https://source.unsplash.com/random" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="https://source.unsplash.com/random" data-holder-rendered="true">
                             <div class="card-body">
                                 <p class="card-text"> <c:out value = "${story.contenuto}"> </c:out></p>
                                 <div class="d-flex justify-content-between align-items-center">
                                     <div class="btn-group">
                                         <button type="button" class="btn btn-sm btn-outline-secondary" value="${story.id}" onclick="sendReaction(this.value)"> <c:out value = "${story.NReazioni}"> </c:out> ❤️</button>
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
                <h4 class="text-white">About</h4>
                <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
                <h4 class="text-white">Contact</h4>
                <ul class="list-unstyled">
                    <li><a href="#" class="text-white">Follow on Twitter</a></li>
                    <li><a href="#" class="text-white">Like on Facebook</a></li>
                    <li><a href="#" class="text-white">Email me</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

 <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
     <div id="succesReaction" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
         <div class="toast-header">
             <img src="..." class="rounded me-2" alt="...">
             <strong class="me-auto">Bootstrap</strong>
             <small>11 mins ago</small>
             <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
         </div>
         <div class="toast-body">
             Reazione aggiunta correttamente.
         </div>
     </div>
 </div>

 <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
     <div id="failureReaction" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
         <div class="toast-header">
             <img src="..." class="rounded me-2" alt="...">
             <strong class="me-auto">Bootstrap</strong>
             <small>11 mins ago</small>
             <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
         </div>
         <div class="toast-body">
             Non è stato possibile aggiungere la reazione.
         </div>
     </div>
 </div>

<div class="navbar navbar-dark bg-dark fixed-bottom align-content-center">
    <form class = "PubblicaStoria" style="display: inline-block; width: 95%" action="./PubblicaStoria" method="post" onsubmit="return validateData()" style="display: block" aria-multiline="true" text-indent = "initial">
        <table>
            <tr>
                <td style="width: 95%">

                    <textarea email="contenuto" name="contenuto" style="width: 100%; padding: 5px" rows="4" placeholder="Scrivi la tua storia..."></textarea>
                    <span email="lenght-alert" class="alert-info " hidden>Questa storia non ha il numero adeguato di caratteri!</span>
                </td>
                <td style="width:5%; height: 100%">
                    <button class="btn btn-lg btn-primary btn-block" style="width: 100%; height: 100%" type="submit" email = "submit-button">
                        <img class="mb-4" src="../images/publish.png" alt="" width="40" height="40">
                    </button>
                </td>
            </tr>
        </table>

    </form>

</div>

<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
        <p>Album example is © Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? <a href="..">Visit the homepage</a> or read our <a href="../../getting-started/">getting started guide</a>.</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <script>window.jQuery || document.write('<script src="./bootstrap-4.0.0/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="./bootstrap-4.0.0/assets/js/vendor/popper.min.js"></script>
<script src="./bootstrap-4.0.0/dist/js/bootstrap.min.js"></script>
<script src="./bootstrap-4.0.0/assets/js/vendor/holder.min.js"></script>


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
             }).fail(function(msg){

        })
    }

</script>

</body>
</html>