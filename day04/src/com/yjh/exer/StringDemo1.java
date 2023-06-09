package com.yjh.exer;

import org.junit.Test;

/**
 * @author yjh 1600063206@qq.com
 * @version 2022/12/26 9:00
 * @since JDK8
 */
public class StringDemo1 {
    /*
    获取一个字符串在另一个字符串中出现的次数。
        比如：获取“ab”在“abkkcadabsdhaobshab”中出现的次数
     */

    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int sunLength = subStr.length();
        int count=0;
        int index=0;
        if(mainLength >=sunLength){
//            方式一：
//            while((index =mainStr.indexOf(subStr))!=-1){
//                count++;
//                mainStr=mainStr.substring(index +subStr.length());
//            }
//            方式二：对方式一的改进
            while((index =mainStr.indexOf(subStr,index))!=-1){
                count++;
                index +=sunLength;
            }


            return count;
        }else{
            return 0;
        }
    }

    @Test
    public void testGetCount(){
        String mainStr="abkkcadabsdhaobshab";
        String subStr="ab";
        int count =getCount(mainStr,subStr);
        System.out.println(count);
    }
}