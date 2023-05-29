package com.yjh.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一；缓冲流的作用
 *
 *1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提高流读写的速度
 *
 * 3.处理流就是套接在已有的流的基础上
 *
 * @author yjh 1600063206@qq.com
 * @version 2023-05-25 9:33
 * @since JDK8
 */
public class buffertest {

    //实现非文本文件的复制
    @Test
    public void test1()  {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile =new File("1.png");
            File destFile =new File("3.png");
            //2.造流
            //2.1造节点流
            FileInputStream fis =new FileInputStream(srcFile);
            FileOutputStream fos =new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);


            //3.复制的细节：读取，写入
            byte[] buffer =new byte[10];
            int len;
            while ((len =bis.read(buffer)) !=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4.资源的关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bis !=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(bos !=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            //说明：关闭外层流的同时，内层流也会自动关闭。所以关于内存流的关闭，我们可以省略
//        fis.close();
//        fos.close();

        }

    }

    @Test
    public void testBufferReaderBufferWriter() throws IOException {
        //
        BufferedReader br=new BufferedReader(new FileReader(new File("")));
        BufferedWriter bw =new BufferedWriter(new FileWriter(new File("")));


    }
}