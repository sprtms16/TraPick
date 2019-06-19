<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TraPick</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="scheduler.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?key=AIzaSyC3G1qQMeFpartaXg_UguoBElqDEDYu3Rg"></script>
<script>

function initialize() {
    
    var mapOptions = {
                        zoom: 18, // 지도를 띄웠을 때의 줌 크기
                        mapTypeId: google.maps.MapTypeId.ROADMAP
                    };
     
     
    var map = new google.maps.Map(document.getElementById("map-canvas"), // div의 id과 값이 같아야 함. "map-canvas"
                                mapOptions);
     
    var size_x = 40; // 마커로 사용할 이미지의 가로 크기
    var size_y = 40; // 마커로 사용할 이미지의 세로 크기
 
    // 마커로 사용할 이미지 주소
    var image = new google.maps.MarkerImage( '주소 여기에 기입!',
                                                new google.maps.Size(size_x, size_y),
                                                '',
                                                '',
                                                new google.maps.Size(size_x, size_y));
     
    // Geocoding *****************************************************
    var address = "<%=request.getParameter("city_name")%>"; // DB에서 주소 가져와서 검색하거나 왼쪽과 같이 주소를 바로 코딩.
    var marker = null;
    var geocoder = new google.maps.Geocoder();

    geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
            marker = new google.maps.Marker({
                            map: map,
                            icon: image, // 마커로 사용할 이미지(변수)
                            title: '한밭도서관', // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
                            position: results[0].geometry.location
                        });

            var content = "위치"; // 말풍선 안에 들어갈 내용
         
            var infowindow = new google.maps.InfoWindow({ content: content});
            google.maps.event.addListener(marker, "click", function() {infowindow.open(map,marker);});
        } else {
            alert("Geocode was not successful for the following reason: " + status);
        }
        
    });     
}
google.maps.event.addDomListener(window, 'load', initialize);
	
/* 	window.onload = function() {
		$("#popUp").hide();
	}
	
	function showPopup() {
		$("#popUp").show();
	}
	 */
	function hidePopup() {
		$("#popUp").hide();
	}
	
</script>
<title>여행상품</title>
</head>
<body>

	<!-- Temp_Scheduler -->
	<form action="????????" id="scheduleTable">
		<p>일정표</p>
				<table border="1">
					<tr>
						<th>일정</th>
						<th>1일차</th>
						<th>2일차</th>
						<th>3일차</th>
						<th>4일차</th>
						<th>5일차</th>
					</tr>
					<tr>
						<td>06 ~ 09</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
					</tr>
					<tr>
						<td>09 ~ 12</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
					</tr>
					<tr>
						<td>12 ~ 15</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
					</tr>
					<tr>
						<td>15 ~ 18</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
					</tr>
					<tr>
						<td>18 ~ 21</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
					</tr>
					<tr>
						<td>21 ~ 24</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
						<td>빈칸</td>
					</tr>
				</table>			
	</form>

	<h2>여행상품 보기</h2>

	<form action="sortList" id="sortButton">
		<button value="price" name="price">가격 순</button>
		<button value="sales" name="sales">판매량 순</button>
		<button value="hits" name="hits">인기 순</button>
		<button value="dist" name="dist" onclick="showPopup();">거리순</button>
		<input type="hidden" name="country_name"
			value="<%=request.getParameter("country_name")%>"> <input
			type="hidden" name="city_name"
			value="<%=request.getParameter("city_name")%>">
	</form>
				<div id="popUp">
					<form action="sortDist">
					위치 : <input type="text" name = "current" value="current">
					<button value="distance" name="distance">확인</button>
					<input type="hidden" name = "country_name" value="<%=request.getParameter("country_name")%>">
					<input type="hidden" name = "city_name" value="<%=request.getParameter("city_name")%>">
					</form>
				</div>
	<div id="content" id="itemList">
		<div id="price">
			<h3>상품 목록</h3>
			<table border="1">
				<tbody>
					<c:forEach var="list" items="${list }">
						<tr>
							<td>${list.name }</td>
							<td>${list.price }</td>
							<td>${list.sales }</td>
							<td>${list.country_name }</td>
							<td>${list.city_name }</td>
							<td>${list.dist }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div id="map-canvas" style="width: 60%; height: 340px" title="지도" id = "Map"></div>	
</body>
</html>