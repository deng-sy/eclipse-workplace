package hard;
//请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证
// 一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    public String serialize(TreeNode root) {
        return rserialize(root,"");
    }

    public TreeNode deserialize(String data) {
        String[]dataArray=data.split(",");
        List<String>datalist=new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize(datalist);
    }
    private String rserialize(TreeNode root,String str){
        if(root==null)
            str+="None,";
        else{
            str+= root.val +",";
            str=rserialize(root.left,str);
            str=rserialize(root.right,str);
        }
        return str;
    }
    private TreeNode rdeserialize(List<String>datalist){
        if(datalist.get(0).equals("None")){
            datalist.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(datalist.get(0)));
        datalist.remove(0);
        root.left=rdeserialize(datalist);
        root.right=rdeserialize(datalist);
        return root;
    }
}
