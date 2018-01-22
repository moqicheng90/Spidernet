<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css">
		</style>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
		
	</head>

	<body>
		
		<table border="1" cellspacing="0" cellpadding="0">
			<thead>
				
			</thead>
			<tbody id="shixinDetail">
				<tr>
					<td><strong>被执行人姓名/名称:</strong></td>
					<td id="iname"></td>
				</tr>
				<tr>
					<td><strong>身份证号码/组织机构代码:</strong></td>
					<td id="cardNum"></td>
				</tr>
				<tr>
					<td><strong>法定代表人:</strong></td>
					<td id="businessEntity"></td>
				</tr>
				<tr>
					<td><strong>执行法院:</strong></td>
					<td id="courtName"></td>
				</tr>
				<tr>
					<td><strong>省份:</strong></td>
					<td id="areaName"></td>
				</tr>
				<tr>
					<td><strong>执行依据文号:</strong></td>
					<td id="gistId"></td>
				</tr>
				<tr>
					<td><strong>立案时间:</strong></td>
					<td id="regDate"></td>
				</tr>
				<tr>
					<td><strong>案号:</strong></td>
					<td id="caseCode"></td>
				</tr>
				<tr>
					<td><strong>做出执行依据单位:</strong></td>
					<td id="gistUnit"></td>
				</tr>
				<tr>
					<td><strong>生效法律文书确定的义务:</strong></td>
					<td id="duty"></td>
				</tr>
				<tr>
					<td><strong>被执行人履行情况:</strong></td>
					<td id="performance"></td>
				</tr>
				<tr>
					<td><strong>失信被执行人行为具体情形:</strong></td>
					<td id="disruptTypeName"></td>
				</tr>
				<tr>
					<td><strong>发布时间:</strong></td>
					<td id="publishDate"></td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
