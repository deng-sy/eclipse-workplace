package didi;
import java.util.*;
public class Island {
    static int cnt;
    static int[][]island;
    static int m,n;
    static int[][]dirs={{-1,0},{1,0},{0,1},{0,-1}};
    static int[]f;
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            cnt=0;
            m=sc.nextInt();
            n=sc.nextInt();
            f=new int[m*n];
            int k=sc.nextInt();
            island=new int[m][n];
            int[]ret=new int[k];
            for(int i=0;i<k;i++){
                int row=sc.nextInt(),col=sc.nextInt();
                merge(row,col);
                ret[i]=cnt;
            }
            for(int i=0;i<k;i++){
                System.out.print(ret[i]);
                if(i!=k-1){
                    System.out.print(" ");
                }
            }
        }
    }
    private static void merge(int row, int col){
        if(row<0||row>=m||col<0||col>=n||island[row][col]==1)
            return;
        island[row][col]=1;
        int id=row*n+col;
        f[id]=id;
        cnt++;
        for(int[]dir:dirs){
            int nrow=row+dir[0],ncol=col+dir[1];
            int nid=nrow*n+ncol;
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n){
                if(island[nrow][ncol]==1){
                    if(find(id)==id){
                        f[id]=find(nid);
                        cnt--;
                    }else if(find(id)!=find(nid)){
                        f[find(nid)]=find(id);
                        cnt--;
                    }
                }
            }
        }

    }
    private static int find(int i){
        if(f[i]==i)
            return i;
        else
            return f[i]=find(f[i]);
    }
}
