package com.yjh.exer;

/**
 * @author yjh 1600063206@qq.com
 * @version 2022/12/8 16:07
 * @since JDK8
 */
public class StringTest {
    String str=new String("good");
    char[] ch={'t','e','s','t'};

    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='b';
    }

    public static void main(String[] args) {
        StringTest ex=new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str+"and");//goodand
        System.out.println(ex.ch);//best
    }
}