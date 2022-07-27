package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1904 {
    static Long[] memo = new Long[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        n = Integer.parseInt(br.readLine());
        System.out.println(dpBottomUp(n));

    }

    public static Long dpBottomUp(int n) {
        memo[1] = 1L;
        memo[2] = 2L;

        for(int i = 3;i<=n;i++){
            memo[i] = (memo[i-2] + memo[i-1]) % 15746;
        }

        return memo[n];
    }

     public static Long dp(int n) {
         //탈출조건
         if (n == 1) {
             return 1L;
         }
         if (n == 2) {
             return 2L;
         }

        //메모에 있는지 확인
        if(memo[n]>0L) {
            return memo[n];
        }

        //점화식
         return memo[n] = (dp(n - 1) + dp(n - 2)) % 15746;
     }
}
