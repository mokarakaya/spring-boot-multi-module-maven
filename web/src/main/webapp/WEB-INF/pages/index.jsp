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
		<tr>
			<td><td><label >Select Storage Type</label></td></td>
			<td>
				<form:select  name= "storageType" path="storageType" onchange="submit()">
					<form:option value="session"  >Session</form:option>
					<form:option value="database" >Database</form:option>
				</form:select>
			</td>
		</tr>
	</table>
		<table>
			<c:forEach items="${accountListWrapper.accountList}" varStatus="i" var="account">
				<tr>
					<td><label >Iban</label></td>
					<!-- if response is not from database account.id should be null -->
					<td><form:input  id="${account.id==null ? i.index:account.id}iban" path="accountList[${i.index}].iban" /></td>
					<td><label >Business Identifier Code</label></td>
					<td><form:input  id="${account.id==null ? i.index:account.id}businessIdentifierCode" path="accountList[${i.index}].businessIdentifierCode" /></td>
					<td><button onclick="updateRow(${account.id==null ? i.index:account.id})" />Update</td>
					<td><button onclick="deleteRow(${account.id==null ? i.index:account.id})" />Delete</td>
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
					<td><button onclick="createRow()" />Create</td>
				</tr>
		</table>
	</form:form>
<script>
	function updateRow(index) {
		storageTypeUrl= $('select[name=storageType]').val() == "session"  ? "sessionOperations" : "operations";
		$.ajax({
			async: false,
			type: "PUT",
			url: "/"+storageTypeUrl+"/?index="+index+"&iban="+document.getElementById(index+"iban").value
			+"&businessIdentifierCode="+document.getElementById(index+"businessIdentifierCode").value,
			success: function(data){
				console.log("update Row successful");
			},
			error : function(request,error) {
				alert(error);
			}});
	}
	function createRow() {
		storageTypeUrl= $('select[name=storageType]').val() == "session"  ? "sessionOperations" : "operations";
		$.ajax({
			async: false,
			type: "POST",
			url: "/"+storageTypeUrl+"/?iban="+document.getElementById("createIban").value
			+"&businessIdentifierCode="+document.getElementById("createBusinessIdentifierCode").value,
			success: function(data){
				console.log("create Row successful");
			},
			error : function(request,error) {
				alert(error);
			}});
	}
	function deleteRow(index,id) {
		storageTypeUrl= $('select[name=storageType]').val() == "session"  ? "sessionOperations" : "operations";
		$.ajax({
			async: false,
			type: "DELETE",
			url: "/"+storageTypeUrl+"/?index="+index,
			success: function(data){
				console.log("delete Row successful");
			},
			error : function(request,error) {
				alert(error);
			}});
	}
</script>
</html>
