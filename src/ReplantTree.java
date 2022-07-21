import java.util.*;

/*
2022.7.14

//某沙漠新种植N颗胡杨（编号1~N），一个月后，有M颗未能成活。现可补种K颗（只可补种，不可新种），请问怎样补种，可以得到最多的连续胡杨树？
输入  N 总种植数量
         M  未成活数量
         M个空格分割的数，按编号从小到大排列
         K 最多可以补种的数量
其中 1<=N<1000 1<=M<N 0<=K<=M
实例 输入
       10
       3
       2 4 7
       1
       输出
       6
说明 补种第7颗 可得到5，6，7,8，9，10连续胡杨树
 */

/**
直接使用滑动窗口解决
 */
public class ReplantTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//树的总数
        int m = sc.nextInt();//死掉的树
        int[] deathTree = new int[m];
        for(int i = 0;i < m;i++){
            deathTree[i] = sc.nextInt();
        }
        int k = sc.nextInt();//补种数量
        int max = 0;//得到的最大连续树
        int maxWin = 0;//最大的滑动窗口
        int deathIndex = 0;//补种的位置
        int left = 0;//窗口起始位置，从0开始
        for(int right = 1;right <= n;right++){
            if(deathIndex < deathTree.length && right == deathTree[deathIndex]){//需要补种 找到死掉的树的位置
                deathIndex++;
                if(k > 0){//剩余的补种树苗数量
                    k--;
                    maxWin++;//补种后窗口扩大
                }else {//补种的树苗不够，窗口缩小
                    int start = deathTree[left++] + 1;
                    maxWin = right - start + 1;//记录当前窗口大小
                }
            }else {//不需要补种 窗口扩大
                maxWin++;
            }
            max = Math.max(max,maxWin);
        }
        System.out.println(max);
    }
}
