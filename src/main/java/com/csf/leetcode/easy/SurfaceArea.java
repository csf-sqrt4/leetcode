package com.csf.leetcode.easy;

/**
 * 功能描述:在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。  每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。   
 * 示例 1：  输入：[[2]] 输出：10
 * 示例 2：  输入：[[1,2],[3,4]] 输出：34
 * 示例 3：  输入：[[1,0],[0,2]] 输出：16
 * 示例 4：  输入：[[1,1,1],[1,0,1],[1,1,1]] 输出：32
 * 示例 5：  输入：[[2,2,2],[2,1,2],[2,2,2]] 输出：46
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenshuangfei
 * @date 2020/3/27 12:07 AM
 */
public class SurfaceArea {

    public int surfaceArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = 0;
        int verticalOverlap = 0;
        int rowOverlap = 0;
        int colOverlap = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += grid[i][j];
                if (grid[i][j] > 1) {
                    verticalOverlap += grid[i][j] - 1;
                }
                if (i > 0) {
                    colOverlap += Math.min(grid[i][j], grid[i - 1][j]);
                }
                if (j > 0) {
                    rowOverlap += Math.min(grid[i][j], grid[i][j - 1]);
                }
            }
        }
        return sum * 6 - (verticalOverlap + rowOverlap + colOverlap) * 2;
    }
}
