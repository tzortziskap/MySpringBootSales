<%-- 
    Document   : familyForm
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
        <h1>Create your fantastic family</h1>
        
    <c:if test="${familyToEdit==null}">
        <c:url value="/family/create" var="link"/>
    </c:if>
    <c:if test="${familyToEdit!=null}">
        <c:url  value="/family/update" var="link"/>
    </c:if>
    <form action="${link}" method="POST">
        <label for="fid">Code:</label>
        <input id="fid" type="number" name="fid" value="${familyToEdit.fid}" readonly/>
        <br/>
        <label for="fname">Name:</label>
        <input id="fname" type="text" name="fname" value="${familyToEdit.fname}"/>
        <br/>
        <label for="dob">Date of Birth:</label>
        <input id="dob" type="date" name="dob" value="${familyToEdit.dob}"/>
        <br/>
        <label for="frelationship">Relationship</label>
        <input id="frelationship" type="text" name="frelationship" value="${familyToEdit.frelationship}"/>
        <br/>
        <label for="salesman">Price:</label>
        <input id="salesman" type="text" name="salesman" value="${familyToEdit.salesman.sname}" />
        <br/>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>