(function(){
    $('.login').click(function(){
        let phone_form_user = $('.phone_form_box .phone_form_user input').val().trim();
        let phone_form_pwd = $('.phone_form_box .phone_form_pwd input').val().trim();
        console.log(phone_form_user)
        console.log(phone_form_pwd)
        sea__.preloader_show();
        setTimeout(()=>{
            sea__.preloader_hide();
            sea__.toast('登录成功');
            setTimeout(()=>{
                window.location.href = './../../html/common/home.html';
            },1000)
        },3000)
    })
})()