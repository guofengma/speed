function util(){
    /**
     *toast框
     * @param {string} msg 必传
     * @param {number} timing 默认2s
     */
    this.toast = function(msg,timing){
        timing = timing || 2000;
        $('body').before($('<div class="modal toast" style="display: block;">'+ msg +'</div>'));
        setTimeout(function(){
            $('.toast:first').addClass('modal-in')
        },100)
        setTimeout(function(timing){
            $('.toast:first').removeClass('modal-in').addClass('modal-out')
            setTimeout(function(){
                $('.toast:first').remove()
            },1000)
        },timing)
    }

    /**
     * 提示框
     * @param {string} text 
     * @param {string} title 
     * @param {function} callback 
     */
    this.alert = function(text,title,callback){
        title = title || null;
        if(title !== null){
            $('body').before($('<div class="modal" style="display: block;"><div class="modal-inner"><div class="modal-title">'+ title +'</div><div class="modal-text">'+ text +'</div></div><div class="modal-buttons "><span class="modal-button modal-button-bold">确定</span></div></div>'));
        }else{
            $('body').before($('<div class="modal" style="display: block;"><div class="modal-inner"><div class="modal-text">'+ text +'</div></div><div class="modal-buttons"><span class="modal-button modal-button-bold">确定</span></div></div>'));
        }
        setTimeout(function(){
            $('.modal').addClass('modal-in')
        },100)
        $('.modal-buttons').click(function(){
            setTimeout(function(){
                $('.modal').removeClass('modal-in').addClass('modal-out')
                setTimeout(function(){
                    $('.modal').remove()
                },100)
            },1000)
        })
    }

    this.set_nav = function(){
    	
        var nav_json = [
            {
                "icon":"icon_home",
                "name":"首页",
                "id":"home"
            },
            {
                "icon":"icon_more",
                "name":"产品",
                "id":"product"
            },
            {
                "icon":"icon_trumpet",
                "name":"素材库",
                "id":"material"
            },
            {
                "icon":"icon_cart",
                "name":"购物车",
                "id":"cart"
            },
            {
                "icon":"icon_my",
                "name":"我的",
                "id":"my"
            }
        ]
        var active = 'active',
        nav_name = null,
        nav_icon = null,
        i = 0,
        nav = ''
        for(var val in nav_json){
            if(i >= 1)  active = ''
            i++
            nav += '<li id="'+ nav_json[val].id +'" class="footer_tabbar_item '+ active +'"><div class="footer_tabbar_item_img '+ nav_json[val].icon +' icon"></div><div class="footer_tabbar_item_name">'+ nav_json[val].name +'</div></li>'
        }
        nav = '<nav class="footer_tabbar_box"><ul class="footer_tabbar_list clearfix">'+ nav +'</ul></nav>';
        $('script:first').before(nav);
        $('body').on('click','.footer_tabbar_box .footer_tabbar_item',function(){
            switch ($(this).index()) {
                case 0:
                    sea__.set_footer_tabbar_color($(this).index(),'home');
                    break;
                case 1:
                    sea__.set_footer_tabbar_color($(this).index(),'product');
                    break;
                case 2:
                    sea__.set_footer_tabbar_color($(this).index(),'material');
                    break;
                case 3:
                    sea__.set_footer_tabbar_color($(this).index(),'cart');
                    break;
                default:
                    sea__.set_footer_tabbar_color($(this).index(),'my');
                    break;
            }
        });
    }

    /**
     * 切掉两端空格
     * @param {string} str 
     */
    this.trim = function(str){
        return str.replace(/(^\s*)|(\s*$)/g, "")
    }
    /**
     * 返回上一步
     */
    this.back = function(){
        window.history.back()
    }
    /**
     * 关闭loading
     */
    this.preloader_hide = function(){
        $('#preview').remove()
    }

    /**
     * 显示loading
     */
    this.preloader_show = function(){
        $('body').before($('<div id="preview"><div class="spinner" role="progressbar"><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div></div></div>'))
    }

    /**
     * 获取验证码
     * @param {number} count 默认60s 
     */
    this.getcode = function(count){
        count= count || 60;
        if($('.get_code').hasClass('active')){
            this.toast('请勿重复点击')
            return
        }
        var countdown = setInterval(function(){
            $('.get_code').addClass('active').html(count)
            if (count === 0) {
                $('.get_code').html('获取验证码').removeClass('active')
                clearInterval(countdown)
            }
            count--;
        }, 1000);
    }

    /**
     * 底部导航栏点击切换颜色 
     * @param {number} num  第几个导航
     * @param {string} link 默认 null  导航对应名称
     */
    this.set_footer_tabbar_color = function(num,link){
        num = num || 0,link = link || null;
        $('.footer_tabbar_box').find('.footer_tabbar_item').eq(num).addClass('active').siblings().removeClass('active')
        if(link !== null){
            this.set_footer_tabbar_link(link)
        }
    }

    /**
     * 底部导航栏点击切换跳转事件
     * @param {string} link 传导航名称(name)
     */
    this.set_footer_tabbar_link = function(link){
        switch (link) {
            case 'home':
                window.location.href = ''+window.cxt+'/src/html/common/home.html';
                break;
            case 'product':
                window.location.href = ''+window.cxt+'/src/html/product/product.html';
                break;
            case 'material':
                window.location.href = ''+window.cxt+'/src/html/material/material.html';
                break;
            case 'cart':
                window.location.href = ''+window.cxt+'/src/html/cart/cart.html';
                break;
            default:
                window.location.href = ''+window.cxt+'/src/html/my/my.html';
                break;
        }
    }

    /**
     * 设置banner
     * @param {string} element dom元素id
     * @param {array} data  数组，
     * @param {Boolean} isVertical 默认false  true = 上下 ， false = 左右
     * @param {Boolean} isLooping 默认true    是否循环
     * @param {Boolean} isAutoplay 默认true   是否自动滚动
     */
    this.set_banner = function(element,data,isVertical,isLooping,isAutoplay){
        isVertical = isVertical||false,isLooping=isLooping||true,isAutoplay=isAutoplay||true;
        return new iSlider({
            dom:document.getElementById(element),
            data:data,
            isVertical: isVertical,
            isLooping: isLooping,
            isAutoplay: isAutoplay
        })
    }


    /*
        * 请以后的前端注意！！
        * 1.所谓的父容器和子容器有严格的限制：子容器必须是一个单一的盒子，不能有兄弟元素
        * 2.父容器的高度必须小于子元素的高度值,否则滑动没有意义
        */
    this.iScroll =function(args){
        /*调用的时候没有初始化的话就是初始化一次*/
        this.init(args);
    }
    this.init = function(args){
        /*局部变量来接受当前的this*/
        var that = this;
        /*如果传入的对象是一个Dom对象就把他看作是我们的大容器盒子*/
        if (args.swipeDom && typeof args.swipeDom == 'object') {
            that.parentDom = args.swipeDom;
        }
        /*如果不存在父容器就停止初始化*/
        if (!that.parentDom) return false;
        /*找到子容器*/
        that.childDom = that.parentDom.children && that.parentDom.children[0] ? that.parentDom.children[0] : '';
        /*如果不存在子容器就停止初始化*/
        if (!that.childDom) return false;
        /*初始化传入的参数*/
        that.settings = {};
        /*默认类型  默认的Y轴滑动 如果不是y的话就是以x轴开始滑动*/
        that.settings.swipeType = args.swipeType ? args.swipeType : 'y';
        /*默认的缓冲滑动距离*/
        that.settings.swipeDistance = args.swipeDistance >= 0 ? args.swipeDistance : 150;
        /*初始化滑动*/
        that._scroll();
    }
    this._scroll = function(){
        /*局部变量来接受当前的this*/
        var that = this;
        /*滑动的类型*/
        var type = that.settings.swipeType == 'y' ? true : false;
        /*父容器的高度或宽度*/
        var parentHeight = type ? that.parentDom.offsetHeight : that.parentDom.offsetWidth;
        /*子容器的高度或宽度*/
        var childHeight = type ? that.childDom.offsetHeight : that.childDom.offsetWidth;

        /*子容器没有父容器大的时候*/
        if (childHeight < parentHeight) {
            if (type) {
                that.childDom.style.height = parentHeight + 'px';
                childHeight = parentHeight;
            } else {
                that.childDom.style.width = parentHeight + 'px';
                childHeight = parentHeight;
            }
        }
        /*缓冲距离*/
        var distance = that.settings.swipeDistance;
        /*区间*/
        /*左侧盒子定位的区间*/
        that.maxPostion = 0;
        that.minPostion = -(childHeight - parentHeight);
        /*设置滑动的当前位置*/
        that.currPostion = 0;
        that.startPostion = 0;
        that.endPostion = 0;
        that.movePostion = 0;
        /*1.滑动*/
        that.childDom.addEventListener('touchstart', function(e) {
            /*初始的Y的坐标*/
            that.startPostion = type ? e.touches[0].clientY : e.touches[0].clientX;
        }, false);
        that.childDom.addEventListener('touchmove', function(e) {
            e.preventDefault();
            /*不停的做滑动的时候记录的endY的值*/
            that.endPostion = type ? e.touches[0].clientY : e.touches[0].clientX;
            that.movePostion = that.startPostion - that.endPostion; /*计算了移动的距离*/

            /*2.滑动区间*/
            /*就是滑动区间*/
            if ((that.currPostion - that.movePostion) < (that.maxPostion + distance) &&
                (that.currPostion - that.movePostion) > (that.minPostion - distance)) {
                that._removeTransition();
                that._changeTranslate(that.currPostion - that.movePostion);
            }
        }, false);
        window.addEventListener('touchend', function(e) {
            /*在限制滑动区间之后 重新计算当前定位*/
            /*判断是否在我们的合理定位区间内*/
            /*先向下滑动 */
            if ((that.currPostion - that.movePostion) > that.maxPostion) {
                that.currPostion = that.maxPostion;
                that._addTransition();
                that._changeTranslate(that.currPostion);
            }
            /*想上滑动的时候*/
            else if ((that.currPostion - that.movePostion) < that.minPostion) {
                that.currPostion = that.minPostion;
                that._addTransition();
                that._changeTranslate(that.currPostion);
            }
            /*正常的情况*/
            else {
                that.currPostion = that.currPostion - that.movePostion;
            }
            that._reset();
        }, false);
    }
    this._changeTranslate = function(translate){
        if (this.settings.swipeType == 'y') {
            this.childDom.style.transform = "translateY(" + translate + "px)";
            this.childDom.style.webkitTransform = "translateY(" + translate + "px)";
        } else {
            this.childDom.style.transform = "translateX(" + translate + "px)";
            this.childDom.style.webkitTransform = "translateX(" + translate + "px)";
        }
    }
    this._removeTransition = function(){
        this.childDom.style.transition = "none";
        this.childDom.style.webkitTransition = "none"; /*兼容 老版本webkit内核浏览器*/
    }
    this._addTransition = function() {
        this.childDom.style.transition = "all .2s ease";
        this.childDom.style.webkitTransition = "all .2s ease"; /*兼容 老版本webkit内核浏览器*/
    }
    /*对外开放的设置定位的方法*/
    this.setTranslate = function(translate){
        this.currPostion = translate;
        this._addTransition();
        this._changeTranslate(this.currPostion);
    }
    this._reset = function(){
        var that = this;
        that.startPostion = 0;
        that.endPostion = 0;
        that.movePostion = 0;
    }

    /**
     * 获取url参数 
     * @param {string} key  传入参数名 获取参数值
     */
	this.get_query_str = function(key) {
        var search = location.search.slice(1),
        searchObj = {}
		for(var i = 0; i < search.split('&').length; i++) {
			searchObj[search.split('&')[i].split('=')[0]] = search.split('&')[i].split('=')[1]
		}
		return arguments.length ? searchObj[key] : searchObj
    }
}


// 构造工具
var  sea__ = new util()

// 返回上一步
$('.header_back').click(function(){
    sea__.back();
})