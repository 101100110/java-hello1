package com.yjh.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用
 * @author yjh 1600063206@qq.com
 * @version 2023/5/17 15:53
 * @since JDK8
 */
public class GenericTest {
    /*
    1.泛型在继承方面的体现
      类A是类B的父类：G<A>和G<B>二者不具备子父类关系，二者是并列关系
            补充：类A是类B的父类，A<G> 是 B<G> 的父类
     */

    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
//        list1= list2
        //编译不通过
//        Date date = new Date();
//        str =date;
        /*
        反证法：
        假设list1 = list2;
        list1.add(123);导致混入非String的数据，出错
         */

       show(list1);
       show1(list2);
    }
    public void show(List<Object>list){

    }
    public void show1(List<String>list){

    }

    @Test
    public void test2(){
        AbstractList<String> list1=null;
        List<String> list2=null;
        ArrayList<String> list3=null;

        list1 = list3;
        list2 = list3;

        List<String> list4 =new ArrayList<>();

    }
    /*
    2.通配符的使用
        通配符：？

        类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
     */

    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list =null;

        list =list1;
        list =list2;

        print(list1);
        print(list2);

        //添加：对于list<?>就不能向其内部添加数据。
        //除了添加null之外.
//        list.add("DD");
//        list.add('?');
        list.add(null);

        //获取（读取）：
        Object o = list.get(2);
    }
    public void print(List<?> list){
        Iterator<?> iterator=list.iterator();
        while (iterator.hasNext()){
            Object obj =iterator.next();
        }
    }

    /*
    3.有限制条件的通配符的使用
        ?extends A:
                 G<? extends A> 可以作为G<A> 和G<B>的父类，其中B是A的子类
        ?super A:
                 G<? super A>可以作为G<A>和G<B>的父类,其中B是A的父类
     */
    @Test
    public void test4(){

        List<? extends Person>list1=null;
        List<? super Person>list2 =null;

        List<Student>list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;
    }
}