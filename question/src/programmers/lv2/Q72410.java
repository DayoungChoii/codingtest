package programmers.lv2;

public class Q72410 {
    public static void main(String[] args) {
        System.out.println(solution("=.="));
    }

    public static String solution(String new_id) {
        //아이디 길이 3 ~ 15
        //소문자, 숫자, -, _, . 만 사용가능
        //마침표는 처음과 끝에 사용 불가, 연속사용도 불가

        //1단계 소문자
        new_id = new_id.toLowerCase();

        //2단계 소문자, 숫자, -, _, . 이거 남기고 다 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        //3단계계 연속되는 .. ->.
        new_id = new_id.replaceAll("\\.{2,}", ".");

        //4단 .이 처음이나 끝이면 제거
        new_id = removeFinishDot(new_id);

        //5단계 빈 문자열이면 a return
        if(new_id.isEmpty()) new_id = "a";

        //6단계 16자 이상이면 자르고 온점제거
        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);
            new_id = removeFinishDot(new_id);
        }

        //7단계
        if (new_id.length() < 3) {
            String last = new_id.substring(new_id.length() - 1);
            while(new_id.length() <= 2){
                new_id = new_id + last;
            }
        }

       return new_id;

    }

    public static String removeFinishDot(String new_id) {
        char first = new_id.charAt(0);
        char last = new_id.charAt(new_id.length()-1);
        if(!new_id.isEmpty() && first == '.') new_id = new_id.substring(1);
        if(!new_id.isEmpty() && last == '.') new_id = new_id.substring(0, new_id.length() - 1);

        return new_id;
    }


}
