import java.util.Scanner;

/*
有一个N个整数的数组，和一个长度为M的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止，每次窗口滑动产生一个窗口和（窗口内所有数和和），求窗口滑动产生的所有窗口和的最大值。

第一行输入一个正整数N，表示整数个数。（0<N<100000）

第二行输入N个整数，整数的取值范围为[-100,100]。

第三行输入一个正整数M，M代表窗口大小，M<=100000，且M<=N。
 */
public class WindowSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
        }
        int size = sc.nextInt();//窗口大小
        int start = 0,end = size - 1,sum = 0;
        int max = Integer.MIN_VALUE;
        while(end < nums.length){
            sum = getSum(nums,start,end);
            max = Math.max(max,sum);
            start++;
            end++;
        }
        System.out.println(max);
    }

    public static int getSum(int[] nums,int start,int end){
        int sum = 0;
        for(int i = start;i <= end;i++){
            sum += nums[i];
        }
        return sum;
    }
}
