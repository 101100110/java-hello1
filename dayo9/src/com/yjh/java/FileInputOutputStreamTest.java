package com.yjh.java;

import org.junit.Test;

import java.io.*;

/**
 *测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1.对于文本文件（.txt.doc.c.cpp），使用字符流处理
 * 2。对于非文本文件(.jpg.mp3.mp4.avi.doc.ppt)，使用字节流处理
 *
 * @author yjh 1600063206@qq.com
 * @version 2023-05-24 11:06
 * @since JDK8
 */
public class FileInputOutputStreamTest {

    //实现对图片的复制操作
    @Test
    public void test1()  {
        FileInputStream fis = null;
        FileOutputStream fos= null;
        try {
            File file =new File("1.png");
            File file1 = new File("2.png");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            //复制的过程
            byte[] buffer=new byte[5];
            int len;
            while ((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
           if(fis !=null){
               try {
                   fis.close();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               } finally {
               }
           }
            if(fos !=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                }
            }
        }

    }
}