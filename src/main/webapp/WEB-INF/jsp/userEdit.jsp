<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		var userVO="${user}";
		$(function(){
			$("#btnRe").click(function(){
				window.location.href="/users/";
			})
			var userid='${user.id }';
			if(userid){
				$("#userid").attr("disabled","true");
			}else{
				$("#userid").removeAttr("disabled");
			}
		})
	</script>
</head>
<body>
<div>
<!-- 	<div  style="width:30%;align:right;text-align: right;"> -->
	<!-- ${pageContext.request.contextPath} --> 
<!-- 		<input type="button" id ="btnSave"  value="保存" ></input> -->
		
<!-- 	</div> -->
	<div  style="width:30%">	
		<form id="formid" action="/users/${user.id }" method="post">
			<table width="100%" border="1"  style="align:left;text-align: left;">
				<c:if test="${empty user.id }">
						<input type="hidden" name="_method" value="post" />					
				</c:if>
				<c:if test="${!empty user.id }">
					<input type="hidden" name="_method" value="put" />
					<tr>
						<td style="width:10%;align:right;text-align: right;">id:</td>
						<td><input type="text" id="userid"name="id" value="${user.id }" /></td>
					</tr>
				</c:if>			
				
				<tr>
					<td style="width:10%;align:right;text-align: right;">name:</td>
					<td><input type="text" id="name" name="name" value="${user.name }" /></td>
				</tr>
				<tr>
					<td style="width:10%;align:right;text-align: right;">address:</td>
					<td><input type="text" id="address" name="address" value="${user.address }" /></td>
				</tr>
				<tr>
					<td style="width:10%;align:right;text-align: right;">age:</td>
					<td><input type="text" id="age" name="age" value="${user.age }" /></td>
				</tr>				
			</table>			
			<input type="submit" value="Submit" />	
			<input type="button" id ="btnRe"  value="返回"></input>
		</form>			
	</div>	
</div>		
</body>

</html>
