package cn.tbk.service;

import cn.tbk.dao.business;
import cn.tbk.utils.PageResponse;

/**
 * Created by xfhe on 2019/6/8.
 *
 * @description
 */
public interface BusinessService
{

    business getBusiness(Integer id);

    PageResponse getGoodsByBusinessid(Integer id,String orderByColumn,String isAsc);
}
