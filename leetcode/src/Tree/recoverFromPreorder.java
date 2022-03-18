package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//我们从二叉树的根节点root开始进行深度优先搜索。
//在遍历中的每个节点处，我们输出D条短划线（其中D是该节点的深度），然后输出该
//节点的值。（如果节点的深度为D，则其直接子节点的深度为D+1。根节点的深度为
//0）。如果节点只有一个子节点，那么保证该子节点为左子节点。
//给出遍历输出S，还原树并返回其根节点root。
public class recoverFromPreorder {

//    采用字符串分割
    public static TreeNode recoverFromPreorder1(String S){
        String[] nodeValues=S.split("-");
        System.out.println(Arrays.toString(nodeValues));
        List<TreeNode> list=new ArrayList<>();
        list.add(new TreeNode(Integer.valueOf(nodeValues[0])));
        int level=1;
        for(int i=1;i<nodeValues.length;i++){
            if(!nodeValues[i].isEmpty()){
                TreeNode node=new TreeNode(Integer.valueOf(nodeValues[i]));
                list.add(level,node);
                TreeNode parent=list.get(level-1);
                if(parent.left==null)
                    parent.left=node;
                else
                    parent.right=node;
                level=1;

            }else
                level++;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        String S="1-2--3---4-5--6---7";
        TreeNode.show(recoverFromPreorder1(S));
    }
}
