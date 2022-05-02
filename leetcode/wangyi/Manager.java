package wangyi;
//A公司和B公司有n个合作的子项目，每个子项目由A公司和B公司各一名员工参与。一名员工可以参与多个子项目。
//一个员工如果担任了该项目的项目经理，它需要对所参与的该项目负责。一个员工也可以负责多个项目。
//A公司和B公司需要保证所有子项目都能有人负责，问最少需要指定几名项目经理？
//第一行为A公司的的人员id列表， 0< id数量 < 10000，用空格切分
// 第二行为B公司的人员id列表， 0< id数量 < 10000，用空格切分
//第三行为有已经有多少个匹配数子项目合作关系n
//下面有n行，每一行为每个子项目的合作对应关系，为两个id，第一个为A公司的员工id，第二个为B公司的员工id，用空格区分
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
