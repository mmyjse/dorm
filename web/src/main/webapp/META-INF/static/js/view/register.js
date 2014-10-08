var ED= ED || {};
jQuery(document).ready(function(){
	ED.Register.init();
});
(function(n, $){
	n.Register = {
		CDN_HOST: $('#cdn_host').val(),
		Require : /.+/,
		Number : /^\d+$/,
		//Email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
		Nickname : /^[a-zA-Z\u4e00-\u9fa5_][0-9a-zA-Z\u4e00-\u9fa5_]*$/,
		init: function() {
			// 服务器端返回错误
			if ($('#er_partyNum').val() != '') {
				n.Register.showTip('#register_error .err_partyNum', {success:false,msg:"手机号已经被使用"});
			}
			if ($('#er_pass').val() != '') {
				n.Register.showTip('#register_error .err_password', {success:false,msg:"密码输入有误，请重新输入"}, {'padding-top': '15px'});
			}
			if ($('#er_rstpass').val() != '') {
				n.Register.showTip('#register_error .err_rstpassword', {success:false,msg:"两次输入的密码不一致，请重新输入"}, {'height': '26px'}, true);
			}
//			if ($('#er_check').val() != '') {
//				n.Register.showTip('#register_error .err_check', {success:false,msg:"验证码输入错误，请重新输入"}, {'padding-top': '16px'});
//			}
			
			// 输入框验证绑定
			$('.v_partyNum').bind('blur', function() {
				n.Register.showTip('#register_error .err_partyNum', n.Register.checkPartyNum($(this).val(), true));
			});
			$('.v_partyNum').bind('focus', function() {	
				$('#register_error .err_partyNum').css('visibility', 'visible');
			});
			$('.v_password').bind('blur', function() {
				n.Register.showTip('#register_error .err_password', n.Register.checkPassword($(this).val()), {'padding-top': '15px'});
			});
			$('.v_password').bind('focus', function() {	
				$('#register_error .err_password').css('visibility', 'visible');
			});
			$('.v_verifyPassword').bind('blur', function() {
				n.Register.showTip('#register_error .err_rstpassword', n.Register.checkVerifyPassword($('.v_password').val(), $(this).val()), {'height': '26px'}, true);
			});
			$('.v_verifyPassword').bind('focus', function() {	
				$('#register_error .err_rstpassword').css('visibility', 'visible');
			});
//			$('.v_pcode').bind('blur', function() {
//				n.Register.showTip('#register_error .err_check', n.Register.checkPcode($(this).val()), {'padding-top': '16px'});
//			});
//			$('.v_pcode').bind('focus', function() {
//				$('#register_error .err_check').css('visibility', 'visible');
//			});
			
//			$('#checkcode_change').click(function() {
//				$('#img_checkcode').attr('src', '/image.do?' + Math.random());
//			});
			
			$('.ipt_sub .sub').click(function() {
				n.Register.doSubmit();
				return false;
			});
		},
		checkPartyNum: function(value, execAsyn) {
			if (!this.Require.test(value)) {
				return {success:false,msg:'请填写手机号码'};
			}
			/*if (!this.Email.test(value)) {
				return {success:false,msg:'邮件地址不正确'};
			}*/
			if (execAsyn) {
				$.get("/user_ajax/isExistsLoginId.json", {loginId : value}, function(response) {
					if (response.success) {
						n.Register.showTip('#register_error .err_partyNum', {success:true});
					} else {
						n.Register.showTip('#register_error .err_partyNum', {success:false,msg:'手机号码已经被使用'});
						return ;
					}
				}, 'json');
			}
			return {success:true,asyn:true};
		},
		checkPassword: function(value) {
			if (!this.Require.test(value)) {
				return {success:false,msg:'请填写密码'};
			}
			if (value.length < 6) {
				return {success:false,msg:'密码太短啦，至少要6位哦'};
			}
			if (value.length > 20) {
				return {success:false,msg:'密码过长，最多20位哦'};
			}
			return {success:true};
		},
		checkVerifyPassword: function(value, verifyPassword) {
			if (!this.Require.test(verifyPassword)) {
				return {success:false,msg:'请重复输入一次密码'};
			}
			if (value != verifyPassword) {
				return {success:false,msg:'两次输入的密码不一致'};
			}
			return {success:true};
		},
//		checkPcode: function(value) {
//			if (!this.Require.test(value)) {
//				return {success:false,msg:'请输入验证码'};
//			}
//			var pcdCookie = $.cookie('pcd');
//			if (value.toLowerCase() != pcdCookie.toLowerCase()) {
//				return {success:false,msg:'验证码输入错误，请重新输入'};
//			}
//			return {success:true};
//		},
		checkBox: function(o) {
			 if($(o).is(":checked")) {
				 return {success:true};
			 }
			 return {success:false};
		}, 
		showTip: function(o, rs, cssArr, customCss) {
			if (!customCss) {
				$(o).css('padding-top', '10px').css('height', '26px');
			}
			if (cssArr) {
				for (css in cssArr) {
					$(o).css(css, cssArr[css]);
				}
			}
			if (rs.success) {
				if (!rs.asyn) {
					$(o).html('<img src="' + n.Register.CDN_HOST + '/images/ok_01.png">');
					$(o).css('visibility', 'visible');
				} else {
					$(o).css('visibility', 'hidden');
				}
			} else {
				$(o).html('<img src="' + n.Register.CDN_HOST + '/images/error1.png"><span style="color:#ff89a7; margin-left:8px; margin-top:0;">' + rs.msg + '</span></div>');
				$(o).css('visibility', 'visible');
			}
			
			return rs.success;
		},
		doSubmit: function() {
			
			if (!this.showTip('#register_error .err_partyNum', this.checkPartyNum($('.v_partyNum').val()), false))
				return false;
			if (!this.showTip('#register_error .err_password', this.checkPassword($('.v_password').val()), {'padding-top': '15px'}))
				return false;
			if (!this.showTip('#register_error .err_rstpassword', this.checkVerifyPassword($('.v_password').val(), $('.v_verifyPassword').val()), {'height': '26px'}, true))
				return false;
//			if (!this.showTip('#register_error .err_check', this.checkPcode($('.v_pcode').val()), {'padding-top': '16px'}))
//				return false;
//			if (!this.checkBox('.v_box').success)
//				return false;
			
			$('#registerForm').submit();
			return true;
		}
			
	};	
	
})(ED, jQuery);