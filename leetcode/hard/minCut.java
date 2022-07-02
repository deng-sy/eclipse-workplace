package hard;

import java.util.Arrays;

public class minCut {
    public int minCut(String s) {
        int n=s.length();
        boolean[][]g=new boolean[n][n];//��ʾs[i,j]�Ƿ�Ϊ�����ַ���
        for(int i=0;i<n;i++){
            Arrays.fill(g[i],true);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                g[i][j]=s.charAt(i)==s.charAt(j)&&g[i+1][j-1];
            }
        }
        int[]f=new int[n];//��ʾs[0,i]����С�ָ����
        Arrays.fill(f,Integer.MAX_VALUE);
        for(int j=0;j<n;j++){
            if(g[0][j])
                f[j]=0;
            else{
                for(int i=0;i<j;i++){
                    if(g[i+1][j])
                        f[j]=Math.min(f[j],f[i]+1);
                }
            }
        }
        return f[n-1];

    }
}
