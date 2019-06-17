<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<article>
		<div class="container" role="main">
			<h2>게시물 업로드</h2>
			<form action="updateAction" method="post">
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