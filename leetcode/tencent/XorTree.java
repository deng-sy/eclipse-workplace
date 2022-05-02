package tencent;
import java.util.*;
public class XorTree {
    int n =0;
    int[]ids;
//    List<Integer>dic;
    public void getSize(TreeNode root){
        if(root==null)
            return;
        getSize(root.left);
        getSize(root.right);
        n++;
    }
    public void getIds(TreeNode root){
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode node;
        int idx=0;
//        dic.add(0);
        while(!queue.isEmpty()){
            size=queue.size();
            for(int i=0;i<size;i++){
                node=queue.poll();
                ids[idx]=node.val;
                node.val=0;
                if(node.left!=null){
                    queue.offer(node.left);
//                    dic.add(idx*2+1);
                }

                if(node.right!=null){
//                    dic.add(idx*2+2);
                    queue.offer(node.right);
                }
                idx++;

            }
        }
    }
    public TreeNode xorTree (TreeNode root, ArrayList<ArrayList<Integer>> op) {
        getSize(root);
        ids=new int[n +1];
//        dic=new ArrayList<>();
        getIds(root);
//        System.out.println(dic);
        List<Integer>list=new ArrayList<>();
        for(int i = 0; i<= n; i++)
            list.add(0);
        for(List<Integer>pair:op){
            int idx=pair.get(0);
            int val=pair.get(1);
            list.set(idx,list.get(idx)^val);
        }
//        System.out.println(list);
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int size;
        TreeNode node;
        int idx=0;
//        int[]pre=new int[n*2];

        while(!queue.isEmpty()){
            size=queue.size();
            for(int i=0;i<size;i++){
                node=queue.poll();
//                if(idx>0){
//                    int parent=dic.indexOf((dic.get(idx)-1)/2);
//                    pre[idx]=list.get(ids[idx])^pre[parent];
//                }else{
//                    pre[idx]=list.get(ids[idx]);
//                }
//                node.val=pre[idx];
                node.val^=list.get(ids[idx]);
                System.out.print(node.val+" ");
                if(node.left!=null){
                    node.left.val^=node.val;
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    node.right.val^=node.val;
                    queue.offer(node.right);
                }
                idx++;
            }
        }
        return root;

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        int[][]nums=new int[][]{{3,2},{1,4},{1,3},{4,2},{2,1}};
        for(int[]num:nums){
            ArrayList<Integer>tmp = new ArrayList<>();
            tmp.add(num[0]);
            tmp.add(num[1]);
            list.add(tmp);
        }
        new XorTree().xorTree(root,list);
    }

}
