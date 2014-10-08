/**
 * param is {}
 */
var JRH= JRH || {};
(function(n, $){
	n.Load = {
		time:5,
		init:function(param){
			if(param==null || param==undefined ){
				return ;
			}
			if(param.time){
				JRH.Load.time = param.time;
			}
			JRH.Load.showLoad();
			setTimeout(JRH.Load.delLoad,JRH.Load.time);
		},
		showLoad:function(){
			$("body").append('<div id="loading" class="loading"><div class="loading_img">....</div></div>');
		},
		delLoad:function(){
			$("#loading").remove();
		}
	};	
	
})(JRH, jQuery);
