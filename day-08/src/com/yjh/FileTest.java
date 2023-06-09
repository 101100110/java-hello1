package com.yjh;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称:文件夹）
 * 2.File类声明在java。io下
 * 3.File类中涉及到关于文件或文件目录的创建，删除，重命名，文件大小等方法
 *      并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4，后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的”终点“
 *
 *
 *
 *
 * @author yjh 1600063206@qq.com
 * @version 2023/5/18 10:28
 * @since JDK8
 */
public class FileTest {

    /*
    1.如何创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)

    2.
    相对路径：相较于某个路径下，指明的路径。
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
    window：\\
    unix:/
     */
    @Test
    public void test1(){

        //构造器1
        File file1;
        File file2;
        file1 = new File("hello.txt");//相对于当前module
        file2 =new File("D:\\workspaceidea\\java-hello\\day-08\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3=new File("D:\\workspaceidea","java-hello");

        //构造器3
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);

    }
    /*
        public String getAbsolutePath():获取绝对路径
        public String getPath():获取路径
        public String getName():获取名称
        public String getParent():获取上层文件目录路径.若无，返回null
        public long length():获取文件长度（即：字节数）.不能获取目录的长度
        public long lastModified():获取最后一次的修改时间，毫秒值
        如下的方法适用于文件目录
        public String[] list():获取指定目录下的所有文件或者文件目录的名称数组
        public File[] listFiles():获取指定目录下的所有文件或者文件目录的File数组
         */

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\IO\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }
    /*
    public boolean isDirectory():判断是否是文件目录
    public boolean isFile():判断是否是文件
    pubLic boolean exists():判断是否存在
    public boolean canRead():判断是否可读
    public boolean canWrite():判断是否可写
    public boolean isHidden():判断是否隐藏
     */
    @Test
    public void test3(){
        File file1=new File("hello.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

    }
    /*
          创建硬盘中对应的文件或文件目录
    public boolean createNameFile():创建文件。若文件存在，则不创建，返回false
    public boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建
    public boolean mkdirs():创建文件目录。如果上层文件目录不存在，一并创建
           删除磁盘中的文件或文件目录
    public boolean delete():删除文件或者文件夹
         删除注意事项
         java中的删除不走回收站
     */

    @Test
    public void test4() throws IOException {

        //文件的创建
        File file =new File("hi.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file.delete();
            System.out.println("删除成功");
        }

    }
    @Test
    public void test5(){
        //文件目录的创建
        File file = new File("D:\\IO\\io3\\io5");
        boolean mkdir = file.mkdir();
        if (mkdir){
            System.out.println("创建成功1");
        }

        File file1 = new File("D:\\IO\\io3\\io6");
        boolean mkdirs = file1.mkdirs();
        if (mkdirs){
            System.out.println("创建成功2");
        }
    }

}