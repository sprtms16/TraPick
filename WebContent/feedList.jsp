<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<title>Insert title here</title>
<!-- 
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../style/css/feedList.css" />
<script type="text/javascript">
	function getQuerystring(paramName) {
		var _tempUrl = window.location.search.substring(1);
		var _tempArray = _tempUrl.split('&');
		if (_tempArray.length > 1) {
			for (var i = 0; _tempArray.length; i++) {
				var _keyValuePair = _tempArray[i].split('=');

				if (_keyValuePair[0] == paramName) {

					return _keyValuePair[1];
				}
			}
		}

	};

	$(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 500) {
				$('#MOVE_TOP_BTN').fadeIn();
			} else {
				$('#MOVE_TOP_BTN').fadeOut();
			}
		});

		$("#MOVE_TOP_BTN").click(function() {
			$('html, body').animate({
				scrollTop : 0
			}, 400);
			return false;
		});
	});

	function scrollMove(seq) {

		//id가 p로 시작하는 객체를 찾아서, 그곳까지 이동

		$('html, body').animate({
			scrollTop : $("#target" + seq).offset().top
		}, 1000);

	}
	$(function() {
		$('.fa-heart').click(function() {
			var href = $(this).parents('a').attr("href");
			$.ajax({
				url : href,
				dataType : "json",
				success : function(data) {
					$('.fa-heart').text(data.heartCount);
					$('.fa-heart').toggleClass("far");
					$('.fa-heart').toggleClass("fas");
				}
			});
			return false;
		});
		$('.fa-thumbs-up').click(function() {
			var href = $(this).parents('a').attr("href");
			var up = $(this);
			$.ajax({
				url : href,
				dataType : "json",
				success : function(data) {
					up.text(data.heartCount);
					up.toggleClass("far");
					up.toggleClass("fas");
				}
			});
			return false;
		});
		$('.fa-thumbs-down').click(function() {
			var href = $(this).parents('a').attr("href");
			var down = $(this);
			$.ajax({
				url : href,
				dataType : "json",
				success : function(data) {
					down.text(data.heartCount);
					down.toggleClass("far");
					down.toggleClass("fas");
				}
			});
			return false;
		});

		/* var content = document.getElementById('hashTags').innerHTML;
		var splitedArray = content.split(' ');
		var linkedContent = '';
		for(var word in splitedArray)
		{
		  word = splitedArray[word];
		   if(word.indexOf('#') == 0)
		   {
		      word = '<a href=\'링크\'>'+word+'</a>';
		   }
		   linkedContent += word+' ';
		}
		 */
		$.each($('.hashtag'), function(index, data) {
			var content = $(data).text();
			var splitedArray = content.split(' ');
			var linkedContent = '';
			for ( var word in splitedArray) {
				word = splitedArray[word];
				if (word.indexOf('#') == 0) {
					var keyword = word.substring(1, word.length);
					word = '<a href=\'list?keyword=' + keyword + '\'>' + word
							+ '</a>';
				}
				linkedContent += word + ' ';
			}
			$(data).html(linkedContent);
		});
	});

	jQuery.event.add(window, "load", function() { //이미지가 모두 실행된 후 함수 실행
		var seq = getQuerystring("feed_idx");
		if (seq != null) {
			scrollMove();
		}
	});
</script>


