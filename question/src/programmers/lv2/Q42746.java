package programmers.lv2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Q42746 {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        //배열로 주어진 정수로 만들 수 있는 수 중 가장 큰 수 구하기
        //제귀로 dfs식으로 풀려면 1000*999*998... 말도 안되는 숫자 제귀로 푸는 건 아닌듯
        //3, 30, 31, 2, 5

        String result = Arrays.stream(numbers)
                .mapToObj(i -> String.valueOf(i))
                .sorted((i, j) -> (j + i).compareTo(i + j))
                .collect(Collectors.joining());

        if(Double.valueOf(result) == 0) result = "0";
        return result;

    }
}
