package com.yjh.java1;

/**
 * 使用同步机制将单例模式中的懒汉模式改写为线程安全的
 *
 * @author yjh 1600063206@qq.com
 * @version 2022/12/6 8:57
 * @since JDK8
 */
public class BankTest {
}

class Bank{
    private Bank(){}

    private static Bank instance=null;

    public static Bank getInstance() {
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance==null){
//
//                instance =new Bank();
//            }
//            return instance;
//    }
        //方式二:效率更高
        if(instance ==null){
            synchronized (Bank.class){
                if(instance ==null){
                    instance=new Bank();
                }
            }
        }
        return instance;
    }
}
