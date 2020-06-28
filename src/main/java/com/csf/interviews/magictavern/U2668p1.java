package com.csf.interviews.magictavern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class U2668p1 {
    public static void main(String[] args) throws Exception {
        int n = 0;
        while (n != 100) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine().trim());
            System.out.println(n);
        }
    }
}
