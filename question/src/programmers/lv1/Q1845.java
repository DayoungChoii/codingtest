package programmers.lv1;

import java.util.Arrays;

public class Q1845 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
    }

    public static int solution(int[] nums) {
        long count = Arrays.stream(nums)
                .distinct()
                .count();

        return count >= nums.length/2 ? nums.length/2 : (int)count;

    }
}
