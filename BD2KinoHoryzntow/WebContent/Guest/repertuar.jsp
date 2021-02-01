<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%> 
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
    
    <div class= "panelMode">
        <h4 id = "panelName">Panel użytkownika</h5>
        <p id = "panelDane">Wypisywanie danych użytkownika</p>
    </div>
    <div class ="menu">    
        <ul id="menuGoscia">
        <li><a href="repertuar.jsp">Repertuar</a></li>
        <li><a href="cennik.jsp">Cennik</a></li>
        <li><a href="kontakt.jsp">Kontakt</a></li>
        </ul>

        <ul id="menuUser">
             <li><a href="Rezerwacja">Zarezerwuj bilet</a></li>
            <li><a href="#">Moje rezerwacje</a></li>
            </ul>

    </div>

    <div class ="login">
           <p id="loginBtn"><a href="../index.jsp">Wyloguj</a></p> 

    </div>
    
    <div class ="tabela">
    <p>Repertuar</p>
    <table border="1" >
       <tr>
          <th>Data</th>
          <th>Godzina</th>
          <th>Nazwa filmu</th>
          <th>Numer sali</th>
          <th>Napisy</th>
          <th>Jezyk</th>
          <th>Czas trwania</th>
       </tr>
       <c:forEach var="s" items="${listSeanse}">
            <tr> 
                <td><c:out value="${s.getData()}"/></td> 
                <td><c:out value="${s.getGodzina()}"/></td> 
                <td><c:out value="${s.getNazwa_filmu()}"/></td> 
                <td><c:out value="${s.getId()}"/></td>
                <td><c:out value="${s.getNapisy()}"/></td> 
                <td><c:out value="${s.getJezyk()}"/></td> 
                <td><c:out value="${s.getCzas_trwania()}"/></td>
            </tr> 
        </c:forEach>
    </table>
    </div>

</body>
</html>