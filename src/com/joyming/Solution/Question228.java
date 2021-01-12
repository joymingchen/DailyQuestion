package com.joyming.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * 示例 3：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：["-1"]
 * <p>
 * 示例 5：
 * 输入：nums = [0]
 * 输出：["0"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */
public class Question228 {

    /**
     * 利用双指针
     * 执行用时: 10 ms
     */
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> answer = new ArrayList<>();
        if (n <= 0) {
            return answer;
        }
        int left = 0, right = 1;
        while (right < n) {
            int start = nums[left];
            int end = nums[right];
            int previous = nums[right - 1];
            if (previous + 1 == end) {
                //连续
                right++;
            } else {
                //不连续
                if (right - left != 1) {
                    answer.add(start + "->" + previous);
                } else {
                    answer.add(start + "");
                }
                left = right;
                right++;
            }
        }
        if (right - left != 1) {
            answer.add(nums[left] + "->" + nums[right - 1]);
        } else {
            answer.add(nums[left] + "");
        }
        return answer;
    }

    /**
     * 执行用时: 0 ms
     */
    public List<String> summaryRanges2(int[] nums) {
        ArrayList<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (!(i + 1 < nums.length && nums[i] + 1 == nums[i + 1])) {
                if (sb.length() > 0)
                    sb.append("->");
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (sb.length() == 0)
                    sb.append(nums[i]);
            }
        }
        return ans;
    }

}
