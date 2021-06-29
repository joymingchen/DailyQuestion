package com.joyming.Solution;

/**
 * 168.Excel表列名称(Easy)
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 */
public class Question168 {

    /**
     * 可以理解为十进制转二十六进制
     * 字母范围是[1,26];全部减一即[0,25]
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder answer = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            answer.append((char) ('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        return answer.reverse().toString();
    }
}
