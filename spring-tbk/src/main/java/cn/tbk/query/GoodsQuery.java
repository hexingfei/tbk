package cn.tbk.query;

import lombok.Data;

/**
 * Created by xfhe on 2019/6/7.
 *
 * @description
 */
@Data
public class GoodsQuery
{

    private Integer type;

    private Integer classify;

    private Integer pageNum;

    private Integer pageSize;

    private String orderByColumn; //排序字段

    private String isAsc;//正序 倒序
}
