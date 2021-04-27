function sidebar(id,url){
	var item = {
		"id" : id,
		"url" : url
	}
	alert(url);
	$("#bodydiv").load("http://localhost:8080/Employee/USerServlet?action="+url+" #AllPermissions>*",item,function(){
		var sc =  document.createElement("script");
		sc.src= "/Employee/static/js/"+url+".js";  //数据表格的js
		$("body").append(sc);

	})
}