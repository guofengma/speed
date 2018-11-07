(function(){
    sea__.set_nav()
    sea__.set_footer_tabbar_color(1);
	sea__.set_footer_tabbar_icon(1,"icon_trumpet","icon_trumpet_red");
	
	$(".header_content_search").click(function(){
		$(".back_color").show();
	})
	$(".cancel").click(function(){
		$(".back_color").hide();
	})
	
    let item_width_length = $('.header_title_list').find('li').length
    let item_width = $('.header_title_list').find('li').width() + 15
    $('.header_title_box .header_title_list').width(item_width_length * item_width)
    sea__.iScroll({
        swipeDom: document.querySelector('.header_title_list_box'),
        swipeType: 'x',
        swipeDistance: 100
    });

    $(".header_title_box").on("click",'li',function(ev){
        $(this).parents('.header_title_sub_nav_box').toggleClass('active')
        $(".header_title_box").find('li').eq($(this).index()).addClass('active').siblings().removeClass('active')
    })

    $(".header_title_box").on("click",'.header_title_sub_nav_icon',function(ev){
        $(this).toggleClass('active')
        $(this).siblings('.header_title_sub_nav_box').toggleClass('active')
    })
    
    $('.academy_info_box').on('click','.academy_info',function(){
    	 $('.share').show();
        /*window.location.href = `./../../html/material/material_detail.html?id=${$(this).attr('data-id')}`*/
    })
     $('.transpond_box').on('click','.transpond_cancel',function(){
        $('.transpond_box').hide()
        sea__.toast('取消')
    })
     $(".task").click(function(){
     	$(".academy_info_list").hide();
     	$(".academy_info_bask").show();
     })
})()