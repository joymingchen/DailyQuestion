package com.joyming.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Question454 {

    /**
     * 遍历所有可能，但时间超出限制
     * 时间复杂度 O(nⁿ4)
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    for (int l = 0; l < length; l++) {
                        if (A[i] + B[j] + C[k] + D[l] == 0) {
                            answer++;
                        }
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 分组+哈希表
     * A+B+C+D=0 => A+B=C+D
     */
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        HashMap<Integer, Integer> table1 = new HashMap();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = A[i] + B[j];

                if (table1.get(sum) == null) {
                    table1.put(sum, 1);
                } else {
                    int num = table1.get(sum);
                    table1.put(sum, ++num);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = C[i] + D[j];


                if(table1.containsKey(-sum)){
                    answer += table1.get(-sum);
                }
            }
        }
        return answer;
    }

}
