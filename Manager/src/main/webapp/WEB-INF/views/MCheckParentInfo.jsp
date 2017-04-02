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
		$(window)
		.load(
		function(){
		var ParentList=${ParentList};
		//var data=$.parseJSON(StudnetList);
		$('#searchTable').datagrid('loadData', ParentList); 
		});
		</script>
		
	</head>
	<body>
		
		
      
			<div id="search" style="margin-top: 10%;">
				
							<table id="searchTable" class="easyui-datagrid" style="width:auto;height:150px" data-options="fitColumns:true,singleSelect:true,collapsible:true,scrollbarSize:0,method:'get'">
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
							</tr>
							</thead>
						</table>
			</div>
			
			
			
			
	</body>
</html>
