(function(){
    sea__.set_nav()
    sea__.set_footer_tabbar_color(2);


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
        window.location.href = `./../../html/material/material_detail.html?id=${$(this).attr('data-id')}`
    })
})()