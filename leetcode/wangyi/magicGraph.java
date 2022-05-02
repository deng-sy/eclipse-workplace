package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class magicGraph {
    public static int shortestPath(int n,int m,int[][]graph){
        int INF=Integer.MAX_VALUE;
        int[]cost=new int[n];
        Arrays.fill(cost,INF);
        cost[0]=0;
        boolean[]used=new boolean[n];
        for(int i=0;i<n;i++){
            int x=-1;
            for(int y=0;y<n;y++){
                if(x==-1||(used[x]&&cost[y]<cost[x])){
                    x=y;
                }

            }
            used[x]=true;
            for(int y=0;y<n;y++){
                if(graph[x][y]>0){
                    cost[y]=Math.min(cost[y],cost[x]+graph[x][y]);
                }
            }
        }
        return cost[n-1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][]graph=new int[n][n];
            for(int i=0;i<m;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                int w=sc.nextInt();
                graph[x-1][y-1]=w;
            }
            int res=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(graph[i][j]>0){
                        graph[j][i]=graph[i][j];
                        res=Math.min(shortestPath(n,m,graph),res);
                        graph[j][i]=0;
                    }

                }
            }
            System.out.println(res==Integer.MAX_VALUE?-1:res);

        }
    }
}
