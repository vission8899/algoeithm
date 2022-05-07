package leetCode.binarySearch;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 * # 278. 第一个错误的版本
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return binarySearch(0,n-1);
    }

    public int binarySearch(int sr,int sc){
        if (!isBadVersion(sc)){
            return sc;
        }
        int mid = (sc-sr)/2 + sr ;
        if (isBadVersion(mid)){
            return binarySearch(0,mid-1);
        }else {
            return binarySearch(mid +1 ,sc);
        }
    }

    boolean isBadVersion(int version){
        boolean[] booleans = new boolean[]{false, false, false, true, true};
        return booleans[version-1];
    }
}
