(function(){
	/*cm*/
    sea__.set_nav()
    sea__.set_footer_tabbar_color(0);
	sea__.set_footer_tabbar_icon(0,"icon_more","icon_more_red");
	$("input[type='search']").focus(function(){
		$('.transpond_box').show();
	})
	$(".cancel").click(function(){
		$('.transpond_box').hide();
	})
	$(".search_delete").click(function(){
		sea__.alert('是否删除搜索记录');
		$(".search_history_new ul").empty();
	})
    var banner_data = [
        {
            "image_url":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517566542185&di=095ed4bb23d2f4b4c7beee321d9550c2&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F017d1558ca6a3ca801219c776917d7.jpg",
            "link":""+window.cxt+"/src/html/common/home.html",
            "id":1
        },
        {
            "image_url":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517566542184&di=27cc7af07fafc92d205da631cf63bdb0&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c61158bcd675a801219c77625451.png",
            "link":""+window.cxt+"/src/html/common/home.html",
            "id":2
        },
        {
            "image_url":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517566542184&di=b5aba336b40a7f15d38c8a947dbb4cd4&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F014726566af87032f8755ac641960a.jpg",
            "link":""+window.cxt+"/src/html/common/home.html",
            "id":3
        }
    ]
    var banner = new Array;
    for(var val in banner_data){
        banner.push({
                /*content: `<a href="${val.link}?id=${val.id}"><img src="${val.image_url}" alt=""></a>`*/
               content:'<a href="'+banner_data[val].link+'?id='+banner_data[val].id+'"><img src="'+banner_data[val].image_url+'" alt=""></a>'
            })
    }
    sea__.set_banner('banner',banner)

    sea__.iScroll({
        /*你想滑动的内容的父容器*/
        swipeDom: document.querySelector('.classify_nav'),
        /*滑动的方向 */
        swipeType: 'y',
        /*滑动的弹簧区间*/
        swipeDistance: 100
    });

    $('.shopping_box').on('click','.classify_nav_list .classify_nav_item',function(){
    	/*cm*/
    	var str = $(this).attr('class');
    	if(str.indexOf('frist')<0){
    		$(".more").removeClass('none');
    	}else{
    		$(".more").addClass('none');
    	}
    	
        $(this).addClass('active').siblings().removeClass('active')
    })
    $('.shopping_box').on('click','.commodity_box .commodity_item',function(){
        console.log($(this).attr('data-id'))
    })
})()