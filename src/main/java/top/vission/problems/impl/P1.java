package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

@Slf4j
public class P1 implements LeetCodeProblemRun {

    @Override
    public void run() {
        int[] nums = {1, 2, 5};
        twoSum(nums, 3);
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
}
