package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class P622 implements LeetCodeProblemRun {

    @Override
    public void run() {
//        log.info("request:{}");
//        log.info("result:{}");

//        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
//        myCircularQueue.enQueue(1);
//        myCircularQueue.enQueue(2);
//        myCircularQueue.enQueue(3);
//        myCircularQueue.enQueue(4);
//        log.info("result:{}", myCircularQueue.Rear());
//        log.info("result:{}", myCircularQueue.isFull());
//        log.info("result:{}", myCircularQueue.Rear());
//        myCircularQueue.enQueue(4);

        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(2);
        log.info("result:{}", myCircularQueue.Rear());
        log.info("result:{}", myCircularQueue.Front());
        myCircularQueue.deQueue();
        log.info("result:{}", myCircularQueue.Front());
        myCircularQueue.deQueue();
        log.info("result:{}", myCircularQueue.Front());
        myCircularQueue.enQueue(4);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);



    }

    class MyCircularQueue {
        Object[] list;
        int in = 0;
        int out = 0;
        int size;

        public MyCircularQueue(int k) {
            list = new Object[k];
            size = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            list[in] = value;
            in++;
            in = in % size;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            list[out] = null;
            out++;
            out = out % size;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            int tmp = out;
            return (int) list[tmp];

        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            int tmp = in;
            tmp = (size + tmp - 1) % size;

            return (int) list[tmp];
        }

        public boolean isEmpty() {
            return list[out] == null;

        }

        public boolean isFull() {
            return list[in] != null;
        }
    }

}
