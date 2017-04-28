<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<section>
	<!--左侧导航结束-->
	<!--右侧内容开始-->
	<div class="shuju-con-right">
		<!--右侧头部开始-->
		<div class="shuju-right-title clearfix">
			<div class="shuju-title-left">
				<h3>设备管理</h3>
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
	                        <th>类型</th>
	                    	<th>状态</th>
                    		<th>Ip</th>
                            <th class="per8 text-center">编辑</th>
							<th class="per8 text-center">删除</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in list" class="quanxian-bg-hover">
							<td>{{$index + 1}}</td>
							<td>{{item.devName}}</td>
				            <td>{{deviceTypeMap[item.devType]}}</td>
				            <td>{{item.devStatus}}</td>
				            <td>{{item.devIp}}</td>
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
	                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">设备ID</label>
	                        <div ng-if="modelAdd" class="col-lg-10 col-md-10">
	                            <input name="devId" maxlength="30" required="required"  class="form-control" type="text" ng-model="app.devId"  placeholder="">
	                        </div>
	            </div>
				<div class="form-group">
	                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">名称</label>
	                        <div class="col-lg-10 col-md-10">
	                            <input name="devName" class="form-control" maxlength="30" required="required" class="form-control" type="text" ng-model="app.devName"  >
	                        </div>
	                    </div>
	                    <div class="form-group">
	                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">BUILDING ID</label>
	                        <div class="col-lg-10 col-md-10">
	                            <input name="buildingId" class="form-control" maxlength="30" class="form-control" type="text" ng-model="app.buildingId"  >
	                        </div>
	                    </div>
	                    <div class="form-group">
	                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">BUILDING 名称</label>
	                        <div class="col-lg-10 col-md-10">
	                            <input name="buildingName" class="form-control" maxlength="30" class="form-control" type="text" ng-model="app.buildingName"  >
	                        </div>
	                    </div>
	                    <div class="form-group">
	                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">状态</label>
	                        <div class="col-lg-10 col-md-10">
	                            <input name="devStatus" class="form-control" maxlength="30" class="form-control" type="text" ng-model="app.devStatus"  >
	                        </div>
	                    </div>
	                    <div class="form-group">
	                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">memo</label>
	                        <div class="col-lg-10 col-md-10">
	                            <input name="devMemo" class="form-control" maxlength="30" class="form-control" type="text" ng-model="app.devMemo"  >
	                        </div>
	                    </div>
	                    <div class="form-group">
	                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">Ip</label>
	                        <div class="col-lg-10 col-md-10">
	                            <input name="devIp" class="form-control" maxlength="30" class="form-control" type="text" ng-model="app.devIp"  >
	                        </div>
	                    </div>
	                    <div class="form-group">
	                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">类型</label>
	                        <div class="col-lg-10 col-md-10">
                                <select name="devType"  class="form-control" required="required" ng-model="app.devType">
									<option ng-repeat="x in deviceTypeList" value="{{x.id}}">{{x.mc}}</option>
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