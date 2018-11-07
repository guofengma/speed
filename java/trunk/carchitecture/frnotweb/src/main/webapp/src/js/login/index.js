$(function(){
	 //CM
     //微信授权登录：接微信的端口。得到微信信息的对象。
    $('.login_select_wx').click(function(){
        // android.hello('123123');
       window.location.href = './src/html/login/accredit_succeed.html'
    })
    $('.login_select_phone').click(function(){
        window.location.href = './src/html/login/phone_login.html'
    })
})