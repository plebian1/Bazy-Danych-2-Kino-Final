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
        <li><a href="kasa">Kasa</a></li>

        </ul>


    </div>

    <div class ="login">
           <p id="loginBtn"><a href="../index.jsp">Wyloguj</a></p> 

    </div>
  <div class ="baner">
        <p>Potwierdz rezerwacje </p>
    
            <form id="nvm" action="rezerwacjaZatwierdz2" method="post"> 
            <label for="biletList">Id rezerwacji</label>
            
            <select name="listRezerwacja" id="listRezerwacja" required>
                   <c:forEach var="r" items="${listRezerwacja}">
                <option value="${r.getId_bilet()}">
                    ${r.getId_bilet()}
                </option>
            </c:forEach>
            </select>
				<input type="submit" value="Potwierdz rezerwacje"/>  
				</form>
</html>