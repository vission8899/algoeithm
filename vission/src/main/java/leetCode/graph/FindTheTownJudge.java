package leetCode.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-the-town-judge/
 * #997 找到小镇法官
 */
public class FindTheTownJudge {
    //创建Node对象
    static class Node {
        public int value;
        public int out;
        public int in;
        public Node(int value){
            this.value = value;
            this.out = 0;
            this.in = 0;
        }
    }
    public static int findJudge(int n, int[][] trust) {
        Map<Integer,Node> map = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            int from = trust[i][0];
            int to = trust[i][1];
            if(!map.containsKey(to)){
                map.put(to,new Node(to));
            }
            if(!map.containsKey(from)){
                map.put(from,new Node(from));
            }
            map.get(from).out++;
            map.get(to).in++;
        }
        for (int i = 1; i <= n; i++) {
            if(map.getOrDefault(i,new Node(i)).out == 0&&map.getOrDefault(i,new Node(i)).in == n-1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 单数组版
     * @param n
     * @param trust
     * @return
     */
    public static int findJudgeByArr(int n, int[][] trust) {
        int[] trusted  = new int[n];
        for (int[] arr: trust)  {
            trusted[arr[0]-1]--;
            trusted[arr[1]-1]++;
        }
        for (int i = 0; i < trusted.length; i++) {
            if(trusted[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = {};
//        int[][] trust = {{1,2}};
//        int[][] trust = {{1,2},{2,3}};
        System.out.println(findJudgeByArr(2,trust));
//        System.out.println(findJudge(2,trust));
    }
}
