package cn.tbk.mapper;

import cn.tbk.dao.goods;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface goodsMapper extends Mapper<goods> {

    /** 依据大类ID查询大类下面的商品*/
    List<goods>  getGoodsByClassifyType(Map<String,Object> paramap);

    List<goods> getGoodsByClassifyid(Map<String,Object> paramap);

    goods getGoodsByBusinessid(Map<String,Object> paramap);


}