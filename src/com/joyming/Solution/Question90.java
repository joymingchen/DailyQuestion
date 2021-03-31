package com.joyming.Solution;

import java.util.*;

/**
 * 90.子集 II（Medium）
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class Question90 {

    /**
     * 迭代法实现子集枚举
     *
     * 考虑数组 [1,2,2]，选择前两个数，或者第一、三个数，都会得到相同的子集。
     *
     * 也就是说，对于当前选择的数 xx，若前面有与其相同的数 yy，且没有选择 yy，此时包含 xx 的子集，必然会出现在包含 yy 的所有子集中。
     *
     * 我们可以通过判断这种情况，来避免生成重复的子集。代码实现时，可以先将数组排序；迭代时，若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集
     *
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        for (int i = 1; i < (1<<n); i++) {
            List<Integer> list = new ArrayList<>();
            boolean isFlag = true;
            //j表示二进制到第几位
            for (int j = 0; j < n; j++) {
                if( (i & (1 << j)) != 0){
                    //上一位未被选择，且与当前位相同
                    if(j > 0 &&  ( (1 << (j - 1)) & i ) == 0 && nums[j] == nums[j - 1]){
                        isFlag = false;
                    }else {
                        list.add(nums[j]);
                    }
                }
            }
            if(isFlag){
                answer.add(list);
            }
        }
        return answer;
    }

}
