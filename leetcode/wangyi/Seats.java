package wangyi;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Seats {
    public static int Seats(int[]seats){
        int maxDist=0;
        int[]people=new int[seats.length];
        int cnt=0;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1)
                people[cnt++]=i;
        }
        if(seats[0]!=1)
            maxDist=Math.max(maxDist,people[0]);
        if(seats[seats.length-1]!=1)
            maxDist=Math.max(maxDist,seats.length-1-people[cnt-1]);
        for(int i=1;i<cnt;i++){
            maxDist=Math.max(maxDist,(people[i]-people[i-1])/2);
        }
        return maxDist;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String[]line=sc.nextLine().split(" ");
            int n=line.length;
            int[]seats=new int[n];
            for(int i=0;i<n;i++)
                seats[i]=Integer.parseInt(line[i]);
            System.out.println(Seats(seats));
        }

    }
}
