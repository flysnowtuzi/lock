<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<section>
	<!--左侧导航结束-->
	<!--右侧内容开始-->
	<div class="shuju-con-right">
		<!--右侧头部开始-->
		<div class="shuju-right-title clearfix">
			<div class="shuju-title-left">
				<h3>事件管理</h3>
			</div>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="pull-left">
					
					<button type="button" class="btn btn-primary" ng-click="newApp()" style="text-shadow: black 5px 3px 3px;">
  新增 <span class="glyphicon glyphicon-plus"></span> 
</button>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-5 col-xs-6 pull-right">
				<!-- <div class="input-group">
					<input type="text" class="form-control"  placeholder="计划名称 模糊匹配" ng-model="keyword['projectName']">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" ng-click="search();">
							<span class="glyphicon glyphicon-search" style="color: rgb(255, 140, 60);"></span>
						</button>
					</span>
				</div>/input-group -->
			</div>
			
			</div>
		</div>


		<div class="content">
			<div class="table-responsive">
				
				<!--表格 -->
				<table class="table   table-hover">
					<thead>
						<tr class="success">
							<th>行号</th>
							<th>事件ID</th>
                            <th>事件名称</th>
                            <th>事件类型</th>
                            <th class="per8 text-center">编辑</th>
							<th class="per8 text-center">删除</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in list" class="quanxian-bg-hover">
							<td>{{$index + 1}}</td>
							<td>{{item.eventId}}</td>
	                      	<td>{{item.eventName}}</td>
	                      	<td>{{eventTypeMap[item.eventStr]}}</td>
							<td class="text-center">
								<button type="button" ng-click="edit(item)" class="btn btn-default" title="编辑">
									<span class="glyphicon glyphicon-edit"></span>
								</button>

							</td>
							<td class="text-center">
								<button type="button" ng-click="del(item)" class="btn btn-default" title="删除">
									<span class="glyphicon glyphicon-trash"></span>
								</button>

							</td>
						</tr>
					</tbody>
				</table>
				<!--表格-->
				</div>
				<!-- pagination start -->
				<div class="panel-body">
					<div class="row">
						<div class="pull-left pagination">一共{{page.totalCount}}条结果，当前第{{page.pageNum}}页，共{{page.totalPage}}页</div>
						<div class="pull-right">
							<ul uib-pagination class="pagination-sm" total-items="page.totalCount" items-per-page="page.numPerPage" previous-text="上一页"  next-text="下一页" ng-model="page.pageNum" max-size="page.pageNumShown" boundary-link="true" boundary-link-numbers="true" rotate="true"></ul>
						</div>
					</div>

				</div>
				<!-- pagination end -->
			
		</div>
	</div>
	<!--右侧内容结束-->
	<!-- 添加应用 -->
	<div cs-window show="flag" autoCenter="true" offset="offset" style="width:450px" title="'事件'">
		<div>
			<form class="form-horizontal group-border w5c-form hover-stripped" role="form" w5c-form-validate="validateOptions" novalidate name="form" >
			<div ng-show="modelAdd" class="form-group">
                   <label class="col-lg-2 col-md-2 col-sm-12 control-label">事件ID</label>
                   <div class="col-lg-10 col-md-10">
                       <input name="eventId" class="form-control" maxlength="30" required="required" class="form-control" type="text" ng-model="app.eventId">
                   </div>
               </div>
               <div class="form-group">
               <label class="col-lg-2 col-md-2 col-sm-12 control-label">事件名称</label>
                   <div class="col-lg-10 col-md-10">
                       <input name="eventName" class="form-control" maxlength="30" required="required" class="form-control" type="text" ng-model="app.eventName"  >
                   </div>
               </div>
               <div class="form-group">
               <label class="col-lg-2 col-md-2 col-sm-12 control-label">事件类型</label>
                   <div class="col-lg-10 col-md-10">
                    <select name="eventType"  class="form-control" required="required" ng-model="app.eventStr">
					<option ng-repeat="x in eventTypeList" value="{{x.id}}">{{x.mc}}</option>
					</select>
                   </div>
               </div>
                 <div class="modal-footer">
		    <button type="submit" class="btn btn-primary" w5c-form-submit="saveEntity()" ng-show="modelAdd" >添加</button>
			<button type="submit" class="btn btn-primary" w5c-form-submit="saveEntity()" ng-show="modelEdit">确定</button>
	</div>	                    
          </form>
		</div>	
		   
		</div>
	
</section>