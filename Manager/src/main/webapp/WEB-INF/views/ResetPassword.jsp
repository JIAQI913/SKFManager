<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SKF Management ResetPassword</title>
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
		<link rel="stylesheet" type="text/css" href="css/icon.css">
		<link rel="stylesheet" type="text/css" href="css/demo.css">
		<link rel="stylesheet" type="text/css" href="css/flexslider.css" />
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
		<script language="JavaScript" type="text/javascript">
                     $.extend($.fn.validatebox.defaults.rules, { 
                       equalTo: {
                         validator:function(value,param){
                           return $(param[0]).val() == value;
                         },
                         message:'Mismatch'
                       }
                            
                     });
					function changePassword(){
						$.ajax({
							type: "get",
							url: "/Manager/changePassword?password="+$("#password").val()+"&oldPassword="+$("#oldpassword").val(),
							dateType: "text",
							success: function(data){
								alert(data);
								window.location.href = "/Manager/get"+data;
								},
							error: function(){
								alert("Failed")
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
							<td align="right"/>Old Password: 
							<td><input class="easyui-validatebox" type="password" required="true" id="oldpassword" />
						</tr>
						<tr>
							<td align="right"/>New Password: 
							<td><input id="password" name="password" validType="length[4,32]" class="easyui-validatebox" required="true" type="password" value=""/>
						</tr>
						<tr>
							<td align="right"/>Confirm Password: 
							<td><input type="password" name="repassword" id="repassword" required="true" class="easyui-validatebox" validType="equalTo['#password']" invalidMessage="Please input the same password"/>
						</tr>
						<tr>
							<td colspan="2">
								<div id="warning" style="color:red;visibility:hidden;">Please input the same new password!</div>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>
								<span ><input class="searchtext" name="submit" type="submit" value="Reset" onclick="changePassword()" /></span>
								
								
						</tr>
				  	</table>
		</div>
			

		</div>		
	</body>
</html>
