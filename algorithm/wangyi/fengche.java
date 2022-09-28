package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class fengche {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int size=2*n-1;
            char[][]graph=new char[size][size];
            for(int i=0;i<size;i++){
                graph[i][i]='*';
                graph[i][size-i-1]='*';
            }
            for(int i=0;i<size;i++){
                graph[n-1][i]='*';

                graph[i][n-1]='*';
            }
            for(int i=0;i<n;i++){
                graph[i][0]='*';
                graph[size-1][i]='*';
            }
            for(int i=n;i<size;i++){
                graph[i][size-1]='*';
                graph[0][i]='*';
            }

            String[]strs=new String[size];
            for(int i=0;i<size;i++)
                strs[i]= Arrays.toString(graph[i]);
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    System.out.print(graph[i][j]);
                }
                System.out.println();
            }
        }
    }
}
