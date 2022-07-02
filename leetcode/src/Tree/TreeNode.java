package Tree;

import java.util.*;

/*
���Ľṹʾ����
     5
   /     \
4           8
/           /   \
11          13      4
/ \                   \
7   2                   1
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){this.val=val;}

//    ���鹹����
    public static TreeNode constructTree(Integer[] nums){
        if(nums.length==0){return new TreeNode(0);}
        Deque<TreeNode> nodeDeque=new LinkedList<>();

        TreeNode root=new TreeNode(nums[0]);
        nodeDeque.offer(root);
        TreeNode cur;

//        ��¼��ǰ�нڵ��������������һ�зǿսڵ�����*2
        int lineNodeNum=2;

//        ��¼��ǰ���������������е���ʼλ��
        int startIndex=1;

//        ��¼�����е�ʣ��Ԫ������
        int restLength=nums.length-1;

        while (restLength > 0) {
            for(int i=startIndex;i<startIndex+lineNodeNum;i+=2){
                if(i==nums.length){return root;}
                cur=nodeDeque.poll();
                if(nums[i]!=null){
                    cur.left=new TreeNode(nums[i]);
                    nodeDeque.offer(cur.left);

                }
                if(i+1==nums.length){return root;}
                if(nums[i+1]!=null){
                    cur.right=new TreeNode(nums[i+1]);
                    nodeDeque.offer(cur.right);
                }
            }
            startIndex+=lineNodeNum;
            restLength=lineNodeNum;
            lineNodeNum=nodeDeque.size()*2;
        }
        return root;
    }


    // ���ڻ�����Ĳ���
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

//    ��ӡ��
    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // ��֤���������Ϊ��
        if (currNode == null) return;
        // �Ƚ���ǰ�ڵ㱣�浽��ά������
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // ���㵱ǰλ�����ĵڼ���
        int currLevel = ((rowIndex + 1) / 2);
        // ���������һ�㣬�򷵻�
        if (currLevel == treeDepth) return;
        // ���㵱ǰ�е���һ�У�ÿ��Ԫ��֮��ļ������һ�е��������뵱ǰԪ�ص�������֮��ļ����
        int gap = treeDepth - currLevel - 1;

        // ������ӽ����жϣ���������ӣ����¼��Ӧ��"/"������ӵ�ֵ
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // ���Ҷ��ӽ����жϣ������Ҷ��ӣ����¼��Ӧ��"\"���Ҷ��ӵ�ֵ
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // �õ��������
        int treeDepth = getTreeDepth(root);

        // ���һ�еĿ��Ϊ2�ģ�n - 1���η���3���ټ�1
        // ��Ϊ������ά����Ŀ��
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (1 << (treeDepth - 1)) * 3 + 1;
        // ��һ���ַ����������洢ÿ��λ��Ӧ��ʾ��Ԫ��
        String[][] res = new String[arrayHeight][arrayWidth];
        // ��������г�ʼ����Ĭ��Ϊһ���ո�
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // �Ӹ��ڵ㿪ʼ���ݹ鴦��������
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // ��ʱ���Ѿ���������Ҫ��ʾ��Ԫ�ش��浽�˶�ά�����У�����ƴ�Ӳ���ӡ����
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    //    ǰ������ݹ�
    public static void preOrder1(TreeNode root){
        if(root==null){return;}
        System.out.print(root.val+" ");
        preOrder1(root.left);
        preOrder1(root.right);
    }
    //    ǰ������ǵݹ�д��
    public static void preOrder2(TreeNode root){
        if(root==null){return;}
        Stack<TreeNode> q1=new Stack<>();
        q1.push(root);
        while(!q1.isEmpty()){
            TreeNode t1=q1.pop();
            System.out.print(t1.val+" ");
            if(t1.right!=null){
                q1.push(t1.right);
            }
            if(t1.left!=null){
                q1.push(t1.left);
            }
        }
    }

//    Morrisǰ�����
    public static void MorrisPreorder(TreeNode root){
        TreeNode cur = root;
        TreeNode mostright;
        while (cur != null) {
            mostright = cur.left;// ��ǰ�ڵ������
            // ��ǰ�ڵ�����������ڣ���mostright��λ���������������ҽڵ�
            if (mostright != null) {
                while (mostright.right != null && mostright.right != cur) {
                    mostright = mostright.right;
                }
                // ������������ҽڵ��rightָ��Ϊ�գ�����ָ��ǰ�ڵ㣬cur������
                if (mostright.right == null) {
                    mostright.right = cur;
                    // 1. cur Ҫ����������֮ǰ�ȴ�ӡ���ڵ�
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                    continue;// ��������������
                } else {
                    // ˵��mostright��rightָ����cur��������Ϊ��
                    mostright.right = null;
                }
            } else {
                // 2. ������Ϊ��ʱ��ӡ���ڵ�
                System.out.print(cur.val + " ");
            }
            // ��ǰ�ڵ�������������ڻ��Ѿ����ʹ���cur������
            cur = cur.right;
        }
    }
    //    ��������ݹ�
    public static void midOrder1(TreeNode root){
        if(root==null){return;}
        midOrder1(root.left);
        System.out.print(root.val+" ");
        midOrder1(root.right);
    }
    //    ��������ǵݹ�д��
    public static void midOrder2(TreeNode root){
        Stack<TreeNode> q1=new Stack<>();
        while(root!=null||!q1.isEmpty()){
            while(root!=null){
                q1.push(root);
                root=root.left;
            }
            if(!q1.isEmpty()){
                root=q1.pop();
                System.out.print(root.val+" ");
                root=root.right;
            }
        }
    }
    //    ����Morris���������ʡ�ռ�
    public static void MorrisInorder(TreeNode root){
        TreeNode cur = root, mostright ;
        while (cur != null) {
            mostright = cur.left;
            if (cur.left != null) {
                while(mostright.right != null && mostright.right != cur)
                    mostright = mostright.right;
                if(mostright.right == null) {
                    mostright.right = cur;
                    cur = cur.left;
                    continue;
                }else
                    mostright.right = null;
            }
            System.out.print(cur.val+" ");
            cur = cur.right;
        }
    }

    //    ��������ݹ�
    public static void aftOrder1(TreeNode root){
        if(root==null){return;}
        aftOrder1(root.left);
        aftOrder1(root.right);
        System.out.print(root.val+" ");
    }
    //    ��������ǵݹ�д��1
    public static void aftOrder2(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> s1=new Stack<>();//���÷��ʵĽڵ�
        Stack<TreeNode> s2=new Stack<>();//����Ҫ��ӡ�Ľڵ�
        s1.push(root);
        while(!s1.isEmpty()){
            root=s1.pop();
            s2.push(root);
            if(root.left!=null){
                s1.push(root.left);
            }
            if(root.right!=null){
                s1.push(root.right);
            }
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().val+" ");
        }

    }

    //    ��������ǵݹ�д��2
    public static void aftOrder3(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack =new Stack<>();
        stack.push(root);
        TreeNode tmp;
        while(!stack.isEmpty()){
            tmp=stack.peek();
//            ��������������ʾ����������ҽڵ㶼�Ѿ����ʹ���
            if(tmp.left!=null&&root!=tmp.left&&root!=tmp.right){
                stack.push(tmp.left);
            }else if(tmp.right!=null&&root!=tmp.right){
                stack.push(tmp.right);
            }else{
                System.out.print(stack.pop().val+" ");
                root=tmp;
            }
        }
    }

    //    �������(������ȷǵݹ���)
    public static List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    //    ���������������ȵݹ�����
    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public static void levelHelper(List<List<Integer>> list, TreeNode root, int level) {
        //�߽������ж�
        if (root == null)
            return;
        //level��ʾ���ǲ��������level >= list.size()��˵������һ���ˣ�����
        //Ҫ�Ȱ���һ���list��ʼ������ֹ����add��ʱ����ֿ�ָ���쳣
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        //level��ʾ���ǵڼ��㣬������ʵ��ڼ��㣬���ǾͰ����ݼ��뵽�ڼ���
        list.get(level).add(root.val);
        //��ǰ�ڵ������֮����ʹ�õݹ�ķ�ʽ�ֱ���ʵ�ǰ�ڵ�������ӽڵ�
        levelHelper(list, root.left, level + 1);
        levelHelper(list, root.right, level + 1);
    }


    //    DFS������ȷǵݹ�
    public static void treeDFS1(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }

        }
    }

    //    DFS������ȵݹ�==ǰ�����
    public static void treeDFS2(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        treeDFS2(root.left);
        treeDFS2(root.right);
    }

    //    BFS������ȷǵݹ�==�������
    public static void treeBFS1(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }

    //   BFS������ȵݹ�
    public static void treeBFS2(TreeNode root){
        int depth=depth(root);
        for(int i=0;i<depth;i++){
            printLevel(root,i);
        }
    }

//    ����������
    private static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth=depth(root.left);
        int rightDepth=depth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
    private static void printLevel(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level==0){
            System.out.print(root.val+" ");
        }else{
            printLevel(root.left,level-1);
            printLevel(root.right,level-1);
        }
    }


    public static void main(String[] args) {
        Integer nums[] ={5,4,8,11,null,13,4,7,2,null,null,null,1};
        // ���ݸ��������鴴��һ����
        TreeNode root = TreeNode.constructTree(nums);
        // ���ոմ���������ӡ����

        TreeNode.show(root);
        System.out.print("ǰ�������");
        MorrisPreorder(root);
        System.out.println();
        System.out.print("���������");
        MorrisInorder(root);
        System.out.println();
        System.out.print("���������");
        aftOrder1(root);
        System.out.println();
        System.out.print("���������");
        System.out.print(levelOrderBFS(root));
    }
}
