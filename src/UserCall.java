import java.util.Scanner;

/*
在通信系统中，一个常见的问题是对用户进行不同策略的调度，会得到不同的系统消耗和性能。

假设当前有n个待串行调度用户，每个用户可以使用A/B/C三种不同的调度策略，不同的策略会消耗不同的系统资源。请你根据如下规则进行用户调度，并返回总的消耗资源数。

规则：

1.    相邻的用户不能使用相同的调度策略，例如，第1个用户使用了A策略，则第2个用户只能使用B或者C策略。

2.    对单个用户而言，不同的调度策略对系统资源的消耗可以归一化后抽象为数值。例如，某用户分别使用A/B/C策略的系统消耗分别为15/8/17。

3.    每个用户依次选择当前所能选择的对系统资源消耗最少的策略（局部最优），如果有多个满足要求的策略，选最后一个。

输入描述:

第一行表示用户个数n

接下来每一行表示一个用户分别使用三个策略的系统消耗resA resB resC

输出描述:

最优策略组合下的总的系统资源消耗数

示例1   输入输出示例仅供调试，后台判题数据一般不包含示例

输入

3

15 8 17

12 20 9

11 7 5

输出

24

说明

1号用户使用B策略，2号用户使用C策略，3号用户使用B策略。系统资源消耗: 8 + 9 + 7 = 24。

备注:

所有策略对系统的资源消耗均为正整数，n < 1000
 */
public class UserCall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] resource = new int[num][3];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                resource[i][j] = sc.nextInt();
            }
        }
        int pre = -1, sum = 0;//pre：策略前缀 sum：资源总和
        for (int i = 0; i < resource.length; i++) {
            int  min = Integer.MAX_VALUE;//min：消耗的最小资源
            if (i == 0) {//第一行元素找到最小的直接收集
                for (int j = 0; j < 3; j++) {
                    if (min >= resource[i][j]) {
                        min = resource[i][j];
                        pre = j;//前缀修改为当前列数
                    }
                }
            } else {//之后几行的元素加入前要比较前缀是否相同
                int temp = 0;
                for (int j = 0; j < 3; j++) {
                    if (j != pre && min >= resource[i][j]) {//当前所在列不等于前缀
                        min = resource[i][j];
                        temp = j;//记录下收集到的最小资源消耗所在列数
                    }
                }
                pre = temp;//更新前缀
            }
            sum += min;
        }
        System.out.println(sum);
    }
}
