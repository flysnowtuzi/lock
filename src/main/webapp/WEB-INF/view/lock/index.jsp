<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<section>
	<!--左侧导航结束-->
	<!--右侧内容开始-->
	<div class="shuju-con-right">
		<!--右侧头部开始-->
		<div class="shuju-right-title clearfix">
			<div class="shuju-title-left">
				<h3>锁管理</h3>
			</div>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="pull-left">
					
				  <button type="button" class="btn btn-primary" ng-click="newApp()" style="text-shadow: black 5px 3px 3px;"> 新增 <span class="glyphicon glyphicon-plus"></span> </button>
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
			                <th>名称</th>
			                <th>门ID</th>
			                <th>锁地址</th>
			                <th>设备</th>
				            <th>是否锁</th>
				           <th>锁状态</th>
				           <th>上次更新时间</th>
				           <th>流水行号</th>
                            <th class="per8 text-center">编辑</th>
							<th class="per8 text-center">删除</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in list" class="quanxian-bg-hover">
						<td>{{$index + 1}}</td>
						<td>{{item.lockName}}</td>
						<td>{{item.doorId}}</td>
						<td>{{item.lockAddr}}</td>
						<td>{{deviceMap[item.devId]}}</td>
						<td>
							<font ng-if="item.lockFlag=='0'">否</font>
							<font ng-if="item.lockFlag=='1'">是</font>
						</td>
						<td>
							<font ng-if="item.lockStatus=='0'">否</font>
							<font ng-if="item.lockStatus=='1'">是</font>
							<font ng-if="item.lockStatus=='2'">是1</font>
						</td>
	                      	<td>{{item.lastUpdate}}</td>
							<td>{{item.waterNo }}</td>
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
	<div cs-window show="flag" autoCenter="true" offset="offset" style="width:450px" title="'锁'">
		<div>
			<form class="form-horizontal group-border w5c-form hover-stripped" role="form" w5c-form-validate="validateOptions" novalidate name="form" >
				        <div  ng-show="modelAdd" class="form-group">
	                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">锁ID</label>
	                        <div ng-if="modelAdd" class="col-lg-10 col-md-10">
	                            <input name="lockId" maxlength="30" required="required"  class="form-control" type="text" ng-model="app.lockId" ng-show="modelAdd" placeholder="">
	                        </div>
	            		</div>
				        <div class="form-group">
				        <label class="col-lg-2 col-md-2 col-sm-12 control-label">锁名称</label>
				           <div class="col-lg-10 col-md-10">
				               <input name="lockName" id="lockName" maxlength="30" required="required" class="form-control" type="text" ng-model="app.lockName"  >
				           </div>
				       </div>
				       <div class="form-group">
				       <label class="col-lg-2 col-md-2 col-sm-12 control-label">门ID</label>
				           <div class="col-lg-10 col-md-10">
				               <input name="doorId" id="doorId" maxlength="30" class="form-control" type="text" ng-model="app.doorId"  >
				           </div>
				       </div>
				       <div class="form-group">
				       <label class="col-lg-2 col-md-2 col-sm-12 control-label">锁地址</label>
				           <div class="col-lg-10 col-md-10">
				               <input name="lockAddr" id="lockAddr" maxlength="30" class="form-control" type="text" ng-model="app.lockAddr"  >
				           </div>
				       </div>
				       <div class="form-group">
				       	<label class="col-lg-2 col-md-2 col-sm-12 control-label">设备ID</label>
				        <div class="col-lg-10 col-md-10">
				        	<div class="col-lg-10 col-md-10">
			                    <select name="devId"  class="form-control" required="required" ng-model="app.devId">
								<option ng-repeat="x in deviceList" value="{{x.id}}">{{x.mc}}</option>
								</select>
			                   </div>
                       	</div>
                       </div>
	                    <div class="form-group">
	                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">楼层</label>
	                        <div class="col-lg-10 col-md-10">
	                            <input name="floorId" id="floorId" maxlength="30" class="form-control" type="text" ng-model="app.floorId"  >
				           </div>
				       </div>
				       <div class="form-group">
				       	<label class="col-lg-2 col-md-2 col-sm-12 control-label">是否锁</label>
				           <div class="col-lg-10 col-md-10">
				           	<select class="form-control" name="lockFlag"  ng-model="app.lockFlag">
								<option ng-repeat="x in lockFlagList" value="{{x.id}}">{{x.mc}}</option>
							</select>
				           </div>
				        </div>
                    <div class="form-group">
                    	<label class="col-lg-2 col-md-2 col-sm-12 control-label">锁MEMO</label>
                        	<div class="col-lg-10 col-md-10">
                            	<input name="lockMemo" maxlength="30" class="form-control" type="text" ng-model="app.lockMemo"  >
           					</div>
       				</div>
			       <div class="form-group">
			       <label class="col-lg-2 col-md-2 col-sm-12 control-label">锁状态</label>
			       
			           <div class="col-lg-10 col-md-10">
			           <select class="form-control" name="lockStatus" ng-model="app.lockStatus">
								<option ng-repeat="x in lockStatusList" value="{{x.id}}">{{x.mc}}</option>
							</select>
			           </div>
			       </div>
			       <div class="form-group">
       				<label class="col-lg-2 col-md-2 col-sm-12 control-label">流水行号</label>
           				<div class="col-lg-10 col-md-10">
               				<input name="waterNo" id="waterNo" maxlength="30" class="form-control" type="text" ng-model="app.waterNo"  >
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