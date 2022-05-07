package leetCode.graph;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-height-trees/
 * #310. 最小高度树
 */
public class MinimumHeightTrees {
    static List<List<Integer>> edgeList;
    static HashSet<Integer> set;
    static int[][] dp;

    //region 超时算法
//    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        dp = new int[n][n];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp.length; j++) {
//                dp[i][j] = -1;
//            }
//        }
//        edgeList = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            edgeList.add(new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            edgeList.get(edge[0]).add(edge[1]);
//            edgeList.get(edge[1]).add(edge[0]);
//        }
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            int[] treeHighArr = new int[n];
//            int[][] dp = new int[n][n];
//            for (int j = 0; j < n; j++) {
//                set = new HashSet<>();
//                int dfs = dfs(i, i, j, 0);
//                treeHighArr[j] = dfs;
//                dp[i][j] = dfs;
//            }
//            int temp = 0;
//            for (int index = 0; index < treeHighArr.length; index++) {
//                if (treeHighArr[temp] < treeHighArr[index]) {
//                    temp = index;
//                }
//            }
//            arr[i] = treeHighArr[temp];
//        }
//        int temp = 0;
//        for (int i = 0; i < n; i++) {
//            if (arr[temp] > arr[i]) {
//                temp = i;
//            }
//        }
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (arr[i] == arr[temp]) {
//                result.add(i);
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 超时了
//     * @param index
//     * @param start
//     * @param aim
//     * @param step
//     * @return
//     */
//    public static int dfs(int index, int start, int aim, int step) {
//        if (dp[start][aim] != -1) {
//            return dp[start][aim];
//        }
//        set.add(index);
//        if (index == aim) {
//            return step;
//        }
//        for (Integer nextIndex : edgeList.get(index)) {
//            if (!set.contains(nextIndex)) {
//                int dfs = dfs(nextIndex, start, aim, ++step);
//                if (dfs == -1) {
//                    step--;
//                    continue;
//                } else {
//                    return dfs;
//                }
//            }
//        }
//        return -1;
//    }
    //endregion

    //region 拓扑排序思路
    static List<List<Integer>> map;
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1){
            res.add(0);
            return res;
        }
        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        int[] outArr = new int[n];
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            outArr[edge[0]]++;
            outArr[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < outArr.length; i++) {
            if (outArr[i] == 1){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                res.add(cur);
                for (Integer next : map.get(cur)) {
                    outArr[next]--;
                    if (outArr[next] == 1){
                        queue.add(next);
                    }
                }
            }
        }
        return res;
    }
    //endregion


    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
