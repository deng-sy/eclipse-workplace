package microsoft;

import java.util.*;

public class MatchDoc {
    public boolean solution(int[] A, int[] B, int S) {
        int n=A.length;
        if(n>S)
            return false;
        int[]match=new int[S];
        int[][]map=new int[n][S];
        boolean[]used=new boolean[S];
        for(int i=0;i<n;i++){
            map[i][A[i]-1]=1;
            map[i][B[i]-1]=1;
        }
        Arrays.fill(match,-1);
        for(int i=0;i<n;i++){
            Arrays.fill(used,false);
            if(!find(map,used,match,S,i))
                return false;
        }
        return true;
    }
    public boolean find(int[][]map,boolean[]used,int[]match,int S,int idx){
        for(int j=0;j<S;j++){
            if(map[idx][j]==1&&!used[j]){
                used[j]=true;
                if(match[j]==-1||find(map,used,match,S,match[j])){
                    match[j]=idx;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]A={1,2,1,6,8,7,8},B={2,3,4,7,7,8,7};
        int S=10;
        System.out.println(new MatchDoc().solution(A,B,S));
    }
}
