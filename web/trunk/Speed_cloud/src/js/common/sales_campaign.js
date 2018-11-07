(function(){

    // 语音
    $('.icon_voice').click(function(){
        console.log(`语音`)
    }) 
    // 切换网格
    $('.header_more').click(function(){
        if($(this).hasClass('icon_more')){
            $(this).removeClass('icon_more').toggleClass('icon_more3')
            $('.search_list').removeClass('default').toggleClass('grid')
        }else{
            $(this).removeClass('icon_more3').toggleClass('icon_more')
            $('.search_list').removeClass('grid').toggleClass('default')
        }
    })

    $('.search_list').on('click','.search_item',function(){
        console.log($(this).index())
    })
})()