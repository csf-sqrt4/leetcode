package com.csf.interviews.magictavern;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 功能描述: 迷宫
 *
 * @author chenshuangfei
 * @date 2020/6/7 12:18 下午
 */
public class SavePrincess {

    private int m;
    private int n;
    private char[][] visited;
    private Position s = null;
    private Position p = null;

    public static void main(String[] args) {
        char[][] maze = {
                /* 0 1 2 3 4 5 6 7 8 9 */
                /* 0 */{'.', '*', '.', '.', '.', '*', '.', '.', '.', '.'},
                /* 1 */{'*', 'S', '*', '.', '.', '.', '.', '.', '.', '.'},
                /* 2 */{'.', '.', '*', '.', '.', '.', '.', '.', '.', '.'},
                /* 3 */{'.', '.', '*', '*', '*', '.', '.', '.', '.', '.'},
                /* 4 */{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                /* 5 */{'.', '.', '.', '.', '*', '.', '.', '.', '.', '.'},
                /* 6 */{'.', '.', '.', '.', '*', '.', '.', '.', '.', '.'},
                /* 7 */{'.', '.', '.', '.', '*', '.', '.', '.', '.', '.'},
                /* 8 */{'.', '.', '.', '.', '*', '.', '.', '.', '.', '.'},
                /* 9 */{'.', 'P', '.', '.', '*', '.', '.', '.', '.', '.'}};

        System.out.println(new SavePrincess().saved(maze, 10, 10, 100));

    }

    /**
     * @param vis M行N列迷宫
     * @param m   M
     * @param n   N
     * @param t   T
     * @return boolean true表示营救成功，反之表示失败。
     */
    public boolean saved(char[][] vis, int m, int n, int t) {
        if (t < 0) {
            return false;
        }

        this.m = m;
        this.n = n;
        this.visited = vis;
        int[][] step = new int[m][n];

        init(m, n, step);

        if (s == null || p == null) {
            System.out.println("input visited error!");
            return false;
        }

        Queue<Position> queue = new LinkedList<>();
        queue.add(s);
        int l = -1;
        while (!queue.isEmpty()) {
            Position e = queue.poll();
            l = dealOneNode(step, queue, e);
        }

        if (l != -1 && l <= t) {
            System.out.println("Saved the princess in " + l + " seconds!");
            return true;
        }

        System.out.println("failed saved the princess! " + l + " > " + "t");
        return false;
    }

    private void init(int m, int n, int[][] step) {
        for (int i = 0; i != m; i++) {
            for (int j = 0; j != n; j++) {
                step[i][j] = 0;
                switch (visited[i][j]) {
                    case '*':
                    case '.':
                        break;
                    case 'S':
                        this.s = new Position(i, j, 'S');
                        break;
                    case 'P':
                        this.p = new Position(i, j, 'P');
                        break;
                    default:
                        System.out.println("input visited error!");
                        System.exit(-1);
                }
            }
        }
    }

    private int dealOneNode(int[][] step, Queue<Position> queue, Position e) {
        /*
         * 在求相邻节点时做了一点优化，遇到墙的节点则不放到相邻节点中。
         * 从设计思想和可读性上看不是太好，从运行效率考虑，可以。
         */
        for (Position c : getNextPostions(e)) {
            switch (c.getV()) {
                case 'P':
                    queue.clear();
                    return step[e.getI()][e.getJ()] + 1;
                case '.':
                    visited[c.getI()][c.getJ()] = '#';
                    queue.add(c);
                    step[c.getI()][c.getJ()] = step[e.getI()][e.getJ()] + 1;
                    break;
                default:
                    // 不可能进入该分支。
                    System.out.println("some error!");
                    break;
            }
        }
        return -1;
    }

    /**
     * 取有效节点。
     * 遇到墙则不加入相邻节点中。
     *
     * @param e
     * @return
     */
    private List<Position> getNextPostions(Position e) {
        int i = e.getI();
        int j = e.getJ();
        List<Position> lst1 = new LinkedList<>();
        addOneNode(i + 1, j, lst1);
        addOneNode(i, j + 1, lst1);
        addOneNode(i - 1, j, lst1);
        addOneNode(i, j - 1, lst1);
        return lst1;
    }

    private void addOneNode(int i, int j, List<Position> lst) {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return;
        }

        char v = visited[i][j];
        switch (v) {
            case '.':
            case 'P':
                lst.add(new Position(i, j, v));
                break;
            default:
                break;
        }
    }

    private static class Position {
        private final int i;
        private final int j;
        private final char v;

        public Position(int i, int j, char value) {
            this.i = i;
            this.j = j;
            this.v = value;
        }

        public char getV() {
            return v;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public String toString() {
            return "(" + i + ", " + j + ")";
        }
    }
}
