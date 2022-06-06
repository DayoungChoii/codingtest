package programmers.lv1;

import java.util.*;
import java.util.stream.IntStream;

public class Q12940 {
    public static void main(String[] args) {
        System.out.println(solution(3, 12));
    }

    public static int[] solution(int n, int m) {
        int big;
        int small;

        if(n > m){
            big = n;
            small = m;
        } else{
            big = m;
            small = n;
        }

        int[] bigArr = IntStream.rangeClosed(1, big)
                .filter(b -> big % b == 0)
                .toArray();

        OptionalInt first = IntStream.rangeClosed(1, small)
                .filter(s -> small % s == 0)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(i -> i)
                .filter(s -> Arrays.stream(bigArr)
                        .anyMatch(b -> b % s == 0))
                .findFirst();

        OptionalInt first1 = IntStream.iterate(small, i -> i + small)
                .limit(1000)
                .filter(s -> IntStream.iterate(big, i -> i + big)
                        .limit(1000)
                        .anyMatch(b -> b == s))
                .findFirst();

        int lcm = first.getAsInt();
        int gcd = first1.getAsInt();

        return new int[]{lcm, gcd};
    }
}
