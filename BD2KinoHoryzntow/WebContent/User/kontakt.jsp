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

    <div class ="tabela">
        <p>Kontakt</p>

        <table class="pracownicyTable">
        <thead>
            <tr>
            <th>Adres</th>
            <th>Godziny otwarcia</th>
            <th>Telefon</th>
           </tr>
        </thead>
        <tbody>
            <tr>
                <td> Wrocław, Nowaka 2</td>
                <td> Pon-Niedz: 12:00-23:00 </td>
                <td> 777 222 888 </td>
            </tr>
        </tbody>
            </table>

    </div>

</body>
</html>