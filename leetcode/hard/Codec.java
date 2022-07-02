package hard;
//�����һ���㷨��ʵ�ֶ����������л��뷴���л������ﲻ�޶�������� / �����л��㷨ִ���߼���ֻ��Ҫ��֤
// һ�����������Ա����л�Ϊһ���ַ������ҽ�����ַ��������л�Ϊԭʼ�����ṹ��

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
