package programmers.lv1;

import java.util.Arrays;
import java.util.HashSet;

public class Q68644 {
    public static void main(String[] args) {
        solution(new int[] {5,0,2,7});
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                resultSet.add(numbers[i] + numbers[j]);
            }
        }

        answer = resultSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(answer);

        return answer;
    }
}
