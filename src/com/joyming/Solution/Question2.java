package com.joyming.Solution;

import com.joyming.data.ListNode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question2 {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.87%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了94.26%的用户
     *
     * 类似竖式计算
     * 时间复杂度：O(Max(m,n)) 链表最长的长度，最多重复Max(m,n)次
     * 空间复杂度：O(Max(m,n)) 空间最长 Max(m,n) + 1
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);

        ListNode p = l1, q = l2, current = listNode;
        //记录进位
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;

            int sum = x + y + carry;

            //刷新进位，0 获取 1
            carry = sum / 10;

            //赋值到尾部
            current.next = new ListNode(sum % 10);
            current = current.next;

            //向后移动
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }

            //覆盖尾部
            if(carry > 0){
                current.next = new ListNode(carry);
            }
        }
        return listNode.next;
    }

    /**
     * 拓展：
     * 如果链表中的数字不是按逆序排列(链表反转)
     *
     * 例如:
     * [2,4,3] + [5,6,4] = [8,0,7]
     */
    public ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);

        ListNode p = l1, q = l2, current = dummyHead;
        //记录进位
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;

            int sum = x + y + carry;

            //刷新进位，0 获取 1
            carry = sum / 10;

            //赋值到尾部
            current.next = new ListNode(sum % 10);
            current = current.next;

            //向后移动
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }

            //覆盖尾部
            if(carry > 0){
                current.next = new ListNode(carry);
            }
        }

        //链表反转
        ListNode listNode = new ListNode(0);

        dummyHead = dummyHead.next;

        while (dummyHead != null){

            //保存插入点之后的数据
            ListNode tempList = dummyHead.next;
            dummyHead.next = listNode.next;
            listNode.next = dummyHead;
            dummyHead = tempList;
        }

        return listNode.next;
    }
}
