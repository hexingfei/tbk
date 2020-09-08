// pages/jingxuan/jingxuan.js
//获取应用实例
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    taobao: '../img/taobao.73106e2.png',
    tianmao: '../img/tianmao.ac24378.png',
    color: '#000000',
    selectColor: "rgba(0, 0, 0, .3)",
    imgUrls: ['https://img.alicdn.com/i3/2906932599/O1CN0107DZ3Y1V4NsoNI5Sc_!!2906932599.jpg', 'https://img.alicdn.com/i1/2906932599/O1CN01jf9Gsx1V4NsZTwGDc_!!2906932599.jpg', 'https://img.alicdn.com/i4/2906932599/O1CN01aTRiOK1V4NsbG4iqk_!!2906932599.jpg'],
    times: 5000,
    nav: ['精选', '女装', '男装', '女鞋', '男鞋', '箱包', '钟表'],
    nav_index: [1, 2, 3, 4, 5, 6, 7],
    deafultColor: 'red',
    defaultSaleSortImg: '../img/default.png',
    defaultLaterSortImg: '../img/default.png',
    pageNum:1,
    sales: '',
    laterst: '',
    dataList: [{
      imgurl:'http://gw.alicdn.com/bao/uploaded/i2/58951881/TB264MazrSYBuNjSspfXXcZCpXa_!!58951881.jpg',
      id:'1',
      goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
      prices:135,
      coupon:10
    }, {
        imgurl: 'http://gw.alicdn.com/bao/uploaded/i4/2606147995/O1CN01JFWdV728vl2rERtgp_!!2606147995.jpg',
        id: '2',
        goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
        prices: 135,
        coupon: 10
      }, {
        imgurl: 'http://gw.alicdn.com/bao/uploaded/i4/2606147995/O1CN01JFWdV728vl2rERtgp_!!2606147995.jpg',
        id: '3',
        goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
        prices: 135,
        coupon: 10
      }, {
        imgurl: 'http://gw.alicdn.com/bao/uploaded/i4/2606147995/O1CN01JFWdV728vl2rERtgp_!!2606147995.jpg',
        id: '5',
        goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
        prices: 135,
        coupon: 10
      }, {
        imgurl: 'http://gw.alicdn.com/bao/uploaded/i2/58951881/TB264MazrSYBuNjSspfXXcZCpXa_!!58951881.jpg',
        id: '4',
        goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
        prices: 135,
        coupon: 10
      }, {
        imgurl: 'http://gw.alicdn.com/bao/uploaded/i2/58951881/TB264MazrSYBuNjSspfXXcZCpXa_!!58951881.jpg',
        id: '5',
        goodsdesc: 'vintage久留米冈山帆布硫化鞋女春夏板鞋女嘻哈潮ins小白鞋超火',
        prices: 135,
        coupon: 10
      }],
    zonghe: 1,
    listimg:'../img/taobao.73106e2.png',
    hasNextPage:false
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.onData(1, "", "");
  
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
  onclick: function(result) {
    console.log("result", result.target.dataset);

    let dataSet = result.target.dataset.index;
    console.log("dataSet", dataSet);
    let name = this.data.nav;
    if (dataSet !=0){

      wx.navigateTo({
        url: '../classify/classify?type=' + dataSet + "&name=" + name[dataSet]
      })
    }

    //console.log("abc", this.data.nav);
  },
  // upper:function(){
  //  console.log(1111);
  //     if(this.pageNum==1){
  //       return;
  //     }else{
  //      let pageNo= this.pageNum-1;
  //       this.pageNum=pageNo;
  //       console.log("pageNo",this.pageNum);
  //       this.onData(pageNo,"","");
  //     }
  // },
  /**
   * 加载精选数据
   */
  onData: function(pageNum, orderByColumn, isAsc) {
    wx.showLoading({
      title: '加载中...',
      icon: 'success',
      duration: 500
    });
    let that = this;
    wx.request({
      url: app.globalData.requestUrl+'goods/isboutique', 
      data: {
        pageNum: pageNum == null ? 1 : pageNum,
        pageSize: 10,
        orderByColumn: orderByColumn,
        isAsc: isAsc
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
     
      success(res) {
       // console.log("res",res.data)
     
        let details = res.data.data.rows;
       // console.log("res", details)
        that.pageNum = res.data.pageNum;
        that.hasNextPage = res.data.hasNextPage;
        if (pageNum==1){
          // that.dataList=[];
          that.dataList = details;
          that.setData({ dataList: details });
        }else{
          //console.log("pageNum", pageNum);
          let abc=that.dataList;
        //  console.log("abc", abc);
          let pageDetails = abc.concat(details);
          that.dataList = pageDetails;
          that.setData({ dataList: pageDetails });
        }
       wx.hideLoading();
      }
    });
  },
  /**
   * 排序方法
   */
  sortData: function(target) {

   // console.log("result", target);
    let clickType = target.target.dataset.click;
    console.log(clickType);
    let sort='';
    let sortColum='';
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
        sortColum ='salestotal';
        if (this.data.sales == 'ASC') {
          
          this.setData({
            defaultSaleSortImg: '../img/shengxu.png',
            defaultLaterSortImg: '../img/default.png',
            sales: 'DESC',
            deafultColorSales :'red',
            deafultColorLaterst:'',
            deafultColor: ''
          })
        } else {
          this.setData({
            defaultSaleSortImg: '../img/jiangxu.png',
            defaultLaterSortImg: '../img/default.png',
            sales: 'ASC',
            deafultColorSales: 'red',
            deafultColorLaterst:'',
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
            defaultSaleSortImg:'../img/default.png',
            laterst: 'DESC',
            deafultColorLaterst: 'red',
            deafultColorSales:'',
            deafultColor:''
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
    this.onData(1, sortColum, sort);

  },
  clickDeatil:function(target){

    //console.log(target.currentTarget.dataset.id);
    let id = target.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../detail/detail?id='+id,
    })
  },
  lower: function () {

   // console.log("hasNextPage", this.hasNextPage);
    //console.log("kaishi");
    if (this.hasNextPage) {
      this.onData(this.pageNum+1,"","");
    }

  },

})