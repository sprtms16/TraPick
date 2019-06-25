<%@page import="java.util.ArrayList"%>
<%@page import="trapick.recommend.domain.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script type="text/javascript"
   src="https://code.jquery.com/jquery-3.1.1.min.js"></script> -->
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
//호텔 , 음식점 스크립트
$(function() {
   
   $('#restList').hide();
   $('#hotelList').hide();
});
   
$(function() {
   
   $('#tab-2').click(function() {
      $('#restList').show();
      $('#hotelList').hide();
      $('#itemList').hide();
   });
});

$(function() {
   
   $('#tab-3').click(function() {
      $('#hotelList').show();
      $('#itemList').hide();
      $('#restList').hide();
   });
});

$(function() {
   
   $('#tab-1').click(function() {
      $('#itemList').show();
      $('#hotelList').hide();
      $('#restList').hide();
   });
});

//호텔 음식점 스크립트 끝


   $(function(){
      
      function pop($selector){
         var url= "";    //팝업창 페이지 URL
          var winWidth = 700;
           var winHeight = 600;
           var popupOption= "width="+winWidth+", height="+winHeight;    //팝업창 옵션(optoin)
           var detail = $selector.parent().find('#detail').text();
           var name = $selector.parent().find('#name').text();
           var price = $selector.parent().find('#price').text();
           var img = $selector.parent().find('img').attr('src');
           var str = '<img src = "'+img+'"><br>이름 : '+name+'<br>상세설명 : '+detail+'<br>가격 : '+price;
          window.open(url,"",popupOption).document.write(str);
      }
      
      function event(){
         $(".delete_schedule").click(function(){
                 $(this).parent().empty();
              })
              $('.detailbt').click(function(){
                 pop($(this));
            })
      }
      
      
      var html = "";

      
       $('.drag').draggable({
             helper: 'clone',
             opacity: 0.5,
             revert: true,
             start : function(e,ui){
                event();
              html += '<button type="button" class="delete_schedule btn btn-default liveButton">x</button>';
              html += '<input type ="button" class = "detailbt liveInput" value ="상세보기">';
                html += $(this).html();
             },
             stop : function(e,ui){
                event();
             }
           }); 
        
        $('table td').droppable({
             accept: "div",
             drop: function(event, ui) {
                $(this).empty();
            $(this).append(html);
            html = "";
             }
         });
      
      //일정 저장
      $('#save').on("click", function(){
         var htmlSource = $('#mySheduleTable').html();
         $.post('saveAjax',{html : htmlSource});
         location.href = '/TrePick/index.jsp';
         return false;
      })
      
      //도시선택시 ajax 구동
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
                  var text = '<div class="row drag"><div class="col-4"><img class="img" src='
                  +item.image+'></div><div class="col-8 list_detail"><div id="name" class="row">'
                  +item.name+'</div><div  style = "display : none"  id ="detail" class="row">'
                  +item.detail+'</div></div></div>';
                  $('#landMarkList').append(text);
               })
               
               $('.drag').draggable({
                      helper: 'clone',
                      opacity: 0.5,
                      revert: true,
                      start : function(e,ui){
                         event();
                         html += '<button type="button" class="delete_schedule btn btn-default liveButton">x</button>';
                         html += '<input type ="button" class = "detailbt liveInput" value ="상세보기">';
                         html += $(this).html();
                      },
                      stop : function(e,ui){
                         event();
                      }
                    }); 
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
                  var text = '<div class="row drag"><div class="col-4"><img class="img" src='
                     +item.img+'></div><div class="col-8 list_detail"><div id="name"  class="row">'
                     +item.name+'</div><div  style = "display : none"  id ="detail" class="row">'
                     +item.detail+'</div><div  id="price" class="row">'
                     +item.price+'</div></div></div>';
                  $('#itemList').append(text);
               })
               
               $('.drag').draggable({
                      helper: 'clone',
                      opacity: 0.5,
                      revert: true,
                      start : function(e,ui){
                         event();
                         html += '<button type="button" class="delete_schedule btn btn-default liveButton">x</button>';
                         html += '<input type ="button" class = "detailbt liveInput" value ="상세보기">';
                         html += $(this).html();
                      },
                      stop : function(e,ui){
                         event();
                      }
                    }); 
            }
         })
         //식당 ajax
          $.ajax({
              url : 'restAjax',
              type : 'post',
              dataType : 'json',
              data :{city_name : $('#city option:selected').val()} ,
              success : function(data){
                 
                 $('#restList').empty();
                   $.each(data, function(index, item){
                      var text = '<div class="row drag"><div class="col-4"><img class="img" src='
                     +item.img+'></div><div class="col-8 list_detail"><div id="name"  class="row">'
                     +item.name+'</div><div  style = "display : none"  id ="detail" class="row">'
                     +item.detail+'</div></div></div>';
                      $('#restList').append(text);
                   }) 
                   $('.drag').draggable({
                      helper: 'clone',
                      opacity: 0.5,
                      revert: true,
                      start : function(e,ui){
                         event();
                         html += '<button type="button" class="delete_schedule btn btn-default liveButton">x</button>';
                         html += '<input type ="button" class = "detailbt liveInput" value ="상세보기">';
                         html += $(this).html();
                      },
                      stop : function(e,ui){
                         event();
                      }
                    }); 
              }
        })
        //숙박 ajax
       $.ajax({
          url : 'hotelAjax',
          type : 'post',
          dataType : 'json',
          data :{city_name : $('#city option:selected').val()} ,
          success : function(data){
              
              $('#hotelList').empty();
                $.each(data, function(index, item){
                   var text = '<div class="row drag"><div class="col-4"><img class="img" src='
                  +item.img+'></div><div class="col-8 list_detail"><div  id="name" class="row">'
                  +item.name+'</div><div  style = "display : none"  id ="detail" class="row">'
                  +item.detail+'</div><div id="price"  class="row">'
                  +item.price+'</div></div></div>';
                   $('#hotelList').append(text);
                   console.log(text);
                }) 
                $('.drag').draggable({
                   helper: 'clone',
                   opacity: 0.5,
                   revert: true,
                   start : function(e,ui){
                      event();
                      html += '<button type="button" class="delete_schedule btn btn-default liveButton">x</button>';
                      html += '<input type ="button" class = "detailbt liveInput" value ="상세보기">';
                      html += $(this).html();
                   },
                   stop : function(e,ui){
                      event();
                   }
                 }); 
           }
        })
         /* return false; */
      })
   })

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
               <div id = "mySheduleTable">
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
                        <td>이름 </td>
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
                </div>
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
            <button id = "save">일정 저장</button>
         </div>


         <div class="col-3">
            <div id ="landMarkList">
               <c:forEach var="landMarkList" items="${landMarkList }">
               <div class="row drag" >
                  <div class="list_thumb" >
                     <img class="img" src=${landMarkList.image }>
                  </div>
                  <div class="list_detail">
                     <div id = "name" class="row">${landMarkList.name }</div>
                     <div  style = "display : none"  id ="detail" class="row">${landMarkList.detail }</div>
           		 </div>
               </div>
               </c:forEach>
               
            </div>
         </div>
         <!-- 음식점 숙박 -->
               <!-- 음식점 숙박 -->
         <div class="col-3">

            <div id="tabs">
               <ul>
                  <li><a href="#tabs-1" id="tab-1">여행 상품</a></li>
                  <li><a href="#tabs-2" id="tab-2">카페 음식점</a></li>
                  <li><a href="#tabs-3" id="tab-3">숙박</a></li>
               </ul>
               <div id="tabs-1">
                  <div id="itemList">
                     <c:forEach var="list" items="${list }">
                        <div class="row drag" id="list_thum">
                           <div>
                              <div class="list_thumb">
                                 <img class="img" src=${list.img }>
                              </div>
                           </div>
                           <div class="list_detail">
                              <div id="name" class="listName">${list.name }</div>
                              <div style="display: none" id="detail" class="listDetail">${list.detail }</div>
                              <div id="price" class="listPrice">${list.price }</div>
                           </div>
                        </div>
                     </c:forEach>
                  </div>
               </div>
               <div id="tabs-2">
                  <div id="restList">
                     <c:forEach var="list" items="${list_Rest }">
                        <div class="row drag" id="list_thum">
                           <div>
                              <div class="list_thumb">
                                 <img class="img" src=${list.img }>
                              </div>
                           </div>
                           <div class="list_detail">
                              <div id="name" class="listName">${list.name }</div>
                              <div style="display: none" id="detail" class="listDetail">${list.detail }</div>
                           </div>
                        </div>
                     </c:forEach>
                  </div>
               </div>
               <div id="tabs-3">
                  <div id="hotelList">
                     <c:forEach var="list" items="${list_Hotel }">
                        <div class="row drag" id="list_thum">
                           <div>
                              <div class="list_thumb">
                                 <img class="img" src=${list.img }>
                              </div>
                           </div>
                           <div class="list_detail">
                              <div id="name" class="listName">${list.name }</div>
                              <div style="display: none" id="detail" class="listDetail">${list.detail }</div>
                           </div>
                        </div>
                     </c:forEach>
                  </div>
               </div>
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