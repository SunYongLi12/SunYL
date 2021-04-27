layui.config({
//    base: 'common/layui/module'
}).extend({
//    tableMerge:"tableMerge",
	tableMerge:"{/}common/layui/module/tableMerge",
    dtree:"{/}common/layui/lay-module/layui_ext/dtree/dtree"
    
})
layui.use(['table','tableMerge'], function(){
	var table = layui.table;
	tableMerge = layui.tableMerge;
	var element = layui.element;
	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
	var tableIns = table.render({
      elem: '#test',
      url : 'http://localhost:8080/Employee/USerServlet?action=AllRoleType',
      toolbar: '#button',
      page : true,
      height: '500',
      limit : 10,
      limits : [10,15,20,25],
      cols : [[
    	  {fixed:"left",type: "checkbox", width:30},
          {field: 'id', title: '编号',  align:'center',Width:50, align:"center"},
          {field: 'userName', title: '用户名', align:'center'},
          {field: 'roleName', title: '用户类型', Width:100, align:"center",merge:true}
      ]],
      done:function(){
//    	  console.log(tableMerge)
    	  tableMerge.render(this)
      }
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        layer.alert(JSON.stringify(data));
      break;
      case 'getCheckLength':
        var data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选');
      break;
      
      //自定义头工具栏右侧图标 - 提示
      case 'LAYTABLE_TIPS':
        layer.alert('这是工具栏右侧自定义的一个图标按钮');
      break;
    };
  });
  
  
  table.on('toolbar(test)', function(obj){
	  alert("jkshchk")
	    var checkStatus = table.checkStatus(obj.config.id);
	    var data = checkStatus.data;
	    var id = "";
	    for(i=0;i<data.length;i++){
	    	id = data[i].id;
	    }
		var checkStatus = table.checkStatus(obj.config.id);

		switch(obj.event){
		case 'btn-delete':
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					delmenu(id);
				}
			
			break;

		case 'btn-update':	//修改
			if(data.length == 0 || data.length > 1){
				layer.msg("请选择一行数据进行操作")
				return ;
			}else{
				upMenu(id);
				
			}
			break;

		case 'btn-add':	//新增
			layer.open({
				title : "添加用户",
				type : 2,
				content : "MenuInsert.jsp",
				area:['450px','500px'],
			})
			break;
		};
	});
  
  
  function delmenu(id){
		alert(id);
		  $.ajax({
			url:"http://localhost:8080/Employee/MenuServlet?action=delmenu&id="+id,
			type:"post",
			success:function(data){
				if(data == 1){
					layer.msg("删除成功")
					/*layer.table.reload("#test");*/
				}
			}
		})
	}

  function upMenu(id){
		alert("id:"+id)
		layui.layer.open({
			title : "修改用户信息",
			type : 2,
			content : "MenuUpdate.jsp",
			area:['400px','540px'],
			success:function(layero, index){
				$.ajax({
					url:"http://localhost:8080/Employee/MenuServlet?action=selectByMenuid&menuid="+id,
					type:"post",
					success:function(data){
						var info = eval('(' + data + ')');
						alert(info[0].userName)
	      				var body = layui.layer.getChildFrame('body', index);
	      				body.find("#id").val(info[0].id);
						body.find("#mname").val(info[0].mname);
						body.find("#parentid").val(info[0].parentid);
						body.find("#mbtn").val(info[0].mbtn);
						body.find("#type2 option[value="+info[0].type+"]").attr("selected",true);	//菜单样式
						
	                    //获取新窗口对象
	                    var iframeWindow = layero.find('iframe')[0].contentWindow;
	                    //重新渲染
	                    iframeWindow.layui.form.render();
					}
				})
			}
		})
	}
  
});








