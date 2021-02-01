<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<html lang="pl">
<head>
    <meta charset="utf-8"> 
<title>Kino Horyzontów (Manager) </title>
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
    
    <div class= "panelMode">
        <h4 id = "panelName">Panel menadżera</h4>

    </div>
      <div class ="menu">    
        <ul id="menuManager">
        <li><a href="seansManagement">Zarządzanie seansami</a></li>
        <li><a href="PracownicyManagement">Zarządzanie pracownikami</a></li>
        <li><a href="FilmManagement">Zarządzanie filmami</a></li>
        </ul>

        <ul id="menuManager2">
            <li><a href="RachunekView">Przegląd rachunków</a></li>
            </ul>
    

    </div>

    <div class ="login">
           <p id="loginBtn"><a href="../index.jsp">Wyloguj</a></p> 

    </div>

    <div class ="pracownikForm">
        <p>Pracownicy</p>

        <form id="insertPracownikForm" action="insertuser" method="post"> 
            <label for="firstName">Imię</label>
            <input type="text" name="firstName" required/><br/>
            <label for="lastName">Nazwisko</label>
            <input type="text" name="lastName" required/><br/>
            <label for="phoneNum">Stanowisko</label>
            <input type="text" name="phoneNum" required/><br/>
            <label for="email">Email</label>
            <input type="text" name="email" required/> <br/>
            <label for="password">Hasło</label>
            <input type="password" name="password" required/><br/>  
            <input id="addBtn" type="submit" value="Dodaj"/>  
        </form>  

        <form  method="get" action="PracownicyManagement">
            <button id="cancelBtn" type="submit">Anuluj</button>
        </form>
        

    </div>

</body>
</html>