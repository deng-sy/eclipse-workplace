package Tree;

import java.util.*;

/*
树的结构示例：
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

//    数组构建树
    public static TreeNode constructTree(Integer[] nums){
        if(nums.length==0){return new TreeNode(0);}
        Deque<TreeNode> nodeDeque=new LinkedList<>();

        TreeNode root=new TreeNode(nums[0]);
        nodeDeque.offer(root);
        TreeNode cur;

//        记录当前行节点的数量，等于上一行非空节点数量*2
        int lineNodeNum=2;

//        记录当前行中数字在数组中的起始位置
        int startIndex=1;

//        记录数组中的剩余元素数量
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


    // 用于获得树的层数
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

//    打印树
    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (1 << (treeDepth - 1)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
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

    //    前序遍历递归
    public static void preOrder1(TreeNode root){
        if(root==null){return;}
        System.out.print(root.val+" ");
        preOrder1(root.left);
        preOrder1(root.right);
    }
    //    前序遍历非递归写法
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

//    Morris前序遍历
    public static void MorrisPreorder(TreeNode root){
        TreeNode cur = root;
        TreeNode mostright;
        while (cur != null) {
            mostright = cur.left;// 当前节点的左孩子
            // 当前节点的左子树存在，则将mostright定位到该左子树的最右节点
            if (mostright != null) {
                while (mostright.right != null && mostright.right != cur) {
                    mostright = mostright.right;
                }
                // 如果左子树最右节点的right指针为空，让其指向当前节点，cur往左走
                if (mostright.right == null) {
                    mostright.right = cur;
                    // 1. cur 要走向左子树之前先打印根节点
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                    continue;// 继续访问左子树
                } else {
                    // 说明mostright的right指向了cur，重新置为空
                    mostright.right = null;
                }
            } else {
                // 2. 左子树为空时打印根节点
                System.out.print(cur.val + " ");
            }
            // 当前节点的左子树不存在或已经访问过，cur往右走
            cur = cur.right;
        }
    }
    //    中序遍历递归
    public static void midOrder1(TreeNode root){
        if(root==null){return;}
        midOrder1(root.left);
        System.out.print(root.val+" ");
        midOrder1(root.right);
    }
    //    中序遍历非递归写法
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
    //    采用Morris中序遍历节省空间
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

    //    后序遍历递归
    public static void aftOrder1(TreeNode root){
        if(root==null){return;}
        aftOrder1(root.left);
        aftOrder1(root.right);
        System.out.print(root.val+" ");
    }
    //    后序遍历非递归写法1
    public static void aftOrder2(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> s1=new Stack<>();//放置访问的节点
        Stack<TreeNode> s2=new Stack<>();//放置要打印的节点
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

    //    后序遍历非递归写法2
    public static void aftOrder3(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack =new Stack<>();
        stack.push(root);
        TreeNode tmp;
        while(!stack.isEmpty()){
            tmp=stack.peek();
//            后面两个条件表示这棵树的左右节点都已经访问过了
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

    //    层序遍历(广度优先非递归解决)
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

    //    层序遍历（深度优先递归解决）
    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public static void levelHelper(List<List<Integer>> list, TreeNode root, int level) {
        //边界条件判断
        if (root == null)
            return;
        //level表示的是层数，如果level >= list.size()，说明到下一层了，所以
        //要先把下一层的list初始化，防止下面add的时候出现空指针异常
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        //level表示的是第几层，这里访问到第几层，我们就把数据加入到第几层
        list.get(level).add(root.val);
        //当前节点访问完之后，再使用递归的方式分别访问当前节点的左右子节点
        levelHelper(list, root.left, level + 1);
        levelHelper(list, root.right, level + 1);
    }


    //    DFS深度优先非递归
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

    //    DFS深度优先递归==前序遍历
    public static void treeDFS2(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        treeDFS2(root.left);
        treeDFS2(root.right);
    }

    //    BFS广度优先非递归==层序遍历
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

    //   BFS广度优先递归
    public static void treeBFS2(TreeNode root){
        int depth=depth(root);
        for(int i=0;i<depth;i++){
            printLevel(root,i);
        }
    }

//    返回最大深度
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
        // 根据给定的数组创建一棵树
        TreeNode root = TreeNode.constructTree(nums);
        // 将刚刚创建的树打印出来

        TreeNode.show(root);
        System.out.print("前序遍历：");
        MorrisPreorder(root);
        System.out.println();
        System.out.print("中序遍历：");
        MorrisInorder(root);
        System.out.println();
        System.out.print("后序遍历：");
        aftOrder1(root);
        System.out.println();
        System.out.print("层序遍历：");
        System.out.print(levelOrderBFS(root));
    }
}
