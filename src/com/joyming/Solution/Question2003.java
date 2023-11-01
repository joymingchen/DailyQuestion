package com.joyming.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 2003. 每棵子树内缺失的最小基因值
 * <p>
 * 有一棵根节点为 0 的 家族树 ，总共包含 n 个节点，节点编号为 0 到 n - 1 。给你一个下标从 0 开始的整数数组 parents ，其中 parents[i] 是节点 i 的父节点。由于节点 0 是 根 ，所以 parents[0] == -1 。
 * <p>
 * 总共有 105 个基因值，每个基因值都用 闭区间 [1, 105] 中的一个整数表示。给你一个下标从 0 开始的整数数组 nums ，其中 nums[i] 是节点 i 的基因值，且基因值 互不相同 。
 * <p>
 * 请你返回一个数组 ans ，长度为 n ，其中 ans[i] 是以节点 i 为根的子树内 缺失 的 最小 基因值。
 * <p>
 * 节点 x 为根的 子树 包含节点 x 和它所有的 后代 节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：parents = [-1,0,0,2], nums = [1,2,3,4]
 * 输出：[5,1,1,1]
 * 解释：每个子树答案计算结果如下：
 * - 0：子树包含节点 [0,1,2,3] ，基因值分别为 [1,2,3,4] 。5 是缺失的最小基因值。
 * - 1：子树只包含节点 1 ，基因值为 2 。1 是缺失的最小基因值。
 * - 2：子树包含节点 [2,3] ，基因值分别为 [3,4] 。1 是缺失的最小基因值。
 * - 3：子树只包含节点 3 ，基因值为 4 。1是缺失的最小基因值。
 * <p>
 * 示例 2：
 * 输入：parents = [-1,0,1,0,3,3], nums = [5,4,6,2,1,3]
 * 输出：[7,1,1,4,2,1]
 * 解释：每个子树答案计算结果如下：
 * - 0：子树内包含节点 [0,1,2,3,4,5] ，基因值分别为 [5,4,6,2,1,3] 。7 是缺失的最小基因值。
 * - 1：子树内包含节点 [1,2] ，基因值分别为 [4,6] 。 1 是缺失的最小基因值。
 * - 2：子树内只包含节点 2 ，基因值为 6 。1 是缺失的最小基因值。
 * - 3：子树内包含节点 [3,4,5] ，基因值分别为 [2,1,3] 。4 是缺失的最小基因值。
 * - 4：子树内只包含节点 4 ，基因值为 1 。2 是缺失的最小基因值。
 * - 5：子树内只包含节点 5 ，基因值为 3 。1 是缺失的最小基因值。
 * <p>
 * 示例 3：
 * 输入：parents = [-1,2,3,0,2,4,1], nums = [2,3,4,5,6,7,8]
 * 输出：[1,1,1,1,1,1,1]
 * 解释：所有子树都缺失基因值 1 。
 * <p>
 * <p>
 * 提示：
 * n == parents.length == nums.length
 * 2 <= n <= 10^5
 * 对于 i != 0 ，满足 0 <= parents[i] <= n - 1
 * parents[0] == -1
 * parents 表示一棵合法的树。
 * 1 <= nums[i] <= 10^5
 * nums[i] 互不相同。
 */
public class Question2003 {

    /**
     * 输入：parents = [-1,0,0,2], nums = [1,2,3,4]
     * 输出：[5,1,1,1]
     * <p>
     * 结论一：nums 中没有 1 时，最小基因数都是为 1
     * 结论二：nums 有 1，所有该节点的“非祖先”节点，答案为 1
     * 结论三：从「1 节点」到「根节点」的路径中，答案必然满足“非递减”性质
     */
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        //找出每个节点的子树节点
        int n = parents.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        //建图
        int cur = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                //找到节点1
                cur = i;
            }

            List<Integer> list = map.getOrDefault(parents[i], new ArrayList<>());
            list.add(i);
            map.put(parents[i], list);
        }

        //结论一：当nums中没有1时，最小基因数都是为1
        if (cur == -1) {
            return answer;
        }

        boolean[] vis = new boolean[100010];

        // 从节点 1 开始往根找（从深到浅）, idx 代表当前节点, ne 代表 cur 在该链路下的子节点
        // val 代表当前的节点的最小缺失值。 cur 代指当前节点，使用 ne 代指当前节点的子节点，vis 数组记录在子树中出现过的基因值
        int ne = cur, val = 1;
        while (cur != -1) {
            // 每次对当前节点所在子树的进行标记
            dfs(cur, ne, map, nums, vis);
            // 在 [val, n+1] 范围内找第一个未被标记基因值
            for (int i = val; i <= n + 1; i++) {
                if (vis[i]) continue;
                answer[cur] = val = i;
                break;
            }
            ne = cur;
            cur = parents[cur]; // 指针上移

        }
        return answer;
    }


    private void dfs(int cur, int ne, HashMap<Integer, List<Integer>> map, int[] nums, boolean[] visited) {
        visited[nums[cur]] = true;
        List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
        for (int x : list) {
            if (x == ne) continue;
            dfs(x, ne, map, nums, visited);
        }
    }


}
