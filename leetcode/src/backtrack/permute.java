package backtrack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//È«ÅÅÁĞ
public class permute {
    public static List<List<Integer>>permute(int[]nums){
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,new boolean[nums.length],0);
        return list;
    }
    private static void backtrack(List<List<Integer>>list,List<Integer>tmpList,int[]nums,boolean[]vis,int last){
        if(tmpList.size()==nums.length){
            list.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i]||(i>0&&nums[i]==nums[i-1]&&!vis[i-1]))
                continue;
            tmpList.add(nums[i]);
            vis[i]=true;
            last=i;
            backtrack(list,tmpList,nums,vis,last);
            vis[last]=false;
            tmpList.remove(tmpList.size()-1);
        }
    }



    public static void main(String[] args) {
        int[]nums={1,2,2,4};
        System.out.println(permute(nums));
    }
}