</head>
<body>

	<div class="container">
		<a id="MOVE_TOP_BTN" href="#">TOP</a>


		<div class="search_menu">
			<form action="list" method="get">
				<aside style="float: right;">
					<input type="text" name="word" placeholder="검색어를 입력하시오">
					<button type="submit">검색</button>

				</aside>
			</form>
		</div>

		<div class="dropdown">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-toggle="dropdown">정렬</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="list">최신 순</a> <a
					class="dropdown-item" href="list?odb=pop&sc=up">인기 순↑</a> <a
					class="dropdown-item" href="list?odb=pop&sc=down">인기 순↓</a> <a
					class="dropdown-item" href="list?odb=rep&sc=up">댓글 순↑</a> <a
					class="dropdown-item" href="list?odb=rep&sc=down">댓글 순↓</a>
				<div class="dropdown-divider"></div>

			</div>
		</div>
	</div>





	<div class="container-fluid">
		<!-- 
		style="margin-left: 360px; inline-block; text-align: center;" -->
		<c:forEach var="feed" items="${feedList}">
			<div id="target${feed.feed_idx }" class="mt-5">
				<div class="card text-center">
					<!-- <img class="card-img-top"
						src="https://picsum.photos/1900/1080?image=235"
						alt="Card image cap"> -->

					<div id="carouselExampleControls${feed.feed_idx }"
						class="carousel slide" data-ride="carousel">
						<div class="carousel-inner">
							<c:forEach var="img" items="${feed.url }" varStatus="status">
								<c:choose>
									<c:when test="${status.first }">
										<div class="carousel-item active"
											style="width: 100%; height: 500px; overflow: hidden">
											<img src="../upload/${img }" class="d-block w-100"
												style="width: auto; height: 500px;">
										</div>
									</c:when>
									<c:otherwise>
										<div class="carousel-item"
											style="width: 100%; height: 500px; overflow: hidden">
											<img src="../upload/${img }" class="d-block w-100"
												style="width: auto; height: 500px;">
										</div>
									</c:otherwise>
								</c:choose>

							</c:forEach>
							<a class="carousel-control-prev"
								href="#carouselExampleControls${feed.feed_idx }" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="sr-only">Previous</span>
							</a> <a class="carousel-control-next"
								href="#carouselExampleControls${feed.feed_idx }" role="button"
								data-slide="next"> <span class="carousel-control-next-icon"
								aria-hidden="true"></span> <span class="sr-only">Next</span>
							</a>
						</div>
					</div>
					<div class="card-body">

						<h5 class="card-title">${feed.title }</h5>
						<hr>

						<div class="hashtag">${feed.contents }</div>



						<div class="container" role="main">
							<form action="insertActionReply" method="post">
								<div class="mb-3">

									<input type="hidden" name="feed_idx" value="${feed.feed_idx}" />
									<textarea class="form-control" rows="1" name="contents"
										id="contents" placeholder="내용을 입력해 주세요"></textarea>
								</div>
								<div>
									<button type="submit" class="btn btn-sm btn-primary"
										id="btnSave">작성</button>
									<a class="btn btn-sm btn-primary" data-toggle="collapse"
										href="#collapseExample" role="button" aria-expanded="false"
										aria-controls="collapseExample"> <i class="fas fa-map"></i>
										모두보기
									</a>
								</div>
							</form>
						</div>
						<p></p>
						<div class="collapse" id="collapseExample">
							<div class="card card-body">

								<c:forEach var="reply" items="${feed.replys}">

									<div>${reply.contents}
										<a
											href="replyLikeAction?feed_idx=${reply.feed_idx}&reply_idx=${reply.reply_idx}">
											<c:choose>
												<c:when test="${reply.isLike eq 1}">
													<i class="fas fa-thumbs-up">${reply.like }</i>
												</c:when>
												<c:otherwise>
													<i class="far fa-thumbs-up">${reply.like }</i>
												</c:otherwise>
											</c:choose>
										</a> <a
											href="replyDislikeAction?feed_idx=${reply.feed_idx}&reply_idx=${reply.reply_idx}">
											<c:choose>
												<c:when test="${reply.isDislike eq 1}">
													<i class="fas fa-thumbs-down">${reply.dislike }</i>
												</c:when>
												<c:otherwise>
													<i class="far fa-thumbs-down">${reply.dislike }</i>
												</c:otherwise>
											</c:choose>
										</a>
									</div>
								</c:forEach>
								<!-- 	<iframe
									src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d11880.492291371422!2d12.4922309!3d41.8902102!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x28f1c82e908503c4!2sColosseo!5e0!3m2!1sit!2sit!4v1524815927977"
									width="100%" height="200" frameborder="0" style="border: 0"
									allowfullscreen></iframe> -->

							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<div class="row">
							<div class="col">
								<a href="updateForm?feed_idx=${feed.feed_idx }"><i
									class="fas fa-edit"></i></a>
							</div>
							<div class="col">
								<a href="deleteFeedAction?feed_idx=${feed.feed_idx }"><i
									class="fas fa-trash-alt"></i></a>
							</div>
							<div class="col">
								<a id="heart" href="hearAction?feed_idx=${feed.feed_idx}"> <c:choose>
										<c:when test="${feed.islike eq 1}">
											<i class="fas fa-heart">${feed.heart }</i>
										</c:when>
										<c:otherwise>
											<i class="far fa-heart">${feed.heart }</i>
										</c:otherwise>
									</c:choose>

								</a>
							</div>
						</div>
					</div>


				</div>
			</div>
		</c:forEach>
	</div>



</body>
</html>