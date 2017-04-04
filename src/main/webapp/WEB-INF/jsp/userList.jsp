<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#btnAdd").click(function(){
				window.location.href="/users/-1";
			})
			$("#btnDelte").click(function(){
				  var deletUserid=$('input:radio[name="radios"]:checked').val();
				  if(deletUserid){
					  $.ajax({
					        type: "DELETE",
					        url: "/users/"+deletUserid,
					        success: function (result) {
					            if (result == "success") {
					            	window.location.href="/users/";
					               alert(result);
					            }
					        }
					    });
				  }else{
					  alert("请选择删除的数据");
				  }
			})
		})
	</script>
</head>
<body>
<div>
<div  style="width:100%;align:right;text-align: right ">
	<input type="button" id ="btnAdd" value="新增" ></input>
	<input type="button" id ="btnDelte" value="删除"></input>
</div>
	<c:if test="${empty requestScope.users }">
		列表数据为空
	</c:if>
	<c:if test="${!empty requestScope.users }">		
		<table border="1" width='100%'>
			<tr>
				<th></th>
				<th>id</th>
				<th>name</th>
				<th>address</th>
				<th>age</th>
			</tr>
			<c:forEach items="${requestScope.users }" var="user">
				<tr>
					<th width="60px"><input type="radio" id="${user.id}" name="radios" value="${user.id}" /></th>
					<th><a href="/users/${user.id}">${user.id}</a></th>
					<th>${user.name}</th>
					<th>${user.address}</th>
					<th>${user.age}</th>
				</tr>
			</c:forEach>
		</table>
	</c:if>
			
</div>
</body>

</html>
