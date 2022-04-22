package baekjoon;

import java.util.Scanner;

public class Q2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i<=num;i++) {
			
			for(int j1=1; j1<=num-i;j1++) {
				System.out.print(" ");
			}
			for(int j2 = 1; j2<=i;j2++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
