package com.joyming.Custom;

/**
 * 数组拆分 I
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 返回该 最大总和 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 * <p>
 * 示例 2：
 * 输入：nums = [6,2,6,5,1,2]
 * 输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 * <p>
 * 提示：
 * 1 <= n <= 104
 * nums.length == 2 * n
 * -104 <= nums[i] <= 104
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/c24he/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class arrayPairSum {

    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        if (n % 2 != 0) {
            return 0;
        }
//        Arrays.sort(nums);
        quickSort(nums, 0, n - 1);
        //sum
        int answer = 0;
        for (int i = 0; i < nums.length; i += 2) {
            answer += nums[i];
        }
        return answer;
    }


    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        //基准点
        int temp = nums[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (temp <= nums[j] && i < j) {
                j--;
            }
            while (temp >= nums[i] && i < j) {
                i++;
            }
            if (i < j) {
                changeIndex(nums, i, j);
            }
        }
        nums[left] = nums[j];
        nums[j] = temp;
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    public void changeIndex(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] answer = new int[2];
        while (left < right) {
            int b = target - nums[left];
            if (b == nums[right]) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                return answer;
            } else if (b < nums[right]) {
                right--;
            } else {
                left++;
            }
        }
        return answer;
    }
}
