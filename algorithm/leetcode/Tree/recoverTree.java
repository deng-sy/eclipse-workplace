package Tree;


//�ָ�����������:
//��������������ĸ��ڵ�root �����е������ڵ��ֵ������ؽ��������ڲ��ı���
//�ṹ������£��ָ��������

public class recoverTree {
    private static TreeNode pre;//��ǰ�ڵ��ǰһ���ڵ�
    private static TreeNode first;//��һ������Ľڵ�
    private static TreeNode second;//�ڶ�������Ľڵ�
    public static void recoverTree(TreeNode root){
        inorder(root);

        int tmp=first.val;
        first.val=second.val;
        second.val=tmp;


    }
//    �������
    private static void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);

        if(first==null&&pre!=null&&pre.val>root.val){
            first=pre;
        }
        if(first!=null&&pre.val>root.val){
            second=root;
        }
        pre=root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums={3,1,4,null,null,2};
        TreeNode root=TreeNode.constructTree(nums);

        System.out.println("ԭʼ��������");
        TreeNode.show(root);
        recoverTree(root);
        System.out.println();
        System.out.println("�ָ���Ķ�������");
        TreeNode.show(root);
    }


}
