package com.yjh.java;

//import com.sun.org.apache.xpath.internal.operations.String;
//import org.junit.Test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 *
 * @author yjh 1600063206@qq.com
 * @version 2022/12/13 9:01
 * @since JDK8
 */
public class StringTest1 {
    /*
    复习：
    String 与基本数据类型，包装类之间的转换

    String -->基本数据类型，包装类;调用包装类的静态方法：parseXxx(str)
    基本数据类型，包装类-->String;调用String重载的ValueOf（xxx）
     */
    @Test
    public void test(){
        String str1="123";
//        int num=(int)str1;//错误的
       int num= Integer.parseInt(str1);

       String str2=String.valueOf(num);//"123"
        String str3=num+"";
    }
    /*
    String 与char[]之间的转换

    String-->char[]:调用String的toCharArray()
    char[]-->String:调用String的构造器
     */
    @Test
    public void test1(){
        String str1="zbc123";

        char[] charrArraay=str1.toCharArray();
        for (int i = 0; i < charrArraay.length; i++) {
            System.out.println(charrArraay[i]);
        }

        char[] arr=new char[]{'z','b','c','1','2','3'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    /*
    String 与 byte[]之间的距离
    编码：String-->byte[]:调用String的getByte()
    解码：Byte[]-->String:

    编码：字符串-->字节（看得懂--->看不懂的二进制数据）
    解码：编码的逆过程，字节-->字符串（看不懂的二进制数据--->看得懂）

    说明：解码时，要求解码时使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
     */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String str1="abc123中国";
        byte[] bytes=str1.getBytes();//使用默认的字符集，进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk的字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("*************");

        String str2= new String(bytes);
        System.out.println(str2);

        String str3=new String(gbks);
        System.out.println(str3);//出现乱码，原因：编码和解码集不一致

        String str4 = new String(gbks, "gbk");
        System.out.println(str4);
    }
}