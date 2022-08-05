import java.util.*;

/*
2022.8.5

【数组组成的最小数字】

给定一个整型数组，请从该数组中选择3个元素组成最小数字并输出

（如果数组长度小于3，则选择数组中所有元素来组成最小数字）。

输入描述

一行用半角逗号分割的字符串记录的整型数组，0 < 数组长度 <= 100，0 < 整数的取值范围 <= 10000。

输出描述

由3个元素组成的最小数字，如果数组长度小于3，则选择数组中所有元素来组成最小数字。

示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

21,30,62,5,31

输出

21305

说明

数组长度超过3，需要选3个元素组成最小数字，21305由21,30,5三个元素组成的数字，为所有组合中最小的数字。

示例2 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

5,21

输出

215

说明

数组长度小于3， 选择所有元素来组成最小值，215为最小值。
 */
public class MinNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(",");
            if(str.length == 1){
                System.out.println(str[0]);
                return;
            }else if(str.length < 3){
                int num1 = Integer.parseInt(str[0] + str[1]);
                int num2 = Integer.parseInt(str[1] + str[0]);
                System.out.println(Math.min(num1, num2));
            }else {
                //先对数组升序排序
                Arrays.sort(str, (o1, o2) -> {
                    return Integer.parseInt(o1) - Integer.parseInt(o2);
                });
                //取前三个最小元素
                String[] min = Arrays.copyOf(str,3);
                //组合，类似小根堆的创建
                Arrays.sort(min,(o1,o2) -> (o1 + o2).compareTo(o2 + o1));
                StringBuilder sb = new StringBuilder();
                for(String s : min){
                    sb.append(s);
                }
                System.out.println(sb);
            }
        }
    }
}
