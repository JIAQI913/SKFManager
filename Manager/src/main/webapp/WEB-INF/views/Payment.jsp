<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SKF</title>
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
		<link rel="stylesheet" type="text/css" href="css/icon.css">
		<link rel="stylesheet" type="text/css" href="css/demo.css">
		<link rel="stylesheet" type="text/css" href="css/flexslider.css" />
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>

		
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
			$('input[type=button]').click(function () {
			  $('input[type=text]').removeAttr('readonly');
			})
		</script>

	</head>
	<body>
		<div id="container">
			<div id="head" align="left">
				<div >	<img src="img/logo.png" /></div>				
			</div>
			<div id="search" style="margin-top: 10%;">
				<div class="easyui-tabs" style="width:1080px;height:auto;color:#AAAAAA">
					<div title="Unpaid" style="margin: 20px">
						<form action="" method="post" id="searchForm" class="form">
							<div>
								<table align="center" style="font-size: 16px; font-family: 'comic sans ms'; fon" >
									<tr>
										<td align="right">First name: </td>
										<td>
											<input class="txt_input" id="txt_FName" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Last name: </td>
										<td>
											<input class="txt_input" id="txt_LName" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Initial: </td>
										<td>
											<input class="txt_input" id="txt_Initial" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Date of birth: </td>
										<td>
											<input class="txt_input" id="txt_DOB" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Phone number : </td>
										<td>
											<input class="txt_input" id="txt_PhoneNum" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Email: </td>
										<td>
											<input class="txt_input" id="txt_Email" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Address: </td>
										<td>
											<input class="txt_input" id="txt_Address" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td colspan="2" align="center">
											<input id="btn_updateStudent" type="button" value="Update" onclick="test()"/>
										</td>
									</tr>
								</table>
								
							</div>		
						</form>
					</div>
					<div title="Paid" style="margin: 20px">
						<form action="" method="post" id="searchForm" class="form">
							<div>
								<table align="center" style="font-size: 16px; font-family: 'comic sans ms'; fon" >
									<tr>
										<td align="right">Student name: </td>
										<td>
											<input id="txt_StudentName" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Parent First Name : </td>
										<td>
											<input id="LName" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Parent Last Name: </td>
										<td>
											<input id="LName" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Relation: </td>
										<td>
											<input id="txt_Relation" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Mobile: </td>
										<td>
											<input id="txt_ParentMobile" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td align="right">Email: </td>
										<td>
											<input id="txt_ParentEmail" type="text" readonly="true" />
										</td>
									</tr>
									<tr>
										<td colspan="2" align="center">
											<input id="btn_updateParents" type="submit" value="Update" onclick="test()"/>
										</td>
									</tr>
								</table>
								
							</div>		
						</form>
					</div>
					
						
				</div>
			</div>
			
			
			
			
	</body>
</html>
