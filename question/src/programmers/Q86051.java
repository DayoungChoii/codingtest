package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q86051 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {5,8,4,0,6,7,9}));
    }

    public static int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        Arrays.stream(numbers)
                .forEach(num -> {
                    if(set.contains(num)){
                        set.remove(num);
                    }
                });

        int sum = set.stream()
                .mapToInt(i -> i).sum();
        return sum;
    }

}
