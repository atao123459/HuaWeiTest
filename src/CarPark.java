import java.util.*;

/*
2022.7.19

【停车场车辆统计】

特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。

车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3）。

统计停车场最少可以停多少辆车，返回具体的数目。

输入描述

整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。

输出描述

整型数字字符串，表示最少停车数目。

示例1   输入输出示例仅供调试，后台判题数据一般不包含示例

输入

1,0,1

输出

2

说明

1个小车占第1个车位

第二个车位空

1个小车占第3个车位

最少有两辆车

示例2   输入输出示例仅供调试，后台判题数据一般不包含示例

输入

1,1,0,0,1,1,1,0,1

输出

3

说明

1个货车占第1、2个车位

第3、4个车位空

1个卡车占第5、6、7个车位

第8个车位空

1个小车占第9个车位

最少3辆车
 */
public class CarPark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(",");
            int bigCar = 0,midCar = 0,smallCar = 0;
            List<Integer> list = new ArrayList<>();
            int count = 0;
            //关键在于判断字符串中连续1的个数
            for (int i = 0;i < str.length;i++){
                while (i < str.length && str[i].equals("1")){//判断连续1的个数
                    count++;
                    i++;//判断下一位
                }
                list.add(count);
                count = 0;
            }
//            for(int n : list){
//                res += n / 3;
//                if(n % 3 != 0){
//                    res++;
//                }
//            }
            for(int n : list){
                if(n == 1){
                    smallCar++;
                }else if(n == 2){
                    midCar++;
                }else if(n == 3){
                    bigCar++;
                }else {
                    continue;
                }
            }
            System.out.println(smallCar + midCar + bigCar);
        }
    }
}
