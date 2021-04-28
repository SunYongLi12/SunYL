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
	alert("userid:"+userid)
	layui.layer.open({
		title : "修改用户信息",
		type : 2,
		content : "FlowerUpdate.jsp",
		area:['400px','540px'],
		success:function(layero, index){
			$.ajax({
				url:"http://localhost:8080/Employee/FlowerServlet?action=selectByUserid&id="+userid,
				type:"post",
				data:{"userid":userid},
				success:function(data){
					var info = eval('(' + data + ')');
					alert(info[0].userName)
      				var body = layui.layer.getChildFrame('body', index);
      				body.find("#id").val(info[0].id);
					body.find("#usercode").val(info[0].userCode);
					body.find("#username").val(info[0].userName);
					body.find("#address").val(info[0].address);
					body.find("#phone").val(info[0].phone);
					alert(info[0].userRole);
					body.find("#role option[value="+info[0].userRole+"]").attr("selected",true);	//菜单样式
					
                    //获取新窗口对象
                    var iframeWindow = layero.find('iframe')[0].contentWindow;
                    //重新渲染
                    iframeWindow.layui.form.render();
				}
			})
		}
	})
}
