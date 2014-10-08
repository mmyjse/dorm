jQuery.namespace("MOA");
jQuery(document).ready(function() {
	MOA.MoaHead.init();
});
(function(n, $) {
	n.MoaHead = {
		init : function() {
			n.MoaHead.nav_active();
			//n.MoaHead.login_status();
		},
		nav_active : function() {
//			$(".h_nav li[class=active] ~ li:first").addClass("active-next");
		},
		login_status:function(){
			var loginUrl = $("#h_check_url").val();
			$.ajax({
				url:loginUrl,
				dataType:"json",
				success:function(data){
					if(data!=null && data.user!=null){
						$("#h_no_login").hide();
						$("#h_logined").show();
						$("#h_logined_name").html(data.user.name);
					}
				}
			});
		}
		
	};

})(MOA, jQuery);
