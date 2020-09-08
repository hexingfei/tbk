// pages/tbcode/tbkcode.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    goodsDesc:'明星唐嫣同款连体裤子女2019新款夏黑白拼色阔腿裤气质连体衣女装',
    prices:145,
    coupon:102,
    tbcode:'￥H4bvY4ovpqI￥',
    height:0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    console.log(options.goodsDesc, options.coupon, options.prices, options.tbcode)
    wx.setNavigationBarTitle({
      title: '免费领券'
    });
    wx.setNavigationBarColor({
      frontColor: '#ffffff',
      backgroundColor: '#ff3163'

    });
    var that=this;
    wx.getSystemInfo({
      success: function(res) {
        let height = res.windowHeight*2.34;
        console.log("height", height);
        that.height = height;
        
        that.setData({ height: height});
      },
    })  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

      console.log(2345);
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

    console.log(1111);
   let pages= getCurrentPages();
    console.log(pages);
    wx.navigateBack({
      delta:2
    })
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

    console.log(999999);
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  onclick:function(){
    
    console.log("c", this.data.tbcode);
    wx.setClipboardData({
      data: this.data.tbcode,
      success: function (res) {
        wx.getClipboardData({
          success: function (res) {
            wx.showToast({
              title: '复制成功',
              icon: 'success',
              duration: 2000
            })
          }
        })
      }
    })
  }
})