package programmers.lv1;

import java.util.Arrays;

public class Q12982 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,2,3,3}, 10));
    }

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);

        int sum = 0;
        int i;
        for (i = 0; i < d.length; i++) {
            sum += d[i];
            if(sum > budget) break;
        }

        return i;
    }
}
