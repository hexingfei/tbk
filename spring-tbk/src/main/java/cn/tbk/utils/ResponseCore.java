package cn.tbk.utils;


import cn.tbk.enums.ResultEnum;
import lombok.Data;

/**
 * @ClassName ResponseCore
 * @Author rhb
 * @Description restful返回对象内容-最基本格式
 * @Date 2018-12-17
 * @Version 1.0
 **/
@Data
public class ResponseCore<T> implements Core {
    private Integer code;
    private String msg;
    private Integer pageSize;
    private Integer pageNum;
    private Boolean hasNextPage;
    private T data;


    public ResponseCore() {
    }

    public ResponseCore(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseCore(Integer code, T data) {
        this.code = code;
        this.data = data;
        this.msg = "";
    }

    public ResponseCore(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public static <E> ResponseCore ResponseCoreFactory(Integer code, String msg, E data) {
        return new ResponseCore(code, msg, data);
    }

    public static <E> ResponseCore ResponseCoreFactory(ResultEnum resultEnum) {
        return new ResponseCore(resultEnum.getCode(), resultEnum.getMsg(), null);
    }


    public static ResponseCore ok() {
        return ResponseCoreFactory(ResultEnum.SUCCESS);
    }

    public static ResponseCore error() {
        return ResponseCoreFactory(ResultEnum.ERROR);
    }

    public static ResponseCore handleBoolean(Boolean b) {
        return ( b!=null && b ) ? ok():error();
    }


    public ResponseCore data(T data,Long totalNum,int pageNum,int pageSize) {
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

        return this;
    }



}
