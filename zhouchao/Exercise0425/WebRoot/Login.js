function deng(){
	var name = $("#name").val();
	var pwd = $("#pwd").val();
	var item = {
		"name":name,
		"pwd":pwd	
	}
	$.ajax({
		url:"http://localhost:8080/Exercise0425/Servlet?action=Login",
		data:item,
		tyep:"post",
		success:function(data){
			alert(data);
			if(data > 0){
				//layer.msg("登录成功")
				setTimeout(function(){
					location.href="http://localhost:8080/Exercise0425/Servlet?action=seleQX&id="+data;
	        	},1000);
			}else{
				alert("失败");
			}
		}
	})
}