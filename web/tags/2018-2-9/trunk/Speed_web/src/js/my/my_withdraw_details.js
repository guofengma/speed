(function(){
    let type = sea__.get_query_str('type'),
    id = sea__.get_query_str('id')
    if(type === 'rebate'){
        $('.header_title').html('返佣明细详情')
        $('.rebate').addClass('active')
    }else{
        $('.header_title').html('提现明细详情')
        $('.withdraw').addClass('active')
    }
    
})()