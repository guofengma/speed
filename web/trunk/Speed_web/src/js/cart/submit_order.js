(function(){
	/*cm*/
    $(".transpond_close").click(function(){
    	 $('.transpond_box').hide();
        sea__.toast('取消')
    })
    $(".submit_order_checkout ").click(function(){
    	$('.transpond_box').show();
    })
})()