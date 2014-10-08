// JavaScript Document
$(document).ready(function(){
	function beginit(){
		var he1=$(window).height(), wid1=$(window).width();
		$('#loginmain').height(he1);
		/*var y1=(2000-he1)/2-107;
		$('#loginmain').css({'background-position':'0,'+ (-y1)+'px'});
		$('#loginmain').css({'backgroundPositionY':-y1+'px'});*/
		$('#dlbottom').width( wid1-20);
	}
	beginit();
	$(window).resize( function(){ beginit(); } );
	$("#imgcode").click(function(){
		$("#imgcode").attr("src","/getCodeImg?code="+Math.random());
	});
	var iscode = $("#iscode").val();
	if(iscode!=null && iscode!=""){
		$("#imgcode").attr("src","/getCodeImg?code="+Math.random());
	}
});