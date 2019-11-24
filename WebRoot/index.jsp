<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="entity.User,entity.Wallet,javax.servlet.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SnowyMoney</title>
		<link rel="icon"type="image/x-icon" href="img/snowymoney.ico" media="screen" />
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
	</head>
	<body>
		<div class="logo_module">
			<img src="img/whitesnowy.png" /><span>SnowyMoney</span>
		</div>
		<div class="login_module">
			<%
			User user = null;
			user = (User)request.getSession().getAttribute("user");
			Wallet wallet = (Wallet)request.getSession().getAttribute("wallet");
			if(user==null){
			 %>
				<span><a href="login.html" id="login">登录</a><a href="register.html" id="register">注册</a></span>
			<%}else{ %>
				<span>您好，<%=user.getUserName() %></a><a href="index.html" style="color:#ffffff;margin-left:2px">注销</a></span>
			<%} %>
		</div>
		<div class="border">
			<head>
			<div class="nav">
				<ul>
					<li><a href="void:javascript(0);" id="home">首页</a></li>
					<li><a href="void:javascript(0);" id="search">寻找兼职</a></li>
					<li><a href="void:javascript(0);" id="publish">发布兼职</a></li>
					<li><a href="void:javascript(0);" id="personal">个人中心</a></li>
				</ul>
			</div>
			
			</head>
			<section>
				<div id="homepage">
					
				</div>
				<div id="search_job">
					<form action="searchJobs.action" method="post" target="_blank">
						<table>
							<tr>
								<td><label for="category">种类:</label></td>
								<td>
									<select name="category" id="category">
										<option value="temporary">临时工</option>
										<option value="educator">家教</option>
										<option value="salesman">促销</option>
										<option value="poster">发单</option>
										<option value="other">其他</option>
									</select>
								</td>
							</tr>
							<tr>
								<td><label for="sex">性别:</label></td>
								<td>
									<select name="sex" id="sex">
										<option value="male">男</option>
										<option value="female">女</option>
									</select>
								</td>
							</tr>
							<tr>
								<td><label for="place">地点:</label></td>
								<td>
									<select name="place" id="place">
										<option value="inner">校内</option>
										<option value="outer">校外</option>		
									</select>
								</td>
							</tr>
							<tr>
								<td><input type="submit" value="查找"/></td>
							</tr>
						</table>
					</form>
				</div>
				<div id="publish_job">
					<form action="addJob.action" method="post">
						<table>
							<tr>
								<td><label for="category">种类:</label></td>
								<td>
									<select name="jobCategory" id="category">
										<option value="temporary">临时工</option>
										<option value="educator">家教</option>
										<option value="salesman">促销</option>
										<option value="poster">发单</option>
										<option value="other">其他</option>
									</select>
								</td>
							</tr>
							<tr>
								<td><label for="sex">性别要求:</label></td>
								<td>
									<select name="jobSex" id="sex">
										<option value="male">男</option>
										<option value="female">女</option>
										<option value="unlimit">不限</option>
									</select>
								</td>
							</tr>
							<tr>
								<td><label for="place">地点:</label></td>
								<td>
									<select name="jobPlace" id="place">
										<option value="inner">校内</option>
										<option value="outer">校外</option>		
									</select>
								</td>
							</tr>
							<tr>
								<td><label for="demand">具体要求:</label></td>
								<td><input type="text" name="jobDemand" id="demand"/></td>
							</tr>
							<tr>
								<td><label for="salary">薪资:</label></td>
								<td><input type="text" name=jobSalary" id="salary"/></td>
							</tr>
							<tr>
								<td><label for="contact">联系方式:</label></td>
								<td><input type="text" name="jobContact" id="contact"/></td>
							</tr>
							<tr>
								<td><input type="submit" value="发布"/></td>
							</tr>
						</table>
					</form>
				</div>
				<div id="personal_info">
					<table>
						<tr>
							<td>用户名:</td>
							<td><%=user.getUserName() %></td>
						</tr>
						<tr>
							<td>性别:</td>
							<td><%=user.getUserSex() %></td>
						</tr>
						<tr>
							<td>年龄:</td>
							<td><%=user.getUserAge() %></td>
						</tr>
						<tr>
							<td>余额:</td>
							<td><% if(wallet==null){%>未知
							<%}else{%><%=wallet.getBalance()%><% } %>米币</td>
						</tr>
						<tr>
							<td>所发布的兼职：</td>
							<td><a href="searchPjobs.action">查看</a></td>
						</tr>
					</table>
				</div>
			</section>
		</div>
	</body>
	<script src="js/jquery.min.js"></script>
	<script src="js/index.js"></script>
</html>
