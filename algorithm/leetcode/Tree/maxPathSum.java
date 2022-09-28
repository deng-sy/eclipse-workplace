package Tree;

//����һ���ǿն����������������·���͡�
//·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С� �� · �� �� �� �� �� һ ��
//�ڵ㣬�Ҳ�һ���������ڵ㡣
public class maxPathSum {
    static int maxSum=Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }
    private static int maxGain(TreeNode root){
        if(root==null)
            return 0;
        int leftGain=Math.max(maxGain(root.left),0);
        int rightGain=Math.max(maxGain(root.right),0);
        int priceNewpath=root.val+leftGain+rightGain;
        maxSum=Math.max(maxSum,priceNewpath);
        return root.val+Math.max(leftGain,rightGain);
    }
    public static void main(String[] args) {
        Integer[]nums={1,2,null,3,4,null,5};
        TreeNode root=TreeNode.constructTree(nums);
        TreeNode.show(root);
        System.out.println(maxPathSum(root));
    }
}
