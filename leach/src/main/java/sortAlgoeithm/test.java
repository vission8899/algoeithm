package sortAlgoeithm;

import java.util.*;

/**
 * @description 归并排序
 * @author  weicheng.lu
 * @date   2022/3/13 5:07 PM
*/
public class test {
    public static void main(String[] args) {
//        int[] arr = SortUtils.getArr(5);
//        int flag = 0;
//        for (int i = 0; i < 3; i++) {
//            flag = flag +i;
//            System.out.println(flag);
//        }
        int[][] x= {{0,1},{1,2},{2,0}};
        System.out.println(validPath(3,x,0,2));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination){
            return true;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> hashSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        hashSet.add(source);
        queue.add(source);
        while (!queue.isEmpty()){
            int x = queue.poll();
            if (x == destination){
                return true;
            }
            for (Integer integer : map.get(x)){
                if (!hashSet.contains(integer)){
                    hashSet.add(integer);
                    queue.add(integer);
                }
            }
        }
        return false;
    }

    public int numWays(int n, int[][] relation, int k) {
        int [][]dp=new int [k+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<k;i++){
            for(int [] line:relation){
                int source=line[0];
                int destination=line[1];
                dp[i+1][destination]+=dp[i][source];
            }
        }
        return dp[k][n-1];
    }
}
