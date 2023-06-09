package com.yjh.java;

/**
 * 创建三个c窗口卖票，总票数为100张,使用实现Runnable接口的方式
 *
 * 1.问题：卖票过程中，出现了重票，错票 -->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3.如何解决：当一个线程在操作ticket的时候，其他线程不能参与进来，直到线程操作完ticket时，其他
 *           线程才可以开始操作ticket。这种情况即使线程A出现了阻塞，也不能被改变。
 * 4.在java中，我们通过同步机制，来解决线程的安全问题.
 *
 *   方式一：同步代码块
 *   synchronized(同步监视器){
 *       //需要被同步的代码
 *
 *   }
 *   说明：1.操作共享数据的代码，即为需要被同步的代码. -->不能包含代码多了，也不能包含代码少了（必要的）
 *        2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 *        3.同步监视器，俗称：锁。任何一个类的对象
 *          要求：多个线程必须要共用同一把锁
 *
 *          补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
 *
 *   方式二：同步方法
 *          如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
 *
 *   5.同步的方式，解决了线程的安全问题。---好处
 *     操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。---局限性
 *
 *
 * @author yjh 1600063206@qq.com
 * @version 2022/11/8 16:40
 * @since JDK8
 */
class Window1 implements Runnable{

    private int ticket=100;
    Object obj=new Object();//保证唯一性

    @Override
    public void run() {
        while(true){
            synchronized(obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                } else{
                    break;
                }
            }

        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1=new Window1();

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