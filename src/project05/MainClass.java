package project05;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		
		
		while(true) {
			System.out.println("1.박상진");
			System.out.println("2.김여진");
			System.out.println("3.김형석");
			System.out.println("4.문지은");
			System.out.println("5.박선영");
			
			input = sc.nextInt();
			sc.nextLine();
			
			switch(input) {
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: System.exit(0); break;
			default: System.out.println("only 1~6."); break;
			}
		}
	}
}
