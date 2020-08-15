/* new Vue({
	el:'#test',
	data:{
		message :'我是测试asd使用'
	}
});

 */

$(function() {
	doindex();
})

function doindex() {
	$.post("/index", {
		"userName": "小张",
		"userNickname": "张总"
	}, function(date) {
		alert(date);
	});
}
