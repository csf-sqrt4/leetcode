package com.csf.leetcode.easy;

/**
 * 功能描述:给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。  你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/majority-element 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenshuangfei
 * @date 2020/3/26 11:58 PM
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int result = nums[0], count = 0;
        for (int i : nums) {
            if (i == result) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = i;
                count++;
            }
        }
        return result;
    }

    /**
     * 示例 1:
     * <p>
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */
    public static void main(String[] args) {

        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 2}));
        System.out.println(new MajorityElement().majorityElement(new int[]{3}));
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));


    }
}
