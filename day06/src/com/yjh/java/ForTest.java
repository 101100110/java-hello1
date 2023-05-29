package com.yjh.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合，数组
 *
 * @author yjh 1600063206@qq.com
 * @version 2023/5/8 15:03
 * @since JDK8
 */
public class ForTest {
    @Test
    public void test(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素的类型 局部变量（名字可改变） ：集合对象)
        //内部仍然调用了迭代器
        for(Object obj:coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test1(){
        int[] arr=new int[]{1,2,3,4,5,6};
        //for(集合元素的类型 局部变量（名字可改变） ：集合对象)
        for (int i:arr) {
            System.out.println(i);
        }
    }

    //练习题
    @Test
    public void test2(){
        String[] arr =new String[]{"MM","MM","MM"};

        //方式一：普通for赋值
//        for(int i=0;i<arr.length;i++){
//            arr[i]="GG";
//        }

        //方式二：增强for循环
        //相当于重新赋值给了一个新的数组
        for(String s:arr){
            s="GG";
        }

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}