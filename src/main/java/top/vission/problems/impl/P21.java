package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;


@Slf4j
public class P21 implements LeetCodeProblemRun {

    @Override
    public void run() {
//        l1 = [1,2,4], l2 = [1,3,4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists3(list1, list2);
        log.info("result:{}", listNode.toString());
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode();
        ListNode cur = newList;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
                continue;
            }

            if (p2 == null) {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
                continue;
            }

            if (p1.val <= p2.val) {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
                continue;
            }
            if (p2.val < p1.val) {
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
                continue;
            }
        }
        return newList.next;
    }


    /**
     * 学习题解优化代码
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        ListNode preHeader = new ListNode(-1);
        ListNode cur = preHeader;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return preHeader.next;
    }

    /**
     * 学习题解——递归实现
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists3(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists3(list1, list2.next);
            return list2;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }
}
