/**
 * 
 */
app.controller('LogCtrl', ['$scope','LogService','mask','sysCode',function($scope,LogService,mask,sysCode) {
	console.log('请求进入');
	$scope.conditions=[]; //查询条件
	$scope.flag=false;
	$scope.flag1=false;
	$scope.flag2=false;
	$scope.modelAdd=false; //新增标志
	$scope.modelEdit=false; //修改标志
	//得到代码
	
	/*$scope.eventList=sysCode.getEventList('1');
	$scope.eventMap=sysCode.getEventMap('1');
	$scope.deviceList=sysCode.getDeviceList('1');
	$scope.deviceMap=sysCode.getDeviceMap('1');
	$scope.lockList=sysCode.getLockList('1');
	$scope.lockMap=sysCode.getLockMap('1');*/
	//sysCode.convertList2Map($scope.appIfTypeList);  不知为啥不好用，等待调试
	
	var levelList = [];
	levelList[0] = {
			id : "INFO",
			mc : "INFO"
		}
	levelList[1] = {
			id : "INFO1",
			mc : "INFO1"
		}
	levelList[2] = {
			id : "INFO2",
			mc : "INFO2"
		}
	$scope.levelList = levelList;
	
	
	 $scope.mutiSource=[{
			queryName : '级别',// 名称
			queryCode : "levelString",
			items :$scope.levelList
		}
		];
 $scope.$watch('conditions',function(val1,val2){
		 
		 if(angular.toJson(val1) != angular.toJson(val2)){
			 var cons={};
			 for(var i=0;i<val1.length;i++){
				 cons[val1[i].queryCode]=val1[i].id
			 }
			 //扫描查询条件
			 for(var key in $scope.keyword){
				console.log($scope.keyword[key]);
				cons[key]=$scope.keyword[key]
			}
			$scope.page.conditions=cons;
		 }
	 },true);
	 /*监控分页工具选择页码的变化，若变更则执行后台调用*/
	  $scope.$watch('page',function(val1,val2){
		  if(val1==undefined||val2==undefined){			  
			  return;
		  }
		  if(val1.pageNum!=val2.pageNum||angular.toJson(val1.conditions)!= angular.toJson(val2.conditions)){
			 // alert('page')  
			  $scope.queryList($scope.page);
		  }

	  },true);
	  
	  
	  $scope.queryList = function(page) {
			mask.showLoading();
			//page.numPerPage=5;
			LogService.queryList(page,function(res) {
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
	//编辑应用
	$scope.edit=function(item){
		$scope.app=angular.copy(item);
		$scope.modelEdit = true;
		$scope.modelAdd = false;
		$scope.flag=true;
	}
	$scope.queryList(null);
}]);


app.service('LogService', ['http','mask','timeAlert','dialog', function(http,mask,timeAlert,dialog) {
	return {
		// 查询应用列表
		queryList : function(param,callback) {
			 // mask.showLoading();
			  http.callService('log/list',param,callback)
		
			//mask.hideLoading();
		}
	}
}]);