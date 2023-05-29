package com.yjh.exer;

/**
 * 定义一个Employee类。
 * 该类包含：private成员变量name,age,birthday,其中birthday 为MyDate类的对象：
 * 并为每一个属性定义getter,setter方法：
 * 并重写toString方法输出name,age,birthday
 *
 *
 * @author yjh 1600063206@qq.com
 * @version 2023/5/12 9:57
 * @since JDK8
 */
public class Employer  implements Comparable<Employer>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employer(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    //没有指明泛型时的写法
    //按name排序
//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Employer){
//            Employer e=(Employer)o;
//            return this.name.compareTo(e.name);
//        }
////        return 0;
//        throw new RuntimeException("传入的类型数据不一致");
//    }

    //指明泛型时的写法
    @Override
    public int compareTo(Employer o) {
        return this.name.compareTo(o.name);
    }
}