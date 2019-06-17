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
<script type="text/javascript">
	$(function() {
		$(".datepicker").datepicker();
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

		$("#target").autocomplete({
			source : uniqueAvailableTags
		});
		
		
		$(".datepicker").datepicker();
		var availableTags2 = [];
		var uniqueAvailableTags2 = [];
		$.getJSON('country', function(data) {
			$.each(data, function(index, item) {
				availableTags2.push(item.name);
			});
			$.each(availableTags2, function(i, el) {
				if ($.inArray(el, uniqueAvailableTags2) === -1)
					uniqueAvailableTags2.push(el);
			});
		});

		$("#target2").autocomplete({
			source : uniqueAvailableTags2
		});
	});
</script>
</head>
<body>
	<form>
		<div>
			<input id="target" type="text" name="country"> 
			<input id="target2" type="text" name="city"> 
			<input type="date" name="start_time" value="출발일"> 
			<input type="date" name="end_time" value="도착일"> 
			<input type="submit" value="확인">
		</div>
	</form>
</body>
</html>