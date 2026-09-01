package top.vission.problems.enums;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum LeetCodeProblemEnum {
    P1("1", "两数之和", "Two Sum", "给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。\n" + "\n" + "你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。\n" + "\n" + "你可以按任意顺序返回答案。\n" + "\n" + " \n" + "\n" + "示例 1：\n" + "\n" + "输入：nums = [2,7,11,15], target = 9\n" + "输出：[0,1]\n" + "解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。\n" + "示例 2：\n" + "\n" + "输入：nums = [3,2,4], target = 6\n" + "输出：[1,2]\n" + "示例 3：\n" + "\n" + "输入：nums = [3,3], target = 6\n" + "输出：[0,1]\n" + " \n" + "\n" + "提示：\n" + "\n" + "2 <= nums.length <= 104\n" + "-109 <= nums[i] <= 109\n" + "-109 <= target <= 109\n" + "只会存在一个有效答案\n" + " \n" + "\n" + "进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？"),
    P26("26", "删除有序数组中的重复项", "Remove Duplicates From Sorted Array", "给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。\n" + "\n" + "考虑 nums 的唯一元素的数量为 k。去重后，返回唯一元素的数量 k。\n" + "\n" + "nums 的前 k 个元素应包含 排序后 的唯一数字。下标 k - 1 之后的剩余元素可以忽略。\n" + "\n" + "判题标准:\n" + "\n" + "系统会用下面的代码来测试你的题解:\n" + "\n" + "int[] nums = [...]; // 输入数组\n" + "int[] expectedNums = [...]; // 长度正确的期望答案\n" + "\n" + "int k = removeDuplicates(nums); // 调用\n" + "\n" + "assert k == expectedNums.length;\n" + "for (int i = 0; i < k; i++) {\n" + "    assert nums[i] == expectedNums[i];\n" + "}\n" + "如果所有断言都通过，那么您的题解将被 通过。\n" + "\n" + " \n" + "\n" + "示例 1：\n" + "\n" + "输入：nums = [1,1,2]\n" + "输出：2, nums = [1,2,_]\n" + "解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。\n" + "示例 2：\n" + "\n" + "输入：nums = [0,0,1,1,1,2,2,3,3,4]\n" + "输出：5, nums = [0,1,2,3,4,_,_,_,_,_]\n" + "解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。\n" + " \n" + "\n" + "提示：\n" + "\n" + "1 <= nums.length <= 3 * 104\n" + "-100 <= nums[i] <= 100\n" + "nums 已按 非递减 顺序排列。"),
    P88("88", "合并两个有序数组", "Merge Sorted Array", "给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。\n" + "\n" + "请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。\n" + "\n" + "注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。\n" + "\n" + " \n" + "\n" + "示例 1：\n" + "\n" + "输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3\n" + "输出：[1,2,2,3,5,6]\n" + "解释：需要合并 [1,2,3] 和 [2,5,6] 。\n" + "合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。\n" + "示例 2：\n" + "\n" + "输入：nums1 = [1], m = 1, nums2 = [], n = 0\n" + "输出：[1]\n" + "解释：需要合并 [1] 和 [] 。\n" + "合并结果是 [1] 。\n" + "示例 3：\n" + "\n" + "输入：nums1 = [0], m = 0, nums2 = [1], n = 1\n" + "输出：[1]\n" + "解释：需要合并的数组是 [] 和 [1] 。\n" + "合并结果是 [1] 。\n" + "注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。\n" + " \n" + "\n" + "提示：\n" + "\n" + "nums1.length == m + n\n" + "nums2.length == n\n" + "0 <= m, n <= 200\n" + "1 <= m + n <= 200\n" + "-109 <= nums1[i], nums2[j] <= 109\n" + " \n" + "\n" + "进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？"),
    P344("344", "反转字符串", "Reverse String", "编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。\n" + "\n" + "不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。\n" + "\n" + " \n" + "\n" + "示例 1：\n" + "\n" + "输入：s = [\"h\",\"e\",\"l\",\"l\",\"o\"]\n" + "输出：[\"o\",\"l\",\"l\",\"e\",\"h\"]\n" + "示例 2：\n" + "\n" + "输入：s = [\"H\",\"a\",\"n\",\"n\",\"a\",\"h\"]\n" + "输出：[\"h\",\"a\",\"n\",\"n\",\"a\",\"H\"]\n" + " \n" + "\n" + "提示：\n" + "\n" + "1 <= s.length <= 105\n" + "s[i] 都是 ASCII 码表中的可打印字符");

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
