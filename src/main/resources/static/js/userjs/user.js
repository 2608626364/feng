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
