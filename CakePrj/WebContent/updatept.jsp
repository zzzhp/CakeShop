<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	<table width="400" border="1" align="center">
		<tr>
			<th>typeid</th>
			<th>cakeid</th>
			<th>color</th>
			<th>size</th>
			<th>flavour</th>
			<th>discounts</th>
			<th>categories</th>
			<th>unitprice</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
		</tr>
	<c:forEach var="udp" items="${list}">
		<tr>
		<form action="updateptpt">
			<td><input type="hidden"  name="typeid"/>${udp.typeid}</td>
			<td><input type="hidden"  name="cakeid"/>${udp.cakeid}</td>
			<td><input type="hidden"  name="color"/>${udp.color}</td>
			<td><input type="hidden"  name="size"/>${udp.size}</td>
			<td><input type="hidden"  name="flavour"/>${udp.flavour}</td>
			<td><input type="hidden"  name="discounts"/>${udp.discounts}</td>
			<td><input type="hidden"  name="categories"/>${udp.categories}</td>
			<td><input type="hidden"  name="unitprice"/>${udp.unitprice}</td>
			<td>
			<input type="submit" name="update" value="修改" />
			<input type="submit" name="delete" value="删除" />
			</td>
			</form>
		</tr>
	</c:forEach>
	<tr>
			<form action="updateptptpt">
			<td><input type="hidden"  name="typeid"/></td>
			<td><input type="hidden"  name="cakeid"/></p></td>
			<td><input type="hidden"  name="color"/></td>
			<td><input type="hidden"  name="size"/></td>
			<td><input type="hidden"  name="flavour"/></td>
			<td><input type="hidden"  name="discounts"/></td>
			<td><input type="hidden"  name="categories"/></td>
			<td><input type="hidden"  name="unitprice"/></td>
			<td>
			<input type="submit" name="update" value="保存" />
			</td>
			</form>
		</tr>
	</table>
</form>
</body>
</html>