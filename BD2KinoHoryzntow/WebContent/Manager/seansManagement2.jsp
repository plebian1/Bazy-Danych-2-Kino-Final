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
<script type="text/javascript">

function confSubmit(form) {
if (confirm("Usuwasz seans !")) {
form.submit();
}

else {
alert("Anulowano usuwanie!");
}
}
</script>
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

        <ul id="menuManager2">
            <li><a href="RachunekView">Przegląd rachunków</a></li>
            </ul>

            <ul id="menuManager3">
                <li><a href="SeansGetdata1">Dodaj seans</a></li>
                <li><a href="seansManagement2">Modyfikuj dane</a></li>
                </ul>   

    </div>

    <div class ="login">
           <p id="loginBtn"><a href="../index.jsp">Wyloguj</a></p> 

    </div>

    <div class ="tabela">
        <p>Seanse </p>

        <table class="seanseTable">
            <thead>
            <tr>
            <th>Id</th>
            <th id="dataCol">Data</th>
          	<th id="czasCol">Godzina</th>
          	<th>Film</th>
          	<th>Sala</th>
          	<th>Napisy</th>
          	<th>Jezyk</th>
          	<th id="czasCol">Długość</th>
          	<th>Opiekun</th>
          	<th id="btnsED"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="s" items="${listSeanse}">
            <tr> 
            	<td><c:out value="${s.getId()}"/></td> 
                <td><c:out value="${s.getData()}"/></td> 
                <td><c:out value="${s.getGodzina()}"/></td> 
                <td><c:out value="${s.getNazwa_filmu()}"/></td> 
                <td><c:out value="${s.getId_sali()}"/></td>
                <td><c:out value="${s.getNapisy()}"/></td> 
                <td><c:out value="${s.getJezyk()}"/></td> 
                <td><c:out value="${s.getCzas_trwania()}"/></td>
                <td><c:out value="${s.getImieNazwisko()}"/></td>
                
                <td>
				
				<form id="editBtnlist" action="SeansEdit" method="post"> 
				 <input type="hidden" name="Id_seansu" value = '${s.getId()}'/>  
				<input type="submit" value="E"/>  </form>  
				
				<form id="deleteBtnlist" action="SeansDelete" method="post"> 
				 <input type="hidden" name="Id_seansu" value = '${s.getId()}'/> 
				<input type="button" onClick="confSubmit(this.form);" value="D"/>  </form>
				
				</td>
            </tr> 
        </c:forEach>
</tbody>
            </table>
    </div>

</body>
</html>
