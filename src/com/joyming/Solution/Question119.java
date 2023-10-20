package com.joyming.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * <p>
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 * <p>
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 <= rowIndex <= 33
 */
public class Question119 {


    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    item.add(1);
                } else {
                    int a = arrays.get(i - 1).get(j - 1);
                    int b = arrays.get(i - 1).get(j);
                    item.add(a + b);
                }
            }
            arrays.add(item);
        }
        return rowIndex < 0 ? new ArrayList<>() : arrays.get(rowIndex);
    }
}
