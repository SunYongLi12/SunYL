
layui.use(['form', 'layedit', 'laydate'],function(){
	 var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	 
	
	$("#menuAjax").click(function(){
		var flowername = $("#flowername").val();

		var data2 = {
				"flowername":flowername
		};

		if(flowername == "" || flowername == null){
			layer.msg("新花名不能为空");
			return false;
		}

		//ajax提交
		$.ajax({
			url:"/Employee/FloServlet?action=FloInsert",
			type:"post",
			data:data2,
			success:function(data){
				//var info = eval('(' + data + ')')
				alert(data)
				if(data > 0){
					top.layer.msg("新增成功");
					layer.closeAll("iframe");
				}else{
					top.layer.msg("新增失败");
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
