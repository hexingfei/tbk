package cn.tbk.dao;

import javax.persistence.*;

public class goodsclassify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 图片地址
     */
    private String imgurl;

    /**
     * 商品类型(1女装2男装3美妆4母婴5美食6居家7箱包)
     */
    private Integer type;

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
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取商品类型(1女装2男装3美妆4母婴5美食6居家7箱包)
     *
     * @return type - 商品类型(1女装2男装3美妆4母婴5美食6居家7箱包)
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置商品类型(1女装2男装3美妆4母婴5美食6居家7箱包)
     *
     * @param type 商品类型(1女装2男装3美妆4母婴5美食6居家7箱包)
     */
    public void setType(Integer type) {
        this.type = type;
    }
}