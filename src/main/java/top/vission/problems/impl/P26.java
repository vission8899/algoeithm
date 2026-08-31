package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.Arrays;

@Slf4j
public class P26 implements LeetCodeProblemRun {

    @Override
    public void run() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        log.info("测试case:{}", nums);
        int k = removeDuplicates(nums);
        log.info("k={},去重后前k个元素:{}", k, Arrays.copyOf(nums, k));
    }

    // 快慢双指针:k 指向已去重区间的下一个位置,数组有序,nums[i] != nums[k-1] 即新元素
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
