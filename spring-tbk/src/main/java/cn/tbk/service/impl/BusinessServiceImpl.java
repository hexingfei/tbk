package cn.tbk.service.impl;

import cn.tbk.dao.business;
import cn.tbk.dao.goods;
import cn.tbk.mapper.businessMapper;
import cn.tbk.mapper.goodsMapper;
import cn.tbk.query.GoodsQuery;
import cn.tbk.service.BusinessService;
import cn.tbk.utils.PageResponse;
import cn.tbk.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xfhe on 2019/6/8.
 *
 * @description
 */
@Service
public class BusinessServiceImpl implements BusinessService
{
    @Autowired
    private businessMapper businessMappers;

    @Autowired
    private goodsMapper  goodsMappers;

    @Override
    public business getBusiness(Integer id)
    {


        business busines= businessMappers.getBusinessByGoodsId(id);

        return busines;
    }

    @Override
    public PageResponse getGoodsByBusinessid(Integer id,String orderByColumn,String isAsc){

        Map<String,Object> map=new HashMap<>();

        map.put("id",id);
        map.put("orderByColumn",orderByColumn);
        map.put("isAsc",isAsc);
        goods goods=goodsMappers.getGoodsByBusinessid(map);



        map.put("id",goods.getGoodsclassifyid());
        map.put("orderByColumn",null);
        GoodsQuery query=new GoodsQuery();
        query.setPageNum(1);
        query.setPageSize(20);
        PageUtil.offsetPage(query);
        List<goods> goodsList=goodsMappers.getGoodsByClassifyid(map);

        return PageUtil.getPageResponse(goodsList);
    }
}
