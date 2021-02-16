<%-- 
    Document   : saleList
    Created on : 16 Φεβ 2021, 6:34:27 μμ
    Author     : tzortziskapellas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
       <title>Sales</title>
    </head>
    <body>
        <h1>This is my List of sales</h1>
        <div>
            <h3>Sales</h3>
            <p>
                ${message}
            </p>
            <a href="${pageContext.request.contextPath}/sales/create">Add sale</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Product</th>
                        <th>Sdate</th>
                        <th>Customer</th>
                        <th>Salesman</th>
                        <th>Quant</th>
                        <th>Cost</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfSales}" var = "sale">
                    <tr>
                        <td>${sale.scode}</td>
                        <td>${sale.pcode.pdescr}</td>
                        <td>${sale.sdate}</td>
                        <td>${sale.ccode.cname}</td>
                        <td>${sale.smcode.sname}</td>
                        <td>${sale.quant}</td>
                        <td>${sale.cost}</td>
                        <td>      
                            <a href="${pageContext.request.contextPath}/sales/update/${sale.pcode}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/sales/delete?id=${sale.pcode}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
