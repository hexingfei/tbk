package cn.tbk.mapper;

import cn.tbk.dao.business;
import tk.mybatis.mapper.common.Mapper;

public interface businessMapper extends Mapper<business> {

    business getBusinessByGoodsId(Integer id);
}