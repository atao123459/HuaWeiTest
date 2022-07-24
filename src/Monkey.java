import java.util.*;

/*
2022.7.23

题目描述：
 一天一只顽猴想要从山脚爬到山顶
 途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
 试问？猴子通过这个阶梯有多少种不同的跳跃方式

 输入描述
 输入只有一个这个数n 0 < n < 50
 此阶梯有多个台阶

 输出描述
 有多少种跳跃方式

 示例一
 输入
 50
 输出
 122106097
 示例二
 输入
 3
 COPY
 输出
 2


     * 解题思路：
     * 动态规划题，找规律
     * n = 1  1
     * n = 2  1
     * n = 3  2
     * n = 4  3
     * n = 5  4
     * n = 6  6
     * n = 7  9
     * 可得当n > 3时 f(n) = f(n - 1) + f(n - 3)
     * 所以可以用递归，n = 1/2/3 时值是固定的，为递归结束条件
 */
public class Monkey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int num = sc.nextInt();
            if(num == 1 || num == 2){
                System.out.println(1);
                return;
            }
            //动态规划方法
            int[] dp = new int[num + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3;i <= num;i++){
                dp[i] = dp[i - 1] + dp[i - 3];
            }
            System.out.println(dp[num - 1]);
        }
    }

    //递归方法
    public static int getResult(int num){
        if(num == 1 || num == 2){
            return 1;
        }
        if(num == 3){
            return 2;
        }
        return getResult(num - 1) + getResult(num - 3);
    }
}
