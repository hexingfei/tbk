package cn.tbk.dao;

import java.util.Date;
import javax.persistence.*;

public class business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商家名称
     */
    private String name;

    /**
     * 评分
     */
    private String score;

    /**
     * 地址
     */
    private String address;

    /**
     * 商家id
     */
    private String telphone;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 商家图片
     */
    private String imgurl;


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
     * 获取商家名称
     *
     * @return name - 商家名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商家名称
     *
     * @param name 商家名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取评分
     *
     * @return score - 评分
     */
    public String getScore() {
        return score;
    }

    /**
     * 设置评分
     *
     * @param score 评分
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取商家id
     *
     * @return telphone - 商家id
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * 设置商家id
     *
     * @param telphone 商家id
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取商家图片
     *
     * @return imgurl - 商家图片
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * 设置商家图片
     *
     * @param imgurl 商家图片
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}