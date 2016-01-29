<%-- 
    Document   : admin_index
    Created on : Jan 28, 2016, 1:37:01 PM
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
        <title>Welcome, Putra Sudaryanto</title>
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
						<li class="active"><a class="dashboard" href="Site?action=index" title="Dashboard">Dashboard</a></li>
						<li><a href="Province?action=manage" title="Province">Province</a></li>
						<li><a href="City?action=manage" title="City">City</a></li>
						<li><a href="District?action=manage" title="District">District</a></li>
						<li><a href="Village?action=manage" title="Village">Village</a></li>
					</ul>
				</div>

				<div class="submenu">
					<h3>Dashboard</h3>
				</div>
			</div>
		</div>
	</div>

	<div class="content">
		<div class="wrapper">
			<h1 class="small">Welcome</h1>
			
		</div>
	</div>
</div>

<%@ include file="/footer.jsp"%>
	
    </body>
</html>
