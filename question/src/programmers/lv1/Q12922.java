package programmers.lv1;

public class Q12922 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static String solution(int n) {
        String answer = "";
        String watermelon = "수박";

       if(n % 2 == 0){
            answer = watermelon.repeat(n/2);
        } else{
            answer = watermelon.repeat(n/2 + 1);
            answer = answer.substring(0, answer.length() - 1);
        }

        return answer;
    }
}
