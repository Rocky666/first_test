<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="${pageContext.request.contextPath}/js/jquery-easyui-1.5.2/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-easyui-1.5.2/jquery.easyui.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui-1.5.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-easyui-1.5.2/themes/icon.css">
	
	
	<script type="text/javascript">
	$(function(){
	/**
 	*	初始化数据表格  
 	*/
$('#t_user').datagrid({
		idField:'id' ,	
		title:'班级列表' ,
		//width:1300 ,
		fit:true ,
		//height:450 ,
		url:'${pageContext.request.contextPath}/class/list' ,
		//url:'${pageContext.request.contextPath}/json/datagrid_data.json' ,
		fitColumns:true ,  
		striped: true ,					//隔行变色特性 
		loadMsg: '数据正在加载,请耐心的等待...' ,
		columns:[[
			{
				field:'id' ,
				title:'id' ,
				width:100 ,
				align:'center' ,
			},
			{
				field:'text' ,
				title:'text' ,
				width:100 ,
			},{
				field:'pid' ,
				title:'pid' ,
				width:100 ,
			},{
				field:'state' , 
				title:'state' ,
				width:50 ,
				},{
				field:'status' , 
				title:'status' ,
				width:50 ,
				}
		]] ,
		 pagination: true , 
		pageSize: 5 ,
		pageList:[5,10,15,20,50] 
		});
		$('#searchbtn').click(function(){
						$('#t_user').datagrid('load' ,serializeForm($('#mysearch')));
					});
					
					
		$('#clearbtn').click(function(){
			$('#mysearch').form('clear');
			$('#t_user').datagrid('load' ,{});
		});
		});
		
		//js方法：序列化表单 			
			function serializeForm(form){
				var obj = {};
				$.each(form.serializeArray(),function(index){
					if(obj[this['name']]){
						obj[this['name']] = obj[this['name']] + ','+this['value'];
					} else {
						obj[this['name']] =this['value'];
					}
				});
				return obj;
			}
	</script>
  </head>
  
  <body>
 		 <div id="lay" class="easyui-layout" style="width: 100%;height:100%" >
				<div region="north" title="班级查询" collapsed=true style="height:100px;" >
					<form id="mysearch" method="post">
							id:&nbsp;&nbsp;&nbsp;<input name="id" class="easyui-validatebox"  value="" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							text:<input name="text"  class="easyui-validatebox"  style="width:160px;"  value="" />	
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a id="searchbtn" class="easyui-linkbutton">查询</a> <a id="clearbtn" class="easyui-linkbutton">清空</a>
					</form>
				
				</div>
 		 
 		 <div region="center" >
			<table id="t_user"></table>
		</div>
	</div>
	</body>
</html>
