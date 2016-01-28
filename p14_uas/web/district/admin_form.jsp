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
        <form method="POST" action="Province" name="">
            <% String action = request.getParameter("action");
            System.out.println(action);
            %>
            <fieldset>
                <div class="cleatfix">
                    <label>MFD Online</label>
                    <div class="desc">
                        <% if (action.equalsIgnoreCase("edit")) {%>
                            <input type="text" name="mfdonline" readonly="readonly" value="<c:out value="${model.mfdonline}" />" />    
                        <%} else {%>
                            <input type="text" name="mfdonline" value="<c:out value="${model.mfdonline}" />" />                        
                        <%}%>
                    </div>
                </div>
                <div class="cleatfix">
                    <label>Province</label>
                    <div class="desc">
                        <input type="text" name="district_name" value="<c:out value="${model.districtName}" />" />
                    </div>
                </div>
                <div class="cleatfix">
                    <label>Publish</label>
                    <div class="desc">
                        <input type="text" name="publish" value="<c:out value="${model.publish}" />" />                           
                    </div>
                </div>
                <div class="cleatfix">
                    <label></label>
                    <div class="desc">
                        <input type="submit" value="Submit" />
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
</html>
