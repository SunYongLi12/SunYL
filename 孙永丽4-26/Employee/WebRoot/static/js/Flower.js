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
					deluser(userid);
				}
			
			break;

		case 'user-update':	//修改
			upUser(userid);
			break;

		case 'user-insert':	//新增
			layer.open({
				title : "添加用户",
				type : 2,
				content : "UserInsert.jsp",
				area:['450px','500px'],
			})
			break;
		};
	});


});


function deluser(userid){
	alert(userid);
	  $.ajax({
		url:"http://localhost:8080/Employee/USerServlet?action=delUser",
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

/*
	 
    //修改用户
    function upUser(userid){
    	layui.layer.open({
    		title : "修改用户信息",
    		type : 2,
    		content : "admin/page/system/user/userInfo.jsp",
    		area:['400px','540px'],
    		success:function(layero, index){
    			$.ajax({
    				url:"/MenuTest/UserServlet?action=allUserByUserid",
    				type:"post",
    				data:{"userid":userid},
    				success:function(data){
    					var info = eval('(' + data + ')');
          				var body = layui.layer.getChildFrame('body', index);
          				body.find("#uid").val(info.data.id);
    					body.find("#uname2").val(info.data.uname);
    					body.find("#uname").val(info.data.uname);
    					body.find("#password").val(info.data.password);
    					body.find("#realName").val(info.data.realname);
    					body.find("#email").val(info.data.email);
    					body.find("#phone").val(info.data.phone);
    					//性别(单选)
    					var sex2 = info.data.sex;
    					if(sex2 == 1){
    						body.find("#sex1").prop("checked",true);
    					}else{
    						body.find("#sex2").prop("checked",true);
    					}
    					//状态(单选)
    					var isStatus = info.data.isStatus;
    					if(isStatus == 0){
    						body.find("#isStatus0").prop("checked",true);
    					}else{
    						body.find("#isStatus1").prop("checked",true);
    					}
    					------下拉框赋值--------
    					$.ajax({
    						  url:"/MenuTest/RoleServlet?action=allRole",
    						  type:"post",
    						  success:function(data){
    							  var info = eval("("+data+")");
    							  var row = info.data;
    							  var role = body.find("#role1");
    							  $.ajax({
    								  url:"/MenuTest/UserServlet?action=queryUserIsRole",	//查询用户是否有角色有返回1,没有返回0
    								  data:{"userid":userid},
    								  type:"post",
    								  success:function(data){
    									  if(data == 0){
    										  var html = '<option value="0">无角色</option>';
    									  }else{
    										  var html = '';
    									  }
    	    							  $.each(row,function(index,item){
    	    								  html += '<option value="'+item.id+'">'+item.rname+'</option>';
    	    							  })
    	    							  role.html(html);
    	    							//获取新窗口对象
    			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
    			                        //重新渲染
    			                        iframeWindow.layui.form.render();
    								  }
    							  })

    						  }
    					  })
    					//赋值后选中
    					$.ajax({
    						url:"/MenuTest/RoleServlet?action=allRoleUserid",
    						type:"post",
    						data:{"userid":userid},
    						success:function(data){
    							var info2 = eval("("+data+")")
    							if(info2 == 0){
    								var select = 'dd[lay-value="0"]';
        							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
    							}else{
    								var select = 'dd[lay-value='+info2.data.roleid+']';
        							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
    							}
    						}
    					})
                        //获取新窗口对象
                        var iframeWindow = layero.find('iframe')[0].contentWindow;
                        //重新渲染
                        iframeWindow.layui.form.render();
    				}
    			})
    		}
    	})
    }
})  */