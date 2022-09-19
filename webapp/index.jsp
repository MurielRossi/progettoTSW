<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">

    <title>Storytelling</title>

    <link href="./bootstrap-4.0.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="product.css" rel="stylesheet">
    <link rel="stylesheet" href="./customcss/general.css"/>
<body>

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
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/registrazione">Registrati</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/Bacheca">Visita Storytelling!</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

</header>

 <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
     <div class="col-md-5 p-lg-5 mx-auto my-5">
         <h1 class="display-4 font-weight-normal">Benvenuto su storytelling!</h1>
         <p class="lead font-weight-normal">Il primo socialnetwork veramente libero. Racconta la tua vita e vivi quella degli altri: qui puoi raccontare le tue storie esprimendoti in modo totalmente libero!</p>
         <a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/registrazione">Inizia subito</a>
     </div>
     <div class="product-device box-shadow d-none d-md-block"></div>
     <div class="product-device product-device-2 box-shadow d-none d-md-block"></div>
 </div>

<footer class="mt-auto">
    <p>Il progetto &egrave reperibile a questo link:
        <a href="https://github.com/MurielRossi/progettoTSW" >progettoTSW</a>
    </p>
    <p>Autrice:
        <a href="https://github.com/MurielRossi">Muriel Rossi</a>
    </p>

</footer>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="./assets/js/vendor/popper.min.js"></script>
<script src=./dist/js/bootstrap.min.js"></script>
<script src="./assets/js/vendor/holder.min.js"></script>
<script>
    Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
    });
</script>
</body>
</html>