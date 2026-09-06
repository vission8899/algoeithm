package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

@Slf4j
public class P73 implements LeetCodeProblemRun {

    @Override
    public void run() {
//        {{1,1,1},{1,0,1},{1,1,1}}
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        log.info("request:");
        for (int i = 0; i < matrix.length; i++) {
            log.info("{}", matrix[i]);
        }

        setZeroes(matrix);

        log.info("result:");
        for (int i = 0; i < matrix.length; i++) {
            log.info("{}", matrix[i]);
        }

    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] flagArray = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    flagArray[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flagArray[i][j] != 1) {
                    continue;
                }

//                列
                for (int k = 0; k < m; k++) {
                    matrix[k][j] = 0;
                }
//                行
                for (int k = 0; k < n; k++) {
                    matrix[i][k] = 0;
                }
            }
        }

    }

    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = column[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }


    }

}
