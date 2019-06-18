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
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("input").checkboxradio();
	});
	
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
	<h2>여행상품 보기</h2>
	
	<form action="sortList">
		<button value="price" name="price">가격 순</button>
		<button value="sales" name="sales">판매량 순</button>
		<button value="hits" name="hits">인기 순</button>
		<button value="dist" name ="dist" onclick="showPopup();">거리순</button>
		<input type="hidden" name = "country_name" value="<%=request.getParameter("country_name")%>">
		<input type="hidden" name = "city_name" value="<%=request.getParameter("city_name")%>">
	</form>
	
	
	<div id="popUp">
		<form action="sortDist">
		위치 : <input type="text" name = "current" value="current">
		<button value="distance" name="distance">확인</button>
		<input type="hidden" name = "country_name" value="<%=request.getParameter("country_name")%>">
		<input type="hidden" name = "city_name" value="<%=request.getParameter("city_name")%>">
		</form>
	</div>
	
	
	<div id="content">
         <div id="price" >
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
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
	</div>
</body>
</html>