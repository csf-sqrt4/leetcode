package com.csf.leetcode.easy;

/**
 * 功能描述: 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenshuangfei
 * @date 2020/6/6 12:38 下午
 */
public class Fibonacci {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int first = 0, second = 1;
        while (n > 1) {
            int temp = (first + second) % 1000000007;
            first = second;
            second = temp;
            n--;
        }
        return second;
    }

    public static void main(String[] args) {
        char c = '9';
        System.out.println(c);
    }
}
