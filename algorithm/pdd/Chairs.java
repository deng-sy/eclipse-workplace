package pdd;
import java.util.*;
public class Chairs {
    static boolean[]used;
    static int[]match;
    static List<Integer>occuped=new ArrayList<>(),empty=new ArrayList<>();
    static int cost=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[]nums=new int[n];

        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
            if(nums[i]==0)
                empty.add(i);
            else
                occuped.add(i);
        }
        used=new boolean[n];
        match=new int[n];
        Arrays.fill(match,-1);
        dfs(0,0);
        System.out.println(cost);

    }
    private static void dfs(int idx,int cur_cost){
        if(idx==occuped.size()){
            cost=Math.min(cost,cur_cost);
            Arrays.fill(used,false);
            return;
        }
        int i=occuped.get(idx);
        for(int j:empty){
            if(!used[j]){
                used[j]=true;
                cur_cost+=Math.abs(i-j);
                dfs(idx+1,cur_cost);
                cur_cost-=Math.abs(i-j);
            }
        }
    }








//    private static boolean find(int i){
//        boolean isFind=false;
//        for(int j:empty){
//            if(!used[j]){
//                used[j]=true;
//                if(match[i]==-1||find(match[i])){
//                     match[i]=j;
//                    }
//                }
//        }
//            }



}