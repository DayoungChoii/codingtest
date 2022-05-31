package programmers;

import java.util.stream.IntStream;

public class Q12928 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n) {
         return IntStream.range(1, n+1)
                .filter(num -> n % num == 0)
                .sum();
    }
}
