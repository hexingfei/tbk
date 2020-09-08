package cn.tbk.dao;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by xfhe on 2019/6/9.
 *
 * @description
 */
@Data
public class GoodsDetail
{

    /**
     * 商品描述
     */
    private String goodsdesc;

    /**
     * 销量
     */
    private Integer salesTotal;

    /**
     * 销量
     */
    private String[] imgurl;

    /**
     * 商品价格
     */
    private BigDecimal prices;

    /**
     * 优惠券
     */
    private Long coupon;

    /**
     *
     */
    private String tbkcode;

    private Integer iconflag;
}
