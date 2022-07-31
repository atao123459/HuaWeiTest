import java.util.*;

/*
2022.7.31

  用数组代表每个人的能力
  一个比赛活动要求 参赛团队的最低能力值为N
  每个团队可以由一人或者两人组成
  且一个人只能参加一个团队
  计算出最多可以派出多少只符合要求的队伍

  输入描述
  5
  3 1 5 7 9
  8
  第一行代表总人数，范围  1~500000
  第二行数组代表每个人的能力
  数组大小范围 1~500000
  元素取值范围 1~500000
  第三行数值为团队要求的最低能力值
  1~500000

  输出描述
  3
  最多可以派出的团队数量

  示例一
  输入
  5
  3 1 5 7 9
  8

  输出
  3

  说明 3、5组成一队   1、7一队  9自己一队  输出3

  7
  3 1 5 7 9 2 6
  8
  输出
  4

  3
  1 1 9
  8
  输出
  1

解题思路：遍历输入的数组，记录大于N的值的数量，将小于N的放进集合里，对集合进行排序，采用双指针，筛选大于N的组合
 */
public class LowestPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int length = sc.nextInt();
            sc.nextLine();
            String[] str = sc.nextLine().split(" ");
            int teams = sc.nextInt();
            int count = 0;
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < length;i++){
                int num = Integer.parseInt(str[i]);
                if(num > teams){
                    count++;
                }else {
                    list.add(num);
                }
            }
            Collections.sort(list);
            int start = 0,end = list.size() - 1;
            while(start < end){
                if(list.get(start) + list.get(end) >= teams){
                    start++;
                    end--;
                    count++;
                }else {
                    start++;
                }
            }
            System.out.println(count);
        }
    }
}
