package com.csf.leetcode.medium;

import java.util.Stack;

/**
 * 功能描述:
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * @author chenshuangfei
 * @date 2020/6/6 1:03 下午
 */
public class Calculator {

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<>();
        char operator = ' ';
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }
            int top = 0;
            if (sb.length() > 0) {
                top = Integer.parseInt(sb.toString());
            }
            switch (operator) {
                case '+':
                    stack.push(top);
                    break;
                case '-':
                    stack.push(-top);
                    break;
                case '*':
                    top = stack.pop() * top;
                    stack.push(top);
                    break;
                case '/':
                    top = stack.pop() / top;
                    stack.push(top);
                    break;
                default:
                    stack.push(top);
            }
            if (i < s.length()) {
                operator = s.charAt(i);
            }
        }
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("3+2*2*8"));
    }
}
