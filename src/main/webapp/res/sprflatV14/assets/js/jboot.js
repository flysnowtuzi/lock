/**
 * @author zxt_0723@163.com
 * 
 */

var JBOOT = {
	version: '1.0.0',
	regPlugins: [], // [function($parent){} ...] 
	// sbar: show sidebar
	
	pageInfo: {pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"},
	statusCode: {ok:200, error:300, timeout:301},
	keys: {statusCode:"statusCode", message:"message"},

	/*
	 * 依赖 bootbox.js 
	 */
	msg:function(txt){
		$.extend($.gritter.options, { 
		    position: 'bottom-right',
		});
		$.gritter.add({
			// (string | mandatory) the heading of the notification
			title: 'Success !!!',
			// (string | mandatory) the text inside the notification
			text: txt,
			// (int | optional) the time you want it to be alive for before fading out
			time: '',
			// (string) specify font-face icon  class for close message
			close_icon: 'en-cross',
			// (string) specify font-face icon class for big icon in left. if are specify image this will not show up.
			icon: 'ec-users',
			// (string | optional) the class name you want to apply to that specific message
			class_name: 'error-notice'
		});
	},
	
	ajaxError:function(xhr, ajaxOptions, thrownError){
		if (alertMsg) {
			alertMsg.error("<div>Http status: " + xhr.status + " " + xhr.statusText + "</div>" 
				+ "<div>ajaxOptions: "+ajaxOptions + "</div>"
				+ "<div>thrownError: "+thrownError + "</div>"
				+ "<div>"+xhr.responseText+"</div>");
		} else {
			alert("Http status: " + xhr.status + " " + xhr.statusText + "\najaxOptions: " + ajaxOptions + "\nthrownError:"+thrownError + "\n" +xhr.responseText);
		}
	},
	ajaxDone:function(json){
		if(json[DWZ.keys.statusCode] == DWZ.statusCode.error) {
			if(json[DWZ.keys.message] && alertMsg) alertMsg.error(json[DWZ.keys.message]);
		} else if (json[DWZ.keys.statusCode] == DWZ.statusCode.timeout) {
			if(alertMsg) alertMsg.error(json[DWZ.keys.message] || DWZ.msg("sessionTimout"), {okCall:DWZ.loadLogin});
			else DWZ.loadLogin();
		} else if (json[DWZ.keys.statusCode] == DWZ.statusCode.ok){
			if(json[DWZ.keys.message] && alertMsg) alertMsg.correct(json[DWZ.keys.message]);
		};
	}

};

/** 
 * You can use this map like this:
 * var myMap = new Map();
 * myMap.put("key","value");
 * var key = myMap.get("key");
 * myMap.remove("key");
 */
function Map(){

	this.elements = new Array();
	
	this.size = function(){
		return this.elements.length;
	}
	
	this.isEmpty = function(){
		return (this.elements.length < 1);
	}
	
	this.clear = function(){
		this.elements = new Array();
	}
	
	this.put = function(_key, _value){
		this.remove(_key);
		this.elements.push({key: _key, value: _value});
	}
	
	this.remove = function(_key){
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					this.elements.splice(i, 1);
					return true;
				}
			}
		} catch (e) {
			return false;
		}
		return false;
	}
	
	this.get = function(_key){
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) { return this.elements[i].value; }
			}
		} catch (e) {
			return null;
		}
	}
	
	this.element = function(_index){
		if (_index < 0 || _index >= this.elements.length) { return null; }
		return this.elements[_index];
	}
	
	this.containsKey = function(_key){
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					return true;
				}
			}
		} catch (e) {
			return false;
		}
		return false;
	}
	
	this.values = function(){
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].value);
		}
		return arr;
	}
	
	this.keys = function(){
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].key);
		}
		return arr;
	}
}
