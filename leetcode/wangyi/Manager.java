package wangyi;
//A��˾��B��˾��n������������Ŀ��ÿ������Ŀ��A��˾��B��˾��һ��Ա�����롣һ��Ա�����Բ���������Ŀ��
//һ��Ա����������˸���Ŀ����Ŀ��������Ҫ��������ĸ���Ŀ����һ��Ա��Ҳ���Ը�������Ŀ��
//A��˾��B��˾��Ҫ��֤��������Ŀ�������˸�����������Ҫָ��������Ŀ����
//��һ��ΪA��˾�ĵ���Աid�б� 0< id���� < 10000���ÿո��з�
// �ڶ���ΪB��˾����Աid�б� 0< id���� < 10000���ÿո��з�
//������Ϊ���Ѿ��ж��ٸ�ƥ��������Ŀ������ϵn
//������n�У�ÿһ��Ϊÿ������Ŀ�ĺ�����Ӧ��ϵ��Ϊ����id����һ��ΪA��˾��Ա��id���ڶ���ΪB��˾��Ա��id���ÿո�����
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Manager {
    static int[][]map;
    static int[]match;
    static int[]a;
    static int[]b;
    static boolean[]used;
    public static int Manager(){
        Arrays.fill(match,-1);
        int res=0;
        for(int i:a){
            Arrays.fill(used,false);
            if(find(b,i))
                res++;
        }
        return res;
    }
    public static boolean find(int[]b,int idx){
        for(int j:b){
            if(map[idx][j]==1&&!used[j]){
                used[j]=true;
                if(match[j]==-1||find(b,match[j])){
                    match[j]=idx;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[]params;
        while((line=br.readLine())!=null){
            params=line.trim().split(" ");
            a = new int[params.length];
            int max_a=0,max_b=0;
            for(int i=0;i<params.length;i++){
                a[i]=Integer.parseInt(params[i]);
                max_a=Math.max(max_a,a[i]);
            }
            params=br.readLine().trim().split(" ");
            b=new int[params.length];
            for(int i=0;i<params.length;i++){
                b[i]=Integer.parseInt(params[i]);
                max_b=Math.max(max_b,b[i]);
            }
            int n=Integer.parseInt(br.readLine().trim());
            map=new int[max_a+1][max_b+1];
            match=new int[max_b+1];
            used=new boolean[max_b+1];
            for(int i=0;i<n;i++){
                params=br.readLine().trim().split(" ");
                int first=Integer.parseInt(params[0]);
                int second=Integer.parseInt(params[1]);
                map[first][second]=1;
            }
            System.out.println(Manager());
        }
    }
}
