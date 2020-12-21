package com.joyming.Solution;


/**
 * 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * <p>
 * 示例 2:
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * <p>
 * 示例 3:
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 */
public class Question321 {

    /**
     * 先找两个数组的长度x+y = k 且要满足 0<= x <= m 和 0<= y <= n
     * 找出两个数组中每个最大长度的数组
     * 双指针
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] answer = new int[k];
        int m = nums1.length;
        int n = nums2.length;
        //第一步：找出所有可能长度的组合
        int start = Math.max(0, k - n);
        int end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            //第二步：列出当前长度下最大值的数组
            int[] numMax1 = findMaxArrays(nums1, i);
            int[] numMax2 = findMaxArrays(nums2, k - i);
            //第三步：两个数组拼接成一个最大的数组
            int[] result = merge(numMax1, numMax2, k);
            //第四步：比较数组的值，保存最大值的数组
            answer = large(answer,result);
        }
        return answer;
    }

    /**
     * 从数组中找出长度为x的最大数的数组
     */
    public int[] findMaxArrays(int[] nums, int x) {
        int[] answer = new int[x];
        int index = 0;
        int lastIndex = 0;
        while (index < x) {
            for (int i = lastIndex; i <= nums.length - x + index; i++) {
                if (nums[i] > answer[index]) {
                    answer[index] = nums[i];
                    lastIndex = i + 1;
                }
                if (x >= nums.length) {
                    answer[index] = nums[i];
                    lastIndex = i + 1;
                    break;
                }
            }
            index++;
        }
        return answer;
    }

    /**
     * 两个数组合并成长度为k的最大数
     */
    public int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int index = 0;
        int i = 0, j = 0;
        while (index < k) {
            if (i >= nums1.length) {
                result[index++] = nums2[j++];
                continue;
            }
            if (j >= nums2.length) {
                result[index++] = nums1[i++];
                continue;
            }
            if (nums1[i] > nums2[j]) {
                result[index++] = nums1[i++];
            } else if (nums1[i] == nums2[j]) {
                //相同对比下一位
                int m = i + 1, n = j + 1;
                while (true) {
                    if(m >= nums1.length){
                        result[index++] = nums2[j++];
                        break;
                    }
                    if(n >= nums2.length){
                        result[index++] = nums1[i++];
                        break;
                    }
                    if (nums1[m] == nums2[n]) {
                        m++;
                        n++;
                    } else {
                        if (nums1[m] > nums2[n]) {
                            result[index++] = nums1[i++];
                        } else {
                            result[index++] = nums2[j++];
                        }
                        break;
                    }
                }
            } else {
                result[index++] = nums2[j++];
            }
        }
        return result;
    }

    /**
     * 比较两个数组的大小
     * @param a
     * @param b
     * @return
     */
    public int[] large(int[] a,int[] b){
        int m = a.length;
        int n = b.length;

        if(m > n){
            return a;
        }else if(m < n){
            return b;
        }else {
            for(int i = 0;i<m;i++){
                if(a[i] > b[i]){
                    return a;
                }else if(a[i] < b[i]){
                    return b;
                }
            }
        }
        return a;
    }

}
