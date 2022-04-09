package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//����������ĸ����root����������㷨����������Ĵ���������С���λ��(row, col)
//��ÿ�������ԣ��������ӽ��ֱ�λ��(row+1, col -1)��(row+1, col+1)�����ĸ���
//��λ��(0,0)��
//�������Ĵ������������ߵ��п�ʼֱ�����ұߵ��н����� �� �� �� �� ÿ һ �� �� �� �� �� ��
//�㣬�γ�һ��������λ�ô��ϵ�������������б����ͬ��ͬ�����ж����㣬�򰴽�
//���ֵ��С�����������
public class verticalTraversal {
    public static List<List<Integer>>verticalTraversal(TreeNode root){
        List<int[]>mList=new ArrayList<>();
        dfs(root,0,0,mList);
        Collections.sort(mList,(arr1,arr2)->{
            if(arr1[2]!=arr2[2])
                return arr1[2]-arr2[2];
            if(arr1[1]!=arr2[1])
                return arr1[1]-arr2[1];
            return arr1[0]-arr2[0];
        });
//        System.out.println(mList);
        List<List<Integer>>res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<mList.size();i++){
            int[]arr=mList.get(i);
            int value=arr[0];
            if(i>0&&arr[2]!=mList.get(i-1)[2])
                res.add(new ArrayList<>());
            res.get(res.size()-1).add(value);
        }
        return res;

    }
    private static void dfs(TreeNode node,int i,int j,List<int[]>mList){
        if(node==null)
            return;
        mList.add(new int[]{node.val,i,j});
        dfs(node.left,i+1,j-1,mList);
        dfs(node.right,i+1,j+1,mList);
    }

    public static void main(String[] args) {
        Integer[]nums={1,2,3,4,5,6,7};
        TreeNode root=TreeNode.constructTree(nums);
        TreeNode.show(root);
        System.out.println(verticalTraversal(root));
    }
}


