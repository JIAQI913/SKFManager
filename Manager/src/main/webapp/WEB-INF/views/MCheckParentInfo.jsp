<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SKF Management Parent Info</title>
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
		<link rel="stylesheet" type="text/css" href="css/icon.css">
		<link rel="stylesheet" type="text/css" href="css/demo.css">
		<link rel="stylesheet" type="text/css" href="css/flexslider.css" />
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
		<script type="text/javascript" src="js/ManagerNavigation.js"></script>

		
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
		var ParentList=${ParentList};
		//var data=$.parseJSON(StudnetList);
		$('#searchTable').datagrid('loadData', ParentList); 
		});

		function operate(value, row, index) {
	        return '<a href="#" onclick="editUser('+index+')">Update</a>';
	    }
		function editUser(index) {
	        $('#searchTable').datagrid('selectRow', index);
	        var row = $('#searchTable').datagrid('getSelected');
	        if (row){
	            $('#dlg').dialog('open').dialog('setTitle','Edit Parent Information');
	            $('#fm').form('load',row);
	           // url = '';
	        }
	    }
		</script>
		
	</head>
	<body>
		
		
      
			<div id="search" style="margin-top: 10%;">
				<div id="toolbar" style="font-weight: bold;font-size:20px">
			<!-- 	onclick+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			        <a href="javascript:void(0)" id="delete" class="easyui-linkbutton" style="width: auto;" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove class information</a>
			    </div>
							<table id="searchTable" class="easyui-datagrid" style="width:auto;height:auto" data-options="pagination:true,fitColumns:true,singleSelect:true,collapsible:true,scrollbarSize:0,method:'get'">
							<thead>
							<tr>
							<th data-options="field:'parNum',width:130,align:'center'">Parent ID</th>
							<th data-options="field:'stuNum',width:130,align:'center'">Student ID</th>
							<th data-options="field:'parRelation',width:130,align:'center'">Relation</th>
							<th data-options="field:'parMobileNum',width:130,align:'center'">Mobile</th>
							<th data-options="field:'parEmail',width:130,align:'center'">Email</th>
							<th data-options="field:'parFname',width:130,align:'center'">First Name</th>
							<th data-options="field:'parLname',width:130,align:'center'">Last Name</th>
							<th data-options="field:'parInitial',width:130,align:'center'">Initial</th>
							<th data-options="field:'_operate',align:'center',width:85, formatter:operate">Update</th>
							</tr>
							</thead>
						</table>
						
						<div id="dlg" class="easyui-dialog" style="width:auto;height:auto; padding: 10px 20px" closed="true" buttons="#dlg-buttons">
			
			<div class="ftitle" style="font-size: 20px;color: #666666;">Class Information</div>
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>Parent ID: </label> <input name="parNum" class="easyui-textbox" required="true">
				</div>
				<div class="fitem">
					<label>Student ID: </label> <input name="stuNum" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Relation: </label> <input name="parRelation" class="easyui-textbox">
				</div>
				<div class="fitem">
					<label>Mobile: </label> <input name="parMobileNum" class="easyui-textbox">
				</div>
				<div class="fitem">
					<label>Email: </label> <input name="parEmail" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Parent first name: </label> <input name="parFname" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Parent last name: </label> <input name="parLname" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Initial: </label> <input name="parInitial" class="easyui-textbox" >
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
