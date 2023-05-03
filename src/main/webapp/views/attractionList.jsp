<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 해당 지역에 속하는 관광지 정보 리스트로 넘기기 --%>
<table class="attraction-list"
	border="1"
    width="50%"
    height="200"
    cellspacing="5">>
	<th>이미지</th>
	<th>관광지 명</th>
	<th>주소</th>
	<th>근처 편의 시설 보기</th>
	<c:forEach items="${attractionList }" var="a">
		<c:if test=""></c:if>
			<tr>
				<td><img alt="" src="${a.first_image }" height="150" width="150"></td>
				<td>${a.title }</td>
				<td>${a.addr1 }</td>
				<td><a href="detail?content_id=${a.content_id }">상세 정보</a></td>
			<tr>
	</c:forEach>
</table>
</body>
</html>