import java.util.*;

/*
2022.7.21

【导师请吃火锅】

入职后，导师会请你吃饭，你选择了火锅。

火锅里会在不同时间下很多菜。

不同食材要煮不同的时间，才能变得刚好合适。

你希望吃到最多的刚好合适的菜，但你的手速不够快，用m代表手速，每次下手捞菜后至少要过m秒才能再捞（每次只能捞一个）。

那么用最合理的策略，最多能吃到多少刚好合适的菜？

输入描述

第一行两个整数n，m，其中n代表往锅里下的菜的个数，m代表手速。

接下来有n行，每行有两个数x，y代表第x秒下的菜过y秒才能变得刚好合适。

（1 < n, m < 1000）（1 < x, y < 1000）

输出描述

输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量。

示例1   输入输出示例仅供调试，后台判题数据一般不包含示例

输入

2 1
1 2
2 1
输出

1
 */
public class HotPot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int i = 0;i < n;i++){
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            //存储菜下锅到煮熟的时间
            int[] time = new int[n];
            for(int i = 0;i < n;i++){
                time[i] = y[i] - x[i];
            }
            Arrays.sort(time);
            int[] count = new int[n];
            Arrays.fill(count,0);
            int next = 0;
            for(int i = 1;i < n;i++){
                if(time[i] >= time[next] + m){//每次都夹当前时间大于下一个菜做好的时间加上冷却时间  如果当前夹的菜能
                    count[i] = 1;
                    next = i;
                }
            }
            int res = 0;
            for(int num : count){
                if(num > 0){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
