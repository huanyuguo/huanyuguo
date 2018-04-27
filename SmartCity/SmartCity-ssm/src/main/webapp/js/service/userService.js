//todo: 服务层
app.service('userService',function($http){
	    	
	//TODO: 读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('/user/findAll.do');
	}
});
