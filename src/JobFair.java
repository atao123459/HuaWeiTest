import java.util.*;

/*
2022.8.1

【面试】

某公司组织一场公开招聘活动，假设由于人数和场地的限制，每人每次面试的时长不等，并已经安排给定，用(S1,E1)、 (S2,E2)、 (Sj,Ej)…(Si < Ei，均为非负整数)表示每场面试的开始和结束时间。

面试采用一对一的方式，即一名面试官同时只能面试一名应试者，一名面试官完成一次面试后可以立即进行下一场面试，且每个面试官的面试人次不超过 m。

为了支撑招聘活动高效顺利进行，请你计算至少需要多少名面试官。

输入描述

输入的第一行为面试官的最多面试人次 m，第二行为当天总的面试场次 n，

接下来的 n 行为每场面试的起始时间和结束时间，起始时间和结束时间用空格分隔。

其中， 1 <= n, m <= 500

输出描述

输出一个整数，表示至少需要的面试官数量。

示例 1   输入输出示例仅供调试，后台判题数据一般不包含示例

输入

2

5

1 2

2 3

3 4

4 5

5 6

输出

3

说明

总共有 5 场面试，且面试时间都不重叠，但每个面试官最多只能面试 2 人次，所以需要 3 名面试官。
 */
public class JobFair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            //对数组先按照开始时间排序
            Arrays.sort(arr, Comparator.comparing(o1 -> o1[0]));
            Deque<int[]> queue = new LinkedList<>();
            //队列中第一个元素为结束时间，第二个为面试的人数，初始为1，相当于存的是面试官
            queue.offer(new int[]{arr[0][1], 1});
            for (int i = 1; i < n; i++) {
                boolean flag = false;
                for (int[] ms : queue) {
                    //如果数组中当前的面试开始时间晚于队列中的结束时间，且队列中的面试人数未达上限，更新结束时间和人数
                    if (ms[0] <= arr[i][0] && ms[1] < m) {
                        ms[1]++;
                        ms[0] = arr[i][1];
                        flag = true;
                        break;
                    }
                }
                //队列中没有符合要求的面试官就创建新的加入
                if (!flag) {
                    queue.offer(new int[]{arr[i][1],1});
                }
            }
            System.out.println(queue.size());
        }
    }
}
