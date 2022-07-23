import java.util.*;

/*
2022.7.22

所谓的水仙花数是指一个n位的正整数其各位数字的n次方的和等于该数本身，
例如153=1^3+5^3+3^3,153是一个三位数
输入描述
    第一行输入一个整数N，
    表示N位的正整数N在3-7之间包含3,7
    第二行输入一个正整数M，
    表示需要返回第M个水仙花数
输出描述
    返回长度是N的第M个水仙花数，
    个数从0开始编号，
    若M大于水仙花数的个数返回最后一个水仙花数和M的乘积，
    若输入不合法返回-1

示例一：

    输入
     3
     0
    输出
     153
    说明：153是第一个水仙花数
 示例二：
    输入
    9
    1
    输出
    -1

 */
public class NumberOfDaffodils {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n < 3 || n > 7){
                System.out.println(-1);
                return;
            }
            //确定数字的范围
            int start = (int) Math.pow(10,n - 1);
            int end = (int) Math.pow(10,n);
            List<Integer> res = new ArrayList<>();
            for(int i = start;i < end;i++){
                int sum = 0;
                List<Integer> numList = getEndNum(i);
                for(int num : numList){
                    sum += Math.pow(num,n);
                }
                if(sum == i){
                    res.add(i);
                }
            }
            System.out.println(res.get(m));
        }
    }

    public static List<Integer> getEndNum(int num){
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            int end = num % 10;
            list.add(end);
            num /= 10;
        }
        return list;
    }
}
