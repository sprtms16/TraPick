<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$('#myCarousel').carousel('cycle');
		$('#myCarousel2').carousel('cycle');
	});
</script>
<body>
	<div class="container">
		<h2>캐러젤</h2>
		<div id="myCarousel" class="carousel slide" data-ride="carousel"
			data-interval="1000">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1" class=""></li>
				<li data-target="#myCarousel" data-slide-to="2" class=""></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="https://picsum.photos/200/300?random=1">
				</div>
				<div class="item">
					<img src="https://picsum.photos/200/300?random=2">
				</div>
				<div class="item">
					<img src="https://picsum.photos/200/300?random=3">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<hr>
		<div id="myCarousel2" class="carousel slide vertical">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel2" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel2" data-slide-to="1" class=""></li>
				<li data-target="#myCarousel2" data-slide-to="2" class=""></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="https://picsum.photos/200/300?random=1">
					<div class="carousel-caption">
						<h3>First slide label</h3>
						<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
					</div>
				</div>
				<div class="item">
					<img src="https://picsum.photos/200/300?random=2">
					<div class="carousel-caption">
						<h3>Second slide label</h3>
						<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
					</div>
				</div>
				<div class="item">
					<img src="https://picsum.photos/200/300?random=3">
					<div class="carousel-caption">
						<h3>Third slide label</h3>
						<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel2" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel2" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>




	<div id="myCarousel" class="carousel slide" data-ride="carousel">

		<!--페이지-->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!--페이지-->

		<div class="carousel-inner">
			<!--슬라이드1-->
			<div class="item active">
				<img src="http://www.blueb.co.kr/SRC2/_image/w01.jpg"
					style="width: 100%" alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Slide 1</h1>
						<p>텍스트 1</p>
					</div>
				</div>
			</div>
			<!--슬라이드1-->

			<!--슬라이드2-->
			<div class="item">
				<img src="http://www.blueb.co.kr/SRC2/_image/w02.jpg"
					style="width: 100%" data-src="" alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Slide 2</h1>
						<p>텍스트 2</p>
					</div>
				</div>
			</div>
			<!--슬라이드2-->

			<!--슬라이드3-->
			<div class="item">
				<img src="http://www.blueb.co.kr/SRC2/_image/w03.jpg"
					style="width: 100%" data-src="" alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Slide 3</h1>
						<p>텍스트 3</p>
					</div>
				</div>
			</div>
			<!--슬라이드3-->
		</div>

		<!--이전, 다음 버튼-->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span
			class="glyphicon glyphicon-chevron-left"></span></a> <a
			class="right carousel-control" href="#myCarousel" data-slide="next"><span
			class="glyphicon glyphicon-chevron-right"></span></a>
	</div>
</body>
</html>