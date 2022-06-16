package programmers.lv1;

public class Q12931 {
    public static void main(String[] args) {
        System.out.println(solution(123));
    }

    public static int solution(int n) {
        return String.valueOf(n).chars()
                .map(i -> i - '0')
                .sum();
    }
}
