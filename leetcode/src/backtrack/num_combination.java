package backtrack;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//�ҳ��������֮��Ϊ n �� k ��������ϡ������ֻ������ 1 - 9 ��������������ÿ������в������ظ������֡�
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
