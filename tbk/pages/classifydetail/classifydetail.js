// pages/classify/classify.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    taobao: '../img/taobao.73106e2.png',
    tianmao: '../img/tianmao.ac24378.png',
    deafultColor: 'red',
    defaultSaleSortImg: '../img/default.png',
    defaultLaterSortImg: '../img/default.png',
    pageNum: 1,
    sales: '',
    laterst: '',
    zonghe: 1,
    dataList: [],
    dataMenu: [],
    pageNum: 1,
    hasNextPage: false,
    orderByColumn: '',
    isAsc: '',
    classify: '',
    height: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

    let classify = options.classify;
    console.log("type", classify);
    wx.setNavigationBarTitle({
      title: options.name
    });
    wx.setNavigationBarColor({
      frontColor: '#ffffff',
      backgroundColor: '#ff3163'

    });
    this.onData('', '', 1, classify);
    this.setData({
      classify: classify
    })
    var that = this;
    wx.getSystemInfo({
      success: function(res) {
        let height = res.windowHeight * 2.34;
        console.log("height", height);
        that.height = height;
        that.setData({
          height: height,
          scrollHeight: height - 250
        });
      },
    })

  },

  clickDeatil: function(target) {

    //console.log(target.currentTarget.dataset.id);
    let id = target.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../detail/detail?id=' + id,
    })
  },

  onData: function(orderByColumn, isAsc, pageNum, classify) {
    let that = this;
    console.log("classify", classify);
    wx.request({
      url: app.globalData.requestUrl+'goods/list',
      data: {
        pageNum: pageNum == null ? 1 : pageNum,
        pageSize: 10,
        orderByColumn: orderByColumn,
        isAsc: isAsc,
        classify: classify
      },
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      success(res) {
        console.log("res", res.data);
        let details = res.data.data.rows;
        // console.log("res", details)
        that.pageNum = res.data.pageNum;
        that.hasNextPage = res.data.hasNextPage;
        var menu = res.data.classifyData;
        var dataList = details
        that.setData({
          dataList: dataList,
          dataMenu: menu
        });
      }
    })
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
  /**
   * 排序方法
   */
  sortData: function(target) {

    // console.log("result", target);
    let clickType = target.target.dataset.click;
    console.log(clickType);
    let sort = '';
    let sortColum = '';
    switch (clickType) {
      //点击的综合
      case 1:
        this.setData({
          deafultColorSales: '',
          deafultColorLaterst: '',
          deafultColor: 'red'
        });
        break;
        //点击的销量
      case 2:
        //正序
        sort = this.data.sales;
        sortColum = 'salestotal';
        if (this.data.sales == 'ASC') {

          this.setData({
            defaultSaleSortImg: '../img/shengxu.png',
            defaultLaterSortImg: '../img/default.png',
            sales: 'DESC',
            deafultColorSales: 'red',
            deafultColorLaterst: '',
            deafultColor: ''
          })
        } else {
          this.setData({
            defaultSaleSortImg: '../img/jiangxu.png',
            defaultLaterSortImg: '../img/default.png',
            sales: 'ASC',
            deafultColorSales: 'red',
            deafultColorLaterst: '',
            deafultColor: ''
          })
        }
        break;
        //点击的最新
      case 3:
        //正序
        sort = this.data.laterst;
        sortColum = 'createtime';
        if (this.data.laterst == 'ASC') {
          this.setData({
            defaultLaterSortImg: '../img/shengxu.png',
            defaultSaleSortImg: '../img/default.png',
            laterst: 'DESC',
            deafultColorLaterst: 'red',
            deafultColorSales: '',
            deafultColor: ''
          })
        } else {
          this.setData({
            defaultLaterSortImg: '../img/jiangxu.png',
            defaultSaleSortImg: '../img/default.png',
            laterst: 'ASC',
            deafultColorLaterst: 'red',
            deafultColorSales: '',
            deafultColor: ''
          })
        }
        break;
    }
    this.onData(sortColum, sort, 1, this.data.classify);

  }
})