package com.yjh.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的5个对象，并把这些对象放入TreeSet集合中(下一章：TreeSet 需使用泛型来定义)
 * 分别按一下两种方式对集合中的元素进行排序，并遍历输出：
 *
 * 1）使Employee实现Comparable接口,并按name排序
 * 2）创建TreeSet时传入Comparator对象，按生日日期的先后排序.
 *
 *
 * @author yjh 1600063206@qq.com
 * @version 2023/5/12 10:06
 * @since JDK8
 */
public class EmployeeTest{

    //问题二：按生日日期的先后排序。
    @Test
    public void test2(){

        TreeSet<Employer> set=new TreeSet<>(new Comparator<Employer>() {

            //使用泛型之后的写法
            @Override
            public int compare(Employer o1, Employer o2) {
                MyDate b1=o1.getBirthday();
                MyDate b2=o2.getBirthday();

                return b1.compareTo(b2);
            }
            //使用泛型之前的写法
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employer && o2 instanceof Employer){
//                    Employer e1=(Employer) o1;
//                    Employer e2=(Employer) o2;
//
//                    MyDate b1=e1.getBirthday();
//                    MyDate b2=e2.getBirthday();
//                    //方式一：
////                    //比较年
////                    int minusYear=b1.getYear() - b2.getYear();
////                    if(minusYear !=0){
////                        return minusYear;
////                    }
////                    //比较月
////                    int minusMonth =b1.getMonth() -b2.getMonth();
////                    if (minusMonth !=0){
////                        return minusMonth;
////                    }
////                    //比较日
////                    return b1.getDay()-b2.getDay();
//                    //方式二：
//                    return b1.compareTo(b2);
//                }
//                throw new RuntimeException("传入的数据类型不一致!");
//            }
        });
        Employer e1 =new Employer("wuyanzhu",48,new MyDate(1987,5,6));
        Employer e2 =new Employer("pengyuyan",37,new MyDate(1987,5,5));
        Employer e3 =new Employer("liudeihua",60,new MyDate(1977,7,7));
        Employer e4 =new Employer("shonghongkang",45,new MyDate(1996,2,12));
        Employer e5 =new Employer("liangchaowei",21,new MyDate(2002,4,14));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator =set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //问题一：使用自然排序
    @Test
    public void test1(){
        TreeSet<Employer> set=new TreeSet<Employer>();

        Employer e1 =new Employer("wuyanzhu",48,new MyDate(1987,5,6));
        Employer e2 =new Employer("pengyuyan",37,new MyDate(1987,5,5));
        Employer e3 =new Employer("liudeihua",60,new MyDate(1977,7,7));
        Employer e4 =new Employer("shonghongkang",45,new MyDate(1996,2,12));
        Employer e5 =new Employer("liangchaowei",21,new MyDate(2002,4,14));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employer> iterator =set.iterator();
        while (iterator.hasNext()){
            Employer next = iterator.next();
        }
    }


}