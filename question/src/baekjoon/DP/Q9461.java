package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q9461 {
    static Long[] memo = new Long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n;

        Arrays.fill(memo, 0L);

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }

    public static Long dp(int n){
        //탈출조건
        if(n>=1 && n<=3){
            return 1L;
        }
        if(n>=4 && n<=5){
            return 2L;
        }

        //이미 계산된 값인지 체크
        if(memo[n] > 0L) return memo[n];

        //점화식
        return memo[n] = dp(n - 1) + dp(n - 5);
    }
}
