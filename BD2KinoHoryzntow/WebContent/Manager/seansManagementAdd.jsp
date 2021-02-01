<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<%@page import="java.util.ArrayList"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <h4 id = "panelName">Panel menadżera</h5>
    </div>
      <div class ="menu">    
        <ul id="menuManager">
        <li><a href="seansManagement">Zarządzanie seansami</a></li>
        <li><a href="PracownicyManagement">Zarządzanie pracownikami</a></li>
        <li><a href="FilmManagement">Zarządzanie filmami</a></li>
        </ul>



    

    </div>

    <div class ="login">
           <p id="loginBtn"><a href="../index.jsp">Wyloguj</a></p> 

    </div>
    
  

    <div class ="pracownikForm">
        <p>Seans</p>

        <form id="insertSeansForm" action="SeansInsert" method="post"> 
            <label for="filmTitle">Film</label>
            
            <select name="filmTitle" id="filmTitle" required>
            <option value="Unknown" selected disabled hidden >Wybierz film</option>
                   <c:forEach items="${listFilm}" var="film">
                <option value="${film.getId()}">
                    ${film.getTytul()}
                </option>
            </c:forEach>
            </select>
            
            <label for="opiekunName">Opiekun</label>
            
            <select name="opiekunName" id="opiekunName" required>
            <option value="Unknown" selected disabled hidden >Wybierz opiekuna</option>
                   <c:forEach items="${listOpiekun}" var="o">
                <option value="${o.getId()}">
                    ${o.getNazwisko()}
                </option>
            </c:forEach>
            </select>
            
           <label for="saleList">Sala</label>

            <select name="saleList" id="saleList" required>
            <option value="Unknown" selected disabled hidden >Wybierz salę</option>
                   <c:forEach items="${listSale}" var="s">
                <option value="${s}">
                    ${s}
                </option>
            </c:forEach>
            </select>
            
            
            <label for="data">Data</label>
            <input type="text" name="data" placeholder="RRRR-MM-DD" required/>
            
            <label for="godzina">Godzina</label>
            <input type="text" name="godzina" placeholder="HH:MM:SS" required/>
            
            <label for="duration">Czas trwania</label>
            <input type="text" name="duration" placeholder="HH:MM:SS" required/>
            
            <label id="napisyL" for="napisy">Napisy</label>

            <select name="napisy" id="napisy" required>
            		<option value="Unknown" selected disabled hidden >Wybierz opcję</option>
                    <option value ="tak">TAK</option>
                    <option value ="nie">NIE</option>
            </select>
            
            <label id="jezykL" for="jezyk">Język</label>
            <select name="jezyk" id="jezyk" required>
                    <option value="Unknown" selected disabled hidden >Wybierz język</option>
                    <option value ="Polski">Polski</option>
                    <option value ="Angielski">Angielski</option>
            </select>
    
            <input id="addBtn" type="submit" value="Dodaj"/>  
        </form>  

        <form  method="get" action="seansManagement">
            <button id="cancelBtn" type="submit">Anuluj</button>
        </form>
        

    </div>

</body>
</html>