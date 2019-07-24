<%@ page language="java" contentType="text/html; charset=EUC-KR"
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
</style>
<script type="text/javascript">
	function submitForm() {
		var fd = new FormData(document.getElementById("fileinfo"));

		$.ajax({
			url : "./api/imgupload.do",
			type : "POST",
			data : fd,
			processData : false,
			contentType : false
		}).done(function(data) {
			console.log(data);
			if(data.status=="1"){
				$("#resultMsg").html("예측결과 : "+data.resultMsg);
			}else{
				alert("예측 실패");
			}
		});
		return false;
	}
</script>

</head>
<body>
	<h3>이미지 deep Learning</h3>
	<form method="post" id="fileinfo" name="fileinfo"
		enctype="multipart/form-data" onsubmit="return submitForm();">		
		<div class="form-group">
			<label for="img_upload">이미지 선택</label> 
			<input type="file" class="form-control-file" id="file" name="file" required>
		</div>
		<br>
		<button type="submit">이미지 예측하기</button><br><br>
		<span id="resultMsg"></span>
	</form>
</body>
</html>