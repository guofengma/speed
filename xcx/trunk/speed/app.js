//app.js
App({
  onLaunch: function () {

  },

  getUserInfo: function (cb) {
    var that = this
    if (this.globalData.userInfo) {
      typeof cb == "function" && cb(this.globalData.userInfo)
    } else {
      //调用登录接口
      wx.getUserInfo({
        withCredentials: false,
        success: function (res) {
          that.globalData.userInfo = res.userInfo
          typeof cb == "function" && cb(that.globalData.userInfo)
        }
      })
    }
  },
  // 去掉两遍空白
  trim(str) {
    return str.replace(/(^\s*)|(\s*$)/g, "");
  },
  // 时间格式化
  format(date) {
    var newDate = new Date();
    newDate.setTime(date);
    // Wed Jun 18 2014 
    // console.log(newDate.toDateString());
    // Wed, 18 Jun 2014 02:33:24 GMT 
    // console.log(newDate.toGMTString());
    // 2014-06-18T02:33:24.000Z
    // console.log(newDate.toISOString());
    // 2014-06-18T02:33:24.000Z 
    // console.log(newDate.toJSON());
    // 2014年6月18日 
    // console.log(newDate.toLocaleDateString())
    // return newDate.toLocaleDateString();
    // 2014年6月18日 上午10:33:24 
    return newDate.toLocaleString();
    // 上午10:33:24 
    // console.log(newDate.toLocaleTimeString());
    // Wed Jun 18 2014 10:33:24 GMT+0800 (中国标准时间)
    // console.log(newDate.toString());
    // 10:33:24 GMT+0800 (中国标准时间) 
    // console.log(newDate.toTimeString());
    // Wed, 18 Jun 2014 02:33:24 GMT
    // console.log(newDate.toUTCString());

  },
  // 时间格式化
  formatData(date) {
    var newDate = new Date();
    newDate.setTime(date);
    // Wed Jun 18 2014 
    // console.log(newDate.toDateString());
    // Wed, 18 Jun 2014 02:33:24 GMT 
    // console.log(newDate.toGMTString());
    // 2014-06-18T02:33:24.000Z
    // console.log(newDate.toISOString());
    // 2014-06-18T02:33:24.000Z 
    // console.log(newDate.toJSON());
    // 2014年6月18日 
    // console.log(newDate.toLocaleDateString())
    return newDate.toLocaleDateString();
    // 2014年6月18日 上午10:33:24 
    // console.log(newDate.toLocaleString());
    // 上午10:33:24 
    // console.log(newDate.toLocaleTimeString());
    // Wed Jun 18 2014 10:33:24 GMT+0800 (中国标准时间)
    // console.log(newDate.toString());
    // 10:33:24 GMT+0800 (中国标准时间) 
    // console.log(newDate.toTimeString());
    // Wed, 18 Jun 2014 02:33:24 GMT
    // console.log(newDate.toUTCString());

  },
  // 时间格式化
  formatTime(date) {
    var newDate = new Date();
    newDate.setTime(date);
    // Wed Jun 18 2014 
    // console.log(newDate.toDateString());
    // Wed, 18 Jun 2014 02:33:24 GMT 
    // console.log(newDate.toGMTString());
    // 2014-06-18T02:33:24.000Z
    // console.log(newDate.toISOString());
    // 2014-06-18T02:33:24.000Z 
    // console.log(newDate.toJSON());
    // 2014年6月18日 
    // console.log(newDate.toLocaleDateString())
    // 2014年6月18日 上午10:33:24 
    // console.log(newDate.toLocaleString());
    // 上午10:33:24 
    return newDate.toLocaleTimeString();
    // console.log(newDate.toLocaleTimeString());
    // Wed Jun 18 2014 10:33:24 GMT+0800 (中国标准时间)
    // console.log(newDate.toString());
    // 10:33:24 GMT+0800 (中国标准时间) 
    // console.log(newDate.toTimeString());
    // Wed, 18 Jun 2014 02:33:24 GMT
    // console.log(newDate.toUTCString());

  },
  globalData: {
    userId: null, //用户id
    cartId: null,//购物车id   
    // 一号店
    server: "https://www.lessismore520.com/shopapi/",
    // server: "http://www.nicholeyep.com:7001/shop1api",
    userInfo: null,
    cart: [],//购物车
    addr: [],//用户地址
    // cartMatList:[],//用户购物车列表
    sellerId: 1,
    mapkey: '7031d1977df395840f166c3f5e942a5b',
    sellerInfo: {
      //卖家信息
      name: "少即多科技有限公司",
      address: "广州市白云区人和凤岗路九洲创意园8号C栋B208",
      phone: "13903015854"
    }
  }
})
