package com.joyming.Solution;

/**
 * 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 */
public class Question605 {

    /**
     * 寻找左右相邻都为空的个数
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int blankNum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] > 0) {
                //已经种植过花
                continue;
            } else {
                //没种植过,检查左右
                int left = i - 1;
                int right = i + 1;

                if (left < 0) {
                    left = 0;
                }
                if (right >= flowerbed.length) {
                    right = flowerbed.length - 1;
                }

                if (i == 0) {
                    if (flowerbed[right] == 0) {
                        flowerbed[i] = 1;
                        blankNum++;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[left] == 0) {
                        flowerbed[i] = 1;
                        blankNum++;
                    }
                } else {
                    if (flowerbed[left] == 0 && flowerbed[right] == 0) {
                        flowerbed[i] = 1;
                        blankNum++;
                    }
                }
            }
        }

        if (blankNum >= n) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 寻找左右相邻都为空的个数
     * 条件优化
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {

        int blankNum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                blankNum++;
            }

            if(blankNum >= n){
                return true;
            }

        }
        return false;
    }

}
