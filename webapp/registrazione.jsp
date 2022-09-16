<!DOCTYPE html>
<head>
    <meta charset="utf-32">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Muriel Rossi">
    <meta name="generator" content="Hugo 0.101.0">
    <title>Registrazione</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/cover/">




    <!--<link rel="stylesheet" href="./customcss/general.css"/>
    <link href="./bootstrap-4.0.0/dist/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="./bootstrap-5.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="./customcss/general.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>



    <meta name="theme-color" content="#712cf9">


    <style>

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .b-example-divider {
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }

        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }

        .nav-scroller .nav {
            display: flex;
            /*flex-wrap: nowrap;*/
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }
    </style>


    <link href="cover.css" rel="stylesheet">
    <script src="chrome-extension://mooikfkahbdckldjjndioackbalphokd/assets/prompt.js"></script>
</head>
<body class="d-flex h-100 text-center text-bg-dark">

<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="mb-auto">
        <div>
            <h3 class="float-md-start mb-2 px-5">Registrazione</h3>
            <nav class="nav nav-masthead justify-content-center float-md-end align-items-center">
                <a class="nav-link fw-bold  px-3 active " aria-current="page" href="#">Home</a>
                <a class="nav-link fw-bold py-1 px-3" href="#">Features</a>
                <a class="nav-link fw-bold py-1 px-3" href="#">Contact</a>
            </nav>
        </div>
    </header>

    <main class="w-100 align-items-center">
        <form class="w-50 align-items-center " style="display: inline-block;">
            <img class="mb-4" src="./images/fairytale.png" alt="" width="86" height="70">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

            <div class=" py-2">
                <input id="username" type="username" class="form-control" email="floatingUsername" placeholder="nameexample19" onfocusout="existingUsername()">
                <span id="username-alert" class="alert-info " hidden>Username già presente</span>
                <br>

                <label for="floatingInput">Username</label>
            </div>

            <div class=" py-2">
                <input id="email" type="email" class="form-control" email="floatingInput" placeholder="name@example.com" onfocusout="existingEmail()">
                <span id="email-alert" class="alert-info " hidden>Email non corretta</span>
                <br>

                <label for="floatingInput">Email address</label>
            </div>

            <div class=" py-2">
                <input id="password" type="password" class="form-control" email="floatingPassword" placeholder="Password" onfocusout="testPassword(this.value)">
                <span id="password-alert" class="alert-info " hidden>Password non inserita</span>

                <label for="floatingPassword">Password</label>
            </div>

            <button id="submit-registration" class="w-100 btn btn-lg btn-primary" type="submit" onclick="validateData()">Registrati</button>
            <p class="mt-5 mb-3 text-muted">Storytelling</p>
        </form>
    </main>

    <footer class="mt-auto text-white-50">
        <p>Il progetto &egrave reperibile a questo link: <a href="https://github.com/MurielRossi/progettoTSW" class="text-white">progettoTSW</a></p>
        <p>Autrice: <a href="https://github.com/MurielRossi" class="text-white">Muriel Rossi</a></p>

    </footer>
</div>

<script>
    let submitable = false;

    function validateData(){
        existingEmail();
        testPassword(document.getElementById());

    }

    function existingEmail(){
        let xhttp = new XMLHttpRequest();
        let emailalert = document.getElementById("email-alert");
        let submit = document.getElementById("submit-registration");
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                if (this.responseText == "true") {
                    emailalert.innerText = "Email già presente!";
                    submit.disabled = true;
                    emailalert.hidden = false;
                    console.log("email rejected");
                    submitable = false;
                } else{
                    submit.disabled = false;
                    emailalert.hidden = true;
                }
            }
        };
        xhttp.open("POST", "./verificaEmail", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("email="+document.getElementById("email").value);
    }

    function existingUsername(){
        let xhttp = new XMLHttpRequest();
        let usernamealert = document.getElementById("username-alert");
        let submit = document.getElementById("submit-registration");
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                if (this.responseText == "true") {
                    usernamealert.innerText = "Username già in uso";
                    submit.disabled = true;
                    usernamealert.hidden = false;
                    console.log("username rejected");
                } else{
                    submit.disabled = false;
                    usernamealert.hidden = true;
                }
            }
        };
        xhttp.open("POST", "./verificaUsername", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("username="+document.getElementById("username").value);
    }

    function testPassword(password){
        let regex=new RegExp("^(?=.*[a-z])(?=.*\\d)(?=.*[@#$%._-])(?=.*[A-Z]).{8,16}$");
        let passAlert= document.getElementById("password-alert");
        console.log(regex.test(password));
        if(!regex.test(password)){
            passAlert.innerText="La password non rispetta i parametri richiesti!"
            passAlert.hidden=false;
        }
        else
            passAlert.hidden=true;
    }
</script>

</body>