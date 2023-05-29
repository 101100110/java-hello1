package com.yjh.java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yjh 1600063206@qq.com
 * @version 2023/5/17 12:23
 * @since JDK8
 */
public class SubOrder extends Order<Integer> {//SubOrder<T>:不是泛型类

    public static  <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list =new ArrayList<>();

        for (E e:arr){
            list.add(e);
        }
        return list;
    }
}