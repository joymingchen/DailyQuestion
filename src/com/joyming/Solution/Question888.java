package com.joyming.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 888. 公平的糖果棒交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * <p>
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 */
public class Question888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] answer = new int[2];
        int aliceSum = 0;
        int bobSum = 0;
        int aLength = A.length;
        int bLength = B.length;
        for (int i = 0; i < aLength; i++) {
            aliceSum += A[i];
        }
        for (int i = 0; i < bLength; i++) {
            bobSum += B[i];
        }
        boolean isGet = false;
        for (int i = 0; i < aLength; i++) {
            for (int j = 0; j < bLength; j++) {
                int leftSum = aliceSum - A[i] + B[j];
                int rightSum = bobSum - B[j] + A[i];
                if(leftSum == rightSum){
                    answer[0] = A[i];
                    answer[1] = B[j];
                    isGet = true;
                    break;
                }
            }
            if(isGet){
                break;
            }
        }
        return answer;
    }


    public int[] fairCandySwap2(int[] A, int[] B) {
        int[] answer = new int[2];
        int aliceSum = Arrays.stream(A).sum();
        int bobSum = Arrays.stream(B).sum();
        int aLength = A.length;
        int bLength = B.length;
        int delta = (aliceSum - bobSum) / 2;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < aLength; i++) {
            hashSet.add(A[i]);
        }

        for (int i = 0; i < bLength; i++) {
            int x = delta  + B[i];
            if(hashSet.contains(x)){
                answer[0] = x;
                answer[1] = B[i];
                break;
            }
        }
        return answer;
    }
}
