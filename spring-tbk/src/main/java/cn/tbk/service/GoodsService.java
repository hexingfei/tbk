package cn.tbk.service;

import cn.tbk.dao.GoodsDetail;
import cn.tbk.dao.goods;
import cn.tbk.query.GoodsQuery;
import cn.tbk.utils.PageRequest;
import cn.tbk.utils.PageResponse;

/**
 * Created by xfhe on 2019/6/7.
 *
 * @description
 */
public interface GoodsService
{
    /**查询精品内容带分页 */
    PageResponse<goods> getIsboutique(GoodsQuery pageRequest);


    GoodsDetail getGoodsById(Integer id);
}
