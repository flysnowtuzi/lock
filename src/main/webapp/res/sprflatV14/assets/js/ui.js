/**
 * @author zxt_0723@163.com
 * 
 */
var hishoryUrl;
var currUrl;
bootbox.setDefaults("locale", "zh_CN");
function initMy() {

	$("a[target=navTab]").each(function() {
		console.log($(this).attr("href"));
		// alert('ddd');
		$(this).unbind('click').click(function(event) {

			var $ts = $(this);

			var url = unescape($ts.attr("href"));
			hishoryUrl = currUrl;
			currUrl = url;
			// $('#loading').modal('show');
			htmlobj = $.ajax({
				url : url,
				async : false
			});

			$("#content-wrapper").html(htmlobj.responseText);
			// $('#loading').modal('hidden');
			event.preventDefault();
			initMy();
		});
	});
	// 返回对话框
	$("#return").attr("href", hishoryUrl);

	$("a[target=ajaxTodo]").each(function() {
		var $this = $(this);

		$(this).unbind('click').click(function(event) {

			if ($this.hasClass('disabled')) {
				return false;
			}
			var url = unescape($this.attr("href"))
			var title = $this.attr("title");
			if (title) {
				bootbox.confirm({
					message : title,
					title : "确定吗?",
					callback : function(result) {
						console.log(result);
						if (result) {
							ajaxTodo(url, $this.attr("callback"));
						}
						;
					}
				});
			}
			event.preventDefault();
		});
	});
	
	$("div.pagination").each(function(){
		var $this = $(this);
		$this.pagination({
			targetType:$this.attr("targetType"),
			rel:$this.attr("rel"),
			totalCount:$this.attr("totalCount"),
			numPerPage:$this.attr("numPerPage"),
			pageNumShown:$this.attr("pageNumShown"),
			currentPage:$this.attr("currentPage")
		});
	});
};

initMy();
/*
 * ajaxTodo
 */
function ajaxTodo(url, callback) {
	var $callback = callback || navTabAjaxDone;
	if (!$.isFunction($callback))
		$callback = eval('(' + callback + ')');
	$.ajax({
		type : 'GET',
		url : url,
		dataType : "json",
		cache : false,
		success : $callback,
		error : ajaxError
	});
};

function validateCallback(form, callback, confirmMsg) {

	var $form = $(form);
	if (!$form.valid()) {
		return false;
	}
	var _submitFn = function() {
		// $form.find(':focus').blur();
		var params = $form.serialize();
		$.ajax({
			type : form.method || 'POST',
			url : $form.attr("action"),
			data : params,
			encoding : "UTF-8",
			dataType : "json",
			cache : false,
			success : callback || ajaxDone,
			error : ajaxError
		});
	}

	if (confirmMsg) {
		bootbox.confirm({
			message : confirmMsg,
			title : "确定吗?",
			callback : function(result) {
				console.log(result);
				if (result) {
					_submitFn();
				} else {
					return false;
				}
			}
		});
	} else {
		_submitFn();
	}

	return false;
}





/*
 * tab ajax 刷新
 */

function navTabAjaxDone(json) {
	checkStatus(json)
	if (json["statusCode"] == "200") {
		if ("forward" == json.callbackType) {
			// navTab.reload(json.forwardUrl);
			htmlobj = $.ajax({
				url : json.forwardUrl,
				async : false
			});
			//
			$("#content-wrapper").html(htmlobj.responseText);
			//msg(json.message);
			//alert("dddd");
			initMy();
		}
	}
}
/*
 * 提示框
 */
function msg(txt) {
	$.extend($.gritter.options, {
		position : 'bottom-right',
	});
	$.gritter.add({
		// (string | mandatory) the heading of the notification
		title : 'Success !!!',
		// (string | mandatory) the text inside the notification
		text : txt,
		// (int | optional) the time you want it to be alive for before fading
		// out
		time : '',
		// (string) specify font-face icon class for close message
		close_icon : 'en-cross',
		// (string) specify font-face icon class for big icon in left. if are
		// specify image this will not show up.
		icon : 'ec-users',
		// (string | optional) the class name you want to apply to that specific
		// message
		class_name : 'error-notice'
	});
}
/*
 * 检查 ajax 返回值的状体
 */

