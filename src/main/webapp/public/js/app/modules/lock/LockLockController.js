/**
 * 
 */
app.controller('LockLockCtrl', ['$scope','LockLockService','mask','sysCode',function($scope,LockLockService,mask,sysCode) {
	console.log('请求进入');
	$scope.conditions=[]; //查询条件
	$scope.flag=false;
	$scope.modelAdd=false; //新增标志
	$scope.modelEdit=false; //修改标志
	//得到代码
	
	//每个表单验证配置，如果不设置，默认和全局配置相同
     $scope.validateOptions = {
         blurTrig: true
     };
     
     $scope.syncTime=function(lock_id){
    	 LockLockService.syncTime(lock_id,function(){
  			$scope.queryList(null);
  		})
 	}
 	
 	$scope.openLock=function(lock_id){
 		LockLockService.openLock(lock_id,function(){
 			$scope.queryList(null);
 		})
 	}
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
			LockLockService.queryList(page,function(res) {
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
	
	
	  //手动查询
	$scope.search=function(){
		for(var key in $scope.keyword){
			console.log($scope.keyword[key]);
			   $scope.page.conditions[key]=$scope.keyword[key]
		}
	}
	//启停应用
	$scope.isUseable=function(item){
		//item=tfst(item);
		item.isUseable=item.isUseable=='01'?'02':'01';
		//item.isUseable="02";
		LockLockService.update(item,function(){
			$scope.queryList($scope.page);
		});
	};
	//处理表单

	$scope.saveEntity = function() {
		//alert($.param($scope.app));
		if($scope.modelEdit){
			LockLockService.update($scope.app,function(){
				$scope.queryList($scope.page);
			});
			$scope.modelEdit=false;
			$scope.flag=false;
		}else{
			LockLockService.add($scope.app,function(){
				$scope.queryList($scope.page); 
			});
			$scope.modelAdd=false;
			$scope.flag=false;
			
		}
		
		return false;
	}
	$scope.queryList(null);
}]);


app.service('LockLockService', ['http','mask','timeAlert','dialog', function(http,mask,timeAlert,dialog) {
	return {
		// 查询应用列表
		queryList : function(param,callback) {
			 // mask.showLoading();
			  http.callService('lock/tuList',param,callback)
		
			//mask.hideLoading();
		},syncTime : function(lock_id,callback) {
			 // mask.showLoading();
			 
			  http.callService('syncTime',lock_id,function(data){
				if(data.statusCode=='200'){
					timeAlert.success("同步成功");
					callback();
				}else{
					timeAlert.error("执行失败");
					
				}
				 //mask.hideLoading();
			  });
			/*http.callService('syncTime',lock_id,callback)
			timeAlert.success("同步");*/
		},
		//应用
		openLock:function(lock_id,callback){
			 
			  http.callService('openLock',lock_id,function(data){
				  alert(data.statusCode);
				if(data.statusCode=='200'){
					alert(data.statusCode);
					timeAlert.success("锁已打开");
					callback();
				}else{
					timeAlert.error("执行失败");
					
				}
			  });
			
			/*http.callService('openLock',lock_id,callback)
			timeAlert.success("锁已打开");*/
		
		},
		//应用
		update:function(item,callback){
		
			  mask.showLoading();
			 
			  http.callService('lock/update',item,function(data){
				if(data.statusCode=='200'){
					timeAlert.success("修改成功");
					if(angular.isFunction(callback)) callback();
					
				}else{
					timeAlert.error(data.message);
					
				}
				 mask.hideLoading();
			  });
		},
		//add
		add:function(item,callback){
			
			  mask.showLoading();
			 
			  http.callService('lock/add',item,function(data){
				if(data.statusCode=='200'){
					timeAlert.success("添加成功");
					callback();
				}else{
					timeAlert.error(data.message);
					
				}
				 mask.hideLoading();
			  });
		},
		del:function(item,callback){
			 
			dialog.confirm("确定要删除"+item.lockName+"的锁吗?",function(){
	    		mask.showLoading();
				  http.callService('lock/del',item,function(data){
					if(data.statusCode=='200'){
						timeAlert.success("删除成功");
						callback();
					}else{
						dialog.error(data.message);
						
					}
					 mask.hideLoading();	
				  });

	        },function(){});
 
		}
	}
}]);