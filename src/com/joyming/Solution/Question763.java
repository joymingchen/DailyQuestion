package com.joyming.Solution;

import java.util.*;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * <p>
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class Question763 {

    /**
     * 拿出所有字符出现的区间进行比较
     * 利用HashMap保存数组
     * 贪心算法
     */
    public List<Integer> partitionLabels(String S) {
        //记录字母出现的区间
        HashMap<Character, int[]> interval = new HashMap<>();

        //预处理
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            int[] ints = interval.get(c);
            if (ints == null) {
                //记录首次出现的位置
                interval.put(c, new int[]{i, i});
            } else {
                //更新最后一次出现的位置
                int end = ints[1];
                if (i > end) {
                    ints[1] = i;
                }
            }
        }

        //遍历hashMap
        int[][] sortInterval = new int[interval.size()][2];
        int index = 0;
        Iterator iterator = interval.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, int[]> entry = (Map.Entry<Character, int[]>) iterator.next();
            sortInterval[index++] = entry.getValue();
        }

        //按x_start排序
        Arrays.sort(sortInterval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int firstEnd = sortInterval[0][1];
        int left = sortInterval[0][0];
        int right = sortInterval[0][1];

        List<int[]> intervalList = new ArrayList<>();
        intervalList.add(new int[]{left, right});
        for (int i = 0; i < sortInterval.length; i++) {
            left = sortInterval[i][0];
            right = sortInterval[i][1];
            if (left > firstEnd) {
                firstEnd = right;
                int minRight = intervalList.size() == 0 ? right : intervalList.get(intervalList.size() - 1)[1];

                if (right > minRight) {
                    minRight = right;
                }
                if(i == 0){
                    left = 0;
                }
                intervalList.add(new int[]{left, minRight});
            } else {
                int minRight = intervalList.get(intervalList.size() - 1)[1];

                if (right > minRight) {
                    int[] now = intervalList.get(intervalList.size() - 1);
                    now[1] = right;
                    intervalList.set(intervalList.size() - 1,now);
                    firstEnd = right;
                }
            }
        }

        List<Integer> numList = new ArrayList<>();
        for (int[] ints : intervalList) {
            int length = ints[1] - ints[0] + 1;
            numList.add(length);
        }
        return numList;
    }
}
