$('#u_name').blur(function () { 
	$("#errormsg1").css("color","red");
	if ($('#u_name').val() =='') { 
		$('#errormsg1').text('用户名不能为空');
	}else{
		$('#errormsg1').text('');
	}
}) 
$('#u_phone').blur(function () { 
	$("#errormsg2").css("color","red");
	if ($('#u_phone').val()=='') { 
		$('#errormsg2').text('手机号不能为空'); 
	}else{
		$('#errormsg2').text('');
	}
})
$('#u_email').blur(function () { 
	$("#errormsg5").css("color","red");
	if ($('#u_email').val()=='') { 
		$('#errormsg5').text('邮箱不能为空'); 
	}else{
		$('#errormsg5').text('');
	}
})
$('#u_pwd1').blur(function () { 
	$("#errormsg6").css("color","red");
	if ($('#u_pwd1').val()=='') { 
		$('#errormsg6').text('密码不能为空'); 
	}else{
		$('#errormsg6').text('');
	}
})
$('#u_pwd2').blur(function () { 
	$("#errormsg7").css({"color":"red","font-size":"14px"});
	if ($('#u_pwd1').val()!=$('#u_pwd2').val()) { 
		$('#errormsg7').text('两次输入密码不一致'); 
	}else{
		$('#errormsg7').text('');
	} 
})
function checkChange(){
	if ($('#u_pwd1').val()=='') { 
		return false;
	}else if($('#u_pwd1').val()!=$('#u_pwd2').val()){
		return false;
	}else{
		return true;
	}
}
jQuery.browser={};
(function(){jQuery.browser.msie=false; 
	jQuery.browser.version=0;
	if(navigator.userAgent.match(/MSIE ([0-9]+)./)){ 
		jQuery.browser.msie=true;jQuery.browser.version=RegExp.$1;
	}
})();
jQuery.fn.integer=function(){ 
	 this.bind("keypress",function(e){ 
		 var code=(e.keyCode?e.keyCode:e.which); //兼容火狐 IE 
		 //火狐下不能使用退格键 
		 if(!$.browser.msie&&(e.keyCode==0x8)){ 
		  return ; 
		 } 
	 	return code >= 48 && code<= 57; 
	 }); 
	 this.bind("paste",function(){ 
		return false; 
	 }); 
	 this.bind("keyup",function(){ 
	 if(/(^0+)/.test(this.value)) 
	 { 
	 this.value = this.value.replace(/^0*/,''); 
	 } 
 }); 
}; 
$(function(){
	$("#u_phone").integer();
	$('#u_age').integer();
    $("#btnsubmit").click(function(){
       	var val=$('input:radio[name="usersex"]:checked').val();
       	if(val==null){
            $("#errormsg3").css("color","red");
            $('#errormsg3').text('请选择性别');
        }

	}); 
});