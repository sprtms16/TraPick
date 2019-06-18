<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../style/css/feedList.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css">
</head>
<body>
	<div class="container-fluid"
		style="display: inline-block; text-align: center;">
		<c:forEach var="feed" items="${feedList}">
<<<<<<< HEAD
			<div class="col-md-6 mt-5 ">
				<div class="card text-center">
					<img class="card-img-top"
						src="https://picsum.photos/1900/1080?image=235"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${feed.title }</h5>
						<hr>
						<p>${feed.contents }</p>
						<p>
							<a class="btn btn-primary" data-toggle="collapse"
								href="#collapseExample" role="button" aria-expanded="false"
								aria-controls="collapseExample"> <i class="fas fa-map"></i>
								Maps
							</a> <a class="btn btn-primary" data-toggle="collapse"
								href="hearAction?feed_idx=${feed.feed_idx}" role="button"
								aria-expanded="false" aria-controls="collapseExample"> <i
								class="fas fa-map"></i> 하트
							</a> <a class="btn btn-primary" data-toggle="collapse"
								href="#collapseExample" role="button" aria-expanded="false"
								aria-controls="collapseExample"> <i class="fas fa-map"></i>
								Maps
							</a>

						</p>
						<div class="container" role="main">
							<h2>댓글입력</h2>
							<form action="insertActionReply" method="post">
								<div class="mb-3">
									<input type="hidden" name="feed_idx" value="${feed.feed_idx}" />
									<label for="content">내용</label>
									<textarea class="form-control" rows="5" name="contents"
										id="contents" placeholder="내용을 입력해 주세요"></textarea>
								</div>
								<div>
									<button type="submit" class="btn btn-sm btn-primary"
										id="btnSave">저장</button>
									<button type="button" class="btn btn-sm btn-primary"
										onClick="history.go(-1)">목록</button>
								</div>
							</form>
						</div>
						<div class="collapse" id="collapseExample">
							<div class="card card-body">
								<c:forEach var="reply" items="${feed.replys}">

									<div>${reply.contents}<button
											onclick="location.href = 'replyLikeAction?feed_idx=${reply.feed_idx}&reply_idx=${reply.reply_idx}'">좋아요</button>
										<button
											onclick="location.href = 'replyDislikeAction?feed_idx=${reply.feed_idx}&reply_idx=${reply.reply_idx}'">싫어요</button>
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
								<a href=""><i class="fas fa-map"></i></a>
							</div>
							<div class="col">
								<a href="mailto:test@test.com"><i class="fas fa-envelope"></i></a>
							</div>
							<div class="col">
								<a href="tel:+123456789"><i class="fas fa-phone"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>