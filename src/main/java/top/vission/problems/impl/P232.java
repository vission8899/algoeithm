package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.Stack;


@Slf4j
public class P232 implements LeetCodeProblemRun {

    @Override
    public void run() {
//        log.info("request:{}");


//        测试用例:
//["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
//[[],[1],[2],[3],[4],[],[5],[],[],[],[]]
//测试结果:
//[null,null,null,null,null,2,null,4,3,3,3]
//期望结果:
//[null,null,null,null,null,1,null,2,3,4,5]
//stdout:

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        log.info("result:{}", myQueue.pop());
        myQueue.push(5);
        log.info("result:{}", myQueue.pop());
        log.info("result:{}", myQueue.pop());
        log.info("result:{}", myQueue.pop());
        log.info("result:{}", myQueue.pop());

    }

    class MyQueue {
        Stack<Object> stack1;
        Stack<Object> tmp;

        public MyQueue() {
            stack1 = new Stack<>();
            tmp = new Stack<>();

        }

        public void push(int x) {
            stack1.add(x);
        }

        public int pop() {
            int size = stack1.size();
            for (int i = 0; i < size - 1; i++) {
                tmp.add(stack1.pop());
            }
            int pop = (int) stack1.pop();

            int tmpSize = tmp.size();
            for (int i = 0; i < tmpSize; i++) {
                stack1.add(tmp.pop());
            }
            return pop;
        }

        public int peek() {
            int size = stack1.size();
            for (int i = 0; i < size - 1; i++) {
                tmp.add(stack1.pop());
            }
            int peek = (int) stack1.peek();

            int tmpSize = tmp.size();
            for (int i = 0; i < tmpSize; i++) {
                stack1.add(tmp.pop());
            }
            return peek;
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}
