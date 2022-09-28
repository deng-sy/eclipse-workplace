package Tree;
import java.util.*;
//�������ö����� root �� subRoot ������ root ���Ƿ������ subRoot ������ͬ�ṹ�ͽڵ�
// ֵ��������������ڣ����� true �����򣬷��� false ��

public class isSubtree {

//    ����һ������
    public static boolean isSubtree1(TreeNode s,TreeNode t){
        return dfs(s,t);
    }
    private static boolean dfs(TreeNode s,TreeNode t){
        if(s==null)
            return false;
        return check(s,t)||dfs(s.left,t)||dfs(s.right,t);
    }
    private static boolean check(TreeNode s,TreeNode t){
        if(s==null&&t==null)
            return true;
        if(s==null||t==null||s.val!=t.val)
            return false;
        return check(s.left,t.left)&&check(s.right,t.right);
    }

//    ������������ϣ
    static final int MAX_N = 1005;
    static final int MOD = 1000000007;
    static boolean[] vis = new boolean[MAX_N];
    static int[] p = new int[MAX_N];//������
    static int tot;
    static Map<TreeNode, int[]> hS = new HashMap<>();
    static Map<TreeNode, int[]> hT = new HashMap<>();

    public static boolean isSubtree2(TreeNode s, TreeNode t) {
        getPrime();
        dfs(s, hS);
        dfs(t, hT);
        int tHash = hT.get(t)[0];
        for (Map.Entry<TreeNode, int[]> entry : hS.entrySet()) {
            if (entry.getValue()[0] == tHash) {
                return true;
            }
        }
        return false;
    }

    public static void getPrime() {
        vis[0] = vis[1] = true;
        tot = 0;
        for (int i = 2; i < MAX_N; ++i) {
            if (!vis[i]) {
                p[++tot] = i;

            }
            for (int j = 1; j <= tot && i * p[j] < MAX_N; ++j) {
                vis[i * p[j]] = true;
                if (i % p[j] == 0) {
                    break;
                }
            }
        }
    }

    public static void dfs(TreeNode o, Map<TreeNode, int[]> h) {
        h.put(o, new int[]{o.val, 1});
        if (o.left == null && o.right == null) {
            return;
        }
        if (o.left != null) {
            dfs(o.left, h);
            int[] val = h.get(o);
            val[1] += h.get(o.left)[1];
            val[0] = (int) ((val[0] + (31L * h.get(o.left)[0] * p[h.get(o.left)[1]]) % MOD) % MOD);
        }
        if (o.right != null) {
            dfs(o.right, h);
            int[] val = h.get(o);
            val[1] += h.get(o.right)[1];
            val[0] = (int) ((val[0] + (179L * h.get(o.right)[0] * p[h.get(o.right)[1]]) % MOD) % MOD);
        }
    }


    public static void main(String[] args) {
        TreeNode s=TreeNode.constructTree(new Integer[]{3,4,5,1,2});
        TreeNode t=TreeNode.constructTree(new Integer[]{4,1,2});
        System.out.println(isSubtree2(s,t));
    }
}
