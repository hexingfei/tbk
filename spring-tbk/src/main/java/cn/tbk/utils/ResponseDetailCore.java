package cn.tbk.utils;

import cn.tbk.dao.GoodsDetail;
import cn.tbk.dao.business;
import cn.tbk.enums.ResultEnum;
import lombok.Data;

/**
 * Created by xfhe on 2019/6/8.
 *
 * @description
 */
@Data
public class ResponseDetailCore<T> implements Core
{

    private Integer code;

    private String msg;

    private Integer pageSize;

    private Integer pageNum;

    private Boolean hasNextPage;

    private T data;

    private business business;

    private GoodsDetail goodsDetail;

    public ResponseDetailCore(Integer code, String msg, T data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <E> ResponseDetailCore ResponseCoreFactory(ResultEnum resultEnum)
    {
        return new ResponseDetailCore(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static ResponseDetailCore ok()
    {
        return ResponseCoreFactory(ResultEnum.SUCCESS);
    }

    public static ResponseDetailCore error()
    {
        return ResponseCoreFactory(ResultEnum.ERROR);
    }

    public static ResponseDetailCore handleBoolean(Boolean b)
    {
        return (b != null && b) ? ok() : error();
    }

    public ResponseDetailCore data(T data, Long totalNum, int pageNum, int pageSize, business business,
        GoodsDetail goodsDetail)
    {
        this.data = data;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        int totalPage =
            (int)((totalNum + pageSize - 1) / pageSize);
        if (pageNum < totalPage)
        {

            this.hasNextPage = true;
        }
        else
        {

            this.hasNextPage = false;
        }
        this.business = business;
        this.goodsDetail = goodsDetail;

        return this;
    }
}
