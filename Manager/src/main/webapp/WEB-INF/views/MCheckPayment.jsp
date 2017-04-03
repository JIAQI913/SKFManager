<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SKF Student Info</title>
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
				margin: 0;
				padding: 0;
				display: block;
			}
			#container{
				width: 1080px;
				margin: 0 auto;
			}
			#head
			{
				margin: 10px auto;
				width: 1080px;
			}
			#search{
				font: "arial black";
			}
			
			.searchtext{
				font-size: 20px;
				height:40px;
				width: 600px;
				padding: 0px 10px 0 10px;
				
			}
			
			.searchbutton{
				font-size: 20px;height:40px;
			}
			
			#banner{
				width: 1080px;
				margin: 0 auto;
			}
			
			#content{
				margin: 40px 0 auto;
				border: 10px;
				border-color: #FF0000;
				font-family: arial;
				font-size: 20px;
				line-height: 40px;
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
			var PayList=${PayList};
			//var data=$.parseJSON(StudnetList);
			$('#searchInvoiceTableStudent').datagrid({loadFilter:pagerFilter}).datagrid('loadData', PayList); 
			$('#searchInvoiceTableInvoice').datagrid({loadFilter:pagerFilter}).datagrid('loadData', PayList); 
		});
			function clickHandler(){
				var txt_input = document.getElementsByClassName("txt_input");
				for(var i=0; i<txt_input.length;i++){
					txt_input[i].readOnly=false;
				}
			}
			function clickHandler1(){
				var txt_upate = document.getElementsByClassName("txt_update");
				for(var i=0; i<txt_upate.length;i++){
					txt_upate[i].readOnly=false;
				}
			}
			function formatStuNum(val, rec){
				return val=rec.id.stuNum;
				}
			function formatInvNum(val, rec){
				return vla=rec.id.invNum;
				}
		</script>
		
	</head>
	<body>
		
		
			<div>
			<div id="search" style="margin-top: 10%;">
				<div class="easyui-tabs" style="width:1080px;height:auto;color:#AAAAAA">
					<div title="Invoice" style="margin: 20px">
						<form action="" method="post" id="searchForm" class="form">
							<div >
								<input type="text"  class="searchtext" placeholder="Search for Invoice number" name="search"/>
								<input type="submit" class="searchbutton"  value="Search"/>
							</div>		
						</form>

						<table id="searchInvoiceTableInvoice" class="easyui-datagrid" style="width:800px;height:308.5px;" data-options="pagination:true,fitColumns:true,singleSelect:true,collapsible:true,scrollbarSize:0,method:'get'">
							<thead>
							<tr>
							<th data-options="field:'stuNum', formatter:formatStuNum , width:160,align:'center'">Student ID</th>
							<th data-options="field:'invNum', formatter:formatInvNum, width:160,align:'center'">Invoice number</th>
							<th data-options="field:'payCreatTime',width:160,align:'center'">Create time</th>
							<th data-options="field:'payPayTime',width:160,align:'center'">Pay time</th>
							<th data-options="field:'payPrice',width:160,align:'center'">Price</th>
							</tr>
							</thead>
						</table>
					</div>
					<div title="Student" style="margin: 20px">
						<form action="" method="post" id="searchForm" class="form">
							<div >
								<input type="text"  class="searchtext" placeholder="Search for Student number" name="search"/>
								<input type="submit" class="searchbutton"  value="Search"/>
							</div>		
						</form>

						<table id="searchInvoiceTableStudent" class="easyui-datagrid" style="width:800px;height:308.5px;" data-options="pagination:true,fitColumns:true,singleSelect:true,collapsible:true,scrollbarSize:0,method:'get'">
							<thead>
							<tr>
							<th data-options="field:'stuNum', formatter:formatStuNum , width:160,align:'center'">Student ID</th>
							<th data-options="field:'invNum', formatter:formatInvNum, width:160,align:'center'">Invoice number</th>
							<th data-options="field:'payCreatTime',width:160,align:'center'">Create time</th>
							<th data-options="field:'payPayTime',width:160,align:'center'">Pay time</th>
							<th data-options="field:'payPrice',width:160,align:'center'">Price</th>
							</tr>
							</thead>
						</table>
					</div>
					
						
				</div>
			
			</div>
			
			
	</body>
</html>
