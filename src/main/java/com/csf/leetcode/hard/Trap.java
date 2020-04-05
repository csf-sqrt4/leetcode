package com.csf.leetcode.hard;

import java.util.Stack;

/**
 * 功能描述:给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 感谢 Marcos 贡献此图。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/trapping-rain-water 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenshuangfei
 * @date 2020/4/5 9:16 PM
 */
public class Trap {

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int s = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int top = stack.peek();
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int bound = Math.min(height[stack.peek()], height[current]);
                s += distance * (bound - height[top]);
            }
            stack.push(current++);
        }
        return s;

    }
}
