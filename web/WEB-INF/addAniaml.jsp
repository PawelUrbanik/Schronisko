<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowy pracownik</title>
</head>
<body>
<div class="container">

    <form class="form-signin" action="/addAnimal" method="post">
        <h2 class="form-signin-heading">Dodaj nowe zwierzę</h2>
        <input name="inputName" type="text" class="form-control" placeholder="Nazwa" required autofocus><br>
        Płeć:
        <input type="radio" name="inputGender" value="male" checked> Male
        <input type="radio" name="inputGender" value="female"> Female<br>
        Age:
        <input name="inputAge" type="text" class="form-control" placeholder="Wiek" required autofocus><br>
        Aktywność:
        <input type="radio" name="inputActivity" value="low" > Mała
        <input type="radio" name="inputActivity" value="medium" checked>  Srednia
        <input type="radio" name="inputActivity" value="high"> Duża <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Dodaj</button>
    </form>

</div> <!-- /container -->
</body>
</html>
