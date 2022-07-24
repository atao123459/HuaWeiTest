import java.util.*;

/*
2022.7.23

 有N个正整数组成的一个序列
 给定一个整数sum
 求长度最长的的连续子序列使他们的和等于sum
 返回次子序列的长度
 如果没有满足要求的序列 返回-1
 案例1：
 输入
 1,2,3,4,2
 6
 输出
 3
 解析：1,2,3和4,2两个序列均能满足要求
 所以最长的连续序列为1,2,3 因此结果为3

 示例2：
 输入
 1,2,3,4,2
 20
 输出
 -1
 解释：没有满足要求的子序列，返回-1

 备注： 输入序列仅由数字和英文逗号构成
 数字之间采用英文逗号分割
 序列长度   1<=N<=200
 输入序列不考虑异常情况
 由题目保证输入序列满足要求

 */
public class LongestContinuousSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(",");
            int sum = sc.nextInt();
//            sc.nextLine();
            int[] nums = new int[str.length];
            int max = -1;
            for(int i = 0;i < str.length;i++){
                nums[i] = Integer.parseInt(str[i]);
            }
            for(int i = 0;i < nums.length;i++){
                if(nums[i] == sum){
                    max = Math.max(max,1);
                }else if(nums[i] < sum){
                    int start = i;
                    int temp = 0;
                    while(start < nums.length){
                        temp += nums[start];
                        if(temp == sum){
                            max = Math.max(max,start - i + 1);
                            break;
                        }else if(temp > sum){
                            break;
                        }else {
                            start++;
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}
