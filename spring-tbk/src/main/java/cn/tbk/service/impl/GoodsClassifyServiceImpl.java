package cn.tbk.service.impl;

import cn.tbk.dao.goods;
import cn.tbk.dao.goodsclassify;
import cn.tbk.mapper.goodsMapper;
import cn.tbk.mapper.goodsclassifyMapper;
import cn.tbk.query.GoodsQuery;
import cn.tbk.service.GoodsClassifyService;
import cn.tbk.utils.PageResponse;
import cn.tbk.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xfhe on 2019/6/8.
 *
 * @description
 */
@Service
public class GoodsClassifyServiceImpl implements GoodsClassifyService
{

    @Autowired
    goodsclassifyMapper goodsclassifyMappers;

    @Autowired
    private cn.tbk.mapper.goodsMapper goodsMappers;

    @Override
    public List<goodsclassify> getGoodsClassify(Integer type)
    {

        Example example = new Example(goodsclassify.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("type", type);

        List<goodsclassify> goodsclassifyList = goodsclassifyMappers.selectByExample(example);
        return goodsclassifyList;
    }

    /**
     * 获取大类下的商品 带排序
     *
     * @param type
     * @return
     * @author hexingfei
     * @date 2019/6/8 8:57 PM
     */
    @Override
    public PageResponse getGoodsByClassifyType(GoodsQuery pageRequest)
    {

        Map<String, Object> paramap = new HashMap<>();

        paramap.put("type", pageRequest.getType());

        paramap.put("orderByColumn", pageRequest.getOrderByColumn());

        paramap.put("isAsc", pageRequest.getIsAsc());

        PageUtil.offsetPage(pageRequest);

        List<goods> goodsList = goodsMappers.getGoodsByClassifyType(paramap);

        return PageUtil.getPageResponse(goodsList);
    }

    /**
     * 获取二级类下的商品 带排序
     *
     * @param id
     * @return
     * @author hexingfei
     * @date 2019/6/8 8:57 PM
     */
    @Override
    public PageResponse getGoodsByClassifyId(GoodsQuery pageRequest)
    {

        Map<String, Object> paramap = new HashMap<>();

        paramap.put("id", pageRequest.getClassify());

        paramap.put("orderByColumn", pageRequest.getOrderByColumn());

        paramap.put("isAsc", pageRequest.getIsAsc());
        PageUtil.offsetPage(pageRequest);

        List<goods> goodsList = goodsMappers.getGoodsByClassifyid(paramap);

        return PageUtil.getPageResponse(goodsList);
    }
}
