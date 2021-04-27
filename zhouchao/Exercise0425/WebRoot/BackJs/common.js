/* 主题内容页面  */
function notempty(id,url,js) {
	var item = {
			"url" : url,
			"id" : id,
	}
	$("#bodydiv").load(url+"&fid="+id + " #AllPermissions>*",item,function(){
		var sc =  document.createElement("script");
		sc.src= "/Exercise0425/BackJsp/js/"+js;  //数据表格的js
		$("body").append(sc); 
	})
}















function ono(url,id,uid,mhtml,mjs) {
	alert(mjs);
	var item = {
			"id" : id,
			"uid" : uid,
			"mhtml" : mhtml,
			"mjs" : mjs
	}

	$("#di").load("/BusinessLayer #di>*",item,function(){
		alert("load");
		var sc =  document.createElement("script");
		sc.src= "/back/js/LsMenuAll.js";  //是你数据表格的js
		$("body").append(sc);
	})
}

function non(url,id,uid,mhtml) {
	alert(mjs);
	var item = {
			"id" : id,
			"uid" : uid,
			"mhtml" : mhtml
	}

	$("#di").load(url+" #di>*",item,function(){
		alert("load");
		var sc =  document.createElement("script");
		sc.src= "/back/js/LsMenuAll.js";  //是你数据表格的js
		$("body").append(sc);
	})
}