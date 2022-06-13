package programmers.lv1;

import java.util.Arrays;

public class Q42862 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1,3,5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] resultArr = new int[n];
        Arrays.fill(resultArr, 1);
        for(int i = 0 ; i < lost.length ; i++){
                resultArr[lost[i]-1]--;

        }

        for(int i = 0; i < reserve.length ;i++){
            resultArr[reserve[i]-1]++;
        }

        //배열 맨 앞, 맨 뒤 체크
        if(resultArr[0] == 0 && resultArr[1] == 2){
            resultArr[0] = 1;
            resultArr[1] = 1;
        }

        if(resultArr[n-1] == 0 && resultArr[n-2] == 2){
            resultArr[n-1] = 1;
            resultArr[n-2] = 1;
        }

        for (int i = 1; i < n-1; i++) {
            if(resultArr[i] == 0 && resultArr[i-1] ==2){
                resultArr[i] = 1;
                resultArr[i-1] =1;
            } else if(resultArr[i] == 0 && resultArr[i+1] ==2){
                resultArr[i] = 1;
                resultArr[i+1] = 1;
            }
        }

        long count = Arrays.stream(resultArr)
                .filter(i -> i >= 1)
                .count();
        return (int)count;
    }
}
