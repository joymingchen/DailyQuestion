package com.joyming.Solution;

/**
 * 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 * <p>
 * 示例：
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * 提示：
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 */
public class Question861 {

    /**
     * 先看第一列，全部变为1
     * 再看后面几列，尽可能每列的1足够多
     * 计算结果
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int answer = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                //转换整行
                for (int j = 0; j < A[i].length; j++) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    } else {
                        A[i][j] = 0;
                    }
                }
            }
        }

        int min = A.length /2;
        for(int i = 0;i<A[0].length;i++){
            int zeroNum = 0;

            for(int j= 0;j<A.length;j++){
                if(A[j][i] == 0){
                    zeroNum += 1;
                }
            }

            if(zeroNum > min && i != 0){
                //需要转换,转换整列
                for(int m = 0;m<A.length;m++){
                    if (A[m][i] == 0) {
                        A[m][i] = 1;
                    } else {
                        A[m][i] = 0;
                    }
                }
            }
        }

        for(int i = 0;i<A.length;i++){
            String tenNum = "";
            for(int j = 0;j<A[0].length;j++){
                tenNum += A[i][j];

            }
            answer += Integer.valueOf(tenNum,2);
        }
        return answer;
    }

    public int matrixScore2(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += (1 - A[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }

}
