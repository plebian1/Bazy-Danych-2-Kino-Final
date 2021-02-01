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

        <form id="insertSeansForm" action="SeansModify" method="post"> 
            
            
            <label for="filmTitle">Film</label>
            <input type="text" name="filmTitle" disabled value="<c:out value='${film.getTytul()}' />" required/><br/>
            <input type="hidden" name="Id_filmu" value="<c:out value='${film.getId()}'/>"/>
            
            <label for="opiekunName">Opiekun</label>
            <select name="opiekunName" id="opiekunName" required>
                   <c:forEach items="${listOpiekun}" var="o">
                <option value="${o.getId()}" <c:if test="${o.getId() == aktualnyOpiekun}">selected="selected"</c:if>>
                    ${o.getNazwisko()}
                </option>
            </c:forEach>
            </select>
            
             <label for="numerSali">Sala</label>
            <input type="text" name="numerSali" disabled value="<c:out value='${sala}' />" required/><br/>
            
            
            <label for="data">Data</label>
            <input type="text" name="data" placeholder="RRRR-MM-DD" value="${seans.getData()}" required/><br/>
            
            <label for="godzina">Godzina</label>
            <input type="text" name="godzina"  placeholder="HH:MM:SS" value="${seans.getGodzina()}" required/><br/>
            
            <label for="duration">Czas trwania</label>
            <input type="text" name="duration"  placeholder="HH:MM:SS" value="${seans.getCzas_trwania()}" required/><br/>
            
            <label id="napisyL" for="napisy">Napisy</label>

            <select name="napisy" id="napisy" required>
                    <option value ="tak" <c:if test="${seans.getNapisy() == 'tak'}">selected="selected"</c:if> >TAK</option>
                    <option value ="nie" <c:if test="${seans.getNapisy() == 'nie'}">selected="selected"</c:if> >NIE</option>
            </select>
            
            <label id="jezykL" for="jezyk">Język</label>
            <select name="jezyk" id="jezyk" required>
                    <option value ="Polski" <c:if test="${seans.getJezyk() == 'Polski'}">selected="selected"</c:if>>Polski</option>
                    <option value ="Angielski" <c:if test="${seans.getJezyk() == 'Angielski'}">selected="selected"</c:if>>Angielski</option>
            </select>
    		
    		<input type="hidden" name="Id_seansu" value="<c:out value='${seans.getId()}'/>"/>

    		
            <input id="addBtn" type="submit" value="Modyfikuj"/>  
        </form>  

        <form  method="get" action="seansManagement">
            <button id="cancelBtn" type="submit">Anuluj</button>
        </form>
        

    </div>

</body>
</html>