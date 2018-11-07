(function(){
    sea__.set_nav()
    sea__.set_footer_tabbar_color(4);

    $('.header_service').click(function(){
        console.log('转到客服')
    })
    $('.user_info_box').click(function(){
        window.location.href = `./../../html/my/personal_info.html`
    })
    $('.my_list_box').on('click','.my_list li > div',function(){
        let index = $(this).index(),
        item = $(this).parent()
        if(item.hasClass('my_order_item')){
            let link = `./../../html/my/my_order.html?index=${index}`
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
                window.location.href = `./../../html/my/my_client.html`
                break;
            case 1:
                window.location.href = `tel:400 168 2727`
                break;
            case 2:
                window.location.href = `./../../html/my/my_setting.html`
                break;
        }
    })
    
    $('.academy .more').click(function(){
        window.location.href = `./../../html/material/material.html`
    })

})()