var JRH= JRH || {};
jQuery(document).ready(function(){
	JRH.Login.init();
});
(function(n, $){
	n.Login = {
		Require : /.+/,
		Number : /^\d+$/,
		altLoginId : '会员名',
		init: function() {
			// 服务器端返回错误
			if ($('.iserror').val() != '') {
				$('.iserror').show();
			}
			
			// 输入框验证绑定
			$('.v_partyNum').bind('blur', function() {
				if($(this).val() == '') {
					$(this).val(n.Login.altLoginId);
				}
				n.Login.showTip('.err_partyNum span', n.Login.checkPartyNum($(this).val()));
			});
			$('.v_password').bind('blur', function() {
				n.Login.showTip('.err_pass span', n.Login.checkPassword($(this).val()));
			});
			
			//绑定回车事件
			$('.v_password').bind('keyup', function(event) {
				if(event.keyCode == 13) {
					if (n.Login.showTip('.err_pass span', n.Login.checkPassword($(this).val()))) {
						n.Login.doSubmit();
					}
				}
			});
			$('.v_partyNum').bind('focus', function() {	
				if($(this).val() == n.Login.altLoginId) {
					$(this).val('');
				}
			});
			
			$('.lg_login .sub').click(function() {
				n.Login.doSubmit();
				return false;
			});
		},
		checkPartyNum: function(value) {
			if (!this.Require.test(value) || value == n.Login.altLoginId) {
				return {success:false,msg:'请输入会员名'};
			}
			if (value.length < 6 || value.length > 100) {
				return {success:false,msg:'会员名输入有误'};
			}
			return {success:true};
		},
		checkPassword: function(value) {
			if (!this.Require.test(value)) {
				return {success:false,msg:'请输入密码'};
			}
			if (value.length < 6 || value.length > 20) {
				return {success:false,msg:'密码输入有误，请检查密码大小写是否正确'};
			}
			return {success:true};
		},
		showTip: function(o, rs) {
			$(o).css('visibility', 'visible');
			if (rs.success) {
				$(o).html('').css('visibility', 'hidden');
			} else {
				$(o).html(rs.msg).css('visibility', 'visible');
			}
			return rs.success;
		},
		doSubmit: function() {
			if (!this.showTip('.err_partyNum span', this.checkPartyNum($('.v_partyNum').val())))
				return false;
			if (!this.showTip('err_pass span', this.checkPassword($('.v_password').val())))
				return false;
			
			$('#loginForm').submit();
			return true;
		}
			
	};	
	
})(JRH, jQuery);