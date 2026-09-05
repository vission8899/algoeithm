package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;


@Slf4j
public class P48 implements LeetCodeProblemRun {

    @Override
    public void run() {
//        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};


        log.info("request:");
        for (int i = 0; i < matrix.length; i++) {
            log.info("{}", matrix[i]);
        }

        rotate(matrix);

        log.info("result:");
        for (int i = 0; i < matrix.length; i++) {
            log.info("{}", matrix[i]);
        }


    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[] tmp = new int[4];
//        计算圈数
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                tmp[0] = matrix[i][j];
                tmp[1] = matrix[j][n - 1 - i];
                tmp[2] = matrix[n - 1 - i][n - 1 - j];
                tmp[3] = matrix[n - 1 - j][i];

                matrix[i][j] = tmp[3];
                matrix[j][n - 1 - i] = tmp[0];
                matrix[n - 1 - i][n - 1 - j] = tmp[1];
                matrix[n - 1 - j][i] = tmp[2];
            }
        }
    }
}
