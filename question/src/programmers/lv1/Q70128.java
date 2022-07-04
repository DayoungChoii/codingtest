package programmers.lv1;

public class Q70128 {
    public static void main(String[] args) {
    }

    public static int solution(int[] a, int[] b) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }

        return sum;
    }
}
