package leetcode;

import java.util.Arrays;

public class Q91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
    }

    public static int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0, memo);
    }

    //입력은 11106 이런식으로 들어옴
   public static int dp(String s, int index, int[] memo){

       if(index >= s.length()){
           return 1;
       }

       if(memo[index] != -1){
           return memo[index];
       }

        //for문 2번 돌면서 1, 2 더해서 자릿수 옮겨
       int result = 0;
       for (int i = 1; i <= 2; i++) {
           if(index + i < s.length() + 1) {
               String digitNumStr = s.substring(index, index + i);
               if (isDigitNumCorrect(digitNumStr)) {
                   result += dp(s, index + i, memo);
               }
           }
        }
       memo[index] = result;
       return result;
    }

    private static boolean isDigitNumCorrect(String digitNumStr) {
        int digitNum = Integer.parseInt(digitNumStr);
        if(digitNumStr.charAt(0) == '0') return false;
        if(digitNum >0 && digitNum <27) return true;
        return false;
    }
}
