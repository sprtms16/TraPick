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
			<h2>�Խù� ���ε�</h2>
			<form action="updateAction" method="post">
				<div class="mb-3">
					<label for="title">����</label> <input type="text"
						class="form-control" name="title" id="title"
						placeholder="������ �Է��� �ּ���">
				</div>
				<div class="mb-3">
					<label for="reg_id">�ۼ���</label> <input type="text"
						class="form-control" name="writer" id="writer"
						placeholder="�̸��� �Է��� �ּ���">
				</div>
				<div class="mb-3">
					<label for="file_id">����</label> <input type="file"
						class="form-control" name="fname" id="fname">
				</div>
				<div class="mb-3">
					<label for="content">����</label>
					<textarea class="form-control" rows="5" name="contents"
						id="contents" placeholder="������ �Է��� �ּ���"></textarea>
				</div>
				<div>
					<button type="submit" class="btn btn-sm btn-primary" id="btnSave">����</button>
					<button type="button" class="btn btn-sm btn-primary"
						onClick="history.go(-1)">���</button>
				</div>
			</form>
		</div>
	</article>
</body>
</html>