package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class P54 implements LeetCodeProblemRun {

    @Override
    public void run() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        log.info("result:{}", spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        List<Integer> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        //0->右 1->下 2->左 3->上 0->1->2->3->0
        int directions = 0;
        list.add(matrix[0][0]);
        while (true) {
            if (list.size() == m * n) {
                break;
            }
            if (directions == 0) {
                for (int i = p2; i <= right; i++) {
                    if (p2 == right) {
                        directions = 1;
                        top++;
                        continue;
                    } else {
                        p2++;
                    }
                    list.add(matrix[p1][p2]);
                }
                continue;
            }

            if (directions == 1) {
                for (int i = p1; i <= bottom; i++) {
                    if (p1 == bottom) {
                        directions = 2;
                        right--;
                        continue;
                    }
                    p1++;
                    list.add(matrix[p1][p2]);
                }
                continue;
            }
            if (directions == 2) {
                for (int i = p2; i >= left; i--) {
                    if (p2 == left) {
                        directions = 3;
                        bottom--;
                        continue;
                    } else {
                        p2--;
                    }
                    list.add(matrix[p1][p2]);
                }
                continue;
            }
            if (directions == 3) {
                for (int i = p1; i >= top; i--) {
                    if (p1 == top) {
                        directions = 0;
                        left++;
                        continue;
                    } else {
                        p1--;
                    }
                    list.add(matrix[p1][p2]);
                }
                continue;
            }
        }
        return list;
    }
}
