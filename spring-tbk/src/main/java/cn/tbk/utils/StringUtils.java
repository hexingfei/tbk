package cn.tbk.utils;

import org.springframework.lang.Nullable;

/**
 * @ClassName StringUtils
 * @Author rhb
 * @Description 自定义字符-工具类
 * @Date 2019-01-02 16:04
 * @Version 1.0
 **/
public class StringUtils
{

    public static boolean isEmpty(@Nullable Object str) {
        return str == null || "".equals(str);
    }

}
