$(function() {
		$("#file").on("change", imgReader);
});
function submitForm() {
	var fd = new FormData(document.getElementById("form1"));

	$.ajax({
		url : "./api/imgupload.do",
		type : "POST",
		data : fd,
		processData : false,
		contentType : false
	}).done(function(data) {
		//console.log(data);
		if(data.status=="1"){
			$("#resultMsg").html("예측결과 : "+data.resultMsg);
		}else{
			alert("예측 실패");
		}
	});
	return false;
}
function imgReader(e) {
	$("#resultMsg").html("");
	var files = e.target.files;
	var fileArr = Array.prototype.slice.call(files);
	
	fileArr.forEach(function (f) {			
		var reader = new FileReader();
		reader.onload = function (e) {
			$("#img_preview").attr("src", e.target.result);				
		}
		reader.readAsDataURL(f);
	});
}