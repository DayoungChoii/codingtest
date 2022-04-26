package programmers;

public class Q12977 {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        int solution = solution(nums);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] nums) {
        int answer = 0;

        int sum = 0;
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            for(int j = i+1 ; j < nums.length - 1; j++){
                for (int k = j+1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if(isSumPrimeNumber(sum)) answer++;
                }
            }
        }
        return answer;
    }

    public static boolean isSumPrimeNumber(int num){
        boolean result = true;

        for (int i = 2; i < num; i++) {
            if(num % i == 0) result = false;
        }
        return result;
    }

}
