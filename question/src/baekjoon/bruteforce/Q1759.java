package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Q1759 {
    public static void main(String[] args) throws IOException {
        //L, C 2개의 정수
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strArr;

        str = br.readLine();
        strArr = str.split(" ");

        L = Integer.parseInt(strArr[0]);
        C = Integer.parseInt(strArr[1]);

        String[] alphabetArr = new String[C];
        passCombi = new String[L];

        str = br.readLine();
        strArr = str.split(" ");

        for (int i = 0; i < C; i++) {
            alphabetArr[i] = strArr[i];
        }
        //주어진 알파벳들 정렬
        alphabetArr = Arrays.stream(alphabetArr)
                .sorted()
                .toArray(s -> new String[s]);

        //StringBuilder에 L개 선택한 값 넣기
        findPasswordCombi(alphabetArr, 0, -1);
        System.out.println(sb.toString());
    }
    static int L, C;
    static StringBuilder sb = new StringBuilder();
    static String[] passCombi;
    public static void findPasswordCombi(String[] alphabetArr, int theNumberOfStr, int curIndex){
        //L개 만큼 다 선택했으면 StringBuilder에 추가
        if(theNumberOfStr == L){
            if(isVowelExist(passCombi) && isConsonantMoreThan2(passCombi)){
                for(int i = 0; i < L; i++){
                    sb.append(passCombi[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < alphabetArr.length; i++) {
            //현재의 위치보다 더 뒤에 있는 알파벳일 경우만 비밀번호에 추가
            if(curIndex<i){
                passCombi[theNumberOfStr] = alphabetArr[i];
                findPasswordCombi(alphabetArr, theNumberOfStr+1, i);
            }
        }
    }

    public static boolean isVowelExist(String[] passCombi){
        String[] vowels = new String[]{"a", "e", "i", "o", "u"};

        return Arrays.stream(passCombi)
                .anyMatch(s -> { return Arrays.stream(vowels).anyMatch(vowel -> vowel.equals(s)); });
    }

    public static boolean isConsonantMoreThan2(String[] passCombi){
        String passCombiStr = Arrays.stream(passCombi).collect(Collectors.joining());
        passCombiStr = passCombiStr.replaceAll("[a,e,i,o,u]", "");
        return passCombiStr.length() < 2 ? false : true;
    }
}
