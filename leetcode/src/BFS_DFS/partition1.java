package BFS_DFS;

import java.util.*;

//����һ���ַ��� s ���뽫 s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����� ���Ĵ� ������ s ���п��ܵķָ����
public class partition1 {
    String str;
    int n;
    List<List<String>>list=new ArrayList<>();
    List<String>tmp=new ArrayList<>();
    boolean[][]f;
    public String[][] partition(String s) {
        str=s;
        n=s.length();
        f=new boolean[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(f[i],true);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                f[i][j]=s.charAt(i)==s.charAt(j)&&f[i+1][j-1];
            }
        }
        dfs(0);
        int N=list.size();
        String[][]ret=new String[N][];
        for(int i=0;i<N;i++){
            int cnt=list.get(i).size();
            ret[i]=new String[cnt];
            for(int j=0;j<cnt;j++){
                ret[i][j]=list.get(i).get(j);
            }
        }
        return ret;

    }
    private void dfs(int idx){
        if(idx==n){
            list.add(new ArrayList<>(tmp));
        }
        for(int i=idx;i<n;i++){
            if(f[idx][i]){
                tmp.add(str.substring(idx,i+1));
                dfs(i+1);
                tmp.remove(tmp.size()-1);
            }

        }

    }

    public static void main(String[] args) {
        String str="googbye";
        String[][]ret=new partition1().partition(str);
        System.out.print(Arrays.deepToString(ret));
    }
}
