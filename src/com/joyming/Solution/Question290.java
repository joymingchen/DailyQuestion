package com.joyming.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Question290 {

    /**
     * 哈希表存储字母对应关系
     * 官方题解用了两个哈希表，可以简化成一个，多加点判断就好了
     */
    public boolean wordPattern(String pattern, String s) {
        HashMap hashMap = new HashMap<Character, String>();
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");
        int length = chars.length;
        int sLength = strs.length;
        if(length != sLength){
            return false;
        }
        for (int i = 0; i < length; i++) {
            if(hashMap.get(chars[i]) == null ){
                if(!hashMap.containsValue(strs[i])){
                    hashMap.put(chars[i],strs[i]);
                }else {
                    return false;
                }
            }else {
                if(hashMap.containsValue(strs[i])){
                    if(!strs[i].equals(hashMap.get(chars[i]))){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
