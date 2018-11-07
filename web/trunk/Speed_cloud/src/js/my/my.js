(function(){
    sea__.set_nav()
    sea__.set_footer_tabbar_color(4);

    $('.header_service').click(function(){
        console.log('转到客服')
    })
    $('.user_info_box').click(function(){
        window.location.href = './../../html/my/personal_info.html';
    })
    $('.my_list_box').on('click','.my_list li > div',function(){
        var index = $(this).index(),
        item = $(this).parent()
        if(item.hasClass('my_order_item')){
            var link = './../../html/my/my_order.html?index=${index}';
            switch (index) {
                case 0:
                    window.location.href = link
                    break;
                case 1:
                    window.location.href = link
                    break;
                case 2:
                    window.location.href = link
                    break;
                case 3:
                    window.location.href = link
                    break;
            }
        }else if(item.hasClass('my_wallet_item')){
            switch (index) {
                case 0:
                    window.location.href = `./../../html/my/my_wallet.html`
                    break;
                case 1:
                    window.location.href = `./../../html/my/my_imazamox.html`
                    break;
                case 2:
                    window.location.href = `./../../html/my/my_coupon.html`
                    break;
                case 3:
                    window.location.href = `./../../html/my/my_withdraw.html`
                    break;
            }
        }else if(item.hasClass('my_store_item')){
            switch (index) {
                case 0:
                    window.location.href = `./../../html/my/my_store.html`
                    break;
                case 1:
                    window.location.href = `./../../html/my/my_imazamox.html`
                    break;
                case 2:
                    window.location.href = `./../../html/my/my_client.html`
                    break;
                case 3:
                    window.location.href = `./../../html/my/my_store_order.html`
                    break;
            }
        }
    })
    
    $('.fn_list_box').on('click','.fn_item',function(){
        switch ($(this).index()) {
            case 0:
                window.location.href = `./../../html/my/applet_code.html`
                break;
            case 1:
                window.location.href = `./../../html/my/my_withdraw.html`
                break;
            case 2:
                window.location.href = `tel:${$('.selectServiceInfo').html()}`
                break;
            case 3:
                window.location.href = `./../../html/my/my_setting.html`
                break;
        }
    })
    
    $('.academy .more').click(function(){
        window.location.href = `./../../html/material/material.html`
    })

    // 订单数量
    $.ajax({
        type: "get",
        url: Speed_cloud_url.api +"my/selectOrderInfo.do",
        success: function(res){
            let index = 0
            for (let i in res.data) {
                $('.my_order_item .my_item').eq(index).find('.my_item_num').html(res.data[i])
                index++
            }
       },
       error:function(error){  
           
       }
   })
   // 店铺产品数量
   $.ajax({
        type: "get",
        url: Speed_cloud_url.api +"my/selectShopInfo.do",
        success: function(res){
            let index = 0
            for (let i in res.data) {
                $('.my_store_item .my_item').eq(index).find('.my_item_num').html(res.data[i])
                index++
            }
       },
       error:function(error){  
           
       }
   })
   // 客服电话
   $.ajax({
        type: "get",
        url: Speed_cloud_url.api +"my/selectServiceInfo.do",
        success: function(res){
            $('.selectServiceInfo').html(res.data.servicePhone)
        },
        error:function(error){  
            
        }
    })

   // 用户信息
   $.ajax({
        type: "get",
        url: Speed_cloud_url.api +"user/getUserInfo.do",
        success: function(res){
           console.log(res)
        },
        error:function(error){  
            
        }
    })
})()