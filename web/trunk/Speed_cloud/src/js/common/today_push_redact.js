(function() {
    // 一键转发
    $('.today_push_redact_box').on('click','.today_push_redact_item_info_content_transpond',function(){
        console.log($(this))
        $('.transpond_box').show()
    })

    // 删除图片
    $('.today_push_redact_box').on('click','.icon_delete',function(){
        console.log($(this).parent().remove())
        sea__.alert('aaaaa','123')
    })

    // 转发取消
    $('.transpond_box').on('click','.transpond_cancel',function(){
        $('.transpond_box').hide()
        sea__.toast('取消')
    })

    
})()