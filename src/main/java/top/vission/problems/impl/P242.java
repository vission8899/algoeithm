package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.HashMap;


@Slf4j
public class P242 implements LeetCodeProblemRun {

    @Override
    public void run() {
        String s = "aa";
        String t = "bb";
        log.info("case,s:{},t:{}", s, t);
        log.info("result:{}", isAnagram(s, t));
    }


    public boolean isAnagram(String s, String t) {
        HashMap<String, Integer> map = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        if (sCharArray.length - tCharArray.length != 0) {
            return false;
        }

        for (int i = 0; i < sCharArray.length; i++) {
            char sChar = sCharArray[i];
            char tChar = tCharArray[i];
            Integer sCharValue = map.getOrDefault(String.valueOf(sChar), 0);
            sCharValue = sCharValue + 1;
            map.put(String.valueOf(sChar), sCharValue);

            Integer tCharValue = map.getOrDefault(String.valueOf(tChar), 0);
            tCharValue = tCharValue - 1;
            map.put(String.valueOf(tChar), tCharValue);
        }

        for (String string : map.keySet()) {
            if (map.get(string) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 不用hashMap，用char-'a',数组下标偏移量表示字母
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        if (sCharArray.length - tCharArray.length != 0) {
            return false;
        }

        int[] ints = new int[26];

        for (int i = 0; i < sCharArray.length; i++) {
            ints[sCharArray[i] - 'a']++;
            ints[tCharArray[i] - 'a']--;
        }

        for (int anInt : ints) {
            if (anInt > 0) {
                return false;
            }
        }
        return true;
    }
}
