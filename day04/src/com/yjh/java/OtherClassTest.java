package com.yjh.java;

import org.junit.Test;

/**
 * 其它常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和BigDecimal
 * @author yjh 1600063206@qq.com
 * @version 2022/12/29 9:52
 * @since JDK8
 */
public class OtherClassTest {
    @Test
    public void test1(){
        String javaVersion =System.getProperty("java.version");
        System.out.println("java的version:"+javaVersion);

        String javaHome =System.getProperty("java.home");
        System.out.println("java的home:"+javaHome);

        String osName=System.getProperty("os.name");
        System.out.println("os的name:"+osName);

        String osVersion=System.getProperty("os.version");
        System.out.println("os的Version:"+osVersion);

        String userName=System.getProperty("user.name");
        System.out.println("user的name:"+userName);

        String javaHome1=System.getProperty("java.home");
    }
}