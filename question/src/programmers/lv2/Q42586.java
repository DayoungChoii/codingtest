package programmers.lv2;

import java.util.ArrayList;

public class Q42586 {
    public static void main(String[] args) {
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        int[] solution = solution(progresses, speeds);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        //각 기능은 진도가 100%일 때 서비스 가능
        //뒤에 있는 기능이 앞에 있는 기능 보다 먼저 개발 가능, 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 배포됨
        ArrayList<Integer> answerList = new ArrayList<>();

        int index, cnt;
        index = 0;
        for (int i = 0; i < 100; i++) {
            // 프로그레스 크기 만큼 돌며 index필요, cnt 필요, i*speed 계산하여 answer찾아내기
            cnt = 0;
            for (int j = 0; j < progresses.length; j++) {
                if(j >= index
                    && progresses[index] + speeds[index] * i >= 100
                    && progresses[j] + speeds[j] * i >= 100){
                    cnt++;
                    index++;
                }
            }
            if(cnt > 0){
                answerList.add(cnt);
            }

        }

        return answerList.stream()
                        .mapToInt(i -> i)
                        .toArray();
    }
}
