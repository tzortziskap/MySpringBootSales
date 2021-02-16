<%-- 
    Document   : familyList
    Created on : 16 Φεβ 2021, 6:34:27 μμ
    Author     : tzortziskapellas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
       <title>Family</title>
    </head>
    <body>
        <h1>This is my List of familys</h1>
        <div>
            <h3>Family</h3>
            <p>
                ${message}
            </p>
            <a href="${pageContext.request.contextPath}/family/create">Add family</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Relationship</th>
                        <th>Date of Birth</th>
                        <th>Parent Name</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfFamilys}" var = "family">
                    <tr>
                        <td>${family.fid}</td>
                        <td>${family.fname}</td>
                        <td>${family.frelationship}</td>
                        <td>${family.dob}</td>
                        <td>${family.salesman.sname}</td>
                        <td>      
                            <a href="${pageContext.request.contextPath}/family/update/${family.fid}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/family/delete?id=${family.fid}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
