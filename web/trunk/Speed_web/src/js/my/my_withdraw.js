(function () {
    $('.record_box').on('click','.record_head_item',function(){
        $(this).addClass('active').siblings().removeClass('active')
        $('.record_box').find('.record_list').eq($(this).index()).addClass('active').siblings().removeClass('active')
    })
    
    $('.record_box').on('click','.record_item',function(){
        let _this = $(this),
        id = _this.attr('data-id'),
        type = _this.parent().hasClass('rebate') === true? 'rebate' : 'withdraw'
        window.location.href = `./../../html/my/my_withdraw_details.html?id=${id}&type=${type}`
    })
})()