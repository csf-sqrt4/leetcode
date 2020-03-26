package com.csf.leetcode.easy;

/**
 * 功能描述:给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。  在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意: 假设字符串的长度不会超过 1010。  示例 1:  输入: "abccccdd"  输出: 7  解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-palindrome 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenshuangfei
 * @date 2020/3/27 12:06 AM
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int count = 0;
        int[] array = new int[52];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                array[c - 'a']++;
            } else {
                array[c - 'A' + 26]++;
            }
        }
        for (int n : array) {
            if (n % 2 == 1) {
                count += n - 1;
            } else {
                count += n;
            }
        }
        return count < s.length() ? count + 1 : count;
    }
}
