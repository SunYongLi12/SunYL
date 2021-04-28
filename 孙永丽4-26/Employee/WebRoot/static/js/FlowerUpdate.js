layui.use(['form', 'layedit', 'laydate'],function(){
	var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;

    $("#s").click(function(){
    	var id = $("#id").val();  //id
    	var flower = $("#flower").val();  //登录名
	    var data2 = {
	    	"id":id,
        	"flower":flower
    	};
        if(flower == "" || flower == null){
        	alert("花名不能为空");
        	return false;
        }
        //提交
        $.ajax({
        	url:"/Employee/FlowerServlet?action=updateFlower",
        	type:"post",
        	data:data2,
        	success:function(data){
        		alert(data);
        		if(data > 0){
    	 			layer.closeAll("iframe");
    	            parent.layui.table.reload("#test");
    	 		}else{
    	 			alert("修改失败");
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
    