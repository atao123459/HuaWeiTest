import java.util.*;

/*
2022.7.28

  运维工程师采集到某产品线网运行一天产生的日志n条
  现需根据日志时间先后顺序对日志进行排序
  日志时间格式为H:M:S.N
  H表示小时(0~23)
  M表示分钟(0~59)
  S表示秒(0~59)
  N表示毫秒(0~999)
  时间可能并没有补全
  也就是说
  01:01:01.001也可能表示为1:1:1.1

  输入描述
 第一行输入一个整数n表示日志条数
 1<=n<=100000
 接下来n行输入n个时间

   输出描述
 按时间升序排序之后的时间
 如果有两个时间表示的时间相同
 则保持输入顺序

   示例：
 输入：
  2
  01:41:8.9
  1:1:09.211
 输出
   1:1:09.211
   01:41:8.9
   示例
 输入
   3
   23:41:08.023
   1:1:09.211
   08:01:22.0
 输出
    1:1:09.211
    08:01:22.0
    23:41:08.023

示例
  输入
    2
    22:41:08.023
    22:41:08.23
  输出
    22:41:08.023
    22:41:08.23
  时间相同保持输入顺序

 */
public class TimeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            sc.nextLine();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextLine());
            }
            list.sort((o1, o2) -> {
                String[] time1 = o1.split(":");
                String[] time2 = o2.split(":");
                int h1 = Integer.parseInt(time1[0]);
                int h2 = Integer.parseInt(time2[0]);

                int m1 = Integer.parseInt(time1[1]);
                int m2 = Integer.parseInt(time2[1]);

                double s1 = Double.parseDouble(time1[2]);
                double s2 = Double.parseDouble(time2[2]);

                if (h1 == h2) {
                    return m1 - m2;
                } else if (m1 == m2 && h1 == h2) {
                    return (int) (s1 - s2);
                } else {
                    return h1 - h2;
                }
            });
            System.out.println(list);
        }
    }
}
