import java.util.*;

/*
2022.8.1

二叉树从根节点到指定节点
 */
public class RootToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int target = sc.nextInt();
            TreeNode root = new TreeNode(0);
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);
            TreeNode node6 = new TreeNode(6);
            TreeNode node7 = new TreeNode(7);
            TreeNode node8 = new TreeNode(8);

            root.left = node1;
            root.right = node2;
            node1.left = node3;
            node1.right = node4;
            node3.left = node5;
            node3.right = node6;
            node6.left = node7;
            node6.right = node8;

            Deque<TreeNode> stack = new LinkedList<>();
            List<Integer> res = new ArrayList<>();
            if(getPathToTarget(root,target,stack)){
                for(TreeNode node : stack){
                    res.add(node.val);
                }
            }
            Collections.reverse(res);
            System.out.println(res);
        }
    }

    public static boolean getPathToTarget(TreeNode root,int target,Deque<TreeNode> stack){
        if(root == null){
            return false;
        }
        stack.push(root);
        if(root.val == target){
            return true;
        }
        if(getPathToTarget(root.left,target,stack)){
            return true;
        }
        if(getPathToTarget(root.right,target,stack)){
            return true;
        }
        stack.pop();//回溯
        return false;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

