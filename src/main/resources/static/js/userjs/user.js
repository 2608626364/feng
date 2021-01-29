$(function() {
	// doindex();
	$("#left").hide();
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
	alert(getObjectURL($("#" + file)[0].files[0]));
	var forData = new FormData();
	forData.append("file", $("#" + file)[0].files[0], "文件1");
	forData.append("file", $("#" + file)[0].files[0], "文件2");
	forData.append("file", $("#" + file)[0].files[0], "文件3");
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


var Arraylist = new Array();
var jsonlist = [];

function onSaveimg() {


	console.log(JSON.stringify(jsonlist));
	/* $.post("/SaveImg", {

		map: JSON.stringify(jsonlist)

	}, function(data) {
		console.log(data);
	}); */
	$.ajax({
		url: '/SaveImg',
		type: 'POST',
		data: {
			list: JSON.stringify(jsonlist)
		},
		dataType: 'json',
		contentType: 'application/json;charset=utf-8',
		success: function(data) {
			console.log(data);
		},
		error: function(data) {
			console.log(data);
		}
	});
}

/* 转化图片并保存 */
function base64img(name) {

	var Base64img = "";
	if (typeof(FileReader) === 'undefined') {
		alert("抱歉，你的浏览器不支持 FileReader，不能将图片转换为Base64，请使用现代浏览器操作！");
	} else {
		try {
			/*图片转Base64 核心代码*/
			var file = $("#" + name)[0].files[0];
			//这里我们判断下类型如果不是图片就返回 去掉就可以上传任意文件 
			if (!/image\/\w+/.test(file.type)) {
				alert("请确保文件为图像类型");
				return false;
			}
			var reader = new FileReader();
			reader.onload = function() {
				Base64img = this.result;
				petlistbykey(name, Base64img);
			}
			reader.readAsDataURL(file);
		} catch (e) {
			alert('图片转Base64出错啦！' + e.toString())
		}
	}
}
/* 获取元素 */
function getlistbykey(key, type) {
	var listIndex = -1;
	var img = "";
	$.each(jsonlist, function(index, value) {
		if (key == value.key) {
			listIndex = index;
			img = value.value;
		}
	});
	if (type == "0") {
		return img
	} else {
		return listIndex;
	}

}
/* 保存元素 */
function petlistbykey(key, value) {
	var listindex = getlistbykey(key, "2");
	if (listindex == -1) {
		jsonlist.push("{key:" + key + ",value:" + value + "}")
	} else {
		jsonlist[listindex] = "{key:" + key + ",value:" + value + "}";
	}
}
