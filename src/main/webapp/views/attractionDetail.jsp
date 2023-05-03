<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
<h1>${attraction.title }</h1>

주변 시설 찾아보기
<select id="type">
      <option value="">---종류을 선택해주세요---</option>
      <option value="AD5">숙박</option>
      <option value="FD6">음식점</option>
      <option value="CT1">문화시설</option>
      <option value="MT1">대형마트</option>
      <option value="CS2">편의점</option>
</select>
<input
      type="button"
      value="검색하기"
      onclick="searchAround(document.getElementById('type').value)"
/>

<script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bf6e75981d6225aa22adc5b8c08f1818&libraries=services"
></script>

<div id="map" style="width:700px;height:500px;"></div>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(${attraction.latitude}, ${attraction.longitude}), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(${attraction.latitude}, ${attraction.longitude}); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>

<script>

function searchAround(type) {
	// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
	var infowindow = new kakao.maps.InfoWindow({zIndex:1});

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
	    mapOption = {
	        center: new kakao.maps.LatLng(${attraction.latitude}, ${attraction.longitude}), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };

	// 지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption);

	// 장소 검색 객체를 생성합니다
	var ps = new kakao.maps.services.Places(map);

	// 카테고리로 은행을 검색합니다
	ps.categorySearch(type, placesSearchCB, {useMapBounds:true});

	// 키워드 검색 완료 시 호출되는 콜백함수 입니다
	function placesSearchCB (data, status, pagination) {
	    if (status === kakao.maps.services.Status.OK) {
	        for (var i=0; i<data.length; i++) {
	            displayMarker(data[i]);
	        }
	    }
	}

	// 지도에 마커를 표시하는 함수입니다
	function displayMarker(place) {
	    // 마커를 생성하고 지도에 표시합니다
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: new kakao.maps.LatLng(place.y, place.x)
	    });

	    // 마커에 클릭이벤트를 등록합니다
	    kakao.maps.event.addListener(marker, 'click', function() {
	        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
	        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
	        infowindow.open(map, marker);
	    });
	}
}
</script>

<h3>${attraction.addr1 }</h3>
<div>${attraction.overview }</div>

</body>
</html>