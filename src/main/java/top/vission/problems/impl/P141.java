package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.HashSet;


@Slf4j
public class P141 implements LeetCodeProblemRun {

    @Override
    public void run() {
//        3->2->0->-4->2
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode_4 = new ListNode(-4);
        listNode3.next = listNode2;
        listNode2.next = listNode0;
        listNode0.next = listNode_4;
        listNode_4.next = listNode2;
        log.info("request:{}", listNode3);
        boolean hasCycle = hasCycle(listNode3);
        log.info("result:{}", hasCycle);
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode cur = head;
        HashSet<ListNode> set = new HashSet();
        Boolean hasCycle = null;

        while (hasCycle == null) {
            if (set.contains(cur)) {
                hasCycle = true;
            }
            if (cur.next == null) {
                hasCycle = false;
            }
            set.add(cur);
            cur = cur.next;
        }
        return hasCycle;

    }

    /**
     * Definition for singly-linked list.
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
