package programmers.lv1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Q76501 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,7,12}, new boolean[]{true,false,true}));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        AtomicInteger index = new AtomicInteger();

        return Arrays.stream(absolutes)
                .map(num -> signs[index.getAndIncrement()]? num : -num)
                .sum();
    }
}
