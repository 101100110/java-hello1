package com.yjh.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 *
 * 结论：
 * 向collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 *
 * @author yjh 1600063206@qq.com
 * @version 2023/1/28 10:45
 * @since JDK8
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.contains(new Person("jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
//        Person p = new Person("jerry",20);
//        coll.add(p);

        //contains(object obj):判断当前集合中是否包含obj
        //我们在判断是会调用obj对象所在类的equals（）
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
//        System.out.println(coll.contains(p));//true
        System.out.println(coll.contains(new Person("jerry",20)));//false

        //containsAll(Collection coll1):判断形参coll1中所有元素是否都存在于当前集合中。
        Collection coll1 = Arrays.asList(123,4567);
        System.out.println(coll.containsAll(coll1));//false
    }

    @Test
    public void test2(){
        //3.remove(Object obj):从当前集合中移除obj元素。
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        coll.remove(1234);
        System.out.println(coll);

        coll.remove(new Person("jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll1):相当于数学的差集：从当前集合中移除coll1中所有的元素
        Collection coll1=Arrays.asList(123,4561);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 =Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(object.obj):要想返回true，需要当前集合和形参集合的元素都相同
        Collection coll1 =new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("jerry",20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));

    }

    @Test
    public void test4(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合--->数组：toArray();
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组--->集合:调用Arrays类的静态方法asList()
        List<String> list= Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(list);

        List arr1=Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size());//1

        List arr2=Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());//2

        //iterator():返回Iterator接口的实列，用于遍历集合元素。放在IteratorTest.java中
    }
}