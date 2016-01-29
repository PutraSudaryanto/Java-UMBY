<%-- 
    Document   : index
    Created on : Jan 10, 2016, 4:46:20 PM
    Author     : Putra Sudaryanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% String action = request.getParameter("action");
System.out.println(action);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Village</title>
        <link rel="stylesheet" href="assets/css/general.css" />
        <link rel="stylesheet" href="assets/css/form.css" />
        <link rel="stylesheet" href="assets/css/typography.css" />
        <link rel="stylesheet" href="assets/css/layout.css" />
    </head>
    <body>
	
<div class="body clearfix">
	<div class="sidebar">
		<div class="table clearfix">
			<div class="menu clearfix">
				<div class="mainmenu">
					<ul class="clearfix">
						<li><a class="dashboard" href="Site?action=index" title="Dashboard">Dashboard</a></li>
						<li><a href="Province?action=manage" title="Province">Province</a></li>
						<li><a href="City?action=manage" title="City">City</a></li>
						<li><a href="District?action=manage" title="District">District</a></li>
						<li class="active"><a href="Village?action=manage" title="Village">Village</a></li>
					</ul>
				</div>

				<div class="submenu">
					<h3>Village</h3>
					<ul>
						<li class="selected"><a href="Village?action=manage" title="Manage">Manage</a></li>
						<% if (action.equalsIgnoreCase("add")) {%>
							<li class="selected"><a href="Village?action=add" title="Add">Add</a></li>
						<%} else {%>
							<li><a href="Village?action=add" title="Add">Add</a></li>
						<%}%>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="content">
		<div class="wrapper">
			<h1 class="small">Manage Village</h1>
			
        <div class="grid-view">
		<table class="items">
			<thead>
				<tr>
					<th>ID</th>
					<th>Village</th>
					<th>Zipcode</th>
					<th>District Id</th>
					<th>MFD Online</th>
					<th>Publish</th>
					<th>creationDate</th>
					<th>modifiedDate</th>
					<th>Option</th>
				</tr>
			</thead>
            <tbody>
                <c:forEach items="${model}" var="data">
                    <tr>
                        <td><c:out value="${data.villageId}" /></td>
                        <td><c:out value="${data.village}" /></td>
                        <td><c:out value="${data.zipcode}" /></td>
                        <td><c:out value="${data.districtId}" /></td>
                        <td><c:out value="${data.mfdonline}" /></td>
                        <td><c:out value="${data.publish}" /></td>
                        <td><c:out value="${data.creationDate}" /></td>
                        <td><c:out value="${data.modifiedDate}" /></td>
                        <td class="button-column">
							<a class="update" href="Village?action=edit&villageId=<c:out value="${data.villageId}"/>">Update</a>|
							<a class="delete" href="Village?action=delete&villageId=<c:out value="${data.villageId}"/>">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		</div>
			
		</div>
	</div>
</div>

<%@ include file="/footer.jsp"%>
    </body>
</html>
