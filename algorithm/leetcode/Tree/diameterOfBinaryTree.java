package Tree;
//����һ�ö�����������Ҫ��������ֱ�����ȡ�һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ���Ҳ���ܲ����������
public class diameterOfBinaryTree {
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        res=1;
        dfs(root);
        return res-1;
    }
    private int dfs(TreeNode node){
        if(node==null)
            return 0;
        int L=dfs(node.left);
        int R=dfs(node.right);
        res=Math.max(res,L+R-1);
        return Math.max(L,R)+1;
    }
}
