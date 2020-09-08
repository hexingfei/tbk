package cn.tbk.dao;

import java.util.Date;
import javax.persistence.*;

public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品分类描述
     */
    private String name;

    /**
     * 商品id
     */
    private Long goodsid;

    /**
     * 销量
     */
    private Long saletotal;

    /**
     * 创建时间
     */
    private Date createTime;

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
     * 获取商品分类描述
     *
     * @return name - 商品分类描述
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品分类描述
     *
     * @param name 商品分类描述
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取商品id
     *
     * @return goodsid - 商品id
     */
    public Long getGoodsid() {
        return goodsid;
    }

    /**
     * 设置商品id
     *
     * @param goodsid 商品id
     */
    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    /**
     * 获取销量
     *
     * @return saletotal - 销量
     */
    public Long getSaletotal() {
        return saletotal;
    }

    /**
     * 设置销量
     *
     * @param saletotal 销量
     */
    public void setSaletotal(Long saletotal) {
        this.saletotal = saletotal;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}