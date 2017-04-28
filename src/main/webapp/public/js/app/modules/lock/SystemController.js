/**
 * 
 */
app.controller('SystemCtrl', ['$scope','SystemService','mask','sysCode',function($scope,SystemService,mask,sysCode) {
	console.log('请求进入');
	$scope.conditions=[]; //查询条件
	$scope.flag=false;
	$scope.modelAdd=false; //新增标志
	$scope.modelEdit=false; //修改标志
	
	 /* $scope.queryList = function(page) {
			mask.showLoading();
			//page.numPerPage=5;
			SystemService.queryList(page,function(res) {
				$scope.list = res.data;// 学生基本信息
				if($scope.page==undefined){
					$scope.page=res.page;
					$scope.page.conditions={};
				}else{
					var pageCon=angular.copy($scope.page.conditions);
					$scope.page=res.page;
					$scope.page.conditions=pageCon;
				}
				//$scope.page.
				mask.hideLoading();
			})
			
		}
	*/
	//编辑应用
	$scope.start=function(){
		SystemService.start(function(){
			//$scope.queryList($scope.page);
		})
	}
	
	$scope.stop=function(){
		SystemService.stop(function(){
			//$scope.queryList($scope.page);
		})
	}
	$scope.sync=function(){
		SystemService.sync(function(){
			//$scope.queryList($scope.page);
		})
	}
}]);


app.service('SystemService', ['http','mask','timeAlert','dialog', function(http,mask,timeAlert,dialog) {
	return {
		// 查询应用列表
		start : function(callback) {
			 // mask.showLoading();
			http.callService('start',callback)
			timeAlert.success("服务启动");
		},
		//应用
		stop:function(item,callback){
			
			http.callService('stop',callback)
			timeAlert.success("服务停止");
		
		},
		sync:function(item,callback){
			
			http.callService('sync',callback)
			timeAlert.success("同步时间");
		}
	}
}]);