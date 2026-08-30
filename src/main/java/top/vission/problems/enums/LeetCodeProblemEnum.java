package top.vission.problems.enums;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum LeetCodeProblemEnum {
    P1("1", "两数之和", "Two Sum", "给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。\n" + "\n" + "你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。\n" + "\n" + "你可以按任意顺序返回答案。\n" + "\n" + " \n" + "\n" + "示例 1：\n" + "\n" + "输入：nums = [2,7,11,15], target = 9\n" + "输出：[0,1]\n" + "解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。\n" + "示例 2：\n" + "\n" + "输入：nums = [3,2,4], target = 6\n" + "输出：[1,2]\n" + "示例 3：\n" + "\n" + "输入：nums = [3,3], target = 6\n" + "输出：[0,1]\n" + " \n" + "\n" + "提示：\n" + "\n" + "2 <= nums.length <= 104\n" + "-109 <= nums[i] <= 109\n" + "-109 <= target <= 109\n" + "只会存在一个有效答案\n" + " \n" + "\n" + "进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？");

    private final String id;
    private final String name;
    private final String englishName;
    private final String description;

    LeetCodeProblemEnum(String id, String name, String englishName, String description) {
        this.id = id;
        this.name = name;
        this.englishName = englishName;
        this.description = description;
    }

    public static LeetCodeProblemEnum getById(String id) {
        for (LeetCodeProblemEnum problem : values()) {
            if (problem.id.equals(id)) {
                return problem;
            }
        }
        throw new IllegalArgumentException("未找到题目：" + id);
    }
}
