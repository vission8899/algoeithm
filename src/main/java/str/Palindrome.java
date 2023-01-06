package str;

/**
 * 回文
 */
public class Palindrome {


    /**
     * 返回字符串的最长回文子串  暴力解法
     *
     * @param str 字符串
     * @return 最长回文子串
     */
    public static Integer longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int length = str.length();
        int max = Integer.MIN_VALUE;
        char[] strChars = str.toCharArray();
        for (int i = 1; i <= length; i++) {
            int index = i - 1;
            int pR = 0;
            while (true) {
                int right = index + pR;
                int left = index - pR;
                if (left < 0 || right >= length) {
                    break;
                } else if (strChars[right] == strChars[left]) {
                    pR++;
                } else {
                    break;
                }
            }
            max = Math.max(max, pR * 2 - 1);
        }
        return max;
    }

    private static char[] transformManacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];//i & 1 二进制末 做&运算判断奇偶
        }
        return res;
    }

    /**
     * 返回字符串的最长回文子串  manacher
     *
     * @param str 字符串
     * @return 最长回文子串
     */
    public static int manacher(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] strChars = Palindrome.transformManacherString(str);
        int length = strChars.length;
        int[] pArr = new int[length]; //回文半径 010 1的回文半径为2
        int pR = -1;
        int pC = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            int index = i - 1;
            int indexShadow = 2 * pC - 1; //index'  pC-(index -pC) = 2*pC-index
            pArr[index] = index < pR ? Math.min(pArr[indexShadow], pR - index) : 1;
            while (true) {
                int left = index - pArr[index];
                int right = index + pArr[index];
                if (left < 0 || right >= length) {
                    break;
                } else if (strChars[left] == strChars[right]) {
                    pArr[index]++;
                } else {
                    break;
                }
            }
            if (pR < index + pArr[index]) {
                pR = index + pArr[index];
                pC = index;
            }
            max = Math.max(pArr[index], max);
        }
        return max - 1;
    }


    public static void main(String[] args) {
        String str = "abcQabcPcbaQcba";
        System.out.println(Palindrome.longestPalindrome(str));
        int manacher = Palindrome.manacher(str);
        System.out.println(manacher);
    }
}
