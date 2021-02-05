package com.joyming.Solution;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * 480. 滑动窗口中位数 (Hard)
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * <p>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 * <p>
 * 提示：
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 */
public class Question480 {

    /**
     * 常规解法，每一次都排序一下
     * 超时
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = k - 1;
        double[] answer = new double[n - k + 1];
        int index = 0;
        while (right < n) {
            int[] current = new int[k];
            for (int i = 0; i < k; i++) {
                current[i] = nums[i + left];
            }
            Arrays.stream(current).sorted();
            int mid1 = k / 2;
            int mid2 = k / 2 - 1;
            if (k % 2 == 0) {
                BigDecimal a, b, c;
                a = new BigDecimal(current[mid1]);
                b = new BigDecimal(current[mid2]);
                c = a.add(b);
                c = c.divide(new BigDecimal(2));
                answer[index++] = c.doubleValue();
            } else {
                answer[index++] = current[mid1];
            }
            left++;
            right++;
        }
        return answer;
    }

    /**
     * 以空间换时间，选取合适的数据结构
     * 大顶堆+小顶堆
     * 双优先队列 + 延迟删除
     */
    public double[] medianSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        double[] answer = new double[n - k + 1];
        DualHeap dualHeap = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dualHeap.insert(nums[i]);
        }
        answer[0] = dualHeap.getMedian();
        for (int i = k; i < n; i++) {
            dualHeap.insert(nums[i]);
            dualHeap.remove(nums[i - k]);
            answer[i - k + 1] = dualHeap.getMedian();
        }
        return answer;
    }


}


/**
 * 大顶堆和小顶堆
 */
class DualHeap {
    //小顶堆
    private PriorityQueue<Integer> small;
    //大顶堆
    private PriorityQueue<Integer> big;
    //需要延迟删除的元素
    private HashMap<Integer, Integer> delayed;

    int smallSize;
    int bigSize;
    private int k;

    public DualHeap(int k) {
        this.small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        this.big = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        this.delayed = new HashMap<>();
        this.k = k;
        this.smallSize = 0;
        this.bigSize = 0;
    }

    /**
     * balance记录了此时两个堆不平等的情况，需要将其平衡到初始水平，此时如果是正的，就从小堆中删除，加到大堆里，
     * 如果是负的，就反过来，平衡完之后，只需要对欠债元素进行删除就可。
     * 欠债元素必须先从small里进行删除，因为添加的时候也是优先添加到small，
     * 优先删除big中的元素极有可能导致big为空，从而导致添加中位数时出问题
     */
    public void insert(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            big.offer(num);
            bigSize++;
        }
        makeBalance();
    }

    public void remove(int num) {
        int deleteNum = delayed.getOrDefault(num, 0);
        delayed.put(num, ++deleteNum);
        if (num <= small.peek()) {
            smallSize--;
            if (num == small.peek()) {
                prune(small);
            }
        } else {
            bigSize--;
            if (num == big.peek()) {
                prune(big);
            }
        }
        makeBalance();
    }


    /**
     * 不断地弹出 heap 的堆顶元素，并且更新哈希表
     */
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                int deleteNum = delayed.getOrDefault(num, 0);
                delayed.put(num, --deleteNum);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                //不需要删除
                break;
            }
        }
    }

    /**
     * 如果 small 和 large 中的元素个数满足要求，则不进行任何操作；
     * <p>
     * 如果 small 比 large 的元素个数多了 2 个，那么我们我们将 small 的堆顶元素放入 large。
     * 此时 small 的对应元素可能是需要删除的，因此我们调用 prune(small)
     * <p>
     * 如果 small 比 large 的元素个数少了 1 个，那么我们将 large 的堆顶元素放入 small。
     * 此时 large 的对应的元素可能是需要删除的，因此我们调用 prune(large)
     */
    private void makeBalance() {
        if (smallSize >= bigSize + 2) {
            // small 比 big 多 2 个
            big.offer(small.poll());
            --smallSize;
            ++bigSize;
            //small元素被移除，需要修剪
            prune(small);
        } else if (smallSize < bigSize) {
            small.offer(big.poll());
            --bigSize;
            ++smallSize;
            //big元素被移除，需要修剪
            prune(big);
        }
    }

    /**
     * 获取中位数
     */
    public double getMedian() {
        return k % 2 == 0 ? ((double) small.peek() / 2) + ((double) big.peek() / 2) : small.peek();
    }


}
