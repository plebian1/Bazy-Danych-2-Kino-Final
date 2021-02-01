<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<script type="text/javascript">

function confSubmit(form) {
if (confirm("Usuwasz rezerwację !")) {
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
        <h4 id = "panelName">Panel użytkownika</h4>
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

        <div class ="tabela">
        <p>Rezerwacje </p>

        <table class="seanseTable">
            <thead>
            <tr>
            <th>Id</th>
            <th>Film</th>
            <th id="dataCol">Data</th>
          	<th id="czasCol">Godzina</th>
          	<th>Sala</th>
          	<th>Rząd</th>
          	<th>Kolumna</th>
          	<th id="btnsED"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="r" items="${listRezerwacje}">
            <tr> 
            	<td><c:out value="${r.getId()}"/></td> 
            	<td><c:out value="${r.getNazwa()}"/></td>
                <td><c:out value="${r.getData()}"/></td> 
                <td><c:out value="${r.getGodzina()}"/></td> 
                <td><c:out value="${r.getSala()}"/></td> 
                <td><c:out value="${r.getRzad()}"/></td> 
                <td><c:out value="${r.getKolumna()}"/></td>
                <td>
				
				<form id="deleteBtnlist" action="RezerwacjaDelete" method="post"> 
				 <input type="hidden" name="Id_rezerwacji" value = '${r.getId()}'/> 
				<input type="button" onClick="confSubmit(this.form);" value="Anuluj"/>  </form>
				
				</td>
            </tr> 
        </c:forEach>
</tbody>
            </table>
            </div>

</body>
</html>