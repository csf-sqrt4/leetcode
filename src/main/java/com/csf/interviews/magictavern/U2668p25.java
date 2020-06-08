package com.csf.interviews.magictavern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class U2668p25 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> queue = new LinkedList<>();
        StringBuilder temp = new StringBuilder();
        char[] chars = br.readLine().trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                temp.append(c);
            } else {
                queue.add(temp.toString());
                temp = new StringBuilder();
                queue.add(String.valueOf(c));
            }
            if (i == chars.length - 1) {
                queue.add(temp.toString());
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            String element = queue.poll();
            if ("-".equals(element)) {
                int nextNum = Integer.parseInt(queue.poll());
                if (!queue.isEmpty()) {
                    String nextOperator = queue.peek();
                    while (nextOperator.equals("+")) {
                        queue.poll();
                        nextNum += Integer.parseInt(queue.poll());
                        if (queue.isEmpty()) {
                            break;
                        }
                        nextOperator = queue.peek();
                    }
                }
                result -= nextNum;
            } else if ("+".equals(element)) {
                result += Integer.parseInt(queue.poll());
            } else {
                result += Integer.parseInt(element);
            }
        }
        System.out.println(result);
    }

}
