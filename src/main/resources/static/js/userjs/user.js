$(function() {
	// doindex();
})
/* 页面加载事件 */
function doindex() {
	$.post("/index", {
		"userName": "小张",
		"userNickname": "张总"
	}, function(data) {
		if (data == null || (data.msg == "" || data.msg == null)) {

		} else {

		}
		console.log(data);

	});
}

function uplodefile(file) {

	$("#ImgData").attr("src", getObjectURL($("#" + file)[0].files[0]));
	var forData = new FormData();
	forData.append("file", $("#" + file)[0].files[0]);
	console.log(forData);
	/* $.post("/upload/Img", {
		"file": forData
	}, function(data) {

	}) */
	$.ajax({
		url: "/Img",
		type: 'post',
		data: forData,
		cache: false, // 不缓存数据
		processData: false, // 不处理数据
		contentType: false, // 不设置内容类型
		success: function(json) {
			if (json == "success") {
				alert("上传成功");
			} else {
				alert("上传失败");
			}
		},
		error: function() {

		}
	});


	/* const file = document.getElementById('pop_file');
	const fileObj = file.files[0];
	const windowURL = window.URL || window.webkitURL;
	const img = document.getElementById('preview');
	if (file && fileObj) {
		const dataURl = windowURL.createObjectURL(fileObj);
		img.setAttribute('src', dataURl);
	} */
}

function getObjectURL(file) {
	if (file == undefined) return "";
	if (window.createObjectURL !== undefined) return window.createObjectURL(file);
	if (window.URL.createObjectURL !== undefined) return window.URL.createObjectURL(file);
	if (window.webkitURL.createObjectURL !== undefined) return window.webkitURL.createObjectURL(file);
}
