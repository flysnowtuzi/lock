<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<section>
	<!--左侧导航结束-->
	<!--右侧内容开始-->
	<div class="shuju-con-right">
		<!--右侧头部开始-->
		<div class="shuju-right-title clearfix">
			<div class="shuju-title-left">
				<h3>锁监控</h3>
			</div>
		</div>



		<div class="content">
		 <div class="panel panel-default plain toggle panelClose panelRefresh">
		<div class="panel-body">
	        <div ng-repeat="item in list" class="col-sm-6 col-md-3" style="width:12.5%">
	        <div class="thumbnail" >
	            <img ng-if="item.lockFlag==2" style="height:100px;width:120px" src="${pageContext.request.contextPath}/public/img/unknow.jpg"
	                 alt="未知({{item.lastUpdate}})">
                <img ng-if="item.lockFlag==1" style="height:100px;width:120px" src="${pageContext.request.contextPath}/public/img/offline.jpg"
                     alt="不在线({{item.lastUpdate}})">
	            <img ng-if="item.lockFlag==0" style="height:100px;width:120px" src="${pageContext.request.contextPath}/public/img/online.jpg"
	                 alt="在线({{item.lastUpdate}})">
	            <div class="caption">
	                <p align="center">{{item.lockName }}</p>
	                <p align="center">
	                <button type="button" class="btn btn-primary" ng-click="openLock(item)" style="text-shadow: black 5px 3px 3px;">
					开锁 
					</button>
					<button type="button" class="btn btn-primary" ng-click="syncTime(item)" style="text-shadow: black 5px 3px 3px;">
					同步
					</button>
	                    <%-- <a href="openLock?lock_id=${item.lockId }&identify=c62d1d25" target="navTab" class="btn btn-primary" role="button">开锁</a>
	                    <a href="syncTime?lock_id=${item.lockId }" target="navTab" class="btn btn-primary" role="button">同步</a> --%>
	                </p>
	            </div>
	        </div>
	    </div>
	 	</div>
			</div>
		</div>
	</div>
	<!--右侧内容结束-->
	
</section>