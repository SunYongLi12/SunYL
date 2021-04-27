 $('#LoginUser').click(function () {
       Login();
    });
 
 $('form').on('keypress', function(event) {
		if (event.keyCode == 13) {
			Login();
		}
	});
 
 function Login(){
	 var name = $(".usercode").val();
		var pwd = $(".userpasswd").val();
		if (name == "" || name == null) {
			alert('操作提醒', "用户名不能为空!");
			return;
		} else if (pwd == "" || pwd == null) {
			alert('操作提醒', "密码不能为空!");
			return;
		} else {
			$.ajax({
				url : "http://localhost:8080/Employee/USerServlet",
				method : "post",
				data : {
					"action" : "LoginUser",
					"usercode" : name,
					"userpasswd" : pwd
				},
				success : function(jsonStr) {
					alert(jsonStr);
					if (jsonStr > 0) {
						// 登录成功！跳转登录界面！！
						location.href = "http://localhost:8080/Employee/USerServlet?action=resMenu&id="+jsonStr;
					} else {
						alert('登陆失败。');
					}
				}
			});
		}
	}
	
