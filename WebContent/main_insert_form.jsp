<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
   rel="stylesheet">
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet"
   href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
<script type="text/javascript">
   $(function() {
      //날짜 선택기능
      $(".datepicker").datepicker();
      //
      var availableTags = [];
      var uniqueAvailableTags = [];
      $.getJSON('country', function(data) {
         $.each(data, function(index, item) {
            availableTags.push(item.name);
         });
         $.each(availableTags, function(i, el) {
            if ($.inArray(el, uniqueAvailableTags) === -1)
               uniqueAvailableTags.push(el);
         });
      });
      var availableTags2 = [];
      var uniqueAvailableTags2 = [];
      
      $("#target").autocomplete({
         source : uniqueAvailableTags,
         select : function(e, ui) {
            $.getJSON('city?country_name='+$(this).val(), function(data) {
               $.each(data, function(index, item) {
                  availableTags2.push(item);
               });
               $('#target2').empty();
               $.each(availableTags2, function(i, el) {
                   if ($.inArray(el, uniqueAvailableTags2) === -1){
                     uniqueAvailableTags2.push(el); 
                   $('#target2').append("<option value =" + availableTags2[i] + ">" + availableTags2[i] + "</opeion>");
               }
               });
            });   
            
            
            
            $.getJSON('country_iso?country_name='+$(this).val(), function(data) {
               $.getJSON("https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.KRW"+data.iso,function(d){
                  $.each(d,function(index, i){
                     $('#target3').text(i.currencyName + " : " + i.currencyUnit + " || " + "한국 돈 : " +  i.openingPrice + "원");
                  });
               });
            });
            
            
            
         }
         
      });
/*       $("#target2").autocomplete({
         source : uniqueAvailableTags2
      });  */
      
      
      
      
      
      $("#today").text(new Date().toLocaleDateString());
      $.datepicker.setDefaults($.datepicker.regional['ko']);
      
      $('#start_time').datepicker({
         showOn: "both",
         dateFormat: "yy-mm-dd",
         changeMonth: true,
         onClose: function(selectDate) {
            var stxt = selectDate.split("-");
            stxt[1] = stxt[1] - 1;
            var sdate = new Date(stxt[0], stxt[1], stxt[2]);
            var mdate = new Date(stxt[0], stxt[1], stxt[2]);
            mdate.setDate(sdate.getDate()+4);
            $("#end_time").datepicker("option", "minDate", sdate);
            $("#end_time").datepicker("option", "maxDate", mdate);
         }
      });
      
      $('#end_time').datepicker({
         showOn: "both",
         dateFormat: "yy-mm-dd",
         changeMonth: true,
         onClose: function(selectDate) {
            var stxt = selectDate.split("-");
            stxt[1] = stxt[1] - 1;
            var sdate = new Date(stxt[0], stxt[1], stxt[2]);
            var mdate = new Date(stxt[0], stxt[1], stxt[2]);
            mdate.setDate(sdate.getDate()-4);
            $("#start_time").datepicker("option", "maxDate", sdate);
            $("#start_time").datepicker("option", "minDate", mdate); 
         }
      });

      
      
      $('#target2').change(function(){
            var city = $('#target2 option:selected').val();
            if(city == '')
                return false;
            $.ajax({
             url: 'city_Ename?city_name='+city ,
             dataType : "text",
             type : "get",
             success : function(data){
               var apiKey = "615c02abafdf24271fbe093a8aa7d138";
               var apiURI = "http://api.openweathermap.org/data/2.5/weather?q="+data+"&appid="+apiKey;
               $.ajax({
                  url: apiURI,
                  dataType: "json",
                  type: "GET",
                  async: "false",
                  success: function(resp) {
                  /*    console.log(resp);
                        console.log("현재온도 : "+ (resp.main.temp- 273.15) );
                        console.log("현재습도 : "+ resp.main.humidity);
                        console.log("날씨 : "+ resp.weather[0].main );
                        console.log("상세날씨설명 : "+ resp.weather[0].description );
                        console.log("날씨 이미지 : "+ resp.weather[0].icon );
                        console.log("바람   : "+ resp.wind.speed );
                        console.log("나라   : "+ resp.sys.country );
                        console.log("도시이름  : "+ resp.name );
                        console.log("구름  : "+ (resp.clouds.all) +"%" );     */
               
                     var imgURL = "http://openweathermap.org/img/w/" + resp.weather[0].icon + ".png";
                     $("#weatherIcon").show();
                     $("#weatherIcon").attr("src", imgURL);
               
                     $("#weather").html('도시이름 : ' + resp.name + '<br>' + '현재온도 : ' + Math.round(resp.main.temp- 273.15) + '°C' + '<br>' + '현재습도 : ' +
                           resp.main.humidity + '%' + '<br>' + '날씨 : ' + resp.weather[0].main);
                  }
               });  
             }
            });
            
            
             
         });
       
    
   
   });
   
</script>
</head>
<body>
   <form action="../Recommend/itemList" method="post">
      <div>
         <input id="target" type="text" name="country_name"> 
         <!-- <input id="target2" type="text" name="city"> -->
         <select id="target2" name="city_name">
                 <option value="">::선택::</option>
         </select>
         <br> 
         오늘날짜 : <span id="today"></span><br>
         <label for="sta   rt_time">출발</label>
         <input type="text"  name="start_time" id="start_time"  autocomplete=off>
         ~
         <label for="end_time">귀국</label>
         <input type="text"   name="end_time" id="end_time"  autocomplete=off> 
         <br>
         <a id="target3"></a>
         <p id="weather"></p>   
         <img src="" id="weatherIcon" style="display:none;"/>
      </div>
      <input type = "submit" value = "생성">
   </form>
</body>
</html>