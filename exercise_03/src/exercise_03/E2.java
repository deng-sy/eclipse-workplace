package exercise_03;

import java.util.Scanner;

public class E2 {

	public static void main(String[] args) {
		System.out.println("Enter the number of rows in a matrix:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Enter the matrix row by row:");
		int[][] matrix=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				matrix[i][j]=sc.nextInt();
		int p,q,z;
		p=findLargestBlock(matrix)[0];q=findLargestBlock(matrix)[1];z=findLargestBlock(matrix)[2];
		
		System.out.println("The maximum square submatrix is at("+p+","+q+") with size "+z);
	}
	public static int[] findLargestBlock(int[][] matrix) {
		int[] a=new int[3];
		a[0]=0;a[1]=0;a[2]=0;
		for (int z = matrix.length; z > 0; z--) {
			for (int i = 0; i <= matrix.length - z; i++) {
				for (int j = 0; j <= matrix.length - z; j++) {
					int sum = 0;
					for (int i2 = i; i2 - i < z; i2++) {
						for (int j2 = j; j2 - j < z; j2++) {
							sum += matrix[i2][j2];
						}
					}
					if (z * z == sum) {
								
						a[0]=i;a[1]=j;a[2]=z;
						return a;
						
					
					}
				}
			}
		}
	
		return a;
	}


	}


