package programmers;

import java.util.*;

public class Q42889 {

    public static void main(String[] args) {
        solution(4, new int[] {4,4,4,4,4});
    }

    public static int[] solution(int N, int[] stages) {
        Map<Integer, StageInfo> stageInfoMap = new LinkedHashMap<>();

        for(int i = 1; i <= N+1; i++){
            stageInfoMap.put(i, new StageInfo(i,0));
        }

        for (int i = 0; i < stages.length; i++) {
            StageInfo stageInfo = stageInfoMap.get(stages[i]);
            stageInfo.stayCnt++;
        }

        float bottom = stages.length;
        float up = 0;
        List<StageInfo> stageList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            StageInfo stageInfo = stageInfoMap.get(i);
            up = stageInfo.stayCnt;

            if(bottom == 0){
                stageInfo.failRate = 0;
            } else{
                stageInfo.failRate = up / bottom;
            }

            bottom -= up;

            stageList.add(stageInfo);
        }

        int[] answer = stageList.stream()
                .sorted((stageInfo1, stageInfo2) -> {
                    if (stageInfo1.failRate - stageInfo2.failRate > 0) {
                        return -1;
                    } else if (stageInfo1.failRate - stageInfo2.failRate == 0) {
                        if (stageInfo1.stage - stageInfo2.stage > 0) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else {
                        return 1;
                    }
                }).mapToInt(stageInfo -> stageInfo.stage)
                .toArray();

        return answer;
    }

    public static class StageInfo{
        int stage = 0;
        int stayCnt = 0;
        float failRate = 0;

        public StageInfo(int stage, int stayCnt) {
            this.stayCnt = stayCnt;
            this.stage = stage;
        }
    }
}