//        System.out.println(findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
//        System.out.println(findMinHeightTrees(315, new int[][]{
//                {0, 1}, {0, 2}, {2, 3}, {1, 4}, {2, 5}, {0, 6}, {2, 7}, {7, 8}, {2, 9}, {7, 10}, {6, 11}, {5, 12}, {6, 13}, {8, 14}, {3, 15}, {5, 16}, {15, 17}, {13, 18}, {16, 19}, {4, 20}, {1, 21}, {0, 22}, {18, 23}, {13, 24}, {8, 25}, {10, 26}, {17, 27}, {17, 28}, {26, 29}, {27, 30}, {13, 31}, {13, 32}, {21, 33}, {14, 34}, {12, 35}, {21, 36}, {28, 37}, {28, 38}, {16, 39}, {35, 40}, {23, 41}, {40, 42}, {39, 43}, {20, 44}, {1, 45}, {36, 46}, {43, 47}, {36, 48}, {47, 49}, {49, 50}, {0, 51}, {24, 52}, {20, 53}, {46, 54}, {23, 55}, {35, 56}, {43, 57}, {38, 58}, {38, 59}, {57, 60}, {39, 61}, {37, 62}, {52, 63}, {11, 64}, {54, 65}, {30, 66}, {24, 67}, {52, 68}, {58, 69}, {5, 70}, {17, 71}, {63, 72}, {40, 73}, {26, 74}, {20, 75}, {30, 76}, {45, 77}, {52, 78}, {46, 79}, {67, 80}, {3, 81}, {33, 82}, {12, 83}, {1, 84}, {82, 85}, {28, 86}, {65, 87}, {62, 88}, {66, 89}, {84, 90}, {86, 91}, {31, 92}, {80, 93}, {79, 94}, {48, 95}, {64, 96}, {7, 97}, {90, 98}, {30, 99}, {12, 100}, {33, 101}, {82, 102}, {28, 103}, {82, 104}, {88, 105}, {0, 106}, {42, 107}, {48, 108}, {50, 109}, {57, 110}, {2, 111}, {97, 112}, {16, 113}, {52, 114}, {60, 115}, {6, 116}, {26, 117}, {61, 118}, {32, 119}, {50, 120}, {65, 121}, {3, 122}, {113, 123}, {46, 124}, {7, 125}, {119, 126}, {82, 127}, {89, 128}, {101, 129}, {27, 130}, {104, 131}, {8, 132}, {19, 133}, {127, 134}, {38, 135}, {16, 136}, {16, 137}, {96, 138}, {8, 139}, {121, 140}, {110, 141}, {101, 142}, {51, 143}, {4, 144}, {131, 145}, {38, 146}, {44, 147}, {80, 148}, {95, 149}, {43, 150}, {113, 151}, {123, 152}, {50, 153}, {141, 154}, {88, 155}, {83, 156}, {42, 157}, {10, 158}, {102, 159}, {142, 160}, {14, 161}, {92, 162}, {13, 163}, {41, 164}, {73, 165}, {140, 166}, {90, 167}, {30, 168}, {68, 169}, {4, 170}, {100, 171}, {98, 172}, {0, 173}, {14, 174}, {15, 175}, {78, 176}, {91, 177}, {23, 178}, {23, 179}, {67, 180}, {54, 181}, {64, 182}, {172, 183}, {173, 184}, {159, 185}, {26, 186}, {93, 187}, {105, 188}, {60, 189}, {144, 190}, {133, 191}, {170, 192}, {163, 193}, {156, 194}, {116, 195}, {110, 196}, {103, 197}, {81, 198}, {79, 199}, {70, 200}, {133, 201}, {20, 202}, {12, 203}, {135, 204}, {201, 205}, {148, 206}, {132, 207}, {37, 208}, {19, 209}, {96, 210}, {151, 211}, {166, 212}, {142, 213}, {175, 214}, {134, 215}, {140, 216}, {176, 217}, {83, 218}, {120, 219}, {205, 220}, {157, 221}, {64, 222}, {93, 223}, {164, 224}, {82, 225}, {74, 226}, {215, 227}, {40, 228}, {109, 229}, {53, 230}, {68, 231}, {133, 232}, {49, 233}, {125, 234}, {230, 235}, {11, 236}, {134, 237}, {90, 238}, {107, 239}, {139, 240}, {139, 241}, {226, 242}, {77, 243}, {53, 244}, {79, 245}, {137, 246}, {200, 247}, {148, 248}, {212, 249}, {197, 250}, {230, 251}, {214, 252}, {190, 253}, {117, 254}, {22, 255}, {156, 256}, {143, 257}, {42, 258}, {48, 259}, {178, 260}, {109, 261}, {9, 262}, {65, 263}, {167, 264}, {246, 265}, {112, 266}, {11, 267}, {207, 268}, {34, 269}, {128, 270}, {186, 271}, {102, 272}, {88, 273}, {15, 274}, {169, 275}, {198, 276}, {260, 277}, {24, 278}, {198, 279}, {33, 280}, {121, 281}, {105, 282}, {93, 283}, {229, 284}, {24, 285}, {267, 286}, {21, 287}, {258, 288}, {142, 289}, {212, 290}, {84, 291}, {2, 292}, {50, 293}, {253, 294}, {114, 295}, {80, 296}, {36, 297}, {128, 298}, {2, 299}, {166, 300}, {279, 301}, {116, 302}, {144, 303}, {72, 304}, {256, 305}, {236, 306}, {29, 307}, {78, 308}, {258, 309}, {8, 310}, {15, 311}, {272, 312}, {14, 313}, {93, 314}
//        }));
    }
}
