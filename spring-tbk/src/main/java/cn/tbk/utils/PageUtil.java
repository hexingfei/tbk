package cn.tbk.utils;

import cn.tbk.query.GoodsQuery;
import com.github.pagehelper.PageHelper;


import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by r on 2018-10-31
 */
public class PageUtil
{

    public static void offsetPage(GoodsQuery pageRequest){
      //  int num = pageRequest.getOffset()/pageRequest.getLimit() + 1;
        if(StringUtils.isEmpty(pageRequest.getOrderByColumn()) || StringUtils.isEmpty(pageRequest.getIsAsc()) ){
            PageHelper.startPage(pageRequest.getPageNum() , pageRequest.getPageSize());
        }else {
            PageHelper.startPage(pageRequest.getPageNum() , pageRequest.getPageSize() , pageRequest.getOrderByColumn()+" " +pageRequest.getIsAsc());
        }
    }

    public static void startPage(PageRequest pageRequest){
        String orderBy = null;
        if(null != pageRequest.getSort() && null != pageRequest.getOrder()) {
            orderBy = pageRequest.getSort()+" " +pageRequest.getOrder();
        }
        startPage(pageRequest.getPage() , pageRequest.getRows() , orderBy);
    }


    public static void startPage(int num, int size , String orderBy) {
        if (size <= 0) {
            size = PageConstant.rows;
        }
        if (StringUtils.isEmpty(orderBy))
            PageHelper.startPage(num, size);
        else
            PageHelper.startPage(num, size,orderBy);
    }


    /**
     * limit偏移量转换成普通分页
     * @param pageRequest
     */
    public static void offset2Size(PageRequest pageRequest){
        pageRequest.setRows(pageRequest.getLimit());
        pageRequest.setPage(pageRequest.getOffset()/pageRequest.getLimit() + 1);
    }


    /**
     * 普通分页转换成limit偏移
     * @param pageRequest
     */
    public static void size2Offset(PageRequest pageRequest){
        pageRequest.setOffset((pageRequest.getPage()-1)*pageRequest.getRows());
        pageRequest.setLimit(pageRequest.getRows());
    }


    /**
     * 得到查询总条数
     *
     * @param data
     * @return
     */
    public static <E> long getTotal(E data) {
        List<?> list = (List) data;
        if (list != null && list.size() > 0) {
            ((com.github.pagehelper.Page<?>) list).getPages();
            return ((com.github.pagehelper.Page<?>) list).getTotal();
        } else {
            return 0l;
        }
    }

    /**
     * 得到总页数
     *
     * @param data
     * @return
     */
    public static <E> long getPages(E data) {
        List<?> list = (List) data;
        if (list != null && list.size() > 0) {
            return ((com.github.pagehelper.Page<?>) list).getPages();
        } else {
            return 0l;
        }
    }


    /**
     * 获取分页结果
     * 设置总条数
     *
     * @param data
     * @param <E>
     * @return
     */
    public static <E> PageResponse getPageResponse(E data) {
        Long total = getTotal(data);
        return PageResponse.PageResponseFactory(data, total);
    }

    /**
     * 获取分页结果
     * 设置总条数
     * 设置总页数
     *
     * @param data
     * @param <E>
     * @return
     */
    public static <E> PageResponse getPageResponseWithSize(E data) {
        Long total = getTotal(data);
        Long size = getPages(data);
        return PageResponse.PageResponseFactory(data, total, size);
    }

}
