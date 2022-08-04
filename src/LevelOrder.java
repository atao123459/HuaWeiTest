import java.util.Scanner;

/*
输入中序和后序遍历，输出层次遍历

输入：
CBEFDA CBAEDF
 */
public class LevelOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] orders = sc.nextLine().split(" ");
        String[] tree = new String[]{"","","","",""};//建成的树,26个结点最多5层
        int i = 0;//树的层级
        String[] res = level(orders[0],orders[1],i,tree);
        for (String s : res) {
            System.out.print(s);
        }
    }

    public static  String[] level(String post,String in,int level,String[] tree){
        String root = String.valueOf(post.charAt(post.length() - 1));//在后序遍历中找到根节点
        tree[level] += root;//根节点加入新树
        String[] subTree = in.split(tree[level].substring(tree[level].length() - 1));//用根节点将中序遍历分成左右子树
        String left = post.substring(0,subTree[0].length());//左子树
        String right = post.substring(subTree[0].length(),post.length() - 1);//右子树
        level = level + 1;//层级加一
        //分割左右子树，直到只有一个字符的时候加入tree中
        if(level < 4 && left.length() > 1){
            level(left,subTree[0],level,tree);
        }else {
            tree[level] += left;
        }

        if(level < 4 && right.length() > 1){
            level(right,subTree[1],level,tree);
        }else {
            tree[level] += right;
        }
        return tree;
    }
}



