<%-- 
    Document   : salesForm
    Created on : 16 Φεβ 2021, 6:33:55 μμ
    Author     : tzortziskapellas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Choose your Sale</h1>

        <c:if test="${salesToEdit==null}">
            <c:url value="/sales/create" var="link"/>
            <c:set var = "saleAttribute" scope = "request" value = "${sale}"/>
        </c:if>
        <c:if test="${salesToEdit!=null}">
            <c:url  value="/sales/update" var="link"/>
            <c:set var = "saleAttribute" scope = "request" value = "${salesToEdit}"/>
        </c:if>
        <form:form action="${link}" method="POST" modelAttribute = "saleAttribute">
            <form:hidden path = "scode"/>
            <label>Choose Products:</label>
            <form:select path = "pcode" multiple = "single" >
                <form:option value = "----" />
                <form:options items = "${products}" itemLabel = "pdescr" itemValue = "pcode"/>
            </form:select>
            <form:errors path = "pcode"/>
            <br/>
            <label>Choose Date:</label>
            <form:input path = "sdate" type = "date"/>
            <form:errors path = "sdate"/>
            <br/>
            <label>Choose Customer:</label>
            <form:select path = "ccode" multiple = "single">
                <form:option value = "----" />
                <form:options items = "${customers}" itemLabel = "cname" itemValue = "ccode"/>
            </form:select>
            <form:errors path = "ccode"/>
            <br/>
            <label>Choose Salesman</label>
            <form:select path = "smcode" multiple = "single">
                <form:option value = "----" />
                <form:options items = "${salesmen}" itemLabel = "sname" itemValue = "scode"/>
            </form:select>
            <form:errors path = "smcode"/>
            <br/>
            <label>Choose Quant</label>
            <form:input path = "quant" type = "number"/>
            <form:errors path = "quant"/>
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>