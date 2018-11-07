(function(){
    $('.login').click(function(){
        let phone_form_user = $('.phone_form_box .phone_form_user input').val().trim();
        let phone_form_pwd = $('.phone_form_box .phone_form_pwd input').val().trim();
        sea__.preloader_show();
        $.ajax({
            type: "post",
            url: Speed_cloud_url.api +"login/login.do",
            data:{
                phone:phone_form_user,
                password:phone_form_pwd
           },
            traditional: true,
            dataType: "json",
            success: function(res){
                sea__.preloader_hide()
                sea__.toast('登录成功')
                setTimeout(()=>{
                    window.location.href = './../../html/common/home.html'
                },1000)
           },
           error:function(error){  
                sea__.preloader_hide();
           }
       })
    })
})()