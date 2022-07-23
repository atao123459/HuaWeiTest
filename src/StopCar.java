import java.util.Scanner;

/*
停车场有一横排车位，0代表没有停车，1代表有车。至少停了一辆车在车位上，也至少有一个空位没有停车。
为了防剐蹭，需为停车人找到一个车位，使得距停车人的车最近的车辆的距离是最大的，返回此时的最大距离。
输入描述:
1、一个用半角逗号分割的停车标识字符串，停车标识为0或1，0为空位，1为已停车。
2、停车位最多100个。
输出描述:
输出一个整数记录最大距离。
示例1
输入
1,0,0,0,0,1,0,0,1,0,1
输出
2
说明
当车停在第3个位置上时，离其最近的的车距离为2（1到3）。
当车停在第4个位置上时，离其最近的的车距离为2（4到6）。
其他位置距离为1。
因此最大距离为2。
 */
public class StopCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] nums = new int[str.length];
        for(int i = 0;i < str.length;i++){
            int num = Integer.parseInt(str[i]);
            nums[i] = num;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1){//i元素为1时跳过当前循环，找到第一个0元素的位置
                continue;
            }
            //maxDistance方法计算当前位置到左右的最大距离
            max = Math.max(max,maxDistance(nums,i));
        }
        System.out.println(max);
    }

    public static int maxDistance(int[] nums,int index){
        int left = 0,right = 0;
        for(int i = 0;i < index;i++){//找到左边车的下标
            if(nums[i] == 1){
                left = i;
            }
        }
        for(int i = index;i < nums.length;i++){//找到右边车的下标
            if(nums[i] == 1){
                right = i;
                break;
            }
        }
        return Math.min(index - left, right - index);//计算到两边的距离
    }
}
