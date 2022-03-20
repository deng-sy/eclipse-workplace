package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//���ǴӶ������ĸ��ڵ�root��ʼ�����������������
//�ڱ����е�ÿ���ڵ㴦���������D���̻��ߣ�����D�Ǹýڵ����ȣ���Ȼ�������
//�ڵ��ֵ��������ڵ�����ΪD������ֱ���ӽڵ�����ΪD+1�����ڵ�����Ϊ
//0��������ڵ�ֻ��һ���ӽڵ㣬��ô��֤���ӽڵ�Ϊ���ӽڵ㡣
//�����������S����ԭ������������ڵ�root��
public class recoverFromPreorder {

//    �����ַ����ָ�
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

//    ����ջ
    public static TreeNode recoverFromPreorder2(String S){
        Stack<TreeNode> stack=new Stack<>();
        for(int i=0;i<S.length();){
            int level=0;
            while(S.charAt(i)=='-'){
                level++;
                i++;
            }
            int val=0;
            while(i<S.length()&&S.charAt(i)!='-'){
                val=val*10+(S.charAt(i)-'0');
                i++;
            }
            while(stack.size()>level)
                stack.pop();
            TreeNode node=new TreeNode(val);
            if(!stack.isEmpty()){
                if(stack.peek().left==null)
                    stack.peek().left=node;
                else
                    stack.peek().right=node;
            }
            stack.add(node);
        }
        while(stack.size()>1)
            stack.pop();
        return stack.pop();
    }

    public static void main(String[] args) {
        String S="1-2--3---4-5--6---7";
        TreeNode.show(recoverFromPreorder2(S));
    }
}
