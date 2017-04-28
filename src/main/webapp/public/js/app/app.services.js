/**
 * 
 */
var services = angular.module('services', []);
/**
 * 定义一个mask(遮罩)服务
 */
services
		.factory(
				'mask',
				function() {
					var body = $("body");// 获取body元素
					// 创建一个全局遮罩
					var mask = $('<div class="cs-window-background"></div>');
					var loading = $('<div class="cs-window-loading"><div class="cs-window-img"></div></div>');
					mask.hide();
					loading.hide();
					body.append(mask);
					body.append(loading);
					return {
						/**
						 * 显示遮罩
						 */
						show : function() {
							mask.show();
						},
						/**
						 * 隐藏遮罩
						 */
						hide : function() {
							mask.hide();
						},
						/**
						 * 显示遮罩和加载中
						 */
						showLoading : function() {

							mask.show();
							loading.show();
						},
						/**
						 * 隐藏遮罩和加载中
						 */
						hideLoading : function() {
							mask.hide();
							loading.hide();
						}
					}
				});
services.factory("timeAlert", function() {
	var defalutOption = {
		"closeButton" : false,
		"debug" : false,
		"positionClass" : "toast-top-center",
		"onclick" : null,
		"showDuration" : "300",
		"hideDuration" : "1000",
		"timeOut" : "2000",
		"extendedTimeOut" : "1000",
		"showEasing" : "swing",
		"hideEasing" : "linear",
		"showMethod" : "fadeIn",
		"hideMethod" : "fadeOut"
	}
	return {
		success : function(massage, title) {
			toastr.options = defalutOption;
			toastr['success'](massage, title);
		},
		error : function(massage, title) {
			toastr.options = defalutOption;
			toastr['error'](massage, title);
		},
		info : function(massage, title) {
			toastr.options = defalutOption;
			toastr['info'](massage, title);
		},
		warning : function(massage, title) {
			toastr.options = defalutOption;
			toastr['warning'](massage, title);
		}
	}
});

/**
 * 对话框服务
 * 因为对话框是以window的形式存在，故没有必要以HTML指令的形式存在于html模版中，因此
 *
 * */
