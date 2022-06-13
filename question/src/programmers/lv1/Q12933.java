package programmers.lv1;

import java.util.Collections;
import java.util.stream.Collectors;

public class Q12933 {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        String num = String.valueOf(n);
        //첫 번째 풀이
        /*Optional<String> reduce = num.chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(eachNum -> (eachNum - '0') + "")
                .reduce((a, b) -> a + b);*/
        //두 번째 풀이
        /*String answerStr = num.chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(eachNum -> String.valueOf(eachNum-'0'))
                .reduce("", String::concat);*/

        //세 번재 풀이
        String answerStr = num.chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(eachNum -> String.valueOf(eachNum-'0'))
                .collect(Collectors.joining());

        return Long.parseLong(answerStr);


    }
}
