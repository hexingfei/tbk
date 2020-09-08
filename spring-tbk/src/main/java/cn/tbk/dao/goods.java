package cn.tbk.dao;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品描述
     */
    private String goodsdesc;

    /**
     * 标头icon(天猫/淘宝)
     */
    private Integer iconflag;

    /**
     * 商品价格
     */
    private BigDecimal prices;

    /**
     * 优惠券
     */
    private Long coupon;

    /**
     * 图片地址
     */
    private String imgurl;

    /**
     * 商家id关联商家表
     */
    private Long businessid;

    /**
     * 关联商品分类id
     */
    private Long goodsclassifyid;

    /**
     * 是否精品
     */
    private Integer isboutique;

    /**
     * 淘宝口令
     */
    private String tbkcode;

    /**
     * 创建时间
     */
    private Date createtime;

    private Integer salestotal;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商品描述
     *
     * @return goodsdesc - 商品描述
     */
    public String getGoodsdesc() {
        return goodsdesc;
    }

    /**
     * 设置商品描述
     *
     * @param goodsdesc 商品描述
     */
    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc;
    }

    /**
     * 获取标头icon(天猫/淘宝)
     *
     * @return iconflag - 标头icon(天猫/淘宝)
     */
    public Integer getIconflag() {
        return iconflag;
    }

    /**
     * 设置标头icon(天猫/淘宝)
     *
     * @param iconflag 标头icon(天猫/淘宝)
     */
    public void setIconflag(Integer iconflag) {
        this.iconflag = iconflag;
    }

    /**
     * 获取商品价格
     *
     * @return prices - 商品价格
     */
    public BigDecimal getPrices() {
        return prices;
    }

    /**
     * 设置商品价格
     *
     * @param prices 商品价格
     */
    public void setPrices(BigDecimal prices) {
        this.prices = prices;
    }

    /**
     * 获取优惠券
     *
     * @return coupon - 优惠券
     */
    public Long getCoupon() {
        return coupon;
    }

    /**
     * 设置优惠券
     *
     * @param coupon 优惠券
     */
    public void setCoupon(Long coupon) {
        this.coupon = coupon;
    }

    /**
     * 获取图片地址
     *
     * @return imgurl - 图片地址
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * 设置图片地址
     *
     * @param imgurl 图片地址
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * 获取商家id关联商家表
     *
     * @return businessid - 商家id关联商家表
     */
    public Long getBusinessid() {
        return businessid;
    }

    /**
     * 设置商家id关联商家表
     *
     * @param businessid 商家id关联商家表
     */
    public void setBusinessid(Long businessid) {
        this.businessid = businessid;
    }

    /**
     * 获取关联商品分类id
     *
     * @return goodsclassifyid - 关联商品分类id
     */
    public Long getGoodsclassifyid() {
        return goodsclassifyid;
    }

    /**
     * 设置关联商品分类id
     *
     * @param goodsclassifyid 关联商品分类id
     */
    public void setGoodsclassifyid(Long goodsclassifyid) {
        this.goodsclassifyid = goodsclassifyid;
    }

    /**
     * 获取是否精品
     *
     * @return isboutique - 是否精品
     */
    public Integer getIsboutique() {
        return isboutique;
    }

    /**
     * 设置是否精品
     *
     * @param isboutique 是否精品
     */
    public void setIsboutique(Integer isboutique) {
        this.isboutique = isboutique;
    }

    /**
     * 获取淘宝口令
     *
     * @return tbkcode - 淘宝口令
     */
    public String getTbkcode() {
        return tbkcode;
    }

    /**
     * 设置淘宝口令
     *
     * @param tbkcode 淘宝口令
     */
    public void setTbkcode(String tbkcode) {
        this.tbkcode = tbkcode;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public Integer getSalestotal()
    {
        return salestotal;
    }

    public void setSalestotal(Integer salestotal)
    {
        this.salestotal = salestotal;
    }
}