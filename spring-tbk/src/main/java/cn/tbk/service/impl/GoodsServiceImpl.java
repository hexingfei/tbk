package cn.tbk.service.impl;

import cn.tbk.dao.GoodsDetail;
import cn.tbk.dao.goods;
import cn.tbk.mapper.goodsMapper;
import cn.tbk.query.GoodsQuery;
import cn.tbk.service.GoodsService;
import cn.tbk.utils.PageRequest;
import cn.tbk.utils.PageResponse;
import cn.tbk.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Random;

/**
 * Created by xfhe on 2019/6/7.
 *
 * @description
 */
@Service
public class GoodsServiceImpl implements GoodsService
{
    @Autowired
    private goodsMapper goodsMappers;

    @Override
    public PageResponse<goods> getIsboutique(GoodsQuery pageRequest)
    {



        Example example = new Example(goods.class);
        Example.Criteria criteria = example.createCriteria();


        criteria.andEqualTo("isboutique","1");


        PageUtil.offsetPage(pageRequest);
        List<goods> goodsList=goodsMappers.selectByExample(example);

        return PageUtil.getPageResponse(goodsList);
    }

    @Override
    public GoodsDetail getGoodsById(Integer id)
    {

        Example example = new Example(goods.class);
        Example.Criteria criteria = example.createCriteria();


        criteria.andEqualTo("id",id);

        goods goods= goodsMappers.selectOneByExample(example);

        GoodsDetail goodsDetail=new GoodsDetail();
        if (goods !=null){

            goodsDetail.setCoupon(goods.getCoupon());
            goodsDetail.setGoodsdesc(goods.getGoodsdesc());
            goodsDetail.setPrices(goods.getPrices());
            goodsDetail.setSalesTotal((int)(Math.random()*2000));
            goodsDetail.setImgurl(new String[]{goods.getImgurl(),goods.getImgurl(),goods.getImgurl()});
            goodsDetail.setTbkcode(goods.getTbkcode());
            goodsDetail.setIconflag(goods.getIconflag());
        }

        return goodsDetail;
    }
}
