(function(){
    // 设置上下滚动效果
    (function(){
        var height = ($('.dynamic_trade_list').height() - $('.dynamic_trade_list').find('li:first').height()) * -1;
        if(parseInt($('.dynamic_trade_list').css('bottom')) <= height){
            $('.dynamic_trade_list').css('bottom',0)
        }
        $('.dynamic_trade_list').animate({'bottom':height },5000,arguments.callee)
    })();

    // 设置左右滚动效果
    (function(){
        var width = ($('.basic_info_store_name').width() - 30) * -1;
        if(parseInt($('.basic_info_store_name').css('left')) >= width){
            $('.basic_info_store_name').css('left',0)
        }
        $('.basic_info_store_name').animate({'left':width },5000,arguments.callee)
    })();
    
    // 获取列表点击
    $('.newsfeed_ads_box').on('click','.newsfeed_ads_item',function(){
        var index = $(this).index();
        switch (index) {
            case 0:
                window.location.href = ''+window.cxt+'/html/common/today_push.html'
                break;
            case 1:
                window.location.href = ''+window.cxt+'/html/common/sales_campaign.html'
                break;
            default:
                window.location.href = ''+window.cxt+'/html/common/latest_activity.html'
                break;
        }
    })

    sea__.set_nav()
    
})()