package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

@Slf4j
public class P125 implements LeetCodeProblemRun {

    @Override
    public void run() {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        log.info("result:{}", palindrome);
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        log.info("Str is {}", s);
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int p1 = length - 1;
        for (int i = 0; i < length; i++) {
            if (i >= p1) {
                return true;
            }

            if (charArray[i] != charArray[p1]) {
                return false;
            }
            p1--;
        }
        return true;
    }
}
