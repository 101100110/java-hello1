package com.yjh.java;

/**
 *
 * 例子：创建三个c窗口卖票，总票数为100张,使用继承Thread类的方式
 *
 * 存在线程的安全问题，待解决。
 *
 * @author yjh 1600063206@qq.com
 * @version 2022/11/7 11:12
 * @since JDK8
 */
class Window extends Thread{

    private static int ticket =100;

    @Override
    public void run() {

        while(true){
            if (ticket>0){
                System.out.println(getName()+":卖票，票号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1=new Window();
        Window w2=new Window();
        Window w3=new Window();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}