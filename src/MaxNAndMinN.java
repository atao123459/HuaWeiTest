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
        while(sc.hasNextLine()){
            int nums = sc.nextInt();
            sc.nextLine();
            Set<Integer> set = new HashSet<>();
            for(int i = 0;i < nums;i++){
                set.add(sc.nextInt());
            }
            sc.nextLine();
            int N = sc.nextInt();
            if(N * 2 > set.size()){
                System.out.println(-1);
                return;
            }
            if(N == 0 || set.size() == 0){
                System.out.println(0);
                return;
            }
            Iterator<Integer> iterator = set.iterator();
            int[] num = new int[set.size()];
            int index = 0;
            while(iterator.hasNext()){
                num[index++] = iterator.next();
            }
            Arrays.sort(num);
            int sum = 0;
            for(int i = 0;i < N;i++){
                sum += num[i];//前N个最小值
                sum += num[num.length - 1 - i];//后N个最大值
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
