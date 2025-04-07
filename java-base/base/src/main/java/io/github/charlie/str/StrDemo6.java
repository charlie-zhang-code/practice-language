package io.github.charlie.str;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/4
 * @Description: TODO
 */
public class StrDemo6 {
    @Test
    public void test1() {
        Date d = new Date();
        System.out.println(d);
    }

    @Test
    public void test2() {
        long time = System.currentTimeMillis();
        System.out.println(time);//1559806982971
        //当前系统时间距离1970-1-1 0:0:0 0毫秒的时间差，毫秒为单位
    }

    @Test
    public void test3() {
        Date d = new Date();
        long time = d.getTime();
        System.out.println(time);//1559807047979
    }

    @Test
    public void test4() {
        long time = 1559807047979L;
        Date d = new Date(time);
        System.out.println(d);
    }

    @Test
    public void test5() {
        long time = Long.MAX_VALUE;
        Date d = new Date(time);
        System.out.println(d);
    }

    //格式化
    @Test
    public void test6() {
        Date d = new Date();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒  E Z");
        //把Date日期转成字符串，按照指定的格式转
        String str = sf.format(d);
        System.out.println(str);
    }

    //解析
    @Test
    public void test7() throws ParseException {
        String str = "2022年06月06日 16时03分14秒 545毫秒  星期四 +0800";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒  E Z");
        Date d = sf.parse(str);
        System.out.println(d);
    }
}
