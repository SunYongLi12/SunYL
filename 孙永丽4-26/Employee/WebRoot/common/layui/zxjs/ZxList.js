alert("11111111111");

/*layui.extend({
    dtree: '{/}js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    */

    /*------------- 加载用户数据 --------------------------------*/
    	layui.use('table', function(){
    		  var table = layui.table;
    	/*var buttom=$(".buttom").val();
    	alert(buttom); 		*/
    var tableIns = table.render({
        elem: '#newsList',
        url : 'FJN?action=sjzx',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'userName', title: '真实姓名', minWidth:100, align:"center"},
            {field: 'loginName', title: '登录名',  align:'center'},
            {field: 'sex', title: '用户性别', align:'center',templet:function(d){
                return d.sex == "1" ? "男" : "女";
            }},
          
            {field: 'email', title: '邮箱', minWidth:150, align:'center'},
            {field: 'mobile', title: '手机号', align:'center'},
            {field: 'type', title: '状态', align:'center',templet:function(d){
                return d.type == "0" ? "<span class='layui-badge layui-bg-green'>正常</span>" : "<span class='layui-badge layui-bg-red'>管理员</span>";
            }}
        ]]
    });

   })
	


