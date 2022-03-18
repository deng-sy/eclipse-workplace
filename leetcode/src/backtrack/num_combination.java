package backtrack;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
public class num_combination {
    public static List<List<Integer>> num_combination(int k,int n){
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,new ArrayList<>(),k,1,n);
        return res;
    }

    private static void dfs(List<List<Integer>>res,List<Integer>list,int k,int start,int n){
        if(list.size()==k||n<=0){
            if(list.size()==k&&n==0)
                res.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<=9;i++){
            list.add(i);
            dfs(res,list,k,i+1,n-i);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        int k=3,n=9;
        System.out.println(num_combination(k,n));
    }

}
