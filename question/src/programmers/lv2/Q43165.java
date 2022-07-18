package programmers.lv2;

public class Q43165 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,1,2,1}, 4));
    }

    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        dfs(0, numbers[0], numbers, target);
        dfs(0, -numbers[0], numbers, target);
        return answer;
    }

    static void dfs(int depth, int sum, int[] numbers, int target) {

        if(depth == numbers.length - 1) {
            if(sum == target){
                answer++;
            }
            return;
        }
        int nextDepth = depth + 1;
        dfs(nextDepth, sum + numbers[nextDepth], numbers, target);
        dfs(nextDepth, sum - numbers[nextDepth], numbers, target);

    }

}
