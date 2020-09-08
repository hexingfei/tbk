package cn.tbk.utils;

import lombok.Data;

/**
 * @ClassName PageRequest
 * @Author rhb
 * @Description 分页请求对象
 * @Date 2018-12-17
 * @Version 1.0
 **/
@Data
public  class PageRequest<T> {
    private int limit;//页面数据条数
    private int offset;//当前数据位置

    private int rows;//页面数据条数
    private int page;//当前页码数*/
    private String sort;//排序字段
    private String order;//ASC DESC

    private T query;//查询对象


}
