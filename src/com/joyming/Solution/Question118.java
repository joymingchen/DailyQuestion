package com.joyming.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * 提示:
 * 1 <= numRows <= 30
 */
public class Question118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    item.add(1);
                }else {
                    int a = arrays.get(i - 1).get(j - 1);
                    int b = arrays.get(i - 1).get(j);
                    item.add(a + b);
                }
            }
            arrays.add(item);
        }
        return arrays;
    }
}
