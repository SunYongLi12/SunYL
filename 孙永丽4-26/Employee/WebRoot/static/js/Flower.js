layui.use('table', function(){
	var table = layui.table;
	table.render({
		elem: '#test',
		url : 'http://localhost:8080//Employee/USerServlet?action=AllFlowers',
		toolbar: '#button',
		page : true,
		height: '500',
		limit : 10,
		limits : [10,15,20,25],
		cols : [[
			// id,usercode,userName,userpassword,Dname,Tname,rolename,phone,address 
			//订单
			{fixed:"left",type: "checkbox", width:30},
			{field: 'id', title: '编号',  align:'center',Width:50, align:"center"},
			{field: 'flowerName', title: '花名', Width:100, align:"center"}
			]]
	});

	//头工具栏事件
	table.on('toolbar(test)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    var data = checkStatus.data;
	    var userid = "";
	    for(i=0;i<data.length;i++){
	    	userid = data[i].id;
	    }
		var checkStatus = table.checkStatus(obj.config.id);

		switch(obj.event){
		case 'user-delete':
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					delFlo(userid);
				}
			
			break;

		case 'user-update':	//修改
			upUser(userid);
			break;

		case 'user-insert':	//新增
			layer.open({
				title : "添加花名",
				type : 2,
				content : "FloInsert.jsp",
				area:['350px','150px'],
			})
			break;
		};
	});


});


function delFlo(userid){
	alert(userid);
	  $.ajax({
		url:"http://localhost:8080/Employee/FloServlet?action=DelFlo",
		data:{"id":userid},
		type:"post",
		success:function(data){
			if(data == 1){
				layer.msg("删除成功")
				/*layer.table.reload("#test");*/
			}
		}
	})
}

//修改用户
function upUser(userid){
	alert("id:"+userid)
	layui.layer.open({
		title : "修改信息",
		type : 2,
		content : "FlowerUpdate.jsp",
		area:['360px','200px'],
		success:function(layero, index){
			$.ajax({
				url:"http://localhost:8080/Employee/FlowerServlet?action=echoFlower&id="+userid,
				type:"post",
				data:{"id":userid},
				success:function(data){
					var info = eval('(' + data + ')');
					alert(info.flowerName)
      				var body = layui.layer.getChildFrame('body', index);
      				body.find("#id").val(info.id);
					body.find("#flower").val(info.flowerName);
					
                    //获取新窗口对象
                    var iframeWindow = layero.find('iframe')[0].contentWindow;
                    //重新渲染
                    iframeWindow.layui.form.render();
				}
			})
		}
	})
}
