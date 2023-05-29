package com.yjh.java;

import org.junit.Test;

import java.io.*;

/**
 * 一，流的分类：
 * 1.操作数据单位：字节流，字符流
 * 2.数据的流向：输入流，输出流
 * 3.流的角色：节点流，处理流
 *
 * 二，流的体系结构
 * 抽象基类                节点流（或文件流）              缓冲流（处理流的一种）
 * InputStream            FileInputStream              BufferedInputStream
 * OutputStream           FileOutputStream             BufferedOutputStream
 * Reader                 FileReader                   BufferedReader
 * Writer                 FileWriter                   BufferedWriter
 *
 *
 *
 * @author yjh 1600063206@qq.com
 * @version 2023-05-23 16:15
 * @since JDK8
 */
public class FileReaderWriterTest {
    //对read（）的操作升级：使用read的重载方法
    @Test
    public void test1() throws IOException {
        //1.File类的实例化
        File file =new File("hello.txt");

        //2.FileReader流的实例化
        FileReader fileReader =new FileReader(file);

        //3.读入的操作
        //read(char[] cfile):返回每次读入的cfile数组中字符的个数。如果达到文件末尾，返回-1
        char[] cfile = new char[5];
        int len;
        while ((len = fileReader.read(cfile)) !=-1){
            //方式一：
            //错误的写法
//            for (int i=0;i<cfile.length;i++){
//                System.out.print(cfile[i]);
//            }
            //正确的写法
//            for (int i=0;i<len;i++){
//                System.out.print(cfile[i]);
//            }
            //方式二:
            //错误的写法：与方式一的错误结果一样
//            String str=new String(cfile);
//            System.out.print(str);
            //正确的写法
            String str =new String(cfile,0,len);
            System.out.print(str);
        }
        //4.资源的关闭
        fileReader.close();
    }

    /*
    从内存中写出数据到硬盘的文件里

    1.输出操作，对应的File可以不存在的，并不会报异常
    2.
            File对应的硬盘文件如果不存在：在输出的过程中会自动创建此文件
            File对应的硬盘文件如果存在：
                    如果流使用的构造器是：FileWriter(file,false) or FileWriter(file):对原有文件进行覆盖
                    如果流使用的构造器是：FileWriter(file,true):不会对原有文件进行覆盖，而是在后进行添加
     */
    @Test
    public void testFileWriter() {
        FileWriter fileWriter= null;
        try {
            //1.提供file类的对象,指明写出到的文件
            File file =new File("C:\\Users\\16000\\Desktop\\新建 文本文档.txt");

            //2.提供FileWriter的对象，用于数据的输出
            fileWriter = new FileWriter(file);

            //3.写出的操作
            fileWriter.write("I have a dream!\n");
            fileWriter.write("You need to have a dream!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                //4.流资源的关闭
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
            }
        }


    }

    @Test
    public void testFileReaderWriter()  {
        FileReader fr= null;
        FileWriter fw= null;
        try {
            File file1=new File("hello.txt");
            File file2=new File("C:\\Users\\16000\\Desktop\\新建 文本文档.txt");

            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            char[] cbuf =new char[5];
            int len;//记录每次读入到cubf数组中的字符的个数
            while ((len = fr.read(cbuf))!=-1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
            }
        }


    }
}