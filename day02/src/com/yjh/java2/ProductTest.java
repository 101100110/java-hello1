package com.yjh.java2;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk),而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品（比如：20），如果生产者试图生产更多的产品，店员会叫生产者
 * 停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员
 * 会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1.是否是多线程问题？是，生产者线程，消费者线程
 * 2.是否有共享数据？是，产品（或店员）
 * 3.如何解决线程的安全问题？同步机制，有三种方法
 * 4.是否涉及到线程通信？是
 *
 * @author yjh 1600063206@qq.com
 * @version 2022/12/6 17:05
 * @since JDK8
 */
class Clerk{

    private int productCount=0;
    //生产产品
    public synchronized void produceProduct() {

        if (productCount <20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            notify();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //消费产品
    public synchronized void consumerProduct() {
        if (productCount>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            productCount--;

            notify();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Producer extends Thread{//生产者

    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产产品.....");
        while(true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread{//消费者
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费产品.....");
        while(true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            clerk.consumerProduct();
        }
    }
}


public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();

        Producer p1=new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1=new Consumer(clerk);
        c1.setName("消费者1");

        p1.start();
        c1.start();
    }
}