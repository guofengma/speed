(function() {

    // 一键转发
    $('.today_push_box').on('click','.today_push_item_info_content_transpond',function(){
        console.log($(this))
        $('.transpond_box').show()
    })

    // 转发取消
    $('.transpond_box').on('click','.transpond_cancel',function(){
        $('.transpond_box').hide()
        sea__.toast('取消')
    })

    // 编辑
    $('.today_push_box').on('click','.today_push_item_info_redact',function(){
        console.log($(this))
        window.location.href = ''+res+'/html/common/today_push_redact.html'
    })

})()