package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;


@Slf4j
public class P344 implements LeetCodeProblemRun {

    @Override
    public void run() {
        char[] charArray = "逼傻大".toCharArray();
        reverseString(charArray);
        log.info("result:{}",charArray);
    }

    public void reverseString(char[] s) {
        int p1 = s.length - 1;
        char tmp;
        for (int i = 0; i < s.length; i++) {
            if (p1 <= i) {
                break;
            }

            tmp = s[i];
            s[i] = s[p1];
            s[p1--] = tmp;

        }
    }
}
