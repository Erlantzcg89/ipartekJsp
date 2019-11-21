<%
	String titulo = "Ipartek Web App";
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Arkanoid</title>

    <base href="/helloweb/">

    <link rel="icon" type="image/png" href="https://picsum.photos/id/1009/50/50" />
    <link rel="stylesheet" href="css/game.css">
</head>

<body>
    <a href="index.jsp">Inicio</a>
    <a href="ejemplos/js/index.jsp">Volver</a>
    <a target="_blank" href="https://developer.mozilla.org/es/docs/Games/Workflows/Famoso_juego_2D_usando_JavaScript_puro">Tutorial</a>

    <h1>Arkanoid</h1>

    <canvas id="myCanvas" width="480" height="320"></canvas>

    <script src="js/game.js"></script>
</body>

</html>