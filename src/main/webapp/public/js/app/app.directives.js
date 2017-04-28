/**
 * 
 */
app.directive('cgMulQueryComm', function() {
	return {
		restrict : 'AE', 
		templateUrl : httpConfig.basePath
				+ '/public/js/ngDirectives/tpl/multiQueryComm.html',
		scope : {
			source : "=",
			result : "=",
			expand : "@",
			noborder : "@"
		},
		link : function(scope, element, attrs) {
			// 当前查询条件
			scope.result = [];
			
			//树的选择结果
			scope.innerTreeResult = {};
			
			//监听树的选择结果
			scope.$watch('innerTreeResult',function(val) {
				if (val.queryCode) {
					var innerTreeHasPushed = false;
					for ( var i = 0; i < scope.result.length; i++) {
						if (scope.result[i].queryCode == scope.innerTreeResult.queryCode) {
							scope.result.splice(i,1,angular.copy(scope.innerTreeResult));
							innerTreeHasPushed = true;
						}
					}
					if (!innerTreeHasPushed) {
						scope.result.push(angular.copy(scope.innerTreeResult));
					}
				}
			}, true);
			
			// 清空查询条件
			scope.cancleQueryAll = function() {
				scope.result = [];
				for ( var i = 0; i < scope.queryArray.length; i++) {
					var item = scope.queryArray[i];
					if(scope.queryArray[i].queryType == "comboTree"){
						scope.queryArray[i].items.dataChangeDate = new Date();
					}else{
						for ( var j = 0; j < item.items.length; j++) {
							item.items[j].checked = false;
						}
					}
				}
				
			};
			scope.cancleQuery = function(obj) {
				for ( var i = 0; i < scope.result.length; i++) {
					if(scope.result[i] == obj){
						scope.result.splice(i,1);
					}
				}
				if(obj.queryType == "comboTree"){
					for ( var i = 0; i < scope.queryArray.length; i++) {
						if(scope.queryArray[i].queryCode == obj.queryCode){
							scope.queryArray[i].items.dataChangeDate = new Date();
						}
					}
				}else{
					for ( var i in scope.queryArray) {
						var item = scope.queryArray[i];
						if(obj.queryName == item.queryName){
							for ( var j = 0; j < item.items.length; j++) {
								item.items[j].checked = false;
							}
						}
					}
				}
			};

			// 查询条件组合
			scope.queryArray = angular.copy(scope.source);

			// 点击更多后，显示某组条件的每一个条件项
			scope.showAll = function(obj) {
				obj.isAll = true;
				for ( var i in obj.items) {
					obj.items[i].show = true;
				}
			};
			// 高级搜索
			scope.isExpandALL = scope.expand ? true : false;
			scope.expandALL = function() {
				scope.isExpandALL = !scope.isExpandALL;
				for ( var i = 1; i < scope.queryArray.length; i++) {
					scope.queryArray[i].isShow = !scope.queryArray[i].isShow;
				}
			};
			// change
			scope.change = function(item, condition) {
				// 改变选中
				for ( var j = 0; j < condition.items.length; j++) {
					condition.items[j].checked = false;
				}
				item.checked = true;
				// 判断item所属的条件组是否有已选条件在result数组中,如果有将新的替换旧的
				var it = {}, itHasPushed = false;
				angular.copy(item, it);
				it.queryName = condition.queryName;
				it.queryCode = condition.queryCode;
				var array = [];
				for ( var i =0;i< scope.result.length;i++) {
					var tt = scope.result[i];
					// 将新的替换旧的
					if (tt.queryCode != it.queryCode) {
						array.push(tt);
					} else {
						array.push(it);
						itHasPushed = true;
					}
				}
				if (!itHasPushed) {
					array.push(it);
				}
				scope.result = array;
			};
			
			scope.$watch('result',function() {
				// 是否页面显示当前查询条件
				scope.isQuery = scope.result.length > 0 ? true : false;
			}, true);

			scope.$watch('source',function() {
				scope.queryArray = angular.copy(scope.source);
				scope.setDefaultChecked();
			}, true);
			
			scope.setDefaultChecked = function(){
				// 遍历条件组合数组，设置默认选中项和默认显示项
				for ( var i in scope.queryArray) {
					var item = scope.queryArray[i];
					// 当条件的组数大于1的时候，默认显示两组，其余的组合点击高级查询显示
					if (i < 1) {
						item.isShow = true;
					} else {
						item.isShow = scope.isExpandALL; 
					}
					// 当某组条件的数量大于5的时候，默认显示5个，其余的点击更多后展示
					item.isAll = item.items.length <= 5 ? true : false;
					if (item.queryType != "comboTree") {
						for ( var j in item.items) {
							var inner = item.items[j];
							inner.show = true;
							/*if (i < 1 && j == 0) {
								inner.checked = true;
								scope.change(inner, item);
							}*///默认第一个选中
							if(item.queryType=='comboSelect')
							for(var k in inner.children){
								if (inner.children[k].checked) {
									scope.change(inner.children[k], item);
								}	
							}
							if (inner.checked) {
								scope.change(inner, item);
							}
							if (j >= 5) {
								inner.show = false;
							}
						}
					}
				}
				
				/*if (scope.queryArray && scope.result.length == 0 && scope.queryArray.length > 0) {
					var ot = scope.queryArray[0];
					if(ot.items && ot.items.length > 0){
						ot.items[0].checked = true;
						scope.change(ot.items[0],ot);
					}
				}*/
			};
			scope.setDefaultChecked();
			if(!scope.noborder){
				scope.noborder = true;
			}
		}
	};
});

