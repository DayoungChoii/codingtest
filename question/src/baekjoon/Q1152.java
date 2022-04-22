package baekjoon;

import java.util.Scanner;

public class Q1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str;
		
		str= sc.nextLine();
		str = str.trim();
		int cnt = 0;
		for(int i = 0; i<str.length();i++) {
			if(str.charAt(i)==' ') {
				cnt++;
			}
		}
		if(str.length()!=0&&cnt==0) {
			System.out.println(1);
		}
		else {
			System.out.println(cnt==0 ? 0 : ++cnt);
		}
	}

}
