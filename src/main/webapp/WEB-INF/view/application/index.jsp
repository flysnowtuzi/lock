<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<section>
	<!--左侧导航结束-->
	<!--右侧内容开始-->
	<div class="shuju-con-right">
		<!--右侧头部开始-->
		<div class="shuju-right-title clearfix">
			<div class="shuju-title-left">
				<h3>应用管理</h3>
			</div>
		</div>
		<!--右侧头部结束-->
		<div cg-mul-query-comm source="mutiSource" result="conditions" noborder="true" class="quanxian-content"></div>

		<div class="panel-body">
			<div class="row">
				<div class="pull-left">
					
					<button type="button" class="btn btn-primary" ng-click="newApp()" style="text-shadow: black 5px 3px 3px;">
  新增 <span class="glyphicon glyphicon-plus"></span> 
</button>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-5 col-xs-6 pull-right">
				<div class="input-group">
					<input type="text" class="form-control"  placeholder="计划名称 模糊匹配" ng-model="keyword['projectName']">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" ng-click="search();">
							<span class="glyphicon glyphicon-search" style="color: rgb(255, 140, 60);"></span>
						</button>
					</span>
				</div><!-- /input-group -->
			</div>
			
			</div>
		</div>


		<div class="content">
			<div class="table-responsive">
				
				<!--表格 -->
				<table class="table   table-hover">
					<thead>
						<tr class="success">
							<th class="per28">应用名称</th>
							<th class="per12">应用类型类型</th>
							<th class="per8">APP_ID</th>
							<th class="per30">应用介绍</th>
							<th class="per6 text-center">启动/停止</th>
							<th class="per8 text-center">编辑</th>
							<th class="per8 text-center">删除</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in list" class="quanxian-bg-hover">
							<td>{{item.projectName}}</td>
							<td>{{appIfTypeCode[item.appType]}}</td>
							<td>{{item.appId}}</td>
							<td>{{item.projectDes}}</td>
							<td ng-if="item.isUseable=='01'" class="text-center">
								<button type="button" ng-click="isUseable(item)" class="btn btn-default" title="当前 启动 状态，点击暂停">
									<span class="glyphicon glyphicon-pause"></span>
								</button>
							</td>
							<td ng-if="item.isUseable!='01'" class="text-center">
								<button type="button" ng-click="isUseable(item)" class="btn btn-default" title="当前 暂停 状态，点击启动">
									<span class="glyphicon glyphicon-play"></span>
								</button>

							</td>
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
	<div cs-window show="flag" autoCenter="true" offset="offset" style="width:450px" title="'应用'">
		<div>
			<form class="form-horizontal group-border w5c-form hover-stripped" role="form" w5c-form-validate="validateOptions" novalidate name="form" >
               <div class="form-group">
                  <label class="col-lg-3 col-md-3 col-sm-12 control-label">应用名称</label>
                     <div class="col-lg-9 col-md-9">
                        <input type="text" class="form-control" required="required" name="projectName" ng-model="app.projectName" placeholder="请输入应用名称" autofocus="autofocus">
                     </div>
                </div>  
                 <div class="form-group">
                  <label class="col-lg-3 col-md-3 col-sm-12 control-label">应用类型</label>
                     <div class="col-lg-9 col-md-9">
                      
                     <select name="appType"  class="form-control" required="required" ng-model="app.appType">
						<option ng-repeat="x in appIfTypeList" value="{{x.id}}">{{x.mc}}</option>
					</select>
                     </div>
                </div> 
                 <div class="form-group">
                  <label class="col-lg-3 col-md-3 col-sm-12 control-label">APP_ID</label>
                     <div class="col-lg-9 col-md-9">
                        <input type="number" class="form-control" name="appId" placeholder="请输入APP_ID" ng-model="app.appId" min="1" max="100" >
                         
                     </div>
                    
                </div>  
                 <div class="form-group">
                  <label class="col-lg-3 col-md-3 col-sm-12 control-label">访问地址</label>
                     <div class="col-lg-9 col-md-9">
                        <input type="url" class="form-control"  name="appUrl" placeholder="请输入应用的访问地址" ng-model="app.appUrl" >
                     </div>
                </div>
                 <div class="form-group">
                  <label class="col-lg-3 col-md-3 col-sm-12 control-label">使用部门</label>
                     <div class="col-lg-9 col-md-9">
                        <input type="text" class="form-control"  name="operDept" placeholder="请输入该应用的使用部门" ng-model="app.operDept">
                     </div>
                </div> 
                  <div class="form-group">
                  <label class="col-lg-3 col-md-3 col-sm-12 control-label">部门电话</label>
                     <div class="col-lg-9 col-md-9">
                        <input type="text" class="form-control"  name="deptPhone" placeholder="请输入使用部门的电话" ng-model="app.deptPhone">
                     </div>
                </div> 
                 <div class="form-group">
                  <label class="col-lg-3 col-md-3 col-sm-12 control-label">是否可用</label>
                     <div class="col-lg-9 col-md-9">
                        
                     
                        <div class="btn-group">
             <label class="btn btn-primary" name="isUseable" ng-model="app.isUseable" uib-btn-radio="'01'">启用</label>
             <label class="btn btn-primary" name="isUseable" ng-model="app.isUseable" uib-btn-radio="'02'">停用</label>
             
         </div>  
        			<!-- <label class="radio-inline">
                           <input type="radio"  name="isUseable" ng-model="app.isUseable" value="'01'">启用
                     </label>
                     <label class="radio-inline">
                           <input type="radio"  name="isUseable" ng-model="app.isUseable" value="'02'" >停止
                     </label>
                           -->                 
                     </div> 
                </div> 
                  <div class="form-group">
                  <label class="col-lg-3 col-md-3 col-sm-12 control-label">应用安全码</label>
                     <div class="col-lg-9 col-md-9">
                        <input type="text" class="form-control"  name="appSecret" placeholder="请输入应用安全码" ng-model="app.appSecret">
                     </div>
                </div> 
                 <div class="form-group">
                  <label class="col-lg-3 col-md-3 col-sm-12 control-label">应用描述</label>
                     <div class="col-lg-9 col-md-9">
                        <input type="text" class="form-control" name="projectDes" placeholder="请输入应用描述" ng-model="app.projectDes" ng-maxlength="20">
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