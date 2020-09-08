// pages/detail/detail.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    color: '#000000',
    selectColor: "rgba(0, 0, 0, .3)",
    imgUrls: ['https://img.alicdn.com/i3/2906932599/O1CN0107DZ3Y1V4NsoNI5Sc_!!2906932599.jpg', 'http://gw.alicdn.com/bao/uploaded/i4/2606147995/O1CN01JFWdV728vl2rERtgp_!!2606147995.jpg', 'http://img.alicdn.com/i2/1834564174/O1CN01sEnJ4C1ghjhImCCKP_!!1834564174.jpg'],
    times: 5000,
    taobao: '../img/taobao.73106e2.png',
    tianmao: '../img/tianmao.ac24378.png',
    hasNextPage: 0,
    detail: {
      iconflag: 2,
      goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
      prices: 147,
      coupon: 10,
      salestotal: 20,
      address: '广东 广州',
      name: '七九一鹿',
      img: 'http://logo.taobaocdn.com/shop-logo/3b/e6/TB1p15dLXXXXXa.aXXXSutbFXXX.jpg'
    },
    business: {

    },
    dataList: [{
      iconflag: 2,
      img: 'http://gw.alicdn.com/bao/uploaded/i2/58951881/TB264MazrSYBuNjSspfXXcZCpXa_!!58951881.jpg',
      id: '1',
      goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
      prices: 135,
      coupon: 10
    }, {
      iconflag: 1,
      img: 'http://gw.alicdn.com/bao/uploaded/i4/2606147995/O1CN01JFWdV728vl2rERtgp_!!2606147995.jpg',
      id: '2',
      goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
      prices: 135,
      coupon: 10
    }, {
      iconflag: 2,
      img: 'http://gw.alicdn.com/bao/uploaded/i4/2606147995/O1CN01JFWdV728vl2rERtgp_!!2606147995.jpg',
      id: '3',
      goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
      prices: 135,
      coupon: 10
    }, {
      iconflag: 1,
      img: 'http://gw.alicdn.com/bao/uploaded/i4/2606147995/O1CN01JFWdV728vl2rERtgp_!!2606147995.jpg',
      id: '5',
      goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
      prices: 135,
      coupon: 10
    }, {
      iconflag: 2,
      img: 'http://gw.alicdn.com/bao/uploaded/i2/58951881/TB264MazrSYBuNjSspfXXcZCpXa_!!58951881.jpg',
      id: '4',
      goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
      prices: 135,
      coupon: 10
    }, {
      iconflag: 2,
      img: 'http://gw.alicdn.com/bao/uploaded/i2/58951881/TB264MazrSYBuNjSspfXXcZCpXa_!!58951881.jpg',
      id: '5',
      goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
      prices: 135,
      coupon: 10
    }]


  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    console.log("id:", options.id);
    wx.setNavigationBarTitle({
      title: '详情页'
    });
    wx.setNavigationBarColor({
      frontColor: '#ffffff',
      backgroundColor: '#ff3163'

    });
    this.getData(options.id, 1, "", "")
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  tolingquan: function() {

   // console.log("ass");
    let tbkcode = '';
    let goodsDesc = '';
    let prices = '';
    let coupon = '';
    wx.navigateTo({
      url: '../tbcode/tbkcode?tbkcode=' + tbkcode + "&goodsDesc=" + goodsDesc + "&prices=" + prices + "&coupon=" + coupon,
    });
  },
  getData: function(id, pageNum, orderByColumn, isAsc) {
    var that = this;
    wx.request({
      url: app.globalData.requestUrl+'goods/detail',
      data: {
        pageNum: pageNum == null ? 1 : pageNum,
        pageSize: 10,
        id: id,
        orderByColumn: orderByColumn,
        isAsc: isAsc
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success(res) {
        console.log("res", res.data)
        let dataList = res.data.data.rows;
        // console.log("res", details)
        that.dataList = dataList;
        let detail = res.data.goodsDetail;
        that.detail = detail;
        let business = res.data.business;
        that.business = business;
        that.hasNextPage = res.data.hasNextPage;
        that.setData({
          dataList: dataList,
          detail: detail,
          business: business,
          hasNextPage: res.data.hasNextPage
        });

        // that.setData({hasNextPage});
      }
    })
  },
  // lower:function(){

  //   console.log("hasNextPage",this.hasNextPage);
  //   console.log("kaishi");
  //   if (this.hasNextPage){

  //     this.getData();
  //   }

  // },
  clickDeatil: function(target) {

    console.log(target.currentTarget.dataset.id);
    let id = target.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../detail/detail?id=' + id,
    })
  }
})