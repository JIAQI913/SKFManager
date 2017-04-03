<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SKF Manager</title>
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
		<link rel="stylesheet" type="text/css" href="css/icon.css">
		<link rel="stylesheet" type="text/css" href="css/demo.css">
		<link rel="stylesheet" type="text/css" href="css/flexslider.css" />
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
		<script type="text/javascript">
		function login(){
			var user={userName : $("#username").val(), userPassword : $("#userpwd").val()};
				$.ajax({
					type : "post",
					url: "/Manager/getIndex",
					dataType : "text",
					contentType : "application/json",
					data : JSON.stringify(user),
					success : function(data){
						//alert(data);
						if(data=="Failed"){
								alert(data);
							}
						else{
							window.location.href = "/Manager/get"+data;
						}
						},
						error : function() {
							alert("Failed");
						}
					});
			}
		</script>
	</head>
	
	<style type="text/css">
			body{
				display: block;
			}
			#container{
				width: 1080px;
				margin: 0 auto;
			}

			
			#logo{

				margin: 100px auto;
				width: 1080px;
				
			}
			#search{
				font: "arial black";
			}
			
			.searchtext{
				font-size: 20px;
				margin:5px auto;				
			}
			
		</style>
	<body>
		
		<div id ="container">
			<div id ="logo" align="center">
				<img  src="img/logo.png" />
			</div>


			<div id="loginform" class="searchtext" style="margin: 100px auto;">
				  	<table align="center">
						<tr>
							<td align="right">ID: </td>
							<td><input class="easyui-validatebox" required="true" type="text" id="username" /></td>
						</tr>
						<tr>
							<td align="right">Password: </td>
							<td><input class="easyui-validatebox" required="true" type="password" id="userpwd" /></td>
						</tr>
						<tr>
								<!-- <td align="center"><input type="radio" name="license" value="Student">Student</td>
								<td align="center"><input type="radio" name="license" value="Administrator">Administrator</td> -->
						
						</tr>
						<tr height="20px"></tr>
						<tr>
							<td colspan="2" align="center">
							<input class="searchtext" name="submit" type="button" value="Login" onclick="login()" />
							</td>
						</tr>
				  	</table>
		</div>
			

		</div>		
	</body>
</html>
