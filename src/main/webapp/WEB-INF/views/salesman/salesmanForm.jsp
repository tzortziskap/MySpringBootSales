<%-- 
    Document   : salesmanForm
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
        <h1>Create your fantastic salesman</h1>
        
    <c:if test="${salesmanToEdit==null}">
        <c:url value="/salesman/create" var="link"/>
    </c:if>
    <c:if test="${salesmanToEdit!=null}">
        <c:url  value="/salesman/update" var="link"/>
    </c:if>
    <form action="${link}" method="POST">
        <label for="scode">Code:</label>
        <input id="scode" type="number" name="scode" value="${salesmanToEdit.scode}" readonly/>
        <br/>
        <label for="sname">Name:</label>
        <input id="sname" type="text" name="sname" value="${salesmanToEdit.sname}"/>
        <br/>
        <label for="scity">City:</label>
        <input id="scity" type="text" name="scity" value="${salesmanToEdit.scity}"/>
        <br/>
        <label for="scomm">Comm</label>
        <input id="scomm" type="number" step="0.01" name="scomm" value="${salesmanToEdit.scomm}"/>
        <br/>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>