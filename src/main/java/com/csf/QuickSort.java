package com.csf;

import com.alibaba.fastjson.JSONObject;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {4, 21, 23, 32, 46, 45, 77, 66, 86, 98};
        sort(0, array.length - 1, array);
        System.out.println(JSONObject.toJSON(array));
    }

    public static void sort(int left, int right, int[] array) {
        if (left >= right) return;
        int start = left;
        int end = right;
        int flag = left;
        while (left < right) {
            while ((left < right) && (array[right] >= array[flag])) {
                right--;
            }
            if (array[right] < array[flag]) {
                int tmp = array[right];
                array[right] = array[flag];
                array[flag] = tmp;
                flag = right;
            }
            while ((left < right) && (array[left] <= array[flag])) {
                left++;
            }
            if (array[left] > array[flag]) {
                int tmp = array[left];
                array[left] = array[flag];
                array[flag] = tmp;
                flag = left;
            }
        }
        sort(start, left - 1, array);
        sort(left + 1, end, array);
    }
}
