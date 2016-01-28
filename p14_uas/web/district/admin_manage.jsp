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
                        <td><c:out value="${data.districtName}" /></td>
                        <td><c:out value="${data.cityId}" /></td>
                        <td><c:out value="${data.mfdonline}" /></td>
                        <td><c:out value="${data.publish}" /></td>
                        <td><c:out value="${data.creationDate}" /></td>
                        <td><c:out value="${data.modifiedDate}" /></td>
                        <td><a href="District?action=edit&districtId=<c:out value="${data.districtId}"/>">Update</a></td>
                        <td><a href="District?action=delete&districtId=<c:out value="${data.districtId}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
