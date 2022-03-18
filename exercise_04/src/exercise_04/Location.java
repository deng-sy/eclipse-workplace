package exercise_04;

import java.util.Scanner;

public class Location {

    public int row,column;

    public double maxValue;

    public static Location locateLargest(double[][] array){

        int row=0;
        int column=0;
        double maxValue=array[0][0];

        for(int i=0;i<array.length;i++){

            for(int j=0;j<array[0].length;j++){

                if(array[i][j]>maxValue){

                    maxValue=array[i][j];

                    row=i;

                    column=j;

                }

            } 

    }
        Location loc=new Location();
        loc.row=row;
        loc.column=column;
        loc.maxValue=maxValue;
        return loc;
    }

    public static void main(String[] args){
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the number of rows and columns in the array: ");
    	int r=sc.nextInt();
    	int c=sc.nextInt();
    	System.out.println("Enter the array: ");
    	double array[][]=new double[r][c];
    	for(int i=0;i<r;i++)
    		for(int j=0;j<c;j++)
    			array[i][j]=sc.nextDouble();
    	Location loc=Location.locateLargest(array);
    	System.out.print("The location of the largest element is"
    			+ " "+loc.maxValue+" at ("+loc.row+"£¬"+loc.column+")");
 
    }

}
