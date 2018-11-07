(function(){

    // 获取验证码
    $('.get_code').click(function(){
        sea__.getcode();
    })
    // 提交
    $('.submit').click(function(){
        let login_info_form_user = $('.login_info_form_box .login_info_form_user input').val().trim();
        let login_info_form_code = $('.login_info_form_box .login_info_form_code input').val().trim();
        let login_info_form_pwd = $('.login_info_form_box .login_info_form_pwd input').val().trim();
        let login_info_form_secondary_pwd = $('.login_info_form_box .login_info_form_secondary_pwd input').val().trim();
        let login_info_form_nickname = $('.login_info_form_box .login_info_form_nickname input').val().trim();
        let login_info_form_invitation_code = $('.login_info_form_box .login_info_form_invitation_code input').val().trim();
        console.log(login_info_form_user)
        console.log(login_info_form_code)
        console.log(login_info_form_pwd)
        console.log(login_info_form_secondary_pwd)
        console.log(login_info_form_nickname)
        console.log(login_info_form_invitation_code)
        sea__.preloader_show();
        setTimeout(()=>{
            sea__.preloader_hide();
            sea__.toast('提交成功');
            window.location.href = './../../html/login/login_result.html';
        },3000)
        
    })

    
})()