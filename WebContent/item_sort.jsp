<%@page import="java.util.ArrayList"%>
<%@page import="trapick.recommend.domain.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>TraPick</title>
<link rel="stylesheet" type="text/css" href="../style/css/scheduler.css" />
<link rel="stylesheet"
   href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
   integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
   crossorigin="anonymous">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
   
/*    window.onload = function() {
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

<script type="text/javascript">
   $(function(){
      
      $('#city_search').on("click",function(){
         //랜드마크 ajax
         $.ajax({
            url : 'landMarkAjax',
            type: 'post',
            dataType:'json',
            data :{city_name : $('#city option:selected').val()} ,
            success : function(data){
               
               $('#landMarkList').empty();
               $.each(data, function(index, item){
                  var text = '<img src = "'+item.image+'"> <span>'+item.name+'</span>';
                  $('#landMarkList').append(text);
               })
            }
         })
         //아이템 ajax
         $.ajax({
            url : 'itemAjax',
            type: 'post',
            dataType:'json',
            data :{city_name : $('#city option:selected').val()} ,
            success : function(data){
               
               $('#itemList').empty();
               $.each(data, function(index, item){
                  var text = '<img src = "'+item.img+'"> <span>'+item.name+'</span>';
                  $('#itemList').append(text);
               })	
            }
         })
         /* return false; */
      })
      
/*      $(document).ready(function(){
    	 var modalLayer = $("#modalLayer");
    	 var modalLink = $(".modalLink");
    	 var modalCont = $(".modalContent");
    	 var marginlLeft = modalCont.outerWidth()/2;
    	 var marginTop = modalCont.outerHeight()/2;
    	 
    	 modalLink.click(function(){
    		 modalLayer.fadeIn("slow");
    		 modalCont.css({"margin-top" : -marginTop,
    			 "margin-left" : -marginlLeft
    		 });
    		 $(this).blur();
    		 $(".modalContent > a").focus();
    		 return false;
    	 });
    	 
    	 $(".modalContent > button").click(function(){
    		 modalLayer.fadeOut("slow");
    		 modalLink.focus();
    	 })
     }) */
     $("#popbutton").click(function(){
        $('div.modal').modal({
                      remote : 'layer.html'
                });
    }) 
	
    $("#delete_schedule").click(function(){
    	$(this).parent().empty();
    })
   });

</script>


<title>여행상품</title>
</head>
<body>


   <div class="container">
      <div class="row">
         <div class="col-6">
            <!-- Temp_Scheduler -->
            <form action="????????" id="scheduleTable">
               <p>여행 일정표</p>
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
                     <td><img src="">뉴욕 우드버리 왕복버스 티켓</td>
                     <td>
                  </td>
                     <td>빈칸</td>
                     <td>
                     	<button type="button" id="delete_schedule" class="btn btn-default">x</button>
						<a href="#modalLayer" class="btn btn-default" data-target="#layerpop" data-toggle="modal">
                        	<img src="https://shopping-phinf.pstatic.net/main_8210211/82102117713.jpg?type=f133">
                        </a><br/>
							<div class="modal fade" id="layerpop" >
							  <div class="modal-dialog">
							    <div class="modal-content">	
							    
							      <!-- header title -->
							      <div class="modal-header">
							        <h4 class="modal-title">상세정보</h4>
							        <button type="button" class="close" data-dismiss="modal">×</button>
							      </div>
							      
							      <!-- body -->
							      <div class="modal-body">
							            <div>여행지 설명 : 뉴욕 우드버리 왕복버스 티켓</div>
										<div>부가설명 : 네이버 아이디 하나로 간편구매</div>
										<div>가격 : 39600</div>
							      </div>
							      
							      <!-- Footer -->
							      <div class="modal-footer">
										<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
							      </div>
							    </div>
							  </div>
							</div>

					</td>
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
            <form action="searchCity" id="searchCity">
               도시 검색 : <input type = "text" name = "search_City">
               <input type = "submit" value="검색">
            </form>
         <select id = "city" name = "city_name">
            <c:forEach var="cityList" items="${cityList }">
               <option value = "${cityList }">${cityList }</option>
            </c:forEach>
         </select>
         <button id = "city_search">검색</button>
            <form action="sortList" id="sortButton">
               <button value="price" name="price">가격 순</button>
               <button value="sales" name="sales">판매량 순</button>
               <button value="hits" name="hits">인기 순</button>
               <button value="dist" name="dist" onclick="showPopup();">거리순</button>
               <input type="hidden" name="country_name" value="<%=request.getParameter("country_name")%>">
               <input type="hidden" name="city_name" value="<%=request.getParameter("city_name")%>">
            </form>
            <div id="popUp">
               <form action="sortDist">
                  위치 : <input type="text" name="current" value="">
                  <button value="distance" name="distance">확인</button>
                  <input type="hidden" name="country_name"
                     value="<%=request.getParameter("country_name")%>"> <input
                     type="hidden" name="city_name"
                     value="<%=request.getParameter("city_name")%>">
               </form>
            </div>
         </div>


         <div class="col-3">
            <h3>관광 명소</h3>
            <div id ="landMarkList">
               <c:forEach var="landMarkList" items="${landMarkList }">
                  <div class="row">
                  <div class="col-4">
                     <img src=${landMarkList.image }>
                  </div>
                  <div class="col-8">
                     <div class="row">${landMarkList.name }</div>
                     <%-- <div class="row">${landMarkList.detail }</div> --%>
                     <%-- <div class="row">${landMarkList.price }</div> --%>
                  </div>
               </div>
               </c:forEach>
            </div>
         </div>

         <div class="col-3">
            <h3>여행 상품</h3>
            <div id="itemList">
               <c:forEach var="list" items="${list }">
                  <div class="row">
                     <div class="col-4">
                        <img src=${list.img }>
                     </div>
                     <div class="col-8">
                        <div class="row">${list.name }</div>
                        <div class="row">${list.detail }</div>
                        <div class="row">${list.price }</div>
                     </div>
                  </div>
               </c:forEach>
            </div>
         </div>


      </div>
   </div>

   <div class="row">
      <div id="map-canvas" style="width: 60%; height: 340px" title="지도"
         id="Map"></div>
   </div>
</body>
</html>