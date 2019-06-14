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
</head>
<body>
	<article>
		<div class="container" role="main">
			<h2>글쓰기</h2>
			<form action="insertAction.do" method="post">
				<div class="mb-3">
					<label for="title">제목</label> <input type="text"
						class="form-control" name="title" id="title"
						placeholder="제목을 입력해 주세요">
				</div>
				<div class="mb-3">
					<label for="reg_id">작성자</label> <input type="text"
						class="form-control" name="writer" id="writer"
						placeholder="이름을 입력해 주세요">
				</div>
				<div class="mb-3">
					<label for="file_id">파일</label> <input type="file"
						class="form-control" name="fname" id="fname">
				</div>
				<div class="mb-3">
					<label for="content">내용</label>
					<textarea class="form-control" rows="5" name="contents"
						id="contents" placeholder="내용을 입력해 주세요"></textarea>
				</div>
				<div>
					<button type="submit" class="btn btn-sm btn-primary" id="btnSave">저장</button>
					<button type="button" class="btn btn-sm btn-primary"
						onClick="history.go(-1)">목록</button>
				</div>
			</form>
		</div>
	</article>
</body>
</html>