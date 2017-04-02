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
			$(function() {
				$(".flexslider").flexslider({
					slideshowSpeed: 4000, //展示时间间隔ms
					animationSpeed: 400, //滚动时间ms
				});
		});	
		</script>

	</head>
	<body>
		<div id="container">
			<div id="head" align="left">
				<div >	<img src="img/logo.png" /></div>				
			</div>
			<div id="search">
				<div class="easyui-tabs" style="width:1080px;height:120px;color:#AAAAAA">
					<div title="Name" style="margin: 20px">
						<form action="" method="post" id="searchForm" class="form">
							<div >
								<input type="text"  class="searchtext" placeholder="Search for Game Name" name="search"/>
								<input type="submit" class="searchbutton"  value="Search"/>
							</div>		
						</form>
					</div>
					
					<div title="Type" style="margin: 20px">
						<form action="" method="post" id="searchForm" class="form">
							<div >
								<input type="text"  class="searchtext" placeholder="Search for Game Type" name="search"/>
								<input type="submit" class="searchbutton"  value="Search"/>
							</div>		
						</form>					
					</div>
					
					<div title="Score" style="margin: 20px">
						<form action="" method="post" id="searchForm" class="form">
							<div >
								<input type="text"  class="searchtext" placeholder="Search for Game Score" name="search"/>
								<input type="submit" class="searchbutton"  value="Search"/>
							</div>		
						</form>				
					</div>
					
					<div title="Date" style="margin: 20px">
						<form action="" method="post" id="searchForm" class="form">
							<div >
								<input type="text"  class="searchtext" placeholder="Search for Game Date" name="search"/>
								<input type="submit" class="searchbutton"  value="Search"/>
							</div>		
						</form>
					</div>
						
				</div>
			</div>
			
			<div id ="banner" >
				<div class="flexslider" style="margin: 0 auto">
					<ul class="slides">
					<li><img src="img/1.png" /></li>
					<li><img src="img/2.png"/></li>
					<li><img src="img/3.png" /></li>			
				
				</div>
			</div>
			
			
	</body>
</html>
