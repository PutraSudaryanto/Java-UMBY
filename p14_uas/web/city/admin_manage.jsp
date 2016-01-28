<%-- 
    Document   : index
    Created on : Jan 10, 2016, 4:46:20 PM
    Author     : Putra Sudaryanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tbody>
                <c:forEach items="${model}" var="data">
                    <tr>
                        <td><c:out value="${data.city}" /></td>
                        <td><c:out value="${data.provinceId}" /></td>
                        <td><c:out value="${data.mfdonline}" /></td>
                        <td><c:out value="${data.publish}" /></td>
                        <td><c:out value="${data.creationDate}" /></td>
                        <td><c:out value="${data.modifiedDate}" /></td>
                        <td><a href="City?action=edit&cityId=<c:out value="${data.cityId}"/>">Update</a></td>
                        <td><a href="City?action=delete&cityId=<c:out value="${data.cityId}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
