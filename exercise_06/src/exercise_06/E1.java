package exercise_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1 {

	public static void main(String[] args) {
		System.out.println("Enter the array size n:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] a=new int[n][n]; 
		System.out.println("The random array is:");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=(int)Math.round(Math.random());
				System.out.print(a[i][j]);
			}
			System.out.print("\n");			
		}
		
		int[] row=new int[n];
		int[] column=new int[n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]==1) {
					row[i]++;
					column[j]++;
				}
			}
		}
		
		
		System.out.println("The largest row index: "+maxIndex(row));	
		System.out.println("The largest column index: "+maxIndex(column));
		
				

	}
	
	public static List<Integer> maxIndex(int[] array) {
		List<Integer> list=new ArrayList<Integer>();
		int n=array.length;
		int max_index=array[0];
		int max=0;
		for(int i=1;i<n;i++) {
			if(array[i]>max) {
				max_index=i;
				max=array[i];
			}
		}
		for(int i=0;i<n;i++) {
			if(array[i]==max) {
				list.add(i);
			}
		}
		return list;
	}

}
