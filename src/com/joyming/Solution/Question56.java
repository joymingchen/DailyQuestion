package com.joyming.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 */
public class Question56 {
    /**
     * 先排序，在合并区间
     * 贪心算法
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        for(int i = 0;i< n;i++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            int next = i + 1;
            if(next >= n){
                result.add(intervals[i]);
                continue;
            }
            int nextLeft = intervals[next][0];
            int nextRight = intervals[next][1];

            if(next == n || right < nextLeft){
                result.add(intervals[i]);
            }else {
                int[] newIntervals = new int[]{left,nextRight};
                if(right > nextRight){
                    newIntervals = new int[]{left,right};
                }
                intervals[next] = newIntervals;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
