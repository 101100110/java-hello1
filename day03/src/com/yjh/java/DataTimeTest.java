package com.yjh.java;

import org.junit.Test;

import java.util.Date;

/**
 * @author yjh 1600063206@qq.com
 * @version 2022/12/23 9:03
 * @since JDK8
 */
public class DataTimeTest {
    /*
    java.util.Date类
            /---java.sql.Date类

    1.两个构造器的使用
            >构造器一：Date()：创建一个对应当前时间的Date对象
            >构造器二：创建指定毫秒数的Date对象
    2.两个方法的使用
        >toString();显示当前的年，月，日，时，分，秒
        >getTime():获取当前Date对象对应的毫秒数。（时间戳）
    3.java.sql.Date对应着数据库中的日期类型的变量
        >如何实列化
        >如何将java.util.Date对象转化为java.sql.Date对象
     */
    @Test
    public void test1(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Fri Dec 23 09:16:08 CST 2022

        System.out.println(date1.getTime());//1671758168325
        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1671758168325L);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(21471493432l);
        System.out.println(date3.toString());

        //如何将java.util.Date对象转化为java.sql.Date对象
        //情况一
//        Date date4 = new java.sql.Date(3254353453453L);
//        java.sql.Date date5=(java.sql.Date)date4;
        //情况二：
        Date date6=new Date();
        java.sql.Date date7=new java.sql.Date(date6.getTime());
        System.out.println(date7.toString());

    }
}