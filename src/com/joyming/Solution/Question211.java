package com.joyming.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 211.添加与搜索单词 - 数据结构设计(Medium)
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * <p>
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * <p>
 * <p>
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 */
public class Question211 {
    class CharNode {
        CharNode[] chars = new CharNode[26];
        boolean isWord;
    }
    CharNode root = new CharNode();

    public void addWord(String word) {
        CharNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.chars[u] == null) {
                p.chars[u] = new CharNode();
            }
            p = p.chars[u];
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, CharNode root, int index) {
        if (word.length() == index) {
            return root.isWord;
        }
        char current = word.charAt(index);

        if (current == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.chars[i] != null) {
                    if (dfs(word, root.chars[i], index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int currentIndex = current - 'a';

            if (root.chars[currentIndex] == null) {
                return false;
            }
            return dfs(word, root.chars[currentIndex], index + 1);
        }
    }
}





/*
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
