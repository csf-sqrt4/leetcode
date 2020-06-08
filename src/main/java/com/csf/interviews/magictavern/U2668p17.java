package com.csf.interviews.magictavern;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class U2668p17 {

    private static final Map<Character, Point> phoneNumMap = new HashMap<>();

    static {
        phoneNumMap.put('0', new Point(0, -2, '0'));
        phoneNumMap.put('1', new Point(-1, 1, '1'));
        phoneNumMap.put('2', new Point(0, 1, '2'));
        phoneNumMap.put('3', new Point(1, 1, '3'));
        phoneNumMap.put('4', new Point(-1, 0, '4'));
        phoneNumMap.put('5', new Point(0, 0, '5'));
        phoneNumMap.put('6', new Point(1, 0, '6'));
        phoneNumMap.put('7', new Point(-1, -1, '7'));
        phoneNumMap.put('8', new Point(0, -1, '8'));
        phoneNumMap.put('9', new Point(1, -1, '9'));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine().trim();
        List<Point> numTemp = new ArrayList<>();
        numTemp.add(phoneNumMap.get('5'));
        for (char c : in.toCharArray()) {
            numTemp.add(phoneNumMap.get(c));
        }
        int distance = 0;
        for (int i = 0; i < numTemp.size() - 1; i++) {
            Point currentPoint = numTemp.get(i);
            //System.out.print(currentPoint.getValue());
            //System.out.print("->");
            Point nextPoint = numTemp.get(i + 1);
            int tempDistance = Math.abs(currentPoint.getX() - nextPoint.getX()) + Math.abs(currentPoint.getY() - nextPoint.getY());
            //System.out.println(nextPoint.getValue() + ":" + tempDistance);
            distance += tempDistance;
        }
        System.out.println(distance);
    }

    private static class Point {
        private int x;
        private int y;
        private char value;

        public Point(int x, int y, char value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }
    }

}
