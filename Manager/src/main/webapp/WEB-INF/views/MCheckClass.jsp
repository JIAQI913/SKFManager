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
		var ClassList=${ClassList};
		//var data=$.parseJSON(StudnetList);
		$('#searchTable').datagrid('loadData', ClassList); 
		});
		</script>
		
	</head>
	<body>
		
		
      
			<div id="search" style="margin-top: 10%;">
				
							<table id="searchTable" class="easyui-datagrid" style="width:auto;height:150px" data-options="fitColumns:true,singleSelect:true,collapsible:true,scrollbarSize:0,method:'get'">
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
			</div>
			
			
			
			
	</body>
</html>
