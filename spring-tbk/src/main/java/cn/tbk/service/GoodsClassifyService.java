package cn.tbk.service;

import cn.tbk.dao.goodsclassify;
import cn.tbk.query.GoodsQuery;
import cn.tbk.utils.PageResponse;

import java.util.List;

/**
 * Created by xfhe on 2019/6/8.
 *
 * @description
 */
public interface GoodsClassifyService
{
    List<goodsclassify> getGoodsClassify(Integer type);

    PageResponse getGoodsByClassifyType(GoodsQuery pageRequest);

    PageResponse getGoodsByClassifyId(GoodsQuery pageRequest);
}
