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
    
    <div class ="tabela">
    <p>Rezerwacje</p>
   <table class ="seanseTable" >
       <thead>
       <tr>
          <th id="czasCol">Data</th>
          <th id="dataCol">Godzina</th>
          <th>Film</th>
          <th>Sala</th>
          <th>Napisy</th>
          <th>Jezyk</th>
          <th id="czasCol">Dlugosc</th>
          <th id="btnsED"> </th>
       </tr>
       </thead>
       <tbody>
       <c:forEach var="s" items="${listSeanse}">
            <tr> 
                <td><c:out value="${s.getData()}"/></td> 
                <td><c:out value="${s.getGodzina()}"/></td> 
                <td><c:out value="${s.getNazwa_filmu()}"/></td> 
                <td><c:out value="${s.getId_sali()}"/></td>
                <td><c:out value="${s.getNapisy()}"/></td> 
                <td><c:out value="${s.getJezyk()}"/></td> 
                <td><c:out value="${s.getCzas_trwania()}"/></td>
                <td>
                
                <form id="editBtnlist" action="rezerwacjaAprove" method="post"> 
				 <input type="hidden" name="Id_seansu" value = '${s.getId()}'/>
				<input type="submit" value="P"/>  </form>  
				<form id="deleteBtnlist" action="sale" method="post"> 
				 <input type="hidden" name="Id_seansu" value = '${s.getId()}'/>
				<input type="submit" value="S"/>  </form> 
                </td>
            </tr> 
        </c:forEach>
        </tbody>
    </table>
    </div>
</html>
