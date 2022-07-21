import java.util.*;

/*
2022.7.19

  一个工厂有m条流水线
  来并行完成n个独立的作业
  该工厂设置了一个调度系统
  在安排作业时，总是优先执行处理时间最短的作业
  现给定流水线个数m
  需要完成的作业数n
  每个作业的处理时间分别为 t1,t2...tn
  请你编程计算处理完所有作业的耗时为多少
  当n>m时 首先处理时间短的m个作业进入流水线
  其他的等待
  当某个作业完成时，
  依次从剩余作业中取处理时间最短的
  进入处理

  输入描述：
  第一行为两个整数(采取空格分隔)
  分别表示流水线个数m和作业数n
  第二行输入n个整数(采取空格分隔)
  表示每个作业的处理时长 t1,t2...tn
  0<m,n<100
  0<t1,t2...tn<100

  输出描述
  输出处理完所有作业的总时长

  案例
  输入
  3 5
  8 4 3 2 10
  输出
  13
  说明
  先安排时间为2,3,4的三个作业
  第一条流水线先完成作业
  调度剩余时间最短的作业8
  第二条流水线完成作业
  调度剩余时间最短的作业10
  总共耗时 就是二条流水线完成作业时间13(3+10)

  输入
  3 9
  1 1 1 2 3 4 6 7 8
  输出
  13

 */
public class JobProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] lines = sc.nextLine().split(" ");
            int m = Integer.parseInt(lines[0]);
            int n = Integer.parseInt(lines[1]);
            String[] times = sc.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n;i++){
                list.add(Integer.parseInt(times[i]));
            }
            Collections.sort(list);
            if(n <= m){//作业数小于等于流水线数时，完成时间就是list中的最后一个元素
                System.out.println(list.get(list.size() - 1));
                return;
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0;i < m;i++){//遍历流水线
                int time = 0;
                for(int j = i;j < list.size();j += m){//遍历作业集合，计算完成作业所需时间，j += m目的是跳到下该流水线执行的下一个作业
                    time += list.get(j);
                }
                max = Math.max(max,time);
            }
            System.out.println(max);
        }
    }
}
