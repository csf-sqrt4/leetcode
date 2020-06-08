package com.csf.interviews.magictavern;

import java.io.*;

public class U2668p6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(fib(n) % 1000000);
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int first = 0, second = 1;
        while (n > 1) {
            int temp = (first + second) % 1000000;
            first = second;
            second = temp;
            n--;
        }
        return second;
    }
}
