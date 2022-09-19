<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-32">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Muriel Rossi">
    <meta name="generator" content="Hugo 0.101.0">
    <title>Login</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/cover/">





    <link href="./bootstrap-4.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="./customcss/general.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

    <meta name="theme-color" content="#712cf9">

</head>
<body class="d-flex h-100 text-center text-bg-dark">



<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">

<header>
    <nav class="navbar navbar-expand-lg" id="navbarTop">
        <div class="container-fluid">
            <a class="navbar-brand text-white" href="${pageContext.request.contextPath}/Bacheca">Storytelling</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">

                    <li class="nav-item">
                        <a class="nav-link text-white" href="/Muriel">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/registrazione">Registrati</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

</header>

    <c:if test="${not empty accessDenied}"> <!-- se l'utente non è loggato -->

        <div class="position-fixed top-0 end-0 p-3" style="z-index: 11">
            <div id="failureLogin" class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    <span>⚠️ </span>
                    <strong class="me-auto">Ops!</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                    Inserisci le credenziali giuste!
                </div>
            </div>
        </div>

    </c:if>

    <main class="w-100 align-items-center">
        <form class="w-50 align-items-center " style="display: inline-block;" action="./login" method="post">
            <img class="mb-4" src="./images/fairytale.png" alt="" width="86" height="70">
            <h1 class="h3 mb-3 fw-normal">Inserisci le tue credenziali</h1>


            <div class=" py-2">
                <input id="email" name="email" type="email" class="form-control" email="floatingInput" placeholder="name@example.com" required>
                <span id="email-alert" class="alert-info " hidden>Email non corretta</span>
                <br>

                <label for="email">Email address</label>
            </div>

            <div class=" py-2">
                <input id="password" name="password" type="password" class="form-control" password="floatingPassword" placeholder="Password" >
                <span id="password-alert" class="alert-info " hidden>Password non inserita</span>

                <label for="password">Password</label>
            </div>

            <button id="submit-registration" class="w-100 btn btn-lg btn-primary" type="submit">Accedi</button>
            <p class="mt-5 mb-3 text-muted">Storytelling</p>
        </form>
    </main>

    <footer class="mt-auto text-white-50">
        <p>Il progetto &egrave reperibile a questo link: <a href="https://github.com/MurielRossi/progettoTSW" class="text-white">progettoTSW</a></p>
        <p>Autrice: <a href="https://github.com/MurielRossi" class="text-white">Muriel Rossi</a></p>

    </footer>
</div>



</body>
</html>