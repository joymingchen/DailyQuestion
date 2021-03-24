package com.joyming.Solution;

import com.joyming.Data.NestedInteger;

import java.util.*;

/**
 * 341.扁平化嵌套列表迭代器(Medium)
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *
 * 示例 1:
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 *
 * 示例 2:
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */
public class Question341 {

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public static class NestedIterator2 implements Iterator<Integer> {

        List<Integer> vals;
        Iterator<Integer> iterator;

        public NestedIterator2(List<NestedInteger> nestedList) {
            vals = new ArrayList();
            dfs(nestedList);
            iterator = vals.iterator();
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        public void dfs(List<NestedInteger> nestedList){
            for(int i =0; i < nestedList.size();i++){
                NestedInteger integer =  nestedList.get(i);
                if(integer.isInteger()){
                    vals.add(integer.getInteger());
                }else {
                    dfs(integer.getList());
                }
            }
        }
    }

    /**
     * 不存储值，而是存储搜索的节点
     * 利用栈来存储深度优先搜索的节点
     */
    public static class NestedIterator implements Iterator<Integer> {

        Deque<Iterator<NestedInteger>> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            // 由于保证调用 next 之前会调用 hasNext，直接返回栈顶列表的当前元素
            return stack.peek().next().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()){
                Iterator<NestedInteger> it = stack.peek();
                if(!it.hasNext()){
                    stack.pop();
                    continue;
                }
                NestedInteger integer = it.next();
                if(integer.isInteger()){
                    List<NestedInteger> list = new ArrayList<>();
                    list.add(integer);
                    stack.push(list.iterator());
                    return true;
                }
                stack.push(integer.getList().iterator());
            }
            return false;
        }

    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
