package programmers.lv1;

public class Q82612 {
    public static void main(String[] args) {
        System.out.println(solution(2500, 1000000000, 2500));
    }

    public static long solution(long price, long money, long count) {
        long totalPrice = price * count * (1 + count) / 2;
        return money - totalPrice < 0 ? totalPrice - money : 0;
    }

}
