alert("insert");
layui.use(['form', 'layedit', 'laydate'],function(){
	 var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;

    /* 新增 */
    $("#submit").click(function(){
    	
    	var usercode = $("#usercode").val();  //登录名
    	var username = $("#username").val();  //用户名
    	var passwd = $("#password").val();  //密码
    	var phone = $("#phone").val();  //手机号
    	var address = $("#address").val();  //地址
    	var role = $("#role").val();//用户类型
    	alert(role);
	    var data2 = {
        		"usercode":usercode,
        		"username":username,
        		"passwd":passwd,
        		"phone":phone,
        		"address": address,
        		"roleName":role
    	};
	    
        if(username == "" || username == null){
        	alert("用户名不能为空");
        	return false;
        }
        
        if(usercode == "" || usercode == null){
        	alert("登录名不能为空");
        	return false;
        }
        
        if(phone == "" || phone == null){
        	alert("手机号不能为空");
        	return false;
        }
        
        if(address == "" || address == null){
        	alert("地址不能为空");
        	return false;
        }
        
        if(passwd == "" || passwd == null){
        	alert("密码不能为空");
        	return false;
        }
        
        if(role == "请选择" || role.size == 0){
        	alert("请选择类型");
        	return false;
        }
        
        //提交
        $.ajax({
        	url:"/Employee/USerServlet?action=addUser",
        	type:"post",
        	data:data2,
        	success:function(data){
        		alert("data"+data)
        		if(data > 0){
    	 			alert("用户新增成功");
    	 			layer.closeAll("iframe");
    	            parent.layui.table.reload("#test");
    	 		}else{
    	 			alert("用户新增失败");
    	 		}
        	}
        })
        return false;
    })
})



	function tongyiType(obj){
		$("#mbtn").val('');
    	var info =  $(obj).html();
    	$("#mbtn").val(info);
    }
    