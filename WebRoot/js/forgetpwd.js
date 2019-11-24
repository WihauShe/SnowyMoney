
$('#userpassword').focus(function () { 
	$('#userpassword').val(''); 
}) 
$('#useraccount').blur(function () { 
	$("#errormsg1").css("color","red");
	if ($('#useraccount').val() =='') { 
		$('#errormsg1').text('帐号不能为空');
	}else if($('#useraccount').val().length!=11){
		$('#errormsg1').text('帐号为11位');
	}else{
		$('#errormsg1').text('');
	}
});
$('#useremail').blur(function () { 
	$("#errormsg2").css({"color":"red","font-size":"14px"});
	if ($('#useremail').val()=='') { 
		$('#errormsg7').text('邮箱不能为空'); 
	}
})
$('#userpassword1').blur(function () { 
	$("#errormsg3").css("color","red");
	if ($('#userpassword1').val()=='') { 
		$('#errormsg3').text('密码不能为空'); 
	} 
});
$('#userpassword2').blur(function () { 
	$("#errormsg4").css({"color":"red","font-size":"14px"});
	if ($('#userpassword2').val()!=$('#userpassword1').val()) { 
		$('#errormsg4').text('两次输入密码不一致'); 
	}else{
		$('#errormsg7').text('');
	} 
})
function checkChange(){
	if($('#userpassword2').val()!=$('#userpassword1').val()) { 
		return false;
	}else if ($('#userpassword1').val()==''){
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
	$("#useraccount").integer();
});
