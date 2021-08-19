package com.joyming.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 345.反转字符串中的元音字母 (Easy)
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * a、e、i、o、u
 * 元音字母不包含字母 "y" 。
 */
public class Question345 {


    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            boolean leftIsVowel = isVowel(chars[left]);
            boolean rightIsVowel = isVowel(chars[right]);

            if (leftIsVowel && rightIsVowel) {
                //都是元音,交换顺序
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            if (!leftIsVowel) {
                left++;
            }
            if (!rightIsVowel) {
                right--;
            }
        }
        return String.valueOf(chars);
    }

    public boolean isVowel(char word) {
        return "aeiouAEIOU".indexOf(word) > 0;
//        return word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u' ||
//                word == 'A' || word == 'E' || word == 'I' || word == 'O' || word == 'U';
    }

}
