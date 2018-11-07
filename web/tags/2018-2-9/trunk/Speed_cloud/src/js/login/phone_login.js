(function(){
    $('.login').click(function(){
        var phone_form_user = $('.phone_form_box .phone_form_user input').val().trim();
        var phone_form_pwd = $('.phone_form_box .phone_form_pwd input').val().trim();
        sea__.preloader_show();
        $.ajax({
            type: "post",
            url: Speed_cloud_url.api +path,
            data:{
                phone:phone_form_user,
                password:phone_form_pwd
           },
            traditional: true,
            dataType: "json",
            success: function(res){
                sea__.preloader_hide();
                sea__.toast('登录成功');
                setTimeout(function(){
                    window.location.href = ''+window.cxt+'/src/html/common/home.html'
                },1000)
           },
           error:function(error){  
                sea__.preloader_hide();
           }
       })
    })
})()