services.factory('dialog',['$compile','$rootScope',function($compile,$rootScope){
    //创建遮罩
	var body = $("body");//获取body元素
    var mask = $('<div class="cs-window-background"></div>');
    mask.hide();
    body.append(mask);
    //居中方法
    var offset = function(el){
        var body = $(window),
            w = el.width(),
            h = el.height(),
            bw = body.innerWidth(),
            bh = body.innerHeight(),
            top = (bh-h)/2-40,
            left = (bw-w)/2;
        el.css("left",left + "px");
        el.css("top",top + "px");
    }

    var errorHtml = '<div class="dialog-windows-pt-body">'+
                        '<div class="dialog-windows-pt-close dialog-windows-pt-close-red" ng-click="$dialog_error_close()"></div>'+
                        '<div class="dialog-windows-pt-img dialog-windows-pt-img-red">{replacement}</div>'+
                        '<div class="dialog-windows-pt-button dialog-windows-pt-button-red" ng-click="$dialog_error_close()">关闭</div>'+
                    '</div>';
    var warnHtml = '<div class="dialog-windows-pt-body">'+
                        '<div class="dialog-windows-pt-close dialog-windows-pt-close-orange" ng-click="$dialog_warn_close()"></div>'+
                        '<div class="dialog-windows-pt-img dialog-windows-pt-img-orange">{replacement}</div>'+
                        '<div class="dialog-windows-pt-button dialog-windows-pt-button-orange" ng-click="$dialog_warn_close()">关闭</div>'+
                    '</div>';
    var infoHtml = '<div class="dialog-windows-pt-body">'+
                        '<div class="dialog-windows-pt-close dialog-windows-pt-close-green" ng-click="$dialog_info_close()"></div>'+
                        '<div class="dialog-windows-pt-img dialog-windows-pt-img-green">{replacement}</div>'+
                        '<div class="dialog-windows-pt-button dialog-windows-pt-button-green" ng-click="$dialog_info_close()">好的</div>'+
                    '</div>';
    var confirmHtml = '<div class="dialog-windows-pt-body">'+
                            '<div class="dialog-windows-pt-close dialog-windows-pt-close-blue"  ng-click="$dialog_confirm_close()"></div>'+
                            '<div class="dialog-windows-pt-img dialog-windows-pt-img-blue">{replacement}</div>'+
                            '<div class="dialog-windows-pt-button"> <span class=" dialog-windows-pt-button-blue dialog-windows-pt-span"  ng-click="$dialog_confirm_sure()">确认</span>' +
                                '<span class=" dialog-windows-pt-button-blue dialog-windows-pt-span dialog-windows-pt-list"  ng-click="$dialog_confirm_cancel()">取消</span> ' +
                            '</div>'+
                      '</div>';
    var successHtml = '<div class="dialog-windows-pt-body">'+
					     '<div class="dialog-windows-pt-close dialog-windows-pt-close-qing" ng-click="$dialog_success_close()"></div>'+
					     '<div class="dialog-windows-pt-img dialog-windows-pt-img-qing">{replacement}</div>'+
					     '<div class="dialog-windows-pt-button dialog-windows-pt-button-qing" ng-click="$dialog_success_close()">关闭</div>'+
					  '</div>';
    /**
     * 把元素添加到body上，显示遮罩，并把dialog居中显示
     * replace message,show mask,show dialog
     * @param html
     * @param message
     * @returns {*|jQuery|HTMLElement}
     */
    var rsd = function(html,message){
        var el = $($compile(html.replace("{replacement}",message))($rootScope));
        body.append(el);
        mask.show();//显示遮罩
        el.show();
        offset(el);//居中
        return el;
    }
    var dialog = {
    		
    };
    return {
        /**
         * 显示一个错误窗口
         * @param message
         */
        error : function(message){
            $rootScope.$dialog_error_close = function(){
            	dialog.error.remove();
                mask.hide();
                delete dialog.error;
            };
            dialog.error = dialog.error||rsd(errorHtml,message);
        },
        /**
         * 显示一个警告窗口
         * @param message
         */
        warn : function(message){
        	$rootScope.$dialog_warn_close = function(){
        		dialog.warn.remove();
                mask.hide();
                delete dialog.warn;
            };
            dialog.warn = dialog.warn||rsd(warnHtml,message);
        },
        /**
         * 显示一个信息提示窗口
         * @param message
         */
        info : function(message){
            $rootScope.$dialog_info_close = function(){
            	dialog.info.remove();
                mask.hide();
                delete dialog.info;
            };
            dialog.info = dialog.info||rsd(infoHtml,message);
        },
        /**
         * 显示一个成功提示窗口
         * @param message
         */
        success : function(message){
            $rootScope.$dialog_success_close = function(){
            	dialog.success.remove();
                mask.hide();
                delete dialog.success;
            };
            dialog.success = dialog.success||rsd(successHtml,message);
        },
        /**
         * 显示一个确认窗口
         * @param message
         * @param doSure
         * @param doFailure
         */
        confirm : function(message,doSure,doCancel){
            $rootScope.$dialog_confirm_close = function(){
            	dialog.confirm.remove();
                mask.hide();
                delete dialog.confirm;
            };
            $rootScope.$dialog_confirm_sure = function(){
            	dialog.confirm.remove();
                mask.hide();
                delete dialog.confirm;
                if(doSure)doSure();
                
            };
            $rootScope.$dialog_confirm_cancel = function(){
            	dialog.confirm.remove();
                mask.hide();
                delete dialog.confirm;
                if(doCancel)doCancel();
            };
            dialog.confirm = dialog.confirm||rsd(confirmHtml,message);
       }
    }
}]);
/**
 * 定义一个获取系统代码的服务
 */
services.factory('sysCode',	['http',function(http) {
							var code_url = "sys/queryCode";
							var data;
							return {
								getMap : function(codeName) {
									var codeMap = {};
									http.callService('sys/queryCode',{codeName : codeName},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																codeMap[req.data[i].codeNo] = req.data[i].codeDescribing;
															}
														}
													});
									return codeMap;
								},
								getList : function(codeName) {
									var codeList = [];
									http.callService('sys/queryCode',{codeName : codeName},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																// codeMap[req.data[i].codeNo]=req.data[i].codeDescribing;
																codeList[i] = {
																	id : req.data[i].codeNo,
																	mc : req.data[i].codeDescribing
																}
															}
														}
													});
									return codeList;
								},
								convertList2Map : function(list) {
									var codeMap = {};
									if(list==undefined||list.length==0) return codeMap;
									for (var i = 0; i < list.length; i++) {
										codeMap[list[i].id] = list[i].id.mc;
									}
									return codeMap;
								},
								getDeviceList : function(codeName) {
									var deviceList = [];
									http.callService('device/queryDevice',{codeName : codeName},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																// codeMap[req.data[i].codeNo]=req.data[i].codeDescribing;
																deviceList[i] = {
																		id : req.data[i].devId,
																		mc : req.data[i].devName
																}
															}
														}
													});
									return deviceList;
								},
								getDeviceMap : function(codeName) {
									var codeMap = {};
									http
											.callService(
													'device/queryDevice',
													{
														codeName : codeName
													},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																codeMap[req.data[i].devId] = req.data[i].devName;
															}
														}
													});
									return codeMap;
								},
								getTypeList : function(codeName) {
									var typeList = [];
									http.callService('type/queryType',{codeName : codeName},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																// codeMap[req.data[i].codeNo]=req.data[i].codeDescribing;
																typeList[i] = {
																		id : req.data[i].devType,
																		mc : req.data[i].typeName
																}
															}
														}
													});
									return typeList;
								},
								getTypeMap : function(codeName) {
									var codeMap = {};
									http
											.callService(
													'type/queryType',
													{
														codeName : codeName
													},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																codeMap[req.data[i].devType] = req.data[i].typeName;
															}
														}
													});
									return codeMap;
								},
								getEventList : function(codeName) {
									var typeList = [];
									http.callService('event/queryEvent',{codeName : codeName},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																// codeMap[req.data[i].codeNo]=req.data[i].codeDescribing;
																typeList[i] = {
																		id : req.data[i].eventId,
																		mc : req.data[i].eventName
																}
															}
														}
													});
									return typeList;
								},
								getEventMap : function(codeName) {
									var codeMap = {};
									http
											.callService(
													'event/queryEvent',
													{
														codeName : codeName
													},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																codeMap[req.data[i].eventId] = req.data[i].eventName;
															}
														}
													});
									return codeMap;
								},
								getLockList : function(codeName) {
									var typeList = [];
									http.callService('lock/queryLock',{codeName : codeName},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																// codeMap[req.data[i].codeNo]=req.data[i].codeDescribing;
																typeList[i] = {
																		id : req.data[i].lockId,
																		mc : req.data[i].lockName
																}
															}
														}
													});
									return typeList;
								},
								getLockMap : function(codeName) {
									var codeMap = {};
									http
											.callService(
													'lock/queryLock',
													{
														codeName : codeName
													},
													function(req) {
														if (req.statusCode == '200') {
															for (var i = 0; i < req.data.length; i++) {
																codeMap[req.data[i].lockId] = req.data[i].lockName;
															}
														}
													});
									return codeMap;
								}
							}

						} ]);

