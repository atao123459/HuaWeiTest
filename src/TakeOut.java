import java.util.Arrays;
import java.util.Scanner;

/*
机智的外卖员
题目描述：
外卖员每天在大厦中送外卖，大厦共有L层（0<L<=10^5），当他处于第N层楼时，可以每分钟通过步行梯向上达到N+1层，或向下达到N-1层，或者乘坐电梯达到2*N层。给定他所处位置N，以及外卖配送的目的楼层M，计算他送达的最短时间。

输入描述
当前所处楼层N和外卖配送的目的楼层M

输出描述
送达的最短时间

样例
输入
5 17
输出
4
————————————————
版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_44052055/article/details/124246788
 */
public class TakeOut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int n = Integer.parseInt(str[0]);//所在楼层
            int m = Integer.parseInt(str[1]);//目标楼层
            if(n >= m){
                System.out.println(0);
                return;
            }
            int[] dp = new int[m + 1];
            Arrays.fill(dp,0);
            for(int i = 0;i <= n;i++){//dp数组初始化为到达N层以下所需的时间
                dp[i] = n - i;
            }
            //由于电梯之能到达偶数层,所有要对目标楼层进行判断
            //走楼梯需要的时间都一样，都是dp[i - 1] + 1
            for(int i = n + 1;i <= m;i++){
                if(i % 2 == 0){
                    //到达偶数层电梯需要的时间dp[i / 2] + 1
                    dp[i] = Math.min(dp[i - 1] + 1,dp[i / 2] + 1);
                }else {
                    //到达奇数层电梯需要的时间dp[(i + 1) / 2] + 2
                    dp[i] = Math.min(dp[i - 1] + 1,dp[(i + 1) / 2] + 2);
                }
            }
            System.out.println(dp[m]);
        }
    }
}
