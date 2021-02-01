<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<html lang="pl">
<head>
    <meta charset="utf-8"> 
<title>Kino Horyzontów </title>
<link rel="stylesheet" href="../css/style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet"> 
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Sen&display=swap" rel="stylesheet"> 
</head>

<body>
    <header>
        <h1 id="mainHeader">Kino Horyzontów</h1>
    </header>
    

    <div class ="logowanie">

            <h1 id ="loginHeader">LOGOWANIE</h1>

            <form id="loginForm" action="Zaloguj" method="post"> 
                <input type="text" placeholder="email" name="email" required/><br/><br/>  
                <input type="password" placeholder="hasło" name="password" required/>
                <br>${message}
                <br/><br/>  
                
                <input type="submit" value="Zaloguj"/>  
            </form>  

            <p id ="orText"> lub </p>
            <form id="registerBtnForm" action="register.jsp">
                <input type="submit" value="Zarejestruj się" />
            </form>   
    </div>


</body>
</html>
