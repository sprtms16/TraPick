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
					$.each(availableTags2, function(i, el) {
						if ($.inArray(el, uniqueAvailableTags2) === -1)
							uniqueAvailableTags2.push(el);
					});
				});
			}
			
		});
		$("#target2").autocomplete({
			source : uniqueAvailableTags2
		});

		
		
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
				mdate.setDate(sdate.getDate()+5);
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
				mdate.setDate(sdate.getDate()-5);
				$("#start_time").datepicker("option", "maxDate", sdate);
				$("#start_time").datepicker("option", "minDate", mdate); 
			}
		});
		
	});
</script>
</head>
<body>
	<form action="#" method="post">
		<div>
			<input id="target" type="text" name="country"> 
			<input id="target2" type="text" name="city">
			<br> 
			오늘날짜 : <span id="today"></span><br>
			<label for="sta	rt_time">출발</label>
			<input type="text"	name="start_time" id="start_time"  autocomplete=off>
			~
			<label for="end_time">귀국</label>
			<input type="text"	name="end_time" id="end_time"  autocomplete=off> 
		</div>
	</form>
</body>
</html>