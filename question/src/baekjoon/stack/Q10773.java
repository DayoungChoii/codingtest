package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                stack.pop();
            } else{
                stack.push(n);
            }
        }

        System.out.println(stack.stream()
                .mapToInt(i->i)
                .sum());
    }
}
