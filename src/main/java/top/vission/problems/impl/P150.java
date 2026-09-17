package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.Stack;


@Slf4j
public class P150 implements LeetCodeProblemRun {

    @Override
    public void run() {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        log.info("request:{}", tokens.toString());
        int result = evalRPN(tokens);
        log.info("result:{}", result);
    }

    public int evalRPN(String[] tokens) {
        int length = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    if ("+".equals(token)) {
                        stack.add(var2 + var1);
                    } else if ("-".equals(token)) {
                        stack.add(var2 - var1);
                    } else if ("*".equals(token)) {
                        stack.add(var2 * var1);
                    } else if ("/".equals(token)) {
                        stack.add(var2 / var1);
                    }
                    continue;
            }
            stack.add(Integer.valueOf(token));
        }
        return stack.pop();

    }

}
