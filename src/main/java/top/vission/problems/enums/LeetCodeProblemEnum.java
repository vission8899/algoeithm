package top.vission.problems.enums;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum LeetCodeProblemEnum {
    P1("1", "两数之和", "Two Sum", "给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。\n" + "\n" + "你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。\n" + "\n" + "你可以按任意顺序返回答案。\n" + "\n" + " \n" + "\n" + "示例 1：\n" + "\n" + "输入：nums = [2,7,11,15], target = 9\n" + "输出：[0,1]\n" + "解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。\n" + "示例 2：\n" + "\n" + "输入：nums = [3,2,4], target = 6\n" + "输出：[1,2]\n" + "示例 3：\n" + "\n" + "输入：nums = [3,3], target = 6\n" + "输出：[0,1]\n" + " \n" + "\n" + "提示：\n" + "\n" + "2 <= nums.length <= 104\n" + "-109 <= nums[i] <= 109\n" + "-109 <= target <= 109\n" + "只会存在一个有效答案\n" + " \n" + "\n" + "进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？"),
    P26("26", "删除有序数组中的重复项", "Remove Duplicates From Sorted Array", "给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。\n" + "\n" + "考虑 nums 的唯一元素的数量为 k。去重后，返回唯一元素的数量 k。\n" + "\n" + "nums 的前 k 个元素应包含 排序后 的唯一数字。下标 k - 1 之后的剩余元素可以忽略。\n" + "\n" + "判题标准:\n" + "\n" + "系统会用下面的代码来测试你的题解:\n" + "\n" + "int[] nums = [...]; // 输入数组\n" + "int[] expectedNums = [...]; // 长度正确的期望答案\n" + "\n" + "int k = removeDuplicates(nums); // 调用\n" + "\n" + "assert k == expectedNums.length;\n" + "for (int i = 0; i < k; i++) {\n" + "    assert nums[i] == expectedNums[i];\n" + "}\n" + "如果所有断言都通过，那么您的题解将被 通过。\n" + "\n" + " \n" + "\n" + "示例 1：\n" + "\n" + "输入：nums = [1,1,2]\n" + "输出：2, nums = [1,2,_]\n" + "解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。\n" + "示例 2：\n" + "\n" + "输入：nums = [0,0,1,1,1,2,2,3,3,4]\n" + "输出：5, nums = [0,1,2,3,4,_,_,_,_,_]\n" + "解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。\n" + " \n" + "\n" + "提示：\n" + "\n" + "1 <= nums.length <= 3 * 104\n" + "-100 <= nums[i] <= 100\n" + "nums 已按 非递减 顺序排列。");

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
