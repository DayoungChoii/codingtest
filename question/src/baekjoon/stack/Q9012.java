package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String str;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            System.out.println(isVPS(str)?"YES":"NO");
        }
    }

    private static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();
        char curChar;

        for (int i = 0; i < str.length(); i++) {
            curChar = str.charAt(i);
            if(stack.size() >0 && stack.peek() == '(' && curChar == ')'){
                stack.pop();
            } else{
                stack.push(curChar);
            }
        }
        return stack.size() == 0 ? true : false;
    }
}
