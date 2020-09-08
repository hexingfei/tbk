package cn.tbk.utils;

import lombok.Data;

/**
 * @ClassName PageResponse
 * @Author rhb
 * @Description 后端分页返回对象
 * @Date 2018-12-17
 * @Version 1.0
 **/
@Data
public class PageResponse<T> implements Core {
    private T rows;
    private Long total;
  //  private Long size;

    public PageResponse() {
    }

    public PageResponse(T t, Long total, Long size) {
        this.rows = t;
        this.total = total;
       // this.size = size;
    }

    public PageResponse(T t, Long total) {
        this.rows = t;
        this.total = total;
      //  this.size =null;
    }

    public static <E> PageResponse PageResponseFactory(E e, Long total,Long size){
        return new PageResponse(e,total,size);
    }
    public static <E> PageResponse PageResponseFactory(E e, Long total){
        return new PageResponse(e,total);
    }
}
