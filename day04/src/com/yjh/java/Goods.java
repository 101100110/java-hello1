package com.yjh.java;

/**
 * @author yjh 1600063206@qq.com
 * @version 2022/12/28 10:34
 * @since JDK8
 */
public class Goods implements Comparable{

    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //指明商品比较大小的方式:按照价格从低到高
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods=(Goods) o;
            if (this.price>goods.price){
                return 1;
            } else if (this.price<goods.price) {
                return -1;
            }else {
                return 0;
            }
        }
        throw new RuntimeException("传入数据类型不一致！");
    }
}