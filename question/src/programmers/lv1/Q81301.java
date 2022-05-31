package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class Q81301 {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {
        HashMap<String, String> numbersMap = new HashMap<>();
        numbersMap.put("zero", "0");
        numbersMap.put("one", "1");
        numbersMap.put("two", "2");
        numbersMap.put("three", "3");
        numbersMap.put("four","4");
        numbersMap.put("five","5");
        numbersMap.put("six","6");
        numbersMap.put("seven","7");
        numbersMap.put("eight","8");
        numbersMap.put("nine","9");

        for (Map.Entry<String, String> entry : numbersMap.entrySet()) {
            s = s.replace(entry.getKey(), entry.getValue());
        }

        return Integer.parseInt(s);
    }
}
