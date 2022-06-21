package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while(true){
            str = br.readLine();
            if (str.length() == 1 && str.equals(".")) break;
            System.out.println(isPerfect(str)?"yes":"no");
        }
    }

    private static boolean isPerfect(String str) {
        Stack<Character> stack = new Stack<>();

        char curChar;

        for (int i = 0; i < str.length(); i++) {
            curChar = str.charAt(i);
            if(curChar == '(' || curChar == ')' || curChar == '[' || curChar == ']') {
                if (stack.size() > 0 && stack.peek() == '(' && curChar == ')') {
                    stack.pop();
                } else if(stack.size() > 0 && stack.peek() == '[' && curChar == ']'){
                    stack.pop();
                } else {
                    stack.push(curChar);
                }
            }


        }
        return stack.size() == 0 ? true : false;
    }
}
