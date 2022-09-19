<!DOCTYPE html>
<head>
    <meta charset="utf-32">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Muriel Rossi">
    <meta name="generator" content="Hugo 0.101.0">
    <title>Registrazione</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/cover/">


    <link href="./bootstrap-5.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="./customcss/general.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>



   <!-- <meta name="theme-color" content="#712cf9"> -->




    <link href="cover.css" rel="stylesheet">
    <script src="chrome-extension://mooikfkahbdckldjjndioackbalphokd/assets/prompt.js"></script>
</head>
<body class="d-flex h-100 text-center text-bg-dark">

<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">

    <header>
        <nav class="navbar navbar-expand-lg" id="navbarTop" style="background-color: #171a1d">
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
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/login">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    </header>

    <main class="w-100 align-items-center">
        <form class="w-50 align-items-center " style="display: inline-block;" action="./registrazione" method="post">
            <img class="mb-4" src="./images/fairytale.png" alt="" width="86" height="70">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

            <div class=" py-2">
                <input id="username" name="username" type="username" class="form-control" placeholder="nameexample19" onfocusout="existingUsername()" required>
                <span id="username-alert" class="alert-info " hidden>Username già presente</span>
                <br>

                <label for="username">Username</label>
            </div>

            <div class=" py-2">
                <input id="email" name="email" type="email" class="form-control" email="floatingInput" placeholder="name@example.com" onfocusout="existingEmail()" required>
                <span id="email-alert" class="alert-info " hidden>Email non corretta</span>
                <br>

                <label for="email">Email address</label>
            </div>

            <div class=" py-2">
                <input id="password" name="password" type="password" class="form-control" email="floatingPassword" placeholder="Password" onfocusout="testPassword(this.value)">
                <span id="password-alert" class="alert-info " hidden>Password non inserita</span>

                <label for="password">Password</label>
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
    let submitable1 = false;
    let submitable2 = false;
    let submitable3 = false;


    function validateData(){
        existingEmail();
        existingUsername();
        testPassword(document.getElementById());

        if(submitable1 && submitable2 && submitable3)
            submitable = true;




        return submitable;
    }

    function existingEmail(){
        let xhttp = new XMLHttpRequest();
        let emailalert = document.getElementById("email-alert");
        let submit = document.getElementById("submit-registration");
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 400) {
                    emailalert.innerText = this.responseText;
                    submit.disabled = true;
                    emailalert.hidden = false;
                    console.log("email rejected");
                } else{
                    submit.disabled = false;
                    emailalert.hidden = true;
                    submitable1 = true;

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
            if (this.readyState == 4 && this.status == 400) {
                usernamealert.innerText = this.responseText;
                submit.disabled = true;
                usernamealert.hidden = false;
                console.log("username rejected");
            } else{
                    submit.disabled = false;
                    usernamealert.hidden = true;
                    submitable2 = true;
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
        else{
            passAlert.hidden=true
            submitable3 = true;
        }

    }
</script>

</body>