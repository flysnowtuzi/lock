<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<section>
	<!--左侧导航结束-->
	<!--右侧内容开始-->
	<div class="shuju-con-right">
		<!--右侧头部开始-->
		<div class="shuju-right-title clearfix">
			<div class="shuju-title-left">
				<h3>锁用户管理</h3>
			</div>
		</div>
		  	
		<div class="panel-body">
			<div class="row">
				 <div class="pull-left">
					
					  <button type="button" class="btn btn-primary" ng-click="newApp()" style="text-shadow: black 5px 3px 3px;"> 按卡号新增 <span class="glyphicon glyphicon-plus"></span> </button>
					  <button type="button" class="btn btn-primary" ng-click="newApp1()" style="text-shadow: black 5px 3px 3px;">  按学号新增 <span class="glyphicon glyphicon-plus"></span> </button>
					  <button type="button" class="btn btn-primary" ng-click="newApp2()" style="text-shadow: black 5px 3px 3px;">  末班导入新增 <span class="glyphicon glyphicon-plus"></span> </button>
			
				</div> 
				 <div class="col-lg-3 col-md-4 col-sm-5 col-xs-6 pull-right">
				<!--  <div class="input-group">
				 	<input type="text" class="form-control"  placeholder="学工号 精确匹配" ng-model="keyword['userId']">
				 </div> -->
				<div class="input-group">
					
					<input type="text" class="form-control"  placeholder="用户名称 模糊匹配" ng-model="keyword['userName']">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" ng-click="search();">
							<span class="glyphicon glyphicon-search" style="color: rgb(255, 140, 60);"></span>
						</button>
					</span>
				</div>
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
			                <th>门锁</th>
							<th>学工号</th>
							<th>姓名</th>
							<th>上次更新时间</th>
							<th>物理卡号</th>
							<th>开门方式</th>
							<th class="text-center">详情</th>
							<th class="text-center">删除</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in list" class="quanxian-bg-hover">
						<td>{{ $index + 1}}</td>
					    <td>{{lockMap[item.lockId]}}</td>
						<td>{{item.userId}}</td>
						<td>{{item.userName}}</td>
						<td>{{item.lastUpdate}}</td>
						<td>{{item.cardPhyid}}</td>
						<td>
							<font ng-if="item.openType=='1'">刷卡开锁</font>
							<font ng-if="item.openType=='2'">远程开锁</font>
						</td>
							
							<td class="text-center">
								<button type="button" ng-click="edit(item)" class="btn btn-default" title="详情">
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
	<div cs-window show="flag" autoCenter="true" offset="offset" style="width:700px" title="'命令'">
		<div>
			<form class="form-horizontal group-border w5c-form hover-stripped" role="form" w5c-form-validate="validateOptions" novalidate name="form" >
               
                <div class="form-group">
                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">ID</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.seqNo}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">锁</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{lockMap[app.lockId]}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">用户id</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.userId}}</label>
                        </div>
                    </div>
                    
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">用户名</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.userName}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">cardPhyid</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.cardPhyid}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">lockUserAddr</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.lockUserAddr}}</label>
                        </div>
                    </div>
                    
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">lockUserStatus</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.lockUserStatus}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">lockUserMemo</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.lockUserMemo}}</label>
                        </div>
                    </div>
                    
                     
                    <div class="form-group">
                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">lastUpdate</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.lastUpdate}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">openType</label>
                        <div class="col-lg-10 col-md-10">
                        <label ng-if="app.openType" style="margin-top:7px;">
                        	<font ng-if="app.openType=='1'">刷卡开锁</font>
							<font ng-if="app.openType=='2'">远程开锁</font>
                         </label>
                        
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">validFrom</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.validFrom}}</label>
                        </div>
                    </div>
                    
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">validTo</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.validTo}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">部门id</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.deptId}}</label>
                        </div>
                    </div>
                    
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">部门名</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{app.deptName}}</label>
                        </div>
                    </div>
          </form>
		</div>	
		   
		</div>
	
</section>