/**
 * 基于angularjs的$http服务之上的封装
 * 
 */
services.factory('http', [ '$http', function($http) {
	var baseUrl = httpConfig.baseUrl;
	var ret;
	return {
		callService : function(url, param, callback) {
			$http({
				method : 'POST',
				url : baseUrl + url,
				data : param
			}).success(function(data) {
				if (callback) { // 如果有回调函数
					callback(data);
				} else {
					ret = data;
				}
			});
			return ret;
		}

	}
} ]);

// services.factory('http',['$http',function($http){
// var baseUrl = httpConfig.baseUrl;
// return {
// /**
// * 请求数据,通过该形式，避免了使用回调函数的形式获取数据，极大的增强了代码的可读性
// * var req = {
// * service : 'beanId?method',
// * params : {
// * name : '张三',
// * sex : '男'
// * }
// * };
// * var data = http.callService(req);
// * $scope.iterator = data;//这里需要在模版中通过iterator.data来进行数据的遍历，
// * //不要在这里直接试图通过iterator.data获取数据（ajax请求是异步的，数据尚未绑定到该键上)
// *
// *********************************************************
// * 当然如果你想直接获取数据：你可以这样做：
// * http.callService(req).success(function(data){
// * //在这里获取你实际需要的数据
// * });
// */
// callService : function(request){
// var requestCopy = angular.copy(request),
// params = requestCopy.params,
// backKey = "data",
//               
// //sm = requestCopy.service.split("?"),
// callback,
// ret = {
// success : function(thenCallback){
// callback = thenCallback;
// }
// };
// //requestCopy.beanName = sm[0];
// //requestCopy.methodName = sm[1];
// if(!requestCopy.params)requestCopy.params = [];
// //requestCopy.dataArray=requestCopy.params;
// //delete requestCopy.service;
// //delete requestCopy.params;
// $http({
// method: 'POST',
// url: baseUrl+requestCopy.service,
// data: requestCopy.params
// }).success(function(data){
// if (callback) {
// callback(data);
// } else {
// ret[backKey] = data;
// delete ret.success;
// }
// });
// return ret;
// },
// /**
// * 为了解决ajax 嵌套调用的问题，屏蔽到复杂的嵌套结构
// * http.call({
// * service : 'base?get'
// * }).call(function(data1){
// * return {
// * service : 'base?get1'
// * }
// * }).call(function(data1,data2){
// * return {
// * service : 'base?get2'
// * }
// * }).end(function(data1,data2,data3){
// *
// * })
// *
// * @param req
// * @returns {{call: call, end: end}}
// */
// call : function(req){
// var me = this,
// requests = [req],
// results = [],
// endCallback,
// ret = {
// call : function(req){
// requests.push(req);
// return this;
// },
// end : function(callback){
// endCallback = callback;
// var reqIndex = 0;
// var callFn = function(req){
// if(angular.isFunction(req)){
// req = req.apply(window,results);
// }
// me.callService(req).success(function(data){
// results.push(data);
// if(reqIndex < requests.length-1){
// var nextReq = requests[reqIndex+1];
// callFn(nextReq);
// }else if(reqIndex == requests.length-1){
// endCallback.apply(window,results);
// }
// reqIndex++;
// });
// }
// callFn(requests[reqIndex]);
// }
// };
// return ret;
// }
// }
// }
// ]);
