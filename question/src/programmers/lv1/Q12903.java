package programmers.lv1;

public class Q12903 {
    public static void main(String[] args) {
        System.out.println(solution("choi"));
    }

    public static String solution(String s) {
        int halfLength = s.length() / 2;
        boolean isEven = s.length() % 2 == 0 ? true : false;
        return isEven ? s.substring(halfLength-1, halfLength + 1) : s.substring(halfLength, halfLength+1);
    }
}
