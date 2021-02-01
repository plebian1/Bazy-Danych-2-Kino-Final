<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%> 
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

            <ul id="menuManager3">
                <li><a href="filmyManagementAdd.jsp">Dodaj film</a></li>
                <li><a href="FilmManagement2">Modyfikuj dane</a></li>
                </ul>     

    </div>

    <div class ="login">
           <p id="loginBtn"><a href="../index.jsp">Wyloguj</a></p> 

    </div>

    <div class ="tabela">
        <p>Filmy</p>

        <table class ="filmyTable">
         <thead>
            <tr>
            <th>Nazwa</th>
            <th>Reżyser</th>
            <th id="czasCol">Dlugosc</th>
            <th id="gatunekCol">Gatunek</th>
            <th id="pegiCol">Pegi</th>
            <th id="obsadaCol">Obsada</th>
            </tr>  
         </thead>
         	
         	<tbody>
        <c:forEach var="f" items="${listFilm}">
            <tr> 
                <td><c:out value="${f.getTytul()}"/></td> 
                <td><c:out value="${f.getRezyser()}"/></td> 
                <td ><c:out value="${f.getDlugosc()}"/></td> 
                <td ><c:out value="${f.getGatunek()}"/></td>
                <td ><c:out value="${f.getPegi()}"/></td>
                <td ><c:out value="${f.getObsada()}"/></td>
            </tr> 
        </c:forEach>
        </tbody>
            </table>
    </div>

</body>
</html>
