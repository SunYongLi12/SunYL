alert("11111111111");

    /*------------- 加载用户数据 --------------------------------*/
    	layui.use('table', function(){
    		  var table = layui.table;
    var tableIns = table.render({
        elem: '#newsList',
        url : 'FJN?action=qxgl',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'mname', title: '权限', minWidth:100, align:"center"},
            {field: 'mfatherid', title: '父类',  align:'center'},
            {field: 'type', title: '级别', align:'center'},
            {field: 'url', title: '路径', minWidth:150, align:'center'},
            {field: 'buttom', title: '按钮', align:'center'},
        ]]
    });

   })
	


