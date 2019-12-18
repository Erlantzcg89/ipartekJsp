<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="es_ES" />

<!DOCTYPE html> <!-- html5 -->
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <%
    	out.print("<title>"+titulo+"</title>");
    %>

    <!-- Base -->
    <base href="/Erlantz/">
    <!-- Favicon -->
    <link rel="icon" type="image/png" href="images/favicon.ico" />
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.css?time=<%=System.currentTimeMillis()%>">
    <!-- Font-awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">