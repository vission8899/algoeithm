package top.vission.problems.enums;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum LeetCodeProblemEnum {
    P1("1", "两数之和", "Two Sum"),
    P26("26", "删除有序数组中的重复项", "Remove Duplicates From Sorted Array"),
    P48("48", "旋转图像", "Rotate Image"),
    P54("54", "螺旋矩阵", "Spiral Matrix"),
    P88("88", "合并两个有序数组", "Merge Sorted Array"),
    P125("125", "验证回文串", "Valid Palindrome"),
    P242("242", "有效的字母异位词", "Valid Anagram"),
    P344("344", "反转字符串", "Reverse String");

    private final String id;
    private final String name;
    private final String englishName;

    LeetCodeProblemEnum(String id, String name, String englishName) {
        this.id = id;
        this.name = name;
        this.englishName = englishName;
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
