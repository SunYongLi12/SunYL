layui.config({
	base:'common/layui/module/'
}).extend({
	tableMerge:'tableMerge',
	dtree: '{/}common/layui/lay-module/layui_ext/dtree'
});
layui.use(['table','element','tableMerge','dtree'],function(){
	var table = layui.table;
	tableMerge = layui.tableMerge;
	var element = layui.element;
	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
	var tableIns = table.render({
		elem: '#test'
			,url:'http://localhost:8080/Exercise0425/Servlet?action=seleALLJS'
				,toolbar: '#button' //开启头部工具栏，并为其绑定左侧模板 
					,defaultToolbar: ['filter', 'exports', 'print', 
						{ //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
						title: '提示'
							,layEvent: 'LAYTABLE_TIPS'
								,icon: 'layui-icon-tips'
						}]
	,title: '角色数据表'
		,cols: [[
			{fixed:"left",type: "checkbox", width:50},
			{field: 'id', title: '编号',  align:'center',hide:true},
			{field: 'name', title: '姓名', minWidth:100, align:"center"},
			{field: 'sex', title: '性别', align:'center',templet:function(d){
				return d.sex == "1" ? "男" : "女";
			}},
			{field: 'role', title: '角色',  align:'center',merge:true}
			]],
			done:function(){
				tableMerge.render(this)
			}
	,page: true
	});
	
	//头工具栏事件
	table.on('toolbar(test)', function(obj){
		var checkStatus = table.checkStatus(obj.config.id);
		var data = checkStatus.data;
		var userid = "";
		for(i=0;i<data.length;i++){
			userid = data[i].id;
		}

		switch(obj.event){

		case 'btn-add'://新增用户
			addUser();
			break;

		case 'btn-delete'://删除用户
			if(data.length == 0 || data.length > 1){
				layer.msg("请选择一行数据进行操作")
				return ;
			}else{
				layer.confirm('确定删除用户吗', {icon: 3, title:'提示'}, function(index){
					var loginName = $("#loginName").val();
					if(userid == loginName){
						layer.msg("你正在登录当前账号,无法删除")
					}else{
						deleUser(userid);
						layer.close(index);
					}
				});
			}
			break;

		case 'btn-update'://修改用户
			if(data.length == 0 || data.length > 1){
				layer.msg("请选择一行数据进行操作")
				return ;
			}else{
				upUser(userid);
			}
			break;

		case 'fenFunc'://分配权限
			if(data.length == 0 || data.length > 1){
				layer.msg("请选择一行数据进行操作")
				return ;
			}else{
				hair(userid);
			}
			break;
		};
	});

	//监听行工具事件
	table.on('tool(test)', function(obj){
		var data = obj.data;
		//console.log(obj)
		if(obj.event === 'del'){
			layer.confirm('真的删除行么', function(index){
				obj.del();
				layer.close(index);
			});
		} else if(obj.event === 'edit'){
			layer.prompt({
				formType: 2
				,value: data.email
			}, function(value, index){
				obj.update({
					email: value
				});
				layer.close(index);
			});
		}
	});

	function upUser(userid){//修改用户   echoYG
		layui.layer.open({
			title : "修改用户信息",
			type : 2,
			content : "http://localhost:8080/Exercise0425/common/pop/YGupdate.jsp",
			area:['400px','450px'],
			success:function(layero, index){
				$.ajax({
					url:"http://localhost:8080/Exercise0425/Servlet?action=echoYG",
					type:"post",
					data:{"id":userid},
					success:function(data){
						var info = eval('(' + data + ')');
						var body = layui.layer.getChildFrame('body', index);
						body.find("#id").val(info.id);
						body.find("#realName").val(info.name);
						//性别(单选)
						var sex2 = info.sex;
						if(sex2 == 1){
							body.find("#sex1").prop("checked",true);
						}else{
							body.find("#sex2").prop("checked",true);
						}
						var select1 = 'dd[lay-value='+info.jsid+']';
						var select2 = 'dd[lay-value='+info.bmid+']';
						var select3 = 'dd[lay-value='+info.zcid+']';
						body.find("#role1").siblings("div.layui-form-select").find('dl').find(select1).click();
						body.find("#role2").siblings("div.layui-form-select").find('dl').find(select2).click();
						body.find("#role3").siblings("div.layui-form-select").find('dl').find(select3).click();
						
						//获取新窗口对象
						var iframeWindow = layero.find('iframe')[0].contentWindow;
						//重新渲染
						iframeWindow.layui.form.render();
					}
				})
			}
		})
	}

	function deleUser(userid){//删除用户
		alert("删除"+userid);
		$.ajax({
			url:"http://localhost:8080/Exercise0425/Servlet?action=deleteYG",
			data:{"id":userid},
			type:"post",
			success:function(data){
				if(data == "1"){
					layer.msg("删除成功")
					tableIns.reload("#test");
				}
			}
		})
	}

	function hair(userid){//分配权限
		layui.layer.open({
			title : "分配权限",
			type : 1,
			content : $('#fenpei'),
			area:['400px','450px'],
			success:function(){
				dtree.render({
					elem: "#demoTree",
					url: "http://localhost:8080/Exercise0425/Servlet?action=seleALLQXTree",
					dataStyle: "layuiStyle",  //使用layui风格的数据格式
					dataFormat: "list",  //配置data的风格为list
					response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
					checkbar:true,
					line: true,  // 显示树线
					done: function(res, $ul, first){
						$.ajax({
							url:"http://localhost:8080/Exercise0425/Servlet?action=seleJSALLQXTree",
							type:"post",
							data:{"userid":userid},
							success:function(res){
								var cs = eval('(' + res + ')');
								$.each(cs,function(index,rows){
									dtree.chooseDataInit("demoTree",[rows.id]); // 初始化选中
								})
							}
						})
					}
				});//dtree
			},
			btn:['分配权限'],
			yes: function(index, layero){
				var params = dtree.getCheckbarNodesParam("demoTree");
				var infos = JSON.stringify(params);
				var cs = eval('(' + infos + ')');
				var mList = new Array();	//所有选中值的权限id
				$.each(cs,function(index,row){
					mList[index] = row.nodeId;
				})
				$.ajax({
					url:"/LayuiExercise/OperationUser?action=fenPeiQuan",
					data:{"arrayid":mList,"userid":userid},
					type:"post",
					traditional:true,
					success:function(data){
						alert(data);
						var demo = eval('(' + data + ')');
						if(demo != 0){
							layer.msg("分配成功");
							layer.closeAll("iframe")
						}else{
							layer.msg("分配失败");
						}// if
					}// yes - ajax - success
				})// yes - ajax
			}// yes

		});// layui.layer.open
	}// function

	function addUser() {//新增用户
		layui.layer.open({
			title : "添加用户",
			type : 2,
			content : "http://localhost:8080/Exercise0425/common/pop/YGadd.jsp",
			area:['400px','450px']
		})
	}
});
