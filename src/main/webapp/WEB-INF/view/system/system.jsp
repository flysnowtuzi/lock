<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="row">
   <div class="col-lg-12 heading">
       <h1 class="page-header"><i class="im-table2"></i>系统维护</h1>
   </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default plain toggle panelClose panelRefresh">
	         <div class="panel-heading white-bg">
	              <ul class="nav nav-pills">
	                <li>
	                <button type="button" class="btn btn-primary" ng-click="start()" style="text-shadow: black 5px 3px 3px;">
					 启动服务 
					</button>
	                <!-- <a href="start" target="navTab" class="btn btn-info" >启动服务</a> --></li>
	                <li>
	                <button type="button" class="btn btn-primary" ng-click="stop()" style="text-shadow: black 5px 3px 3px;">
					停止服务
					</button>
	                </li>
	                <li>
	                <button type="button" class="btn btn-primary" style="text-shadow: black 5px 3px 3px;">
					初始化锁
					</button>
	                </li>
	                <li>
	                <button type="button" class="btn btn-primary" ng-click="sync()" style="text-shadow: black 5px 3px 3px;">
					同步时间
					</button>
	                </li>
	                <li style="margin-left:20px;margin-top:10px;"><font style="" color="red">${msg }</font></li>
	              </ul>
	         </div>
   		</div>
	</div>
    <div class="col-lg-12">
        <div class="panel panel-default plain toggle panelClose panelRefresh">
             <div class="panel-heading white-bg">
			  <div id="log-container" style="height: 450px; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;">
			    <div>
			    </div>
			  </div>
             </div>
        </div>
    </div>
</div>
<script type="text/javascript">  
	var websocket;  
	if ('WebSocket' in window) {             
	    var url = 'ws://ecard.dlmu.edu.cn:9080/elock/webSocketServer';  
	    websocket = new WebSocket(url);  
	} else if ('MozWebSocket' in window) {  
	    alert("MozWebSocket");  
	    websocket = new MozWebSocket("ws://echo");  
	} else {  
	    alert("SockJS");  
	    websocket = new SockJS("http://ecard.dlmu.edu.cn:9080/elock/webSocketServer/sockjs");  
	}  
	websocket.onopen = function(evnt) { 
	    $("#log-container div").append("链接服务器成功!<br/>");
	};  
	websocket.onmessage = function(evnt) {  
	    $("#log-container div").append(event.data);
	    $("#log-container").scrollTop($("#log-container div").height() - $("#log-container").height());
	
	};  
	websocket.onerror = function(evnt) {  
	};  
	websocket.onclose = function(evnt) {  
		$("#log-container div").append("与服务器断开了链接!<br/>"); 
	} 
</script>