package programmers.lv1;


public class Q12919 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "park","Kim"}));
    }

    public static String solution(String[] seoul) {
        int result = 0;

        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")){
                result = i;
                break;
            }
        }

        return "김서방은 " + result + "에 있다";
    }
}
