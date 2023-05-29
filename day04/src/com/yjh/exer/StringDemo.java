package com.yjh.exer;

import org.junit.Test;

/**
 * @author yjh 1600063206@qq.com
 * @version 2022/12/23 11:34
 * @since JDK8
 */
public class StringDemo {
    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为“abfedcg”
     */
//    方式一：转换为char[]
    public String reverse(String str,int startIndex,int endIndex){
        char [] arr=str.toCharArray();
        for (int x = startIndex,y=endIndex; x <y ; x++,y--) {
                char temp =arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
        }

        return new String(arr);
    }

//    方式二：使用String的拼接
    public String reverse1(String str,int startIndex,int endIndex) {
        if (str != null) {
            //第1部分
            String reverseStr = str.substring(0, startIndex);
            //第2部分
            for (int i = endIndex; i >= startIndex; i--) {
                reverseStr += str.charAt(i);
            }
            //第3部分
            reverseStr += str.substring(endIndex + 1);

            return reverseStr;
        }
        return null;
    }
    @Test
    public void testReverse(){
        String str="abcdefg";
        String reverse = reverse(str, 2, 5);
        System.out.println(reverse);
    }
}