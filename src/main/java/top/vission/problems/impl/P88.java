package top.vission.problems.impl;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;


@Slf4j
public class P88 implements LeetCodeProblemRun {

    @Override
    public void run() {
        int[] nums1;
        int[] nums2;
        int m;
        int n;

//        case1
//        nums1 = new int[]{1,2,3,0,0,0};
//        nums2 = new int[]{2,5,6};
//        m=3;
//        n=3;

//        case2
//        nums1 = new int[]{0};
//        nums2 = new int[]{1};
//        m=0;
//        n=1;

//        case3
        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;

        merge(nums1, m, nums2, n);
        log.info("result:{}", nums1);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int cur;

        for (int i = m + n - 1; i >= 0; i--) {
            if (p1 < 0) {
                cur = nums2[p2--];
            } else if (p2 < 0) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[i] = cur;
        }
    }
}
