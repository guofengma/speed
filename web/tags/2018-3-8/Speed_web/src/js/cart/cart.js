(function(){
    sea__.set_nav()
    sea__.set_footer_tabbar_color(3);
    sea__.set_footer_tabbar_icon(3,"icon_cart","icon_cart_red");

    $('.header_title_box').on('click','.header_title_cart_management',function(){
        var _this = $(this)
        var cart_checkout_box = $('.cart_checkout_box')
        if(!_this.hasClass('redact')){
            _this.toggleClass('redact')
            cart_checkout_box.toggleClass('redact')
            _this.html('完成')
        }else{
            _this.toggleClass('redact')
            cart_checkout_box.toggleClass('redact')
            _this.html('管理')
        }
    })
    
    // 点选商品
    $('.cart_box').on('click','.cart_item_checkbox',function(){
        var _this = $(this),
        cart_checkbox_list = $('.cart_box .cart_item_checkbox'),
        cart_checkout_checkbox = $('.cart_checkout_box .cart_checkout_checkbox'),
        cart_checkbox_list_length = cart_checkbox_list.length,
        num = 0
        for (var checked_item in cart_checkbox_list) {
            if($(checked_item).prop('checked')) num++
            if(num === cart_checkbox_list_length){
                cart_checkout_checkbox.prop('checked',true)
            }else{
                cart_checkout_checkbox.prop('checked',false)
            }
        }
        count()
    })
    // 购物车选择商品增加
    $('.cart_box').on('click','.cart_item_info_number div',function(){
        var _this = $(this),
        cart_item_info_realnum = _this.siblings('.cart_item_info_realnum'),
        realnum = +cart_item_info_realnum.attr('data-realnum')
        if(_this.hasClass('cart_item_info_subtract')){
            if(realnum <= 0){
                sea__.alert('不能再减了')
            }else{
                realnum--
                cart_item_info_realnum.attr('data-realnum',realnum).val(realnum)
            }
        }else{
            if(realnum >= 99){
                sea__.alert('不能再加了')
            }else{
                realnum++
                cart_item_info_realnum.attr('data-realnum',realnum).val(realnum)
            }
        }
        count()
    })
    // 购物车选择商品数量输入框
    $('.cart_box').on('change','.cart_item_info_realnum',function(){
        var _this = $(this),
        realnum = +_this.val()
        if(realnum === ''){
            console.log('空的');
        }else{
            console.log(realnum)
        }
    })

    // 删除购物车
    $('.cart_checkout_box').on('click','.cart_remove',function(){
        var _this = $(this),
        is_cart_checkbox_list = $('.cart_box .cart_item_checkbox:checked'),
        cart_checkout_checkbox = $('.cart_checkout_box .cart_checkout_checkbox')
        for (var is_cart_checkbox_item in is_cart_checkbox_list) {
            $(is_cart_checkbox_item).parent().remove()
        }
        $(cart_checkout_checkbox).prop('checked',true);
        count()
    })
    // 全选购物车
    $('.cart_checkout_box').on('click','.cart_checkout_checkbox',function(){
        var _this = $(this),
        cart_checkbox_list = $('.cart_box .cart_item_checkbox'),
        is_checked = _this.prop('checked')
        for (let checked_item of cart_checkbox_list) {
            $(checked_item).prop('checked',is_checked)
        }
        count()
        sum_red()
    })
    // 结算购物车
    $('.cart_checkout_box').on('click','.cart_checkout',function(){
        var _this = $(this),
        is_cart_checkbox_list = $('.cart_box .cart_item_checkbox:checked');
        console.log(is_cart_checkbox_list.length);
        if(is_cart_checkbox_list.length === 0) sea__.alert('没有买的商品')
        count()
        window.location.href = ''+window.cxt+'/src/html/cart/submit_order.html';
    })

    function count(){
    	/*购物车中的数量*/
    	var car_num = $(".cart_item").length;
        var is_cart_checkbox_list = $('.cart_box .cart_item_checkbox:checked').parent(),
        cart_sum = 0,
        num = 0
        for (let is_cart_checkbox_item of is_cart_checkbox_list) {
            num += +$(is_cart_checkbox_item).find('.cart_item_info_realnum').attr('data-realnum')
            cart_sum += $(is_cart_checkbox_item).find('.cart_item_info_price').attr('data-price') * $(is_cart_checkbox_item).find('.cart_item_info_realnum').attr('data-realnum')
        }
        $('.cart_sum span').html(cart_sum)
        $('.header_title_box .header_title span').html(car_num)
    }
	/*cm*/
	function sum_red(){
		$(".cart_checkout").css("background-color","red");
		$(".cart_checkout span").css("display","block");
	}
    $('.cart_checkout_checkbox').click();
})()