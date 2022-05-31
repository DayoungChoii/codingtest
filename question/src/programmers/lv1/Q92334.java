package programmers.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q92334 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] solution = solution(id_list, report, k);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        int[] reportCountArr = new int[id_list.length];
        List<HashSet<Integer>> reportMappingList = new ArrayList<>(id_list.length);
        HashMap<String, Integer> strToIntInfo = new HashMap<>();

        for (int i = 0 ; i < id_list.length ; i ++) {
            strToIntInfo.put(id_list[i], i);
            reportMappingList.add(new HashSet<Integer>());
        }

        for (int i = 0 ; i < report.length ; i++) {
            String[] reportInfo = report[i].split(" ");
            HashSet<Integer> reportedInfo = reportMappingList.get(strToIntInfo.get(reportInfo[0]));

            if(!reportedInfo.contains(strToIntInfo.get(reportInfo[1]))){
                reportCountArr[strToIntInfo.get(reportInfo[1])]++;
            }
            reportedInfo.add(strToIntInfo.get(reportInfo[1]));
        }

        for (int i = 0; i < reportCountArr.length; i++) {
            if (reportCountArr[i] >= k) {
                for (int j = 0; j < reportMappingList.size(); j++) {
                    HashSet<Integer> reportedInfo = reportMappingList.get(j);
                    if(reportedInfo.contains(i)){
                        answer[j]++;
                    }
                }
            }
        }

        return answer;
    }
}
