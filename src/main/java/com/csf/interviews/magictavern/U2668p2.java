package com.csf.interviews.magictavern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class U2668p2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine().trim();
        boolean notCorrect = false;
        for (char c : in.toCharArray()) {
            if (!Character.isDigit(c)) {
                notCorrect = true;
                break;
            }
        }
        if (notCorrect) {
            System.out.println("输入值必须为数字！");
            return;
        }
        int n = Integer.parseInt(in);
        if (n < 1) {
            System.out.println("请输入正确的数！");
            return;
        }
        System.out.println(powerOfTwo(n));

    }

    private static int powerOfTwo(int n) {
        if (n == 1) {
            return 1;
        } else if (n % 2 == 1) {
            return 0;
        }
        return powerOfTwo(n / 2);
    }
}
