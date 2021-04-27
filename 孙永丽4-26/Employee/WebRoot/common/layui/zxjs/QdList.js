alert("11111111111");

    /*------------- 加载用户数据 --------------------------------*/
    	layui.use('table', function(){
    		  var table = layui.table;
    var tableIns = table.render({
        elem: '#newsList',
        url : 'FJN?action=qdgl',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'loginName', title: '用户', minWidth:100, align:"center"},
            {field: 'userAddress', title: '地址',  align:'center'},
            {field: 'createTime', title: '订单时间', align:'center'},
            {field: 'cost', title: '总金额', minWidth:150, align:'center'},
            {field: 'status', title: '数量', align:'center'},
        ]]
    });

   })
	


