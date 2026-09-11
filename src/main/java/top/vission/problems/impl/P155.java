package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.DelayQueue;


@Slf4j
public class P155 implements LeetCodeProblemRun {

    @Override
    public void run() {
        MinStack minStack = new MinStack();

//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//
////        log.info("request:{}");
//        log.info("result:{}", minStack.getMin());
//        minStack.pop();
//        log.info("result:{}", minStack.top());
//        log.info("result:{}", minStack.getMin());

        minStack.push(-1);
        log.info("result:{}", minStack.top());
        log.info("result:{}", minStack.getMin());

    }


    class MinStack {
        Deque<int[]> stack = new ArrayDeque<>(); // [值, 当前最小值]

        public void push(int value) {
            int min = stack.isEmpty() ? value : Math.min(getMin(), value);
            stack.push(new int[]{value, min});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }
}
