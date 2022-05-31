package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Q42576_lamda {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"kiki", "kiki", "eden"}, new String[]{"kiki", "kiki"}));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Long> participantMap = Arrays.asList(participant).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(String name : completion) {

            Long value = participantMap.get(name) - 1L;

            if(value == 0L) {
                participantMap.remove(name);
            } else {
                participantMap.put(name, value);
            }
        }

        return participantMap.keySet().iterator().next();
    }
}
