layui.extend({///LayuiExercise/WebRoot/common/layui/lay-module/layui_ext/dtree/dtree.css
	dtree: '{/}common/layui/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
	var form = layui.form,
	layer = parent.layer === undefined ? layui.layer : top.layer,
			$ = layui.jquery,
			laydate = layui.laydate,
			laytpl = layui.laytpl,
			table = layui.table;
	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
	/*/Exercise0425/WebRoot/BackJsp/js/YG.js
layui.use('table', function(){*/
	var table = layui.table;
	var tableIns = table.render({
		elem: '#test'
			,url:'http://localhost:8080/Exercise0425/Servlet?action=seleALLQX'
				,toolbar: '#button' //开启头部工具栏，并为其绑定左侧模板 
					,defaultToolbar: ['filter', 'exports', 'print', 
						{ //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
						title: '提示'
							,layEvent: 'LAYTABLE_TIPS'
								,icon: 'layui-icon-tips'
						}]
	,title: '权限数据表'
		,cols: [[
			{fixed:"left",type: "checkbox", width:50},
			{field: 'id', title: 'ID',  align:'center'},
			{field: 'qname', title: 'NAME', minWidth:100, align:"center"},
			{field: 'btn', title: 'BTN',  align:'center'},
			{field: 'type', title: 'TYPE', minWidth:150, align:'center',templet:function(d){
				if(d.type == "1"){
            		return "<span class='layui-badge layui-bg-orange'>目录</span>";
            	} else if(d.type == "2"){
            		return "<span class='layui-badge layui-bg-red'>菜单</span>";
            	} else if(d.type == "3"){
            		return "<span class='layui-badge layui-bg-green'>按钮</span>";
            	}
			}},
			{field: 'url', title: 'URL', align:'center'},
			{field: 'js', title: 'JS', align:'center'}
			]]
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
			content : "http://localhost:8080/Exercise0425/common/pop/QXupdate.jsp",
			area:['400px','450px'],
			success:function(layero, index){
				$.ajax({
					url:"http://localhost:8080/Exercise0425/Servlet?action=echoQX",
					type:"post",
					data:{"id":userid},
					success:function(data){
						var info = eval('(' + data + ')');
						var body = layui.layer.getChildFrame('body', index);
						body.find("#uid").val(info.id);
						body.find("#mname").val(info.qname);
						body.find("#murl").val(info.url);
						body.find("#mjs").val(info.js);
						body.find("#mbtn").val(info.btn);
						body.find("#btnType").val(info.btn);
						
						var select1 = 'dd[lay-value='+info.fid+']';
						var select2 = 'dd[lay-value='+info.type+']';
						body.find("#FID").siblings("div.layui-form-select").find('dl').find(select1).click();
						body.find("#type2").siblings("div.layui-form-select").find('dl').find(select2).click();
						
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
			url:"http://localhost:8080/Exercise0425/Servlet?action=deleteQX",
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
					url: "/LayuiExercise/OperationUser?action=AllMenu",
					dataStyle: "layuiStyle",  //使用layui风格的数据格式
					dataFormat: "list",  //配置data的风格为list
					response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
					checkbar:true,
					line: true,  // 显示树线
					done: function(res, $ul, first){
						$.ajax({
							url:"/LayuiExercise/OperationUser?action=UserAllMenu",
							type:"post",
							data:{"userid":userid},
							success:function(res){
								var cs = eval('(' + res + ')');
								$.each(cs,function(index,rows){
									dtree.chooseDataInit("demoTree",[rows.menuid]); // 初始化选中
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
			content : "http://localhost:8080/Exercise0425/common/pop/QXadd.jsp",
			area:['420px','550px']
		})
	}
});
