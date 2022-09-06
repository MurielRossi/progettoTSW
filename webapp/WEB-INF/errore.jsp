<%--
  Created by IntelliJ IDEA.
  User: Lethal Muriel
  Date: 06/09/2022
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Throwable exceptionType = (Throwable) request.getAttribute("javax.servlet.error.exception");
    Integer statusCode=(Integer) request.getAttribute("javax.servlet.error.status_code");
    String servletName= (String) request.getAttribute("javax.servlet.error.servlet_name");
    String requestUri=(String) request.getAttribute("javax.servlet.error.request_uri");
%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Storytelling-<%=statusCode%></title>

</head>

<body>
<div>
    <h1>Error Type:<br><%=exceptionType%></h1>
    <h1>Error Code:<br><%=statusCode%></h1>
    <h1>Servlet who gived the error:<br><%=servletName%></h1>
    <h1>The Uri who caused the error:<br><%=requestUri%></h1>
</div>
</body>