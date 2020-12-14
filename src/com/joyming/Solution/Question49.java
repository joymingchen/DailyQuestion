package com.joyming.Solution;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Question49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        List<List<String>> sortAnswer = new ArrayList<>();
        String[] test = strs.clone();
        for (int i = 0; i < test.length; i++) {
            String item = test[i];
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            test[i] = String.valueOf(chars);
        }
        for (int i = 0; i < test.length; i++) {
            String item = test[i];
            boolean isHave = false;
            for (int j = 0; j < answer.size(); j++) {
                if (sortAnswer.get(j).contains(item)) {
                    isHave = true;
                    sortAnswer.get(j).add(test[i]);
                    answer.get(j).add(strs[i]);
                }
            }
            if (!isHave) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                answer.add(list);
                List<String> sortList = new ArrayList<>();
                sortList.add(test[i]);
                sortAnswer.add(sortList);
            }
        }
        return answer;
    }

    /**
     * 利用hash表
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

}
