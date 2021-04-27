
function demo(url,id){
	
		var uid=$(".uid").val();
 		var ise={
 			"id":id,//自身id
 			"uid":uid//账号的id
 		};
 		alert(id);
 		if(id==2){
 			$("#div").load(url+" #ssdiv>*",ise,function(){
   	           var sc =  document.createElement("script");
   	           sc.src= "js/zxjs/ZxList.js";  //是你数据表格的js
   	           $("body").append(sc);
   	           $("#toolbarDemo").css('display','none');
   	        })
 		}else if(id==3){
 			$("#div").load(url+" #ssdiv>*",ise,function(){
    	           var sc =  document.createElement("script");
    	           sc.src= "js/zxjs/QxList.js";  //是你数据表格的js
    	           $("body").append(sc);
    	           $("#toolbarDemo").css('display','none');
    	        })
 		}else if(id==12){
 			$("#div").load(url+" #ssdiv>*",ise,function(){
 	           var sc =  document.createElement("script");
 	           sc.src= "js/zxjs/QdList.js";  //是你数据表格的js
 	           $("body").append(sc);
 	           $("#toolbarDemo").css('display','none');
 	        })
		}
 			
 		 
 			
 	/*	$("#div").load(url+" #ssdiv>*",ise); */
} 
