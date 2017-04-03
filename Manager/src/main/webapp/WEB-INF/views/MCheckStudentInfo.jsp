<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SKF Management Info</title>
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
		var StudnetList=${StudnetList};
		//var data=$.parseJSON(StudnetList);
		$('#searchTable').datagrid({loadFilter:pagerFilter}).datagrid('loadData', StudnetList); 
		});
		
		function operate(value, row, index) {
	        return '<a href="#" onclick="editUser('+index+')">Update</a>';
	    }
		function editUser(index) {
	        $('#searchTable').datagrid('selectRow', index);
	        var row = $('#searchTable').datagrid('getSelected');
	        if (row){
	            $('#dlg').dialog('open').dialog('setTitle','Edit Student Information');
	            $('#fm').form('load',row);
	           // url = '';
	        }
	    }
		
		 function del(index){   
	            $.messager.confirm('confirm','Do you want to delete?',function(row){  
	                if(row){  
	                    var selectedRow = $('#toolbar').datagrid('getSelected');   
	                    $.ajax({  
	                        url:'delHandler.ashx?id='+selectedRow.xsbh+'&type=stu',    
						 
	                        success:function(){alert('Success!');}  
	                    });  
	                    $('#toolbar').datagrid('deleteRow',index);  
	                }  
	            })  
	          }  
		</script>
		
	</head>
	<body>
		
		
      
			<div id="search" style="margin-top: 10%;">
				
				<div id="toolbar" style="font-weight: bold;font-size:20px">
			<!-- 	onclick+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			        <a href="javascript:void(0)" id="delete" class="easyui-linkbutton" style="width: auto;" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove student information</a>
			    </div>
				
				<table id="searchTable"  style="width:auto;height:auto" data-options="pagination:true,fitColumns:true,singleSelect:true,collapsible:true,scrollbarSize:0,pageSize:10,method:'get'">
				<thead>
				<tr>
				<th data-options="field:'stuNum',width:130,align:'center'">Student ID</th>
				<th data-options="field:'stuFname',width:130,align:'center'">First name</th>
				<th data-options="field:'stuLname',width:130,align:'center'">Last name</th>
				<th data-options="field:'stuInitial',width:130,align:'center'">Initial</th>
				<th data-options="field:'stuDob',width:130,align:'center'">Date of birth</th>
				<th data-options="field:'stuMobileNum',width:130,align:'center'">Mobile</th>
				<th data-options="field:'stuEmail',width:130,align:'center'">Email</th>
				<th data-options="field:'stuAddress',width:130,align:'center'">Address</th>
				<th data-options="field:'_operate',align:'center',width:85, formatter:operate">Update</th>
				</tr>
				</thead>
			</table>
						
						
						<div id="dlg" class="easyui-dialog" style="width:auto;height:auto; padding: 10px 20px" closed="true" buttons="#dlg-buttons">
			
			<div class="ftitle">User Information</div>
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>Student ID: </label> <input name="stuNum" class="easyui-textbox" required="true">
				</div>
				<div class="fitem">
					<label>First Name: </label> <input name="stuFname" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Last Name: </label> <input name="stuLname" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Initial: </label> <input name="stuInitial" class="easyui-textbox">
				</div>
				<div class="fitem">
					<label>Date of birth: </label> <input name="stuDob" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Mobile: </label> <input name="stuMobileNum" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Email: </label> <input name="stuEmail" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>Address: </label> <input name="stuAddress" class="easyui-textbox" >
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
