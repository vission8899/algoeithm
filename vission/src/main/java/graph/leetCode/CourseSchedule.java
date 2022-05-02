package graph.leetCode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 * #207. 课程表
 *
 * https://leetcode-cn.com/tag/graph/problemset/
 * #210. 课程表 II
 */
public class CourseSchedule {
    /**
     * 课程表
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //记录出度
        int[][] nodes = new int[numCourses][numCourses];
        int[] inArr = new int[numCourses];
        for (int[] node : prerequisites) {
            nodes[node[1]][node[0]]++;
            inArr[node[0]]++;
        }
        HashSet<Integer> polled = new HashSet<>();
        Queue<Integer> zeroQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inArr[i] == 0) {
                zeroQueue.add(i);
                polled.add(i);
            }
        }
        int result = 0;
        while (!zeroQueue.isEmpty()) {
            Integer cur = zeroQueue.poll();
            polled.add(cur);
            result++;
            for (int j = 0; j < numCourses; j++) {
                if (nodes[cur][j] == 1 && cur != j) {
                    inArr[j]--;
                }
                nodes[cur][j] = 0;
                if (inArr[j] == 0 && !polled.contains(j)) {
                    zeroQueue.add(j);
                    polled.add(j);
                }
            }
        }

        return result == numCourses;
    }

    /**
     * 课程表 II
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //记录出度
        int[][] nodes = new int[numCourses][numCourses];
        int[] inArr = new int[numCourses];
        for (int[] node : prerequisites) {
            nodes[node[1]][node[0]]++;
            inArr[node[0]]++;
        }
        HashSet<Integer> polled = new HashSet<>();
        Queue<Integer> zeroQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inArr[i] == 0) {
                zeroQueue.add(i);
                polled.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!zeroQueue.isEmpty()) {
            Integer cur = zeroQueue.poll();
            polled.add(cur);
            result.add(cur);
            for (int j = 0; j < numCourses; j++) {
                if (nodes[cur][j] == 1 && cur != j) {
                    inArr[j]--;
                }
                nodes[cur][j] = 0;
                if (inArr[j] == 0 && !polled.contains(j)) {
                    zeroQueue.add(j);
                    polled.add(j);
                }
            }
        }
        if (result.size()==numCourses){
            int[] resultArr = new int[numCourses];
            for (int i = 0; i < result.size(); i++) {
                resultArr[i] = result.get(i);
            }
            return resultArr;
        }
        return new int[0];
    }

    public static void main(String[] args) {
//        canFinish(2,new int[][]{{1,0}});
//        canFinish(2,new int[][]{{1,0},{0,1}});
//        canFinish(3,new int[][]{{1,0},{0,2},{2,1}});
//        canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}});
//        canFinish(20,new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}});
//        canFinish(1,new int[][]{{0,0}});
//        canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
        findOrder(2,new int[][]{{1,0},{0,1}});
    }
}
