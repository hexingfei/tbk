package cn.tbk.dao;

import lombok.Data;

/**
 * Created by xfhe on 2019/6/8.
 *
 * @description
 */
@Data
public class ClassifyData
{
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
}
