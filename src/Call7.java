import java.util.*;

/*
2022.7.22

 喊7 是一个传统的聚会游戏
    N个人围成一圈
    按顺时针从1-7编号
    编号为1的人从1开始喊数
    下一个人喊得数字是上一个人喊得数字+1
    但是当将要喊出数字7的倍数或者含有7的话
    不能喊出 而是要喊过

    假定N个人都没有失误。
    当喊道数字k时
    可以统计每个人喊 “过"的次数

    现给定一个长度n的数组
    存储打乱的每个人喊”过"的次数
    请把它还原成正确顺序

    即数组的第i个元素存储编号i的人喊“过“的次数

       输入为1行
       空格分割的喊过的次数
       注意k并不提供

       k不超过200
       数字个数为n
       输出描述

       输出为1行
       顺序正确的喊过的次数  空格分割

       例子
       输入
         0 1 0
       输出
         1 0 0

       只有一次过
       发生在7
       按顺序编号1的人遇到7  所以100
       结束时的k不一定是7 也可以是 8 9
         喊过都是100

         例子
       输入
         0 0 0 2 1
       输出
         0 2 0 1 0
       一共三次喊过
       发生在7 14 17
       编号为2 的遇到7 17
       编号为4 的遇到14

 */
public class Call7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int sum = 0;
            for (String s : str) {
                sum += Integer.parseInt(s);//喊过次数求和
            }
            List<Integer> list = new ArrayList<>();
            for(int i = 1;i < 200;i++){
                if(i % 7 == 0 || String.valueOf(i).contains("7")){
                    list.add(i);//找到7的倍数和含7的数字
                }
            }
            //求7的倍数和含7数字的另一种方法
            //从0到sum*7的范围内找，因为喊的次数总和乘于7就是最后喊到的数
            //for(int i = 0;i < sum * 7;i++){
            //                if(i % 7 == 0 || String.valueOf(i).contains("7")){
            //                    list.add(i);//找到7的倍数和含7的数字
            //                }
            //            }
            int length = str.length;
            int[] res = new int[length];
            for(int i = 0;i < sum;i++){
                //list中相应位置的数与总人数取模得到对应喊7的人
                res[(list.get(i) % length) - 1]++;
            }
            for(int n : res){
                System.out.print(n + " ");
            }
        }
    }
}
