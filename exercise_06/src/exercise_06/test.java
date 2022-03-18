package exercise_06;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] array=new int[5];
		boolean isValued=false;
		while(!isValued) {
			for(int i=0;i<5;i++) 
				array[i]=sc.nextInt();
			for(int i=0;i<5;i++) {
				if(array[i]>10) {
					System.out.println("Error.");
					isValued=false;
					continue;
				}
				else
					isValued=true;
			}
				
			
		}
	}

}
