package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Q12919_lamda {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "park","Kim"}));
    }

    public static String solution(String[] seoul) {
        AtomicInteger index = new AtomicInteger();
        Optional<HashMap<String, Integer>> kim = Arrays.stream(seoul)
                .map(s -> {
                    HashMap<String, Integer> resultMap = new HashMap<>();
                    resultMap.put(s, index.getAndIncrement());
                    return resultMap;
                })
                .filter(map -> map.containsKey("Kim"))
                .findFirst();

        return "김서방은 " + kim.get().get("Kim") + "에 있다";
    }
}
