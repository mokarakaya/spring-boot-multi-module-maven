<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.apiDemo.model.Account"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
<body>
	<form:form method="GET" modelAttribute="accountListWrapper" action="/">
		<table>
			<c:forEach items="${accountListWrapper.accountList}" varStatus="i">
				<tr>
					<td><label >Iban</label></td>
					<td><form:input  id="${i.index}iban" path="accountList[${i.index}].iban" /></td>
					<td><label >Business Identifier Code</label></td>
					<td><form:input  id="${i.index}businessIdentifierCode" path="accountList[${i.index}].businessIdentifierCode" /></td>
					<td><button onclick="updateRow(${i.index})" />Update</td>
					<td><button onclick="deleteRow(${i.index})" />Delete</td>
				</tr>
			</c:forEach>
		</table>
		<br>

		<table>
				<tr>
					<td><label >Iban</label></td>
					<td><input  id="createIban" path="createIban" /></td>
					<td><label >Business Identifier Code</label></td>
					<td><input  id="createBusinessIdentifierCode" path="createBusinessIdentifierCode" /></td>
					<td><button onclick="createRow(${i.index})" />Create</td>
				</tr>
		</table>
	</form:form>
<script>
	function updateRow(index) {
		$.ajax({
			type: "PUT",
			url: "/operations/?index="+index+"&iban="+document.getElementById(index+"iban").value
			+"&businessIdentifierCode="+document.getElementById(index+"businessIdentifierCode").value,
			success: function(data){
				console.log("update Row successful");
			},
			error : function(request,error) {
				alert(error);
			}});
	}
	function createRow(index) {
		$.ajax({
			type: "POST",
			url: "/operations/?iban="+document.getElementById("createIban").value
			+"&businessIdentifierCode="+document.getElementById("createBusinessIdentifierCode").value,
			success: function(data){
				console.log("create Row successful");
			},
			error : function(request,error) {
				alert(error);
			}});
	}
	function deleteRow(index) {
		$.ajax({
			type: "DELETE",
			url: "/operations/?index="+index,
			success: function(data){
				console.log("delete Row successful");
			},
			error : function(request,error) {
				alert(error);
			}});
	}
</script>
</html>
