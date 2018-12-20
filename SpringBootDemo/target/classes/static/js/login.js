$(document).ready(function(){
	window.onload = function myfun(){ 
		alert($("p").text()));
		if(($("p").text())!=""){
			$(".login").hide();
		}
		else{
			$(".login").show();
		}
	} 　　
});