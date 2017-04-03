<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SKF Management Class Info</title>
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
		<link rel="stylesheet" type="text/css" href="css/icon.css">
		<link rel="stylesheet" type="text/css" href="css/demo.css">
		<link rel="stylesheet" type="text/css" href="css/flexslider.css" />
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
		<script type="text/javascript" src="js/StudentNavigation.js"></script>

		
		<style type="text/css">
			body{
				display: block;
			}
			
			
			
			
		</style>

		
		<link rel="stylesheet" href="css/menubar.css" type="text/css" media="screen" />
		<script type="text/javascript">
		function pagerFilter(data){
			var searchTable = $(this);
	            var opts = searchTable.datagrid('options');
	            var pager = searchTable.datagrid('getPager');
	            pager.pagination({
	                onSelectPage:function(pageNum, pageSize){
	                    opts.pageNumber = pageNum;
	                    opts.pageSize = pageSize;
	                    pager.pagination('refresh',{
	                        pageNumber:pageNum,
	                        pageSize:pageSize
	                    });
	                    searchTable.datagrid('loadData',data);
	                }
	            });
	            if (!data.originalRows){
	                data.originalRows = (data.rows);
	            }
	            var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
	            var end = start + parseInt(opts.pageSize);
	            data.rows = (data.originalRows.slice(start, end));
	            return data;
	           }
		
		$(window)
		.load(
		function(){
		var ClassList=${ClassList};
		//var data=$.parseJSON(StudnetList);
		$('#searchTable').datagrid('loadData', ClassList); 
		});
		</script>
		
	</head>
	<body>
		
		
      
			<div id="search" style="margin-top: 10%;">
				
				<div id="toolbar" style="font-weight: bold;font-size:20px">
			    </div>
							<table id="searchTable" class="easyui-datagrid" style="width:auto;height:auto" data-options="pagination:true,fitColumns:true,singleSelect:true,collapsible:true,scrollbarSize:0,method:'get'">
							<thead>
							<tr>
							<th data-options="field:'classId',width:130,align:'center'">Class ID</th>
							<th data-options="field:'classRoom',width:130,align:'center'">Class room</th>
							<th data-options="field:'classWeekday',width:130,align:'center'">Weekday</th>
							<th data-options="field:'classStartTime',width:130,align:'center'">Start time</th>
							<th data-options="field:'classEndTime',width:130,align:'center'">End time</th>
							<th data-options="field:'classLevel',width:130,align:'center'">Class level</th>
							<th data-options="field:'classInstructor',width:130,align:'center'">Instructor</th>
							</tr>
							</thead>
						</table>
						
						<div id="dlg" class="easyui-dialog" style="width:auto;height:auto; padding: 10px 20px" closed="true" buttons="#dlg-buttons">
			
			<div class="ftitle" style="font-size: 20px;color: #666666;">Class Information</div>
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>Class ID: </label> <input name="classId" class="easyui-textbox" required="true">
				</div>
				<div class="fitem">
					<label>Class room: </label> <input name="classRoom" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Weekday: </label> <input name="classWeekday" class="easyui-textbox">
				</div>
				<div class="fitem">
					<label>Start time: </label> <input name="classStartTime" class="easyui-textbox">
				</div>
				<div class="fitem">
					<label>End time: </label> <input name="classEndTime" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Class level: </label> <input name="classLevel" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Instructor: </label> <input name="classInstructor" class="easyui-textbox" >
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width: 90px">Save</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width: 90px">Cancel</a>
		</div>
			</div>
			
			
			
			
	</body>
</html>
