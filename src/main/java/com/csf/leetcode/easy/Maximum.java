package com.csf.leetcode.easy;

/**
 * 功能描述: 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 * @author chenshuangfei
 * @date 2020/3/27 12:04 AM
 */
public class Maximum {

    public int maximum(int a, int b) {
        long c = (long) a - (long) b;
        long k = c >>> 63;
        return (int) (a * (1 ^ k) + b * (k));
        // 1*0+(-2)*1
    }


}