/**
 * 窗体指令
 *  <div cs-window show="flag" autoCenter="true" offset="offset">窗体</div>
 */
app.directive('csWindow',['$timeout','$compile',function($timeout,$compile){
	//创建遮罩
	var body = $("#content");//获取body元素
    var mask = $('<div class="cs-window-background"></div>');
    mask.hide();
    
    body.append(mask);
    var offset = function(el,autoCenter){
        var body = $("#content"),
            w = el.width(),
            h = el.height(),
            bw = body.width(),
           
            bh = body.outerHeight(true),
            top = (bh-h)/2-40,
            left = (bw-w)/2;
       
        if(top<0)top=0;
        if(autoCenter == "true"){
              el.css("left",left + "px");
              el.css("top",top + "px");
        }
    }
    var offset1 = function(el,offset){
    	el.offset(offset);
    }
    return {
        restrict : 'A',
        scope : {
            show : '=',
            offset : '=offset',
            clickDisappear : '=clickDisappear',
            title:'='
        },
        link : function(scope, element, attrs){
            var autoCenter = attrs.autocenter || "true",
                m = attrs.mask || "true",
                disappear = attrs.clickDisappear || "true";
            var windowClickEvent = false;
            scope.$watch('title',function(newV,oldV){
            	scope.title=scope.title||"&nbsp";
            	 var headerHtml=$("<div class='modal-header'>"+
                 "<button type='button' class='close' data-dismiss='modal'><span class='aclose' >×</span></button>"+
                 "<h4 style='margin:0px;line-height:1;'>"+ scope.title+"</h4>"+
                 "</div>");
            	 element.find(".modal-header").remove();
            	 var newElem = $compile(headerHtml)(scope);
                 element.prepend(headerHtml);
                 element.find(".modal-header").next().addClass("content");
            },true);
            scope.$watch('show',function(newV,oldV){
                if(newV == true){
                    element.show();
                    element.resize();
                    if(m === "true")mask.show();
                    if(scope.clickDisappear){
                    	$timeout(function(){
                        	$(document).one('click',function(event){
                        		scope.show = false;
                        		$timeout(function(){
                        			scope.$apply();
                        		});
                        	});
                    	});
                    }
                    
                    $(".modal-header button.close").on('click',function(){
                     	scope.show = false;
                     	$timeout(function(){
                			scope.$apply();
                		});
                     }); 
                }else{//如果值不是通过document click事件进行改变的，需要首先对document的click事件解除绑定
                	$(document).unbind('click');
                    element.hide();
                    mask.hide();
                }
            },true);
            if(scope.clickDisappear){
            	if(!windowClickEvent){//如果值false，则表明未初始化click事件，注册click事件，阻止冒泡
            		element.on('click',function(event){
            			event.stopPropagation();
            		});
            		windowClickEvent = true;
            	}
            }
            scope.$watch('offset',function(newV,oldV){
                offset1(element,newV);//手动移动到指定位置
            });
            //判断是否显示window窗口
            if(scope.show) element.show(); else element.hide();
            //添加window样式
            element.addClass('cs-window-windows');
            //设置元素居中
            if(!scope.offset)offset(element,autoCenter);
            else offset1(element,scope.offset);//手动移动到指定位置	
            $(window).resize(function () {  
            	 if(!scope.offset)offset(element,autoCenter);
                 else offset1(element,scope.offset);//手动移动到指定位置	
            });
        }
    }
}]);