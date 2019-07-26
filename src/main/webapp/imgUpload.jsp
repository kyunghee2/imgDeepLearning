<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>이미지 업로드</title>
<style type="text/css">
.result {
	font-size: 20px;
	font-weight: bold;
    color: blue;
}
#img_preview{
	width: 80px;
}
</style>
<script type="text/javascript" src="./js/imgUpload.js"></script>
</head>
<body>
	<h3>이미지 deep Learning</h3>
	<form method="post" id="form1" name="form1"
		enctype="multipart/form-data" onsubmit="return submitForm();">		
		<div class="form-group">
			<label for="img_upload">이미지 선택</label> 
			<input type="file" class="form-control-file" id="file" name="file" accept="image/*" required>
			<div class="img">
				<img id="img_preview" >
			</div>			
		</div>
		<br>
		<button type="submit">이미지 예측하기</button><br><br>
		<span id="resultMsg"></span>
	</form>
</body>
</html>