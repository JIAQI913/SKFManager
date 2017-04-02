<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SKF Management Rank Info</title>
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
		var RankList=${RankList};
		//var data=$.parseJSON(StudnetList);
		$('#searchTable').datagrid('loadData', RankList); 
		});
		</script>
		
	</head>
	<body>
		
		
      
			<div id="search" style="margin-top: 10%;">
				
							<table id="searchTable" class="easyui-datagrid" style="width:auto;height:150px" data-options="fitColumns:true,singleSelect:true,collapsible:true,scrollbarSize:0,method:'get'">
							<thead>
							<tr>
							<th data-options="field:'rankNum',width:130,align:'center'">Rank Number</th>
							<th data-options="field:'rankBelt',width:130,align:'center'">Rank belt</th>
							<th data-options="field:'reqNum',width:130,align:'center',hidden:true">Requirement Number</th>
							<th data-options="field:'reqDescript',width:130,align:'center'">Description</th>
							<th data-options="field:'rankTestTime',width:130,align:'center'">Test time</th>
							</tr>
							</thead>
						</table>
			</div>
			
			
			
			
	</body>
</html>
