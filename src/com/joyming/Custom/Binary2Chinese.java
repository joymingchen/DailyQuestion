package com.joyming.Custom;

/**
 * 将二进制的数字转换为中文
 * 范围为 0 ~ 2^16
 */
public class Binary2Chinese {

    public String binary2Chinese(int n) {
        if (n == 2) {
            return "十";
        }
        if (n == 3) {
            return "十一";
        }
        String answer = "";
        //1000 0000 0000 0000
        int maxValue = 32768;
        String num = "";
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
                num += "1";
                switch (intervalNum) {
                    case 0:
                        isHaveThousand = true;
                        answer += "一千";
                        break;
                    case 1:
                        isHaveHundred = true;
                        answer += "一百";
                        break;
                    case 2:
                        isHaveTen = true;
                        answer += "一十";
                        break;
                    case 3:
                        isHaveOne = true;
                        answer += "一";
                        break;
                }
            } else {
                num += "0";
                answer += "零";
            }
            if (intervalNum == 3) {
                //零的特殊处理
                answer = answer.replaceAll("零零零零", "");
                answer = answer.replaceAll("零零零", "");
                answer = answer.replaceAll("零零", "零");

                if (answer.startsWith("零")) {
                    answer = answer.substring(1, answer.length());
                }
                if (answer.endsWith("十零")) {
                    answer = answer.substring(0, answer.length() - 1);
                }
                if (answer.endsWith("百零")) {
                    answer = answer.substring(0, answer.length() - 1);
                }
                if (answer.endsWith("一千一百")) {
                    answer = answer.substring(0, answer.length() - 1);
                }
                if (answer.endsWith("一百一十")) {
                    answer = answer.substring(0, answer.length() - 1);
                }

                //单位
                if (isHaveThousand || isHaveHundred || isHaveTen || isHaveOne) {
                    answer += unitText[unitNum];
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
        System.out.println("\n数字:" + num + " ");
        return answer;
    }
}
