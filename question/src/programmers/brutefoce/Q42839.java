package programmers.brutefoce;

import java.util.HashSet;

public class Q42839 {
    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    static boolean[] visited;
    static HashSet<Integer> hs = new HashSet<>();
    static String[] numbersArr;

    public static int solution(String numbers) {
        int answer = 0;
        numbersArr = numbers.split("");
        visited = new boolean[numbers.length()];

        for (int i = 0; i < numbersArr.length; i++) {
            dfs(new StringBuilder(), 0, i);
        }

        for (Integer h : hs) {
            System.out.println("h = " + h);
        }
        return hs.size();
    }

    public static void dfs(StringBuilder sb, int depth, int index){
        //마지막 depth+1이면 return
        if (numbersArr.length == depth) {
            return;
        }
        //sb에 숫자추가
        sb.append(numbersArr[index]);

        //HashSet에 들어있는지, 소수인지 판별
        int curNum = Integer.parseInt(sb.toString());
        if(!hs.contains(curNum) && isPrime(curNum)){
            hs.add(curNum);
        }

        //visited 체크
        visited[index] = true;
        //루프돌며 dfs호출
        for (int i = 0; i < numbersArr.length; i++) {
            if(visited[i] == false){
                dfs(sb, depth + 1, i);
            }
        }
        //함수 나가기 전 visited초기화, sb 초기화
        visited[index] = false;
        sb.delete(sb.length()-1, sb.length());
    }

    public static boolean isPrime(int number){
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) flag = false;
        }
        if(number <=1) flag = false;
        return flag;
    }
}
