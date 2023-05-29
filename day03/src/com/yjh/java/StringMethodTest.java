package com.yjh.java;

import org.junit.Test;

/**
 * @author yjh 1600063206@qq.com
 * @version 2022/12/9 10:31
 * @since JDK8
 */
public class StringMethodTest {
    /*
    替换
    String replace(char oldChar,char newChar):返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldChar得到的
    String replace(CharSequence target,CharSequence replacement):使用指定的字面值替换序列替换字符串所有匹配字面值目标序列的子字符串
    String replaceAll(String regex,String replacement):使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串
    String replaceFirst(String regex,String replacement):使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串
    匹配
    boolean matches(String regex):告知此字符串是否匹配给定的正则表达式
    切片
    String split(String regex):根据给定正则表达式的匹配拆分此字符串
     */
    @Test
    public void test4(){
        String str1="重庆麻辣小龙虾";
        String str2=str1.replace('小','大');

        System.out.println(str1);
        System.out.println(str2);
    }

    /*
    boolean endsWith(String suffix):测试此字符串是否以指定的后缀结束
    boolean startsWish(String prefix):测试此字符串是否以指定的前缀开始
    boolean startsWith(String prefix,int toffset):测试此字符串从指定索引开始的子字符串是否以指定前缀开始
    boolean contains(CharSequence s):当且仅当此字符串包含指定的char值序列时，返回true
    int indexOf(String str):返回指定子字符串在此字符串中选出第一次出现处的索引
    int indexOf(String str.int fromIndex):返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
    int lastIndexOf(String str):返回指定字符串中最右边出现处的索引
     */
    @Test
    public void test3(){
        String str1="helloworld";
        boolean b1=str1.endsWith("rld");
        System.out.println(b1);

        boolean b2=str1.startsWith("He");
        System.out.println(b2);

//        boolean b3=str1.contains(2);

    }
    /*
    int Length():返回字符串的长度：return value.Length
    char charAt(int index):返回某索引处的字符return value[index]
    boolean isEmpty():判断是否是空字符串：return value.length ==0
    String toLowerCase():使用默认语言环境，讲String中的所有字符转换成小写
    String toUpperCase():使用默认语言环境，讲String中的所有字符转换成大写
    String trim():返回字符串的副本，忽略前导空白和尾部空白
    boolean equals(Object obj):比较字符串的内容是否相同
    boolean equalsIgnoreCase(String anotherString):与equals方法类似,忽略大小写
    String concat(String str):将指定字符串连接到此字符串的结尾。等价于用“+”
    int compareTo(String anotherString):比较两个字符串的大小
    String substring(int beginIndex):返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后一个子字符串
    String substring(int beginIndex,int endIndex):返回一个新字符串，它是此字符串从beginIndex开始截取，endIndex(不包含)结束
     */

    @Test
    public void test2(){
        String s1="HelloWorld";
        String s2="helloWorld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3="abc";
        String s4=s3.concat("def");
        System.out.println(s4);

        String s5="abc";
        String s6=new String("abe");
        System.out.println(s5.compareTo(s6));//涉及到字符串排序

        String s7="重庆伊拉克石油";
        String s8=s7.substring(2);
        System.out.println(s7);
        System.out.println(s8);

        String s9=s7.substring(2,6);
        System.out.println(s9);
    }

    @Test
    public void test1(){
        String s1="helloworld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());

        String s2=s1.toLowerCase();
        System.out.println(s1);//s1不可变，任然为原来的字符串
        System.out.println(s2);//改成小写以后的字符串

        String s3=" he  llo   world ";
        String s4=s3.trim();
        System.out.println("----"+s3+"----");
        System.out.println("----"+s4+"----");
    }
}