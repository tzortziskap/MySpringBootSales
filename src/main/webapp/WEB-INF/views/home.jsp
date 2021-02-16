<%-- 
    Document   : home
    Created on : 16 Φεβ 2021, 12:20:59 μμ
    Author     : tzortziskapellas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="${pageContext.request.contextPath}/product">Product</a>
        <a href="${pageContext.request.contextPath}/customer">Customer</a>
        <a href="${pageContext.request.contextPath}/sales">Sales</a>
        <a href="${pageContext.request.contextPath}/salesman">Salesman</a>
        <a href="${pageContext.request.contextPath}/family">Family</a>
    </body>
</html>
