package com.yjh.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 *
 * @author yjh 1600063206@qq.com
 * @version 2022/12/5 14:50
 * @since JDK8
 */
class Window3 implements Runnable{

    private int ticket=100;
    @Override
    public void run() {
        while(true){

            show();
        }
    }

    public synchronized void show(){//同步监视器：this

        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }
}
public class windowTest3{
    public static void main(String[] args) {
        Window3 w1=new Window3();

        Thread t1=new Thread(w1);
        Thread t2=new Thread(w1);
        Thread t3=new Thread(w1);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}