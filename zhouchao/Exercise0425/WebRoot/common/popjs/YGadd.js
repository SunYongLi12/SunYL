layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  //角色
  $.ajax({
	  url:"http://localhost:8080/Exercise0425/Servlet?action=seleJS",
	  type:"post",
	  async:false,
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info;
		  var role = $("#role1");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.role+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  //部门
  $.ajax({
	  url:"http://localhost:8080/Exercise0425/Servlet?action=seleBM",
	  type:"post",
	  async:false,
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info;
		  var role = $("#role2");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.branch+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  //职称
  $.ajax({
	  url:"http://localhost:8080/Exercise0425/Servlet?action=seleZC",
	  type:"post",
	  async:false,
	  success:function(data){
		  var info = eval("("+data+")");
		  var row = info;
		  var role = $("#role3");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.rank+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
  //验证账户是否存在
  /*function checkUname(uname){
	  var is = false;
	  $.ajax({
		  url:"/LayuiExercise/OperationUser?action=isUname",
		  data:{"uname":uname},
		  async:false,
		  type:"post",
		  success:function(data){
			  if(data == 0){
				  is = true;
			  }else{
				  is = false;
			  }
		  }
	  })
	  return is;
  }*/
  
  /*$("#uname").blur(function(){
	  var name = $("#uname").val();
	  if(!name.length == "" || !name.length == null){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入")
		  }
	  }
  })*/
  
  
  $("#tijiao").click(function(){
	  var name = $("#realName").val();
	  var sex = $("input[type='radio']:checked").val();
	  var js = $("select[name='role1']").val();
	  var bm = $("select[name='role2']").val();
	  var zc = $("select[name='role3']").val();
	  var data = {
			  "name":name,
			  "sex":sex,
			  "js":js,
			  "bm":bm,
			  "zc":zc
	  }
	 
	  $.ajax({
	  		url:"http://localhost:8080/Exercise0425/Servlet?action=addYG",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("添加成功")
					setTimeout(function(){
						parent.layer.closeAll("iframe");
			            //刷新父页面
			          /*  parent.location.reload();*/
						parent.layui.table.reload("test");
		        	},1000);
				}else{
					layer.msg("系统异常");
				}
				
			}
	  })
	  return false;
  })
  
});
