package programmers;

import java.util.Arrays;

public class Q42748 {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4,4,1},{1,7,3}};
        int[] solution = solution(array, commands);
        System.out.println("solution = " + solution.toString());
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int answerIndex = 0;
        for (int n = 0; n < commands.length ; n++) {
            int i = commands[n][0] -1;
            int j = commands[n][1] -1;
            int k = commands[n][2] -1;

            int[] tempArr = new int[j - i + 1];
            for(int m = 0 ; m < j-i+1 ; m++){
                tempArr[m] = array[i + m];
            }
            Arrays.sort(tempArr);

            answer[answerIndex++] = tempArr[k];

        }

        return answer;
    }
}
