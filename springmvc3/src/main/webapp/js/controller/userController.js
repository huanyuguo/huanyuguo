 //TODO: 控制层
app.controller('userController' ,function($scope,$controller,userService){
	
	$controller('baseController',{$scope:$scope});//继承

    //TODO: 读取列表数据绑定到表单中
	$scope.findAll=function(){
		userService.findAll().success(
			function(response){
				$scope.list=response;
            }
		);
	}
});	
