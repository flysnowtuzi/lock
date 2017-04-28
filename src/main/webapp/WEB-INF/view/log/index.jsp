<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<section>
	<!--左侧导航结束-->
	<!--右侧内容开始-->
	<div class="shuju-con-right">
		<!--右侧头部开始-->
		<div class="shuju-right-title clearfix">
			<div class="shuju-title-left">
				<h3>日志查询</h3>
			</div>
		</div>
		<!--右侧头部结束-->
		<div cg-mul-query-comm source="mutiSource" result="conditions" noborder="true" class="quanxian-content"></div>

		<div class="panel-body">
			<div class="row">
			</div>
		</div>


		<div class="content">
			<div class="table-responsive">
				
				<!--表格 -->
				<table class="table   table-hover">
					<thead>
						<tr class="success">
							<th>行号</th>
							<th>event id</th>
	                         <th>信息</th>
	                        <th>级别</th>
	                        <th>时间</th>
							<th class="per8 text-center">详情</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in list" class="quanxian-bg-hover">
						<td>{{ $index + 1}}</td>
					     <td>{{item.eventId}}</td>
					     <td>{{item.formattedMessage}}</td>
					     <td>({{item.levelString}})</td>
					     <td>{{item.timestmp}}</td>
							
							<td class="text-center">
								<button type="button" ng-click="edit(item)" class="btn btn-default" title="详情">
									<span class="glyphicon glyphicon-edit"></span>
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
	<div cs-window show="flag" autoCenter="true" offset="offset" style="width:650px" title="'日志'">
		<div>
			<form class="form-horizontal group-border w5c-form hover-stripped" role="form" w5c-form-validate="validateOptions" novalidate name="form" >
               
                <div class="form-group">
                         <label class="col-lg-2 col-md-2 col-sm-12 control-label">eventId</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.eventId}}</label>
                         </div>
                     </div>
                    <!--  <div class="form-group">
                         <label class="col-lg-2 col-md-2 col-sm-12 control-label">设备ID</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.devId}}</label>
                         </div>
                     </div> -->
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">timestmp</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.timestmp}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">信息</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.formattedMessage}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">loggerName</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.loggerName}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">levelString</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.levelString}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">threadName</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.threadName}}</label>
                         </div>
                     </div> 
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">referenceFlag</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.referenceFlag}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">arg0</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.arg0}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">arg1</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.arg1}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">arg2</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.arg2}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">arg3</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.arg3}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">callerFilename</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.callerFilename}}</label>
                         </div>
                     </div> 
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">callerClass</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.callerClass}}</label>
                         </div>
                     </div>
                     <div class="form-group">
                     <label class="col-lg-2 col-md-2 col-sm-12 control-label">callerMethod</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.callerMethod}}</label>
                         </div>
                     </div>
                    <div class="form-group">
                    <label class="col-lg-2 col-md-2 col-sm-12 control-label">callerLine</label>
                         <div class="col-lg-10 col-md-10">
                         <label style="margin-top:7px;"> {{app.callerLine}}</label>
                         </div>
                     </div>
          </form>
		</div>	
		</div>
	
</section>