function checkStatus(json) {
	if (json["statusCode"] == "300") {
		if (json["message"])
			bootbox.alert(json["message"]);
	} else if (json["statusCode"] == "301") {
		bootbox.alert("超时");
		// 加载超时处理 调到主页面
	} else if (json["statusCode"] == "200") {
		if (json["message"])
			msg(json["message"]);
	}
	;
}
/*
 * ajax 错误提示
 */
function ajaxError(xhr, ajaxOptions, thrownError) {
	bootbox.alert({
		message : "<div>Http status: " + xhr.status + " " + xhr.statusText
				+ "</div>" + "<div>ajaxOptions: " + ajaxOptions + "</div>"
				+ "<div>thrownError: " + thrownError + "</div>" + "<div>"
				+ xhr.responseText + "</div>",
		size : 'large'
	});
}
/**
 * 处理navTab中的分页和排序
 * targetType: navTab 或 dialog
 * rel: 可选 用于局部刷新div id号
 * data: pagerForm参数 {pageNum:"n", numPerPage:"n", orderField:"xxx", orderDirection:""}
 * callback: 加载完成回调函数
 */
function pageBreak(data){
	//var op = $.extend({data:{pageNum:"", numPerPage:"", orderField:"", orderDirection:""}, callback:null}, options);
	
		var form = _getPagerForm(data);
		var params = $(form).serializeArray();
		//$("#loading").modal("show");
		$("#content-wrapper").ajaxUrl({type:"POST",url:$(form).attr("action"),data: params, callback:null});
		
		return false;
	}

/**
 * 
 * @param {Object} args {pageNum:"",numPerPage:"",orderField:"",orderDirection:""}
 * @param String formId 分页表单选择器，非必填项默认值是 "pagerForm"
 */
function _getPagerForm(args) {
	var form = $("#pagerForm").get(0);

	if (form&&args) {
		//alert(form["pageNum"].value);
		//alert(args["pageNum"]);
		if (args["pageNum"]) form["pageNum"].value = args["pageNum"];
		//alert(form["pageNum"].value);
		if (args["numPerPage"]) form["numPerPage"].value = args["numPerPage"];
		if (args["orderField"]) form["orderField"].value = args["orderField"];
		if (args["orderDirection"] && form["orderDirection"]) form["orderDirection"].value = args["orderDirection"];
	}
	
	return form;
}

$.fn.extend({
	/**
	 * @param {Object} op: {type:GET/POST, url:ajax请求地址, data:ajax请求参数列表, callback:回调函数 }
	 */
	ajaxUrl:function(op){
		var $this = $(this);

		//$this.trigger(DWZ.eventType.pageClear);
		
		$.ajax({
			type: op.type || 'GET',
			url: op.url,
			data: op.data,
			cache: false,
			success: function(response){
				var json = jsonEval(response);
				checkStatus(json);
				$this.html(response);
				initMy();
			},
			error: ajaxError,
			statusCode: {
				503: function(xhr, ajaxOptions, thrownError) {
					alert(thrownError);
				}
			}
		});
	}
});
/*
 * 解析json
 */
function jsonEval(data) {
	try{
		if ($.type(data) == 'string')
			return eval('(' + data + ')');
		else return data;
	} catch (e){
		return {};
	}
}
/*
 * 扩展String
 */
$.extend(String.prototype, {
	isPositiveInteger:function(){
		return (new RegExp(/^[1-9]\d*$/).test(this));
	},
	replaceAll:function(os, ns){
		return this.replace(new RegExp(os,"gm"),ns);
	},
	hoverClass: function(className, speed){
		var _className = className || "hover";
		return this.each(function(){
			var $this = $(this), mouseOutTimer;
			$this.hover(function(){
				if (mouseOutTimer) clearTimeout(mouseOutTimer);
				$this.addClass(_className);
			},function(){
				mouseOutTimer = setTimeout(function(){$this.removeClass(_className);}, speed||10);
			});
		});
	},
	focusClass: function(className){
		var _className = className || "textInputFocus";
		return this.each(function(){
			$(this).focus(function(){
				$(this).addClass(_className);
			}).blur(function(){
				$(this).removeClass(_className);
			});
		});
	}
});