package com.joyming.Custom;

/**
 * 将二进制的数字转换为中文
 * 范围为 0 ~ 2^16
 *
 * 示例 1:
 * 输入: 2
 * 输出: 十
 * 解释: 2 的二进制为 10
 *
 * 示例 2:
 * 输入: 6
 * 输出: 一百一
 * 解释: 6 的二进制为 110
 *
 * 示例 3:
 * 输入: 174
 * 输出: 一千零一十万一千一百一
 * 解释: 174 的二进制为 10101110
 */
public class Binary2Chinese {

    /**
     * 时间复杂度: O(n)
     */
    public String binary2Chinese(int n) {
        if (n == 2) {
            return "十";
        }
        if (n == 3) {
            return "十一";
        }
        StringBuilder answer = new StringBuilder();
        //1000 0000 0000 0000
        int maxValue = 32768;
        StringBuilder num = new StringBuilder();
        String[] unitText = {"兆", "亿", "万", ""};
        int unitNum = 0;
        int intervalNum = 0;
        //是否有千位
        boolean isHaveThousand = false;
        //是否有百位
        boolean isHaveHundred = false;
        //是否有十位
        boolean isHaveTen = false;
        //是否有个位
        boolean isHaveOne = false;

        for (int i = 0; i < 16; i++) {
            if ((n & (maxValue >> i)) != 0) {
                //1位
                num.append("1");
                switch (intervalNum) {
                    case 0:
                        isHaveThousand = true;
                        answer.append("一千");
                        break;
                    case 1:
                        isHaveHundred = true;
                        answer.append("一百");
                        break;
                    case 2:
                        isHaveTen = true;
                        answer.append("一十");
                        break;
                    case 3:
                        isHaveOne = true;
                        answer.append("一");
                        break;
                }
            } else {
                num.append("0");
                answer.append("零");
            }
            if (intervalNum == 3) {
                //零的特殊处理
                answer = new StringBuilder(answer.toString().replaceAll("零零零零", ""));
                answer = new StringBuilder(answer.toString().replaceAll("零零零", ""));
                answer = new StringBuilder(answer.toString().replaceAll("零零", "零"));

                if (answer.toString().startsWith("零")) {
                    answer = new StringBuilder(answer.substring(1, answer.length()));
                }
                if (answer.toString().endsWith("十零")) {
                    answer = new StringBuilder(answer.substring(0, answer.length() - 1));
                }
                if (answer.toString().endsWith("百零")) {
                    answer = new StringBuilder(answer.substring(0, answer.length() - 1));
                }

                //单位
                if (isHaveThousand || isHaveHundred || isHaveTen || isHaveOne) {
                    answer.append(unitText[unitNum]);
                }

                //标记位初始化
                intervalNum = -1;
                unitNum++;
                isHaveThousand = false;
                isHaveHundred = false;
                isHaveTen = false;
                isHaveOne = false;
            }
            intervalNum++;
        }

        if (answer.toString().endsWith("一千一百")) {
            answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        }
        if (answer.toString().endsWith("一百一十")) {
            answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        }
        System.out.println("\n数字:" + num + " ");
        return answer.toString();
    }
}
