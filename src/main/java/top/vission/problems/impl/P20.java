package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.Stack;


@Slf4j
public class P20 implements LeetCodeProblemRun {

    @Override
    public void run() {
        String request = "([])";
        log.info("request:{}", request);
        log.info("result:{}", isValid(request));
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(String.valueOf(c));
                continue;
            }

            if (String.valueOf(c).equals("]")) {
                String peek = stack.peek();
                if (peek.equals("[")) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }

            if (String.valueOf(c).equals("}")) {
                String peek = stack.peek();
                if (peek.equals("{")) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }

            if (String.valueOf(c).equals(")")) {
                String peek = stack.peek();
                if (peek.equals("(")) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }

            stack.push(String.valueOf(c));
        }

        return stack.isEmpty();

    }

}
