<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html> <!-- html5 -->
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <base href="/helloweb/">

    <%
    	out.print("<title>"+titulo+"</title>");
    %>
    
    <link rel="icon" type="image/png" href="https://picsum.photos/id/1009/50/50" />
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <link rel="stylesheet" href="css/styles.css?time=<%=System.currentTimeMillis()%>">
</head>

<body id="cuerpo">