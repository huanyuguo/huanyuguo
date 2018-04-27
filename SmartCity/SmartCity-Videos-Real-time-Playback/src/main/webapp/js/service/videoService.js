//todo: 服务层
app.service('videoService',function($http){
	    	
	//TODO: 推流 将本地流推到rtmp服务器；
	this.pullVideo=function(){
		return $http.get('/native/pullVideo.do');
	}
	this.savaVideo=function(){
		return $http.get('/native/saveVideo.do');
	}
});
