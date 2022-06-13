package programmers.lv1;

public class Q12948 {
    public static void main(String[] args) {
        System.out.println(solution("01022151650"));
    }

    public static String solution(String phone_number) {
        String starStr = "*";
        int lastFourthIndex = phone_number.length() - 4;
        String lastFour = phone_number.substring(lastFourthIndex);
        String staredNum = starStr.repeat(lastFourthIndex);

        return staredNum + lastFour;
    }
}
