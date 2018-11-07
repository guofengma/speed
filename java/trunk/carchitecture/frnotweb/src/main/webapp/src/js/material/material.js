(function(){
    sea__.set_nav()
    sea__.set_footer_tabbar_color(1);
	sea__.set_footer_tabbar_icon(1,"icon_trumpet","icon_trumpet_red");
	
	$.ajax({
            type: "get",
            url: Speed_cloud_url.api + "/materiaType/list.do",
            traditional: true,
            dataType: "json",
            success: function(resu){
            	var str = "";
            	var typeId = resu.data[0].id;
            	for (var i = 0; i < resu.data.length; i++) {
            		if( i == 0){
            			str += "<li class='active' data-id="+resu.data[i].id+">"+resu.data[i].name+"</li>";
            		}else{
            			str += "<li data-id="+resu.data[i].id+">"+resu.data[i].name+"</li>";            
            		}
            	}
            	$(".header_title_list").append(str);
            	ajaxList(typeId);
           },
       })	
	$(".header_content_search").click(function(){
		$(".back_color").show();
	})
	$(".cancel").click(function(){
		$(".back_color").hide();
	})
	
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
        $(".header_title_box").find('li').eq($(this).index()).addClass('active').siblings().removeClass('active');
        var typeId = $(this).attr("data-id");
        $(".academy_info_list").empty();
        $(".academy_info_bask").hide();
        if(typeId == 1){
        	 ajaxList(typeId);
        }else if(typeId ==2 ){
        	 ajaxList(typeId);
        }else if(typeId == 4){
	     	$(".academy_info_bask").show();
        }
       
    })
    function ajaxList(typeId){
    	$.ajax({
            type: "get",
            url: Speed_cloud_url.api + "/material/list.do",
            data:{
                typeId:typeId
           },
            traditional: true,
            dataType: "json",
            success: function(result){
            	var str = "";
            	for (var i = 0; i < result.data.length; i++) {
            		str +="<li class='academy_info clearfix' data-id='1'>";
            		str +="<div class='academy_info_img fl'>";
                	str +="<img src='./../../picture/1.jpg' alt=''></div>";
                    str +="<div class='academy_info_detail fl'>";
                	str +="<div class='academy_info_detail_title'>"+result.data[i].title+"</div>";
                	str +="<div class='academy_info_detail_transpond'></div>";
                    str +="<div class='academy_info_detail_content_box clearfix'>";
					str +="<div class='academy_info_detail_content_avatar fl'>";                    
                    str +="<img src="+result.data[i].img+" alt=''></div>";
                    str +="<div class='academy_info_detail_content_name fl'>极速云商</div>";
	                str +="<div class='academy_info_detail_content_time fl'>2018.01.06</div>";           
                    str +="<div class='academy_info_detail_content fl'>"+result.data[i].content+"</div>";
                    str +="</div></div></li>";
            	}
            	$(".academy_info_list").append(str);
           },
       })
    }
	function ajaxTask(){
		$.ajax({
            type: "get",
            url: Speed_cloud_url.api + "/material/list.do",
            data:{
                typeId:typeId
           },
            traditional: true,
            dataType: "json",
            success: function(result){
            	var str = "";
            	for (var i = 0; i < result.data.length; i++) {
            		str +="<li class='academy_info_bask_item'>";
            		str +="<div class='bask_item'>";
            		str +="<div class='bask_user clearfix'>";
		            str +="<div class='bask_user_info_avatar fl'>";
		            str +="<img src='https://ss0.baidu.com/73x1bjeh1BF3odCf/it/u=4262817607,878422095&fm=85&s=2981FD1301527FFD09AC0DFB03005031' alt=''></div>";
					str +="<div class='bask_user_item_info fl'>";		                    
		            str +=" <div class='bask_item_info_name'>极速云商</div>";   
		            str +="<div class='bask_item_info_time fr'>2018.01.06</div></div></div>";
		            str +="<div class='bask_item_info_content_box'>";
		            str +=" <div class='bask_item_info_content'>想拥有一款好车想拥有一款好车.......</div>";       
		            str +="<div class='bask_item_info_content_imgs clearfix'>";    
		            str +="<img src='./../../picture/1.jpg' alt=''>";
		            str +="<img src='./../../picture/1.jpg' alt=''>";   
		            str +="<img src='./../../picture/1.jpg' alt=''>";   
		            str +="<img src='./../../picture/1.jpg' alt=''>";   
		            str +="<img src='./../../picture/1.jpg' alt=''>";   
		            str +="<img src='./../../picture/1.jpg' alt=''>";   
		            str +="<img src='./../../picture/1.jpg' alt=''> </div>";   
		            str +="<div class='bask_item_info_content_transpond'>一键转发<div class='academy_info_detail_transpond'></div></div></div></div></li>";
            	}
            	$(".academy_info_bask").append(str);
           },
       })
	}
    $(".header_title_box").on("click",'.header_title_sub_nav_icon',function(ev){
        $(this).toggleClass('active')
        $(this).siblings('.header_title_sub_nav_box').toggleClass('active')
    })
    
    $('.academy_info_box').on('click','.academy_info',function(){
    	 $('.share').show();
        /*window.location.href = `./../../html/material/material_detail.html?id=${$(this).attr('data-id')}`*/
    })
     $('.transpond_box').on('click','.transpond_cancel',function(){
        $('.transpond_box').hide()
        sea__.toast('取消')
    })
     /*function taskDo(){
     	$(".task").click(function(){
	     	
     })
     }*/
     
})()