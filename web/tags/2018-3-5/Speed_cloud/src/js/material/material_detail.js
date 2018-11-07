(function(){
    // 页面传过来的id
    let id = sea__.get_query_str('id') || undefined


    let dp = new DPlayer({
        element: document.getElementById('material_detail_item_player'),
        video: {
            url: './../../video/dsqx.mp4',
            pic: './../../picture/1.jpg'
        }
    })

})()