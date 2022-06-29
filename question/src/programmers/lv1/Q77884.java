package programmers.lv1;

public class Q77884 {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }

    public static int solution(int left, int right) {

        int sum = 0;
        for (int i = left; i <= right; i++) {
            if(isCntEven(i)){
                sum += i;
            } else{
                sum -= i;
            }
        }
        return sum;
    }

    private static boolean isCntEven(int num) {
        int cnt = 0;
        for (int i = 1; i <= num ; i++) {
            if(num % i == 0) cnt++;
        }

        return cnt % 2 == 0 ? true : false;
    }
}
