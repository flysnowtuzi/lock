<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<section>
	<!--左侧导航结束-->
	<!--右侧内容开始-->
	<div class="shuju-con-right">
		<!--右侧头部开始-->
		<div class="shuju-right-title clearfix">
			<div class="shuju-title-left">
				<h3>命令管理</h3>
			</div>
		</div>
		<!--右侧头部结束-->
		<div cg-mul-query-comm source="mutiSource" result="conditions" noborder="true" class="quanxian-content"></div>

		<div class="panel-body">
			<div class="row">
				<!-- <div class="pull-left">
					
					<button type="button" class="btn btn-primary" ng-click="newApp()" style="text-shadow: black 5px 3px 3px;">
  新增 <span class="glyphicon glyphicon-plus"></span> 
</button>
				</div> -->
				<!--  <div class="col-lg-3 col-md-4 col-sm-5 col-xs-6 pull-right">
				<div class="input-group">
					<input type="text" class="form-control"  placeholder="序列号 模糊匹配" ng-model="keyword['seqNo']">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" ng-click="search();">
							<span class="glyphicon glyphicon-search" style="color: rgb(255, 140, 60);"></span>
						</button>
					</span>
				</div>
			</div> 
			 -->
			</div>
		</div>


		<div class="content">
			<div class="table-responsive">
				
				<!--表格 -->
				<table class="table   table-hover">
					<thead>
						<tr class="success">
							<th>行号</th>
							<th>设备ip</th>
	                         <th>设备</th>
	                        <th>事件</th>
	                        <th>锁</th>
	                        <th>CMD_FLAG</th>
	                        <th>TIME_CREATE</th>
	                        <!-- <th>RTN</th> -->
	                        <th>LOCK_USER_SEQ</th>
							<th class="per8 text-center">编辑</th>
							<th class="per8 text-center">再次执行</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in list" class="quanxian-bg-hover">
						<td>{{ $index + 1}}</td>
					     <td>{{item.devIp}}</td>
					     <td>{{deviceMap[item.devId]}}</td>
					     <td>{{eventMap[item.eventId]}}({{item.eventId}})</td>
					     <td>{{lockMap[item.lockId]}}</td>
					     <td >
					     	<font ng-if="item.cmdFlag=='0'">未执行</font>
					     	<font ng-if="item.cmdFlag=='1'">成功</font>
					     	<font ng-if="item.cmdFlag=='2'">失败</font>
					     	<font ng-if="item.cmdFlag=='3'">超时</font>
					     </td>
					     <td>{{item.timeCreate}}</td>
					     <!-- <td>{{item.rtn}}</td> -->
					     <td>
					     <a ng-if="item.lockUserSeq!='N/A'" ng-click="edit2(item.user)" href="JavaScript:0" target="navTab">锁用户</a>
					     </td>
							
							<td class="text-center">
								<button type="button" ng-click="edit(item)" class="btn btn-default" title="详情">
									<span class="glyphicon glyphicon-edit"></span>
								</button>

							</td>
							<td class="text-center">
								<button type="button" ng-click="do(item)" class="btn btn-default" title="再次执行">
									<span class="glyphicon glyphicon-play"></span>
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
	<div cs-window show="flag" autoCenter="true" offset="offset" style="width:650px" title="'命令'">
		<div ng-if="flag1">
			<form class="form-horizontal group-border w5c-form hover-stripped" role="form" w5c-form-validate="validateOptions" novalidate name="form" >
               
                <div class="form-group">
                         <label class="col-lg-2 col-md-2 col-sm-12 control-label">命令ID</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.seqNo}}</label>
                         </div>
                     </div>
                    <!--  <div class="form-group">
                         <label class="col-lg-2 col-md-2 col-sm-12 control-label">设备ID</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.devId}}</label>
                         </div>
                     </div> -->
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">设备名称</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{deviceMap[app.devId]}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">cmdPlain</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.cmdPlain}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">cmdCipher</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.cmdCipher}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">timeCreate</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.timeCreate}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">rtnPlain</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.rtnPlain}}</label>
                         </div>
                     </div> 
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">rtnCipher</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.rtnCipher}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">timeCost</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.timeCost}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">cmdFlag</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.cmdFlag}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">事件</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{eventMap[app.eventId]}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">cmdStatus</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.cmdStatus}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">lockAddr</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.lockAddr}}</label>
                         </div>
                     </div> 
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">timeDownload</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.timeDownload}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">timeReturn</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.timeReturn}}</label>
                         </div>
                     </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">锁</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.lockName}}</label>
                         </div>
                     </div>
                     
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">rtn</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.rtn}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">lockUserSeq</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.lockUserSeq}}</label>
                         </div>
                     </div>
          </form>
		</div>	
		   <div ng-if="flag2">
			<form class="form-horizontal group-border w5c-form hover-stripped" role="form" w5c-form-validate="validateOptions" novalidate name="form" >
               
                <div class="form-group">
                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">ID</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.seqNo}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">锁</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{lockMap[user.lockId]}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">用户id</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.userId}}</label>
                        </div>
                    </div>
                    
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">用户名</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.userName}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">cardPhyid</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.cardPhyid}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">lockUserAddr</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.lockUserAddr}}</label>
                        </div>
                    </div>
                    
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">lockUserStatus</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.lockUserStatus}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">lockUserMemo</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.lockUserMemo}}</label>
                        </div>
                    </div>
                    
                     
                    <div class="form-group">
                        <label class="col-lg-2 col-md-2 col-sm-12 control-label">lastUpdate</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.lastUpdate}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">openType</label>
                        <div class="col-lg-10 col-md-10">
                        <label ng-if="user.openType" style="margin-top:7px;">
                        	<font ng-if="user.openType=='1'">刷卡开锁</font>
							<font ng-if="user.openType=='2'">远程开锁</font>
                         </label>
                        
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">validFrom</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.validFrom}}</label>
                        </div>
                    </div>
                    
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">validTo</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.validTo}}</label>
                        </div>
                    </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">部门id</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.deptId}}</label>
                        </div>
                    </div>
                    
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">部门名</label>
                        <div class="col-lg-10 col-md-10">
                        <label style="margin-top:7px;"> {{user.deptName}}</label>
                        </div>
                    </div>
          </form>
		</div>
		</div>
	
</section>