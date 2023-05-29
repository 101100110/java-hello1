package com.yjh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换成字符的输入流
 * OutputStreamWriter讲一个字符的输出流转换成字节的输出流
 * 2.作用：提供字节流和字符流的转换
 * <p>
 * 3.解码：字节，字节数组 --->字符数组，字符串
 * 编码：字符数组，字符串--->字节，字节数组
 * <p>
 * 4.字符集
 *
 * @author yjh 1600063206@qq.com
 * @version 2023-05-26 9:28
 * @since JDK8
 */
public class InputStreamReaderTest {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = null;

            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}