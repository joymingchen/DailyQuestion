package com.joyming.Solution;

import java.util.*;

/**
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，
 * 其余元素是 emails 表示该账户的邮箱地址。
 * <p>
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 * 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。
 * 一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * <p>
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。
 * 账户本身可以以任意顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
 * ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 * ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 * ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * <p>
 * <p>
 * 提示：
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 */
public class Question721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //建立邮箱对应index的映射关系
        Map<String, Integer> emailToIndex = new HashMap<>();
        //建立邮箱对应姓名的映射关系
        Map<String, String> emailToName = new HashMap<>();
        //邮箱个数
        int emailCount = 0;

        //遍历所有的账户，建立邮箱的对应关系
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    //如果没有出现过这个邮箱，将它添加到两个对应的map中
                    emailToIndex.put(email, emailCount++);
                    emailToName.put(email, name);
                }
            }
        }

        //开始通过并查集来进行合并
        UnionFind unionFind = new UnionFind(emailCount);
        //遍历所有邮箱
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String nextEmail = account.get(i);
                unionFind.union(emailToIndex.get(firstEmail), emailToIndex.get(nextEmail));
            }
        }

        //建立一个nameIndex对应邮箱地址的Map
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            //邮箱对应的姓名索引， 根据索引在并查集中得到当前邮箱地址的根节点
            int index = unionFind.find(emailToIndex.get(email));
            //判断是否存在
            List<String> list = indexToEmails.getOrDefault(index,new ArrayList<>());
            list.add(email);
            indexToEmails.put(index,list);
        }

        //创建结果
        List<List<String>> answer = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            //将emails按照题目要求进行排序
            Collections.sort(emails);
            //找到邮箱对应的账户姓名
            String name = emailToName.get(emails.get(0));
            //创建新的list
            List<String> newList = new ArrayList<>();
            newList.add(name);
            newList.addAll(emails);
            answer.add(newList);
        }
        return answer;
    }

    private class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
            }
        }


        private int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
    }
}
