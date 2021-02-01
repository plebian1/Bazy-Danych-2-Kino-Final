<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
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
        <p>Film</p>

		
        <form id="insertPracownikForm" action="FilmModify" method="post"> 
            <label for="filmTitle">Tytuł</label>
            <input type="text" name="filmTitle" value="<c:out value='${film.getTytul()}' />" required/><br/>
            <label for="director">Reżyser</label>
            <input type="text" placeholder="HH:MM:SS" name="director" value="<c:out value='${film.getRezyser()}' />" required/><br/>
            <label for="duration">Czas trwania</label>
            <input type="text" name="duration" value="<c:out value='${film.getDlugosc()}' />" required/><br/>
            <label for="gatunek">Gatunek</label>

            <select name="gatunek" id="gatunek"  required>
            		<option value="Unknown" selected disabled hidden >Wybierz gatunek</option>
                    <option value ="Komedia" <c:if test="${film.getGatunek() == 'Komedia'}">selected="selected"</c:if>>Komedia</option>
                    <option value ="Dramat" <c:if test="${film.getGatunek() == 'Dramat'}">selected="selected"</c:if>>Dramat</option>
                    <option value ="Thriller" <c:if test="${film.getGatunek() == 'Thriller'}">selected="selected"</c:if>>Thriller</option>
                    <option value ="Sci-Fi" <c:if test="${film.getGatunek() == 'Sci-Fi'}">selected="selected"</c:if>>Sci-Fi</option>
                    <option value ="Dokumentalny" <c:if test="${film.getGatunek() == 'Dokumentalny'}">selected="selected"</c:if>>Dokumentalny</option>
                    <option value ="Akcji" <c:if test="${film.getGatunek() == 'Akcji'}">selected="selected"</c:if>>Akcji</option>
                    <option value ="Romans" <c:if test="${film.getGatunek() == 'Romans'}">selected="selected"</c:if>>Romans</option>
            </select>
            <label for="pegi">Pegi</label>

            <select name="pegi" id="pegi" required>
            		<option value="Unknown" selected disabled hidden >Wybierz PEGI</option>
                    <option value ="3+" <c:if test="${film.getPegi() == '3+'}">selected="selected"</c:if>>3+</option>
                    <option value ="7+" <c:if test="${film.getPegi() == '7+'}">selected="selected"</c:if>>7+</option>
                    <option value ="12+" <c:if test="${film.getPegi() == '12+'}">selected="selected"</c:if>>12+</option>
                    <option value ="16+" <c:if test="${film.getPegi() == '16+'}">selected="selected"</c:if>>16+</option>
                    <option value ="18+" <c:if test="${film.getPegi() == '18+'}">selected="selected"</c:if>>18+</option>
            </select>

            <label for="cast">Obsada</label>
            <input type="text" name="cast" value="<c:out value='${film.getObsada()}'/>"/><br/>     
			 <input type="hidden" name="Id_filmu" value = "<c:out value='${film.getId()}'/>"/><br/>  
            <input id="addBtn" type="submit" value="Modyfikuj"/>  
        </form>  

        <form  method="get" action="FilmManagement">
            <button id="cancelBtn" type="submit">Anuluj</button>
        </form>
        

    </div>

</body>
</html>