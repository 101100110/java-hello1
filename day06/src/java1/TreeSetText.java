package java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author yjh 1600063206@qq.com
 * @version 2023/5/11 10:22
 * @since JDK8
 */
public class TreeSetText {
    /*
    1.向TreeSet中添加的数据，要求是相同类的对象。
    2.两种排序方式：自然排序(实现Comparable接口) 和 定制排序

    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals().
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()
     */

    @Test
    public void test1(){
        TreeSet set =new TreeSet();

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("aa");
//        set.add(new User("Tom",12));

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);

        //举例二：
        set.add(new User("Tom",21));
        set.add(new User("Brown",12));
        set.add(new User("Jake",24));
        set.add(new User("Ros",18));
        set.add(new User("Tom",44));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Comparator com =new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1,Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw  new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet set =new TreeSet(com);
        set.add(new User("Tom",21));
        set.add(new User("Brown",12));
        set.add(new User("Jake",24));
        set.add(new User("Ros",18));
        set.add(new User("Tom",44));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}