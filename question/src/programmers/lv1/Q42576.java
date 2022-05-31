package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Q42576 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"kiki", "kiki", "eden"}, new String[]{"kiki", "kiki"}));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionMap = new HashMap<>();
       /* for (String s : completion) {
            if(completionMap.containsKey(s)){
                Integer num = completionMap.get(s);
                completionMap.put(s, ++num);
            } else{
                completionMap.put(s, 1);
            }
        }*/

        Map<String, Long> participantMap = Arrays.stream(completion).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String[] strings = Arrays.stream(participant)
                .filter(person ->
                {
                   Integer curNum = completionMap.get(person);
                   if (curNum != null && curNum > 0) {
                       completionMap.put(person, --curNum);
                       return false;
                   } else {
                       return true;
                   }

                })
                .toArray(String[]::new);


        return strings[0];
    }
}
