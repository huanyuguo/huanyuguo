//TODO: 控制层
app.controller('videoController', function($scope, $controller, videoService) {

	//TODO: 推流到rtmp服务器
	$scope.pullVideo = function() {
		videoService.pullVideo().success(function(response) {
			alert("come in ......")
		});
	}
	$scope.saveVideo = function() {
		videoService.saveVideo().success(function(response) {
			alert("开始保存。。。。。。")
		})
	}

});
