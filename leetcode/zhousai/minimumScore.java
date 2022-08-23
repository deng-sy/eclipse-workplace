package zhousai;
import java.util.*;
public class minimumScore {
    static List<Integer>[]list;
    static int ans=Integer.MAX_VALUE;
    static int sum;
    public static int minimumScore(int[] nums, int[][] edges) {
        int m=nums.length;
        sum=0;
        for(int num:nums)
            sum^=num;
        list=new ArrayList[m];
        for(int i=0;i<m;i++)
            list[i]=new ArrayList<>();
        for(int[]edge:edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        for(int[]edge:edges){
            int left=dfs1(edge[0],edge[1],nums);
            dfs2(left,edge[1],edge[0],nums);
            int right=sum^left;
            dfs2(right,edge[0],edge[1],nums);
        }
        return ans;
    }
    private static int dfs1(int left,int right,int[]nums){
        int res=nums[left];
        for(int i:list[left]){
            if(i==right)
                continue;
            res^=dfs1(i,left,nums);
        }
        return res;
    }
    private static int dfs2(int first,int left,int right,int[]nums){
        int res=nums[left];
        for(int i:list[left]){
            if(i==right)
                continue;
            int second=dfs2(first,i,left,nums);
            res^=second;
            int third=sum^first^second;
            int max=Math.max(first,Math.max(second,third));
            int min=Math.min(first,Math.min(second,third));
            ans=Math.min(ans,max-min);
        }
        return res;
    }
    public static void main(String[] args) {
        int[]nums={1,5,5,4,11};
        int[][]edges={{0,1},{1,2},{1,3},{3,4}};
        long time=System.currentTimeMillis();
        System.out.println(minimumScore(nums,edges));
        System.out.println(System.currentTimeMillis()-time);

    }
}
