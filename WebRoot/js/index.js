$('#home').click(function(){
	$('#homepage').css('display','block');
	$('#search_job').css('display','none');
	$('#publish_job').css('display','none');
	$('#personal_info').css('display','none');
});
$('#search').click(function(){
	$('#homepage').css('display','none');
	$('#search_job').css('display','block');
	$('#publish_job').css('display','none');
	$('#personal_info').css('display','none');
});
$('#publish').click(function(){
	$('#homepage').css('display','none');
	$('#search_job').css('display','none');
	$('#publish_job').css('display','block');
	$('#personal_info').css('display','none');
});
$('#personal').click(function(){
	$('#homepage').css('display','none');
	$('#search_job').css('display','none');
	$('#publish_job').css('display','none');
	$('#personal_info').css('display','block');
})



$(function(){
	$('#homepage').css('display','block');
	$('#search_job').css('display','none');
	$('#publish_job').css('display','none');
	$('#personal_info').css('display','none');
})
