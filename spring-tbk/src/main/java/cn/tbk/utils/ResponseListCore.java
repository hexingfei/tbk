package cn.tbk.utils;

import cn.tbk.dao.ClassifyData;
import cn.tbk.dao.goodsclassify;
import cn.tbk.enums.ResultEnum;
import lombok.Data;

import java.util.List;

/**
 * Created by xfhe on 2019/6/8.
 *
 * @description
 */
@Data
public class ResponseListCore<T> implements  Core
{
    private Integer code;
    private String msg;
    private Integer pageSize;
    private Integer pageNum;
    private Boolean hasNextPage;
    private T data;

    private List<goodsclassify> classifyData;

    public ResponseListCore(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <E> ResponseListCore ResponseCoreFactory(ResultEnum resultEnum) {
        return new ResponseListCore(resultEnum.getCode(), resultEnum.getMsg(), null);
    }


    public static ResponseListCore ok() {
        return ResponseCoreFactory(ResultEnum.SUCCESS);
    }

    public static ResponseListCore error() {
        return ResponseCoreFactory(ResultEnum.ERROR);
    }

    public static ResponseListCore handleBoolean(Boolean b) {
        return ( b!=null && b ) ? ok():error();
    }

    public ResponseListCore data(T data,Long totalNum,int pageNum,int pageSize,List<goodsclassify> classifyData) {
        this.data = data;
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        int totalPage =
            (int)((totalNum + pageSize - 1)/ pageSize);
        if (pageNum<totalPage){

            this.hasNextPage=true;
        }else{

            this.hasNextPage=false;
        }
        this.classifyData=classifyData;

        return this;
    }

}
