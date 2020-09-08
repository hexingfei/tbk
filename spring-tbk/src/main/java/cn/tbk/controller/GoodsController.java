package cn.tbk.controller;

import cn.tbk.dao.GoodsDetail;
import cn.tbk.dao.business;
import cn.tbk.dao.goods;
import cn.tbk.dao.goodsclassify;
import cn.tbk.query.GoodsQuery;
import cn.tbk.service.BusinessService;
import cn.tbk.service.GoodsClassifyService;
import cn.tbk.service.GoodsService;
import cn.tbk.utils.PageResponse;
import cn.tbk.utils.ResponseCore;
import cn.tbk.utils.ResponseDetailCore;
import cn.tbk.utils.ResponseListCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xfhe on 2019/6/7.
 *
 * @description
 */
@RequestMapping("goods")
@RestController
public class GoodsController
{

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsClassifyService goodsClassifyService;

    @Autowired
    private BusinessService businessService;

    /**
     * @param pageRequest
     * @return
     */
    @RequestMapping("isboutique")
    public ResponseCore getIsboutique(GoodsQuery pageRequest)
    {

        PageResponse<goods> goodsPageResponse = goodsService.getIsboutique(pageRequest);

        return ResponseCore.handleBoolean(goodsPageResponse != null)
            .data(goodsPageResponse, goodsPageResponse.getTotal(), pageRequest.getPageNum(), pageRequest.getPageSize());
    }

    @RequestMapping("list")
    public ResponseListCore getGoodsList(GoodsQuery pageRequest)
    {

        List<goodsclassify> goodsclassifyList = goodsClassifyService.getGoodsClassify(pageRequest.getType());
        PageResponse pageResponse = null;
        if (pageRequest.getType() != null && pageRequest.getClassify() == null)
        {

            pageResponse = goodsClassifyService.getGoodsByClassifyType(pageRequest);
        }
        else
        {

            pageResponse = goodsClassifyService.getGoodsByClassifyId(pageRequest);
        }

        return ResponseListCore.handleBoolean(pageResponse != null)
            .data(pageResponse,
                pageResponse.getTotal(),
                pageRequest.getPageNum(),
                pageRequest.getPageNum(),
                goodsclassifyList);
    }

    @RequestMapping("detail")
    @ResponseBody
    public ResponseDetailCore getGoodsDetail(Integer id, String orderByColumn, String isAsc)
    {

        business business = businessService.getBusiness(id);

        PageResponse pageResponse = businessService.getGoodsByBusinessid(id, orderByColumn, isAsc);



        ResponseDetailCore responseDetailCore = ResponseDetailCore.handleBoolean(pageResponse != null)
            .data(pageResponse, pageResponse.getTotal(), 1, 10, business,goodsService.getGoodsById(id));

        return responseDetailCore;
    }

    public static void main(String[] args)
    {
        List<Long> list=new ArrayList<>();
        list.add(12l);
        list.add(2l);
        list.add(600l);
        list.add(10l);

        list.sort((a,b)->a.compareTo(b.longValue()));
        System.out.println(list.get(list.size()-1));
    }

}
