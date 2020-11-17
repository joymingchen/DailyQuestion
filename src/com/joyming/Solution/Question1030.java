package com.joyming.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1030. 距离顺序排列矩阵单元格
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * <p>
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 * <p>
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 * <p>
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 */
public class Question1030 {

    /**
     * 枚举出所有的点，然后根据曼哈顿距离排序
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] rect = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rect[i * C + j] = new int[]{i, j};
            }
        }

        Arrays.sort(rect, Comparator.comparingInt(a -> (Math.abs(a[0] - r0) + Math.abs(a[1] - c0))));
        return rect;
    }

    /**
     * 枚举出所有的点的时候，根据曼哈顿距离进行桶排序
     */
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int maxDistance = Math.max(R, R - 1 - r0) + Math.max(C, C - 1 - c0);
        //创建桶
        List<List<int[]>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxDistance; i++) {
            buckets.add(new ArrayList<>());
        }

        //枚举所有点
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int distance = dist(i,j,r0,c0);
                buckets.get(distance).add(new int[]{i,j});
            }
        }

        //从桶中按照顺序取出
        int[][] rect = new int[R*C][];
        int index = 0;
        for(int i =0;i<=maxDistance;i++){
            for(int[] it : buckets.get(i)){
                rect[index++] = it;
            }
        }
        return rect;
    }

    /**
     * 计算曼哈顿距离
     */
    private int dist(int r0, int c0, int r1, int c1) {
        return Math.abs(r1 - r0) + Math.abs(c1 - c0);
    }

}
