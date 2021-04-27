layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;
       
    /* --- 验证权限名是否存在 ---------------------------------------------------------------*/
    /*$("#mname").blur(function(){
    	var mname = $("#mname").val();  //权限
    	$.post("/MenuTest/MenuServlet?action=isMenuName&mname="+mname,function(res){
    		var cs = eval('(' + res + ')');
    		if(res == 1){
    			layer.msg('权限名已存在');
    		}
		 })
    })*/
    
    /* --- 验证请求路径是否存在 ----------------------------------------------------------------*/
    /*$("#mfunction").blur(function(){
    	var mfunction = $("#mfunction").val();  //请求路径
    	$.post("/MenuTest/MenuServlet?action=isMenuUrl&mfunction="+mfunction,function(res){
    		var cs = eval('(' + res + ')');
    		if(res == 1){
    			layer.msg('请求路径已存在');
    		}
		 })
    })*/


    /* -- 新增权限 --------------------------------------------------------------- */
    form.on('submit(menuUser)',function(data){
    	var name = $("#mname").val();  //权限
	    var url = $("#murl").val(); //请求路径
	    var js = $("#mjs").val(); //请求js
	    var type = $("#type2").val();  //请求类型
	    var btn = $("#mbtn").val();  //按钮代码
	    var fid = $("#FID").val();  //父级
	    
	   
	    //权限名
        if(name == "" || name == null){
        	layer.msg("权限名不能为空");
        	return false;
        }
  
        //murl
        if(url == "" || url == null){
        	layer.msg("请求url路径不能为空");
        	return false;
        }
        
        //js
        if(js == "" || js == null){
        	layer.msg("请求js路径不能为空");
        	return false;
        }
    	
        //类型
        if(type == 0 || type.size == 0){
        	layer.msg("请选择类型");
        	return false;
        }
        
        if(type != 1){
        	if(fid == 0){
        		layer.msg("菜单或按钮不能没有上级");
            	return false;
        	}
        }
        if(type == 3){
        	if(btn == null || btn.length < 30 || btn==""){
            	layer.msg("按钮代码格式错误");
            	return false;
            }
        }
        if(type != 3){
        	btn = name;
        }
      
        var item = {
            	"name":name,
            	"url":url,
            	"js":js,
            	"type":type,
            	"btn":btn,
            	"fid":fid
        }
        
        $.ajax({
	  		url:"http://localhost:8080/Exercise0425/Servlet?action=addQX",
			data:item,
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
    
    
    /*-----------类型选择下拉框的点击事件----------*/
    form.on('select(type2)', function(data){
    	var type = data.value;
        var dom = $("#goodsid");
        var mname = $("#mname").val();  //权限
        dom.html("");
        if(type == 3){
        	$("#mbtn").val('');
        	$("#sty").css("display","block");
        	$.get("http://localhost:8080/Exercise0425/Servlet?action=seleAllBtn",function (res) {
        		
        		var result = eval('(' + res + ')');
        		var btntype = $('#btnType');
        		var html = '<span value="0"></span>';
                $.each(result,function (index, item) {
                    html += '<span class="btnType4" onclick="executive(this)">'+item.button+'</span> ';
                });
                btntype.html(html);
        	})
        }else{
        	$("#sty").css("display","none");
        }
        $.get("http://localhost:8080/Exercise0425/Servlet?action=seleFF&type="+type,function (res) {
        	var cs = eval('(' + res + ')');
            var data = cs;
            var dom = $("#FID");
            if(type == 1){
            	var html = '<option value="0">目录没有上一级</option>';
            }else{
            	var html = '<option value="0">请选择</option>';
                $.each(data,function (index, item) {
                    html += '<option value="'+item.id+'">'+item.qname+'</option>';
                });
            }
            dom.html(html);
            //重新渲染下拉列表
            form.render("select");
        });
    });
    /*-----------监听下拉框----------*/
    
})
	function executive(obj){
		$("#mbtn").val('');
    	var info =  $(obj).html();
    	$("#mbtn").val(info);
    }
    