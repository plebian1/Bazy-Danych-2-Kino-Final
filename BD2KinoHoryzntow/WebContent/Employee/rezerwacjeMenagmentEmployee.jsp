<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%> 
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<html lang="pl">
<head>
    <meta charset="utf-8"> 
<title>Kino Horyzontów (Pracownik) </title>
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
        <h4 id = "panelName">Panel pracownika</h5>

    </div>
    <div class ="menu">    
        <ul id="menuPracownika">
        <li><a href="ticketBuy.jsp">Kasa</a></li>


        </ul>


    </div>

    <div class ="login">
           <p id="loginBtn"><a href="../index.jsp">Wyloguj</a></p> 

    </div>

    <div class ="baner">
        <p>Zarządzaj rezerwacjami </p>
    </div>

</body>
</html>