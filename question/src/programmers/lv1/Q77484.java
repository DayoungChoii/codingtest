package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;

public class Q77484 {
    public static void main(String[] args) {

        int[] solution = solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        long zeroCnt = Arrays.stream(lottos)
                .filter(i -> i == 0)
                .count();
        long matchCnt = Arrays.stream(lottos)
                .filter(i -> i != 0)
                .filter(i -> Arrays.stream(win_nums).anyMatch(j -> i == j))
                .count();

        setAnswer(answer, 0, (int)zeroCnt + (int)matchCnt);
        setAnswer(answer, 1, (int)matchCnt);


        return answer;
    }

    private static void setAnswer(int[] answer, int index, int sum) {
        HashMap<Integer, Integer> winRank = new HashMap<>();

        winRank.put(6, 1);
        winRank.put(5, 2);
        winRank.put(4, 3);
        winRank.put(3, 4);
        winRank.put(2, 5);

        if(winRank.containsKey(sum)){
            answer[index] = winRank.get(sum);
        } else{
            answer[index] = 6;
        }
    }
}
