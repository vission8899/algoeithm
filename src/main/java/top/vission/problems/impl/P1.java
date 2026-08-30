package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.HashMap;

@Slf4j
public class P1 implements LeetCodeProblemRun {

    @Override
    public void run() {
        int[] nums = {1, 2, 5};
        twoSum2(nums, 3);
    }

    public int[] twoSum(int[] nums, int target) {
        log.info("TestCase:{},target:{}", nums, target);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        log.info("结果:{}", result);
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        log.info("TestCase:{},target:{}", nums, target);
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                result[1] = map.get(key);
                result[0] = i;
            }
            map.put(nums[i],i);
        }
        log.info("结果:{}", result);
        return result;
    }
}
