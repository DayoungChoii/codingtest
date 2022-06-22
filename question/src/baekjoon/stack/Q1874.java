package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[] resultArr;
        int index = 1;

        n = Integer.parseInt(br.readLine());
        resultArr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            resultArr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(index > resultArr[i]){
                int latestNum = stack.peek();
                if(resultArr[i] != latestNum){
                    sb.delete(0, sb.length());
                    sb.append("NO");
                    break;
                } else{
                    stack.pop();
                    sb.append("-\n");
                }
            }
            if (index < resultArr[i]) {
                for (int j = index; j < resultArr[i]; j++) {
                    stack.push(index++);
                    sb.append("+\n");
                }
            }
            if (index == resultArr[i]) {
                sb.append("+\n");
                sb.append("-\n");
                index++;
            }
        }

        System.out.println(sb.toString());

    }
}
