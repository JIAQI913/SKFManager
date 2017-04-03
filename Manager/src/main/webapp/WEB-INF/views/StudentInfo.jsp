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
		<script type="text/javascript" src="js/StudentNavigation.js"></script>

		
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
		$(window)
		.load(
				function() {
					document.getElementById('txt_FName').value="${STUDENT.stuFname}";
					document.getElementById('txt_LName').value="${STUDENT.stuLname}";
					document.getElementById('txt_Initial').value="${STUDENT.stuInitial}";
					document.getElementById('txt_DOB').value="${STUDENT.stuDob}";
					document.getElementById('txt_PhoneNum').value="${STUDENT.stuMobileNum}";
					document.getElementById('txt_Email').value="${STUDENT.stuEmail}";
					document.getElementById('txt_Address').value="${STUDENT.stuAddress}";
				});
			function clickHandler(){
				var txt_input = document.getElementsByClassName("txt_input");
				for(var i=0; i<txt_input.length;i++){
					txt_input[i].readOnly=false;
				}
			}
			
			function update(){
				var student={
						stuFname: document.getElementById('txt_FName').value,
						stuLname: document.getElementById('txt_LName').value,
						stuInitial: document.getElementById('txt_Initial').value,
						stuDob: document.getElementById('txt_DOB').value,
						stuMobileNum: document.getElementById('txt_PhoneNum').value,
						stuEmail: document.getElementById('txt_Email').value,
						stuAddress: document.getElementById('txt_Address').value
						};
				$.ajax({
					type : "post",
					url: "/Manager/changeStudent",
					dataType : "text",
					async : false,
					contentType : "application/json",
					data : JSON.stringify(student),
					success : function(data){
						alert(data);
						//window.location.href = "/Manager/get"+data;
						},
						error: function() {
							alert("Failed");
						}
					});
				}
		</script>
		<link rel="stylesheet" href="css/menubar.css" type="text/css" media="screen" />
	</head>
	<body>
		
		<div id="container">
			
			
					
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
                                         <td align="center">
                                                <input id="btn_changeStudent" type="button" value="Change" onclick="clickHandler()"/>
                                         </td>
                                         <td align="center">
                                                <input id="btn_updateStudent" type="submit" value="Update" onclick="update()"/>
                                         </td>
                                  </tr>
								</table>
								
							</div>		
						</form>
					</div>
					
					
						
				
			
			
	</body>
</html>
