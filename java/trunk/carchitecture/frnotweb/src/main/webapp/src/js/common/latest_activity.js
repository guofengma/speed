(function() {


    // 每一项的id
    $('.latest_activity_box').on('click','.latest_activity_item',function(){
       window.location.href = `./../../html/common/latest_activity_details.html?id=${$(this).attr('data-id')}`
    })

})()