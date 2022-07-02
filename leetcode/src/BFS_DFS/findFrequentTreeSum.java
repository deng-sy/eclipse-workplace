package BFS_DFS;
import java.util.*;

public class findFrequentTreeSum {
    Map<Integer,Integer> map=new HashMap<>();
    int max_cnt=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer>list=new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()==max_cnt){
                list.add(entry.getKey());
            }
        }
        int n=list.size();
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left_val=dfs(root.left),right_val=dfs(root.right);
        int sum=root.val+left_val+right_val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        max_cnt=Math.max(max_cnt,map.get(sum));
        return sum;
    }

    public static void main(String[] args) {

    }
}
