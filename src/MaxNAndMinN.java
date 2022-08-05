import java.util.*;

/*
2022.7.19

在提供的M个数里找最大的N个和最小的N个的和，需要自己去重，最大数集合和最小数集合有重合的则返回-1
输入 第一行是数组元素个数M，第二行是数组里的数字，每个数字用空格隔开，第三个数字是N

输入
6
2 3 1 5 12 7
2
输出
22
最大的2个数是 12 7，最小的两个数是1 2，则输出 12+7+1+2=22

输入
4
1 7 1 2 2
2
输出
-1
最大的2个数是7 2，最小的2个数是1 2，有重合的输出-1
————————————————
版权声明：本文为CSDN博主「HumoChen99」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/HumorChen99/article/details/120329819
 */
public class MaxNAndMinN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int num = sc.nextInt();
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
            int n = sc.nextInt();
            Collections.sort(list);
            if(list.size() < n * 2){
                System.out.println(-1);
                return;
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += list.get(i) + list.get(list.size() - i - 1);
            }
            System.out.println(res);
        }
    }
}
