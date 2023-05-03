<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>map</title>
</head>
<body>
	<!-- 지도를 표시할 div 입니다 -->
	<h1>관광지 찾아보기</h1>
	<form action="attractionList" method="post">
		<select name="location">
			<option value="">---지역을 선택해주세요---</option>
			<c:forEach items="${sidoList }" var="s">
				<option value="${s.sido_code }">${s.sido_name }</option>
			</c:forEach>
		</select>
		<input type="submit" value="검색하기"/>
	</form>
</body>
</html>