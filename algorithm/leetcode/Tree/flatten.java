package Tree;
//����������ĸ���� root �����㽫��չ��Ϊһ��������
//
//չ����ĵ�����Ӧ��ͬ��ʹ�� TreeNode ������ right ��ָ��ָ����������һ����㣬������ָ��ʼ��Ϊ null ��
//չ����ĵ�����Ӧ��������� ������� ˳����ͬ��

public class flatten {
    public void flatten(TreeNode root) {
        TreeNode cur=root;
        TreeNode mostright;
        TreeNode next;
        while(cur!=null){
            mostright=cur.left;
            next=mostright;
            if(mostright!=null){
                while(mostright.right!=null)
                    mostright=mostright.right;
                mostright.right=cur.right;
                cur.left=null;
                cur.right=next;
            }
            cur=cur.right;
        }
    }
}
