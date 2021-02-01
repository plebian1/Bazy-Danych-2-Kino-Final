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
        <p id = "panelDane">${user.getImie()} ${user.getNazwisko()} <br/>
        ${user.getEmail()}
        </p>
    </div>
    <div class ="menu">    
        <ul id="menuGoscia">
        <li><a href="SeansKlient">Repertuar</a></li>
        <li><a href="cennik.jsp">Cennik</a></li>
        <li><a href="kontakt.jsp">Kontakt</a></li>
        </ul>

        <ul id="menuUser">
            <li><a href="userRezerwacje">Moje rezerwacje</a></li>
            </ul>

    </div>

    <div class ="login">
           <p id="loginBtn"><a href="../index.jsp">Wyloguj</a></p> 

    </div>

    <div class ="baner">
        <p>Rezerwuje. </p>
    
            <form id="nvm" action="rezerwacjaZatwierdz" method="post"> 
            <label for="biletList">Miejsce</label>
            
            <select name="biletList" id="biletList" required>
                   <c:forEach var="b" items="${listBilet}">
                <option value="${b.getId_biletu()}">
                    Rzad: ${b.getRzad()} Miejsce: ${b.getKolumna()}
                </option>
            </c:forEach>
            </select>
				<input type="submit" value="Zarezerwuj bilet"/>  
				</form>
</div>
</body>
</html>