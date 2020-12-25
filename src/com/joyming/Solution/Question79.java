package com.joyming.Solution;

import java.util.Arrays;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * <p>
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Question79 {

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        boolean[][] table = new boolean[n][board[0].length];
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                char item = board[i][j];
                String itemStr = "";
                itemStr += item;
                table[i][j] = true;
                if (word.startsWith(itemStr)) {
                    if(word.equals(itemStr)){
                        return true;
                    }else{
                        if (depthFind(itemStr, i, j, board, table, word)) {
                            return true;
                        } else {
                            table[i][j] = false;
                        }
                    }
                } else {
                    table[i][j] = false;
                    continue;
                }
            }
        }
        return false;
    }

    public boolean depthFind(String str, int x, int y, char[][] board, boolean[][] table, String word) {
        if (x >= board.length || y >= board[0].length) {
            return false;
        }

        //先向上
        if(x - 1 >= 0 && !table[x - 1][y]){
            char item = board[x - 1][y];
            str += item;
            table[x - 1][y] = true;
            if(word.startsWith(str)){
                if (str.equals(word)) {
                    return true;
                } else {
                    if(depthFind(str, x - 1, y, board, table, word)){
                        return true;
                    }else {
                        table[x - 1][y] = false;
                        str = str.substring(0,str.length() -1);
                    }
                }
            }else {
                table[x - 1][y] = false;
                str = str.substring(0,str.length() -1);
            }
        }

        //向左
        if(y - 1 >= 0 && !table[x][y - 1]){
            char item = board[x][y - 1];
            str += item;
            table[x][y - 1] = true;
            if(word.startsWith(str)){
                if (str.equals(word)) {
                    return true;
                } else {
                    if(depthFind(str, x,y - 1, board, table, word)){
                        return true;
                    }else {
                        table[x][y - 1] = false;
                        str = str.substring(0,str.length() -1);
                    }
                }
            }else {
                table[x][y - 1] = false;
                str = str.substring(0,str.length() -1);
            }
        }

        //向下
        if(x + 1 < board.length && !table[x + 1][y]){
            char item = board[x + 1][y ];
            str += item;
            table[x + 1][y] = true;
            if(word.startsWith(str)){
                if (str.equals(word)) {
                    return true;
                } else {
                    if(depthFind(str, x + 1,y, board, table, word)){
                        return true;
                    }else {
                        table[x + 1][y] = false;
                        str = str.substring(0,str.length() -1);
                    }
                }
            }else {
                table[x + 1][y] = false;
                str = str.substring(0,str.length() -1);
            }
        }

        //向右
        if(y + 1 < board[0].length && !table[x][y + 1]){
            char item = board[x][y + 1];
            str += item;
            table[x][y + 1] = true;
            if(word.startsWith(str)){
                if (str.equals(word)) {
                    return true;
                } else {
                    if(depthFind(str, x,y + 1, board, table, word)){
                        return true;
                    }else {
                        table[x][y + 1] = false;
                        str = str.substring(0,str.length() -1);
                    }
                }
            }else {
                table[x][y + 1] = false;
                str = str.substring(0,str.length() -1);
            }
        }

        return false;
    }
}
