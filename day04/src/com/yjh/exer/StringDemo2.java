package com.yjh.exer;

import org.junit.Test;

/**
 * @author yjh 1600063206@qq.com
 * @version 2022/12/26 9:24
 * @since JDK8
 */
public class StringDemo2 {
    /*
    获取两个字符串中最大相同子串。比如：
    str1="abcwerthsshfassfdsffds";str2="safvsfassfsfd"
    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     */
    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {

            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }
    @Test
    public void testGetMaxSameString(){
        String str1="abcwerthelloyuiodefabcdef";
        String str2="cvhellobnm";
        String maxSameString = getMaxSameString(str1, str2);
        System.out.println(maxSameString);
    }
}