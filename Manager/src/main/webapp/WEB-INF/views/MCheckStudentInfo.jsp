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
		</script>
		
	</head>
	<body>
		
		
      
			<div id="search" style="margin-top: 10%;">
				
							<table id="searchTable"  style="width:auto;height:308.5px" data-options="pagination:true,fitColumns:true,singleSelect:true,collapsible:true,scrollbarSize:0,pageSize:10,method:'get'">
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
							</tr>
							</thead>
						</table>
			</div>
			
			
			
			
	</body>
</html>
