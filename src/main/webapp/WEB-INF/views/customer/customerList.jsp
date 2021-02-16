<%-- 
    Document   : customerList
    Created on : 16 Φεβ 2021, 6:34:27 μμ
    Author     : tzortziskapellas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
       <title>Customers</title>
    </head>
    <body>
        <h1>This is my List of customers</h1>
        <div>
            <h3>Customer</h3>
            <p>
            </p>
            <a href="${pageContext.request.contextPath}/customer/create">Add customer</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfCustomers}" var = "customer">
                    <tr>
                        <td>${customer.ccode}</td>
                        <td>${customer.cname}</td>
                        <td>      
                            <a href="${pageContext.request.contextPath}/customer/update/${customer.ccode}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/customer/delete?id=${customer.ccode}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
