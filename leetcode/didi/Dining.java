package didi;
import java.util.*;

public class Dining {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt(),m=sc.nextInt();
            int[]tables=new int[n];
            int[][]customers=new int[m][2];
            for(int i=0;i<n;i++){
                tables[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++){
                customers[i][0]=sc.nextInt();
                customers[i][1]=sc.nextInt();
            }
            Arrays.sort(tables);
            Arrays.sort(customers, (o1, o2) -> o2[1]-o1[1]);
            boolean[]used=new boolean[n];
            long ans=0l;
            for(int i=0;i<m;i++){
                if(customers[i][0]>tables[n-1])
                    continue;
                int idx=search(tables,customers[i][0]);
                while(idx<n&&used[idx])
                    idx++;
                if(idx<n){
                    used[idx]=true;
                    ans+=customers[i][1];
                }
            }
            System.out.println(ans);

        }


    }
    private static int search(int[]tables,int people){
        int low=0,high=tables.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(tables[mid]>=people){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
