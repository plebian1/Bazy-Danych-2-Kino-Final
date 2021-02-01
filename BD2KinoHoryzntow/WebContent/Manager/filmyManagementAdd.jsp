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

        <ul id="menuManager2">
            <li><a href="RachunekView">Przegląd rachunków</a></li>
            </ul>
   

    </div>

    <div class ="login">
           <p id="loginBtn"><a href="../index.jsp">Wyloguj</a></p> 

    </div>

    <div class ="pracownikForm">
        <p>Film</p>

        <form id="insertPracownikForm" action="insertfilm" method="post"> 
            <label for="filmTitle">Tytuł</label>
            <input type="text" name="filmTitle" required/>
            <label for="director">Reżyser</label>
            <input type="text" name="director" required/>
            <label for="duration">Czas trwania</label>
            <input type="text" placeholder="HH:MM:SS" name="duration" required/>
            <label for="gatunek">Gatunek</label>

            <select name="gatunek" id="gatunek"  required>
            		<option value="Unknown" selected disabled hidden >Wybierz gatunek</option>
                    <option value ="Komedia" >Komedia</option>
                    <option value ="Dramat" >Dramat</option>
                    <option value ="Thriller">Thriller</option>
                    <option value ="Sci-Fi" >Sci-Fi</option>
                    <option value ="Dokumentalny" >Dokumentalny</option>
                    <option value ="Akcji" >Akcji</option>
                    <option value ="Romans">Romans</option>
            </select>
            <label for="pegi">Pegi</label>

            <select name="pegi" id="pegi" required>
            		<option value="Unknown" selected disabled hidden >Wybierz PEGI</option>
                    <option value ="3+">3+</option>
                    <option value ="7+">7+</option>
                    <option value ="12+">12+</option>
                    <option value ="16+">16+</option>
                    <option value ="18+">18+</option>
            </select>

            <label for="cast">Obsada</label>
            <input type="text" name="cast"/>    


            <input id="addBtn" type="submit" value="Dodaj"/>  
        </form>  

        <form  method="get" action="FilmManagement">
            <button id="cancelBtn" type="submit">Anuluj</button>
        </form>
        

    </div>

</body>
</html>