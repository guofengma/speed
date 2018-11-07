(function(){
    // 页面传过来的id
    let id = sea__.get_query_str('id') || undefined


    let dp = new DPlayer({
        element: document.getElementById('material_detail_item_player'),
        video: {
            url: 'https://www.nicholeyep.com:5000/src/video/dsqx.mp4',
            pic: './../../picture/1.jpg'
        }
    })
	$(".bask_item_info_content_transpond").click(function(){
		
	})
})()