package com.joyming.Solution;

import java.util.*;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class Question1122 {

    /**
     * 遍历进行比较
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int index = 0;

        for (int num : arr2) {
            //先找相同的
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == num) {
                    result[index++] = arr1[j];
                    arr1[j] = -1;
                }
            }
        }

        //不相同的
        if(arr1.length > arr2.length){
            int[] diffSort = new int[arr1.length - arr2.length];
            int diffIndex = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] > 0) {
                    diffSort[diffIndex++] = arr1[j];
                    arr1[j] = -1;
                }
            }
            Arrays.sort(diffSort);

            for(int i : diffSort){
                if(i > 0){
                    result[index++] = i;
                }
            }
        }
        return result;
    }

    /**
     * 自定义排序
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) list.add(num);
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        list.sort((x, y) -> {
            if (map.containsKey(x) || map.containsKey(y))
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }
}
