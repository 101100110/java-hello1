package com.yjh.java;

/**
 * 一，枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们城之为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 * 二，如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 *
 * 三，Enum类中的常用方法
 *      values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举类
 *      valueOf(String str):可以把一个字符串转为相应的枚举类对象。要求字符串必须是枚举类对象
 *      toString():返回当前枚举类对象常量的名称
 *
 * 四，使用enum关键字定义的枚举类实现接口的情况
 *      情况一：实现接口，在enum类中实现抽象方法
 *      情况二：让枚举类的对象分别实现接口中的抽象方法
 *
 * @author yjh 1600063206@qq.com
 * @version 2023/1/4 9:37
 * @since JDK8
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString():
        System.out.println(summer.toString());
        //System.out.println(Season.close,getSuperclass());
        System.out.println("*************");
        //values();
        Season1[] values=Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        Season1 winter =Season1.valueOf("WINTER");
//        Season1 winter =Season1.valueOf("WINTER1");
        System.out.println(winter);
        winter.show();
    }
}

interface Info{
    void show();
}

//使用enum关键字枚举类
enum Season1 implements Info{
    //1.提供当前枚举类的对象，多个对象之间用“，”隔开，末尾对象“；”结束

    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };
    //声明Season对象的属性:private final修饰
    private String seasonName;
    private String seasonDesc;
    private Season1(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
    //4.其它诉求1：获取枚举类的属性
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }
    //4.其它诉求1：提供toString()

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
    
}