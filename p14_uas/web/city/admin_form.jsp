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
		<% if (action.equalsIgnoreCase("add")) {%>
		<title>Add City</title>
		<%} else {%>
		<title>Update City</title>
		<% }%>
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
						<li class="active"><a href="City?action=manage" title="City">City</a></li>
						<li><a href="District?action=manage" title="District">District</a></li>
						<li><a href="Village?action=manage" title="Village">Village</a></li>
					</ul>
				</div>

				<div class="submenu">
					<h3>City</h3>
					<ul>
						<li><a href="City?action=manage" title="Manage">Manage</a></li>
						<% if (action.equalsIgnoreCase("add")) {%>
							<li class="selected"><a href="City?action=add" title="Add">Add</a></li>
						<%} else {%>
							<li><a href="City?action=add" title="Add">Add</a></li>
						<%}%>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="content">
		<div class="wrapper">
			<% if (action.equalsIgnoreCase("add")) {%>
			<h1 class="small">Add City</h1>
			<%} else {%>
			<h1 class="small">Update City</h1>
			<% }%>
			
        <form method="POST" action="City" name="">
            <fieldset class="clearfix">
                <div class="clearfix">
                    <label>MFD Online</label>
                    <div class="desc">
                        <% if (action.equalsIgnoreCase("edit")) {%>
                            <input type="text" name="mfdonline" readonly="readonly" value="<c:out value="${model.mfdonline}" />" />    
                        <%} else {%>
                            <input type="text" name="mfdonline" value="<c:out value="${model.mfdonline}" />" />                        
                        <%}%>
                    </div>
                </div>
                <div class="clearfix">
                    <label>City</label>
                    <div class="desc">
                        <input type="text" name="city" value="<c:out value="${model.city}" />" />
                    </div>
                </div>
                <div class="clearfix">
                    <label>Publish</label>
                    <div class="desc">
                        <input type="text" name="publish" value="<c:out value="${model.publish}" />" />                           
                    </div>
                </div>
                <div class="clearfix">
                    <label></label>
                    <div class="desc">
                        <input type="submit" value="Submit" />
                    </div>
                </div>
            </fieldset>
        </form>			
			
		</div>
	</div>
</div>

<%@ include file="/footer.jsp"%>
    </body>
</html>
