<%-- 
    Document   : salesForm
    Created on : 16 Φεβ 2021, 6:33:55 μμ
    Author     : tzortziskapellas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create your fantastic sales</h1>
        
    <c:if test="${salesToEdit==null}">
        <c:url value="/sales/create" var="link"/>
    </c:if>
    <c:if test="${salesToEdit!=null}">
        <c:url  value="/sales/update" var="link"/>
    </c:if>
    <form action="${link}" method="POST">
        <label for="">Code:</label>
        <input id="pcode" type="number" name="pcode" value="${salesToEdit.pcode}" readonly/>
        <br/>
        <label for="pdescr">Name:</label>
        <input id="pdescr" type="text" name="pdescr" value="${salesToEdit.pdescr}"/>
        <br/>
        <label for="pprice">Price:</label>
        <input id="pprice" type="text" name="pprice" value="${salesToEdit.pprice}"/>
        <br/>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>