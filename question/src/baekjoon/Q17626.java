package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q17626 {
    static int[] memo = new int[50001];
    public static void main(String[] args) throws IOException {
        //자연수를 넷 혹은 그 이하의 제곱수 합으로 나타내

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Arrays.fill(memo, Integer.MAX_VALUE);
        //현재 수의 가장 가까운 제곱근을 구해
        //현재수 - 제곱근의 제곱을 반복하며 그 수가 0이 될 때 까지 시행
        //제곱근부터 시작해서 -1씩 for문으로 찾기
        int sqrt = (int)Math.sqrt(num);
        System.out.println(getPowerCnt(num, sqrt));
    }

    public static int getPowerCnt(int num, int sqrt){
        if(num == 0) return 0;

        if(memo[num] != Integer.MAX_VALUE) return memo[num];

        int pow;
        int result = Integer.MAX_VALUE;
        for(int i = sqrt ; i > 0 ; i--){
            pow = (int)Math.pow(i, 2);
            int tempNum = num - pow;

            memo[num] = Math.min(getPowerCnt(tempNum, (int)Math.sqrt(tempNum)) + 1, memo[num]);
        }
        return memo[num];
    }
}
