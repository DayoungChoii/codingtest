package programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;

public class Q12930 {

    static final int diff = 'A' - 'a';

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if(curChar == ' '){
                sb.append(' ');
                index = 0;
                continue;
            } else{
                if(index % 2 == 0){
                    sb.append(makeUpperCase(curChar));
                }else{
                    sb.append(makeLowerCase(curChar));
                }
                index++;
            }
        }

        return sb.toString();
    }

    public static char makeUpperCase(char c) {
        int result;
        if(c >= 'a' && c <= 'z'){
            result = c + diff;
        } else{
            result = c;
        }
        return (char)result;
    }

    public static char makeLowerCase(char c) {
        int result;
        if(c >= 'A' && c <= 'Z'){
            result = c - diff;
        } else{
            result = c;
        }
        return (char)result;
    }
}
