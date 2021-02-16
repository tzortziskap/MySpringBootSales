<%-- 
    Document   : salesmanList
    Created on : 16 Φεβ 2021, 6:34:27 μμ
    Author     : tzortziskapellas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
       <title>Salesmen</title>
    </head>
    <body>
        <h1>This is my List of salesmen</h1>
        <div>
            <h3>Salesmen</h3>
            <a href="${pageContext.request.contextPath}/salesman/create">Add salesman</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Comm</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfSalesmen}" var = "salesman">
                    <tr>
                        <td>${salesman.scode}</td>
                        <td>${salesman.sname}</td>
                        <td>${salesman.scity}</td>
                        <td>${salesman.scomm}</td>
                        <td>      
                            <a href="${pageContext.request.contextPath}/salesman/update/${salesman.scode}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/salesman/delete?id=${salesman.scode}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
