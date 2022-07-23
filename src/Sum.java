import java.util.*;

/*
一个整数可以由连续的自然数之和来表示。给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式。
输入描述:
一个目标整数T (1 <=T<= 1000)
输出描述:
该整数的所有表达式和表达式的个数。如果有多种表达式，输出要求为：
1.自然数个数最少的表达式优先输出
2.每个表达式中按自然数递增的顺序输出，具体的格式参见样例。在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数。
示例1
输入
9
输出
9=9
9=4+5
9=2+3+4
Result:3
说明
整数 9 有三种表示方法，第1个表达式只有1个自然数，最先输出，第2个表达式有2个自然数，第2次序输出，第3个表达式有3个自然数，最后输出。每个表达式中的自然数都是按递增次序输出的。
数字与符号之间无空格
示例2
输入
10
输出
10=10
10=1+2+3+4
Result:2
 */
public class Sum {
    /**
     * 方法一
     * 使用数学公式计算
     * **/
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println(num + "=" + num);
//        int count = 1;
//        // i 表示组成t的连续的数字的个数，从 2个开始，因为1个已经打印过了。
//        for (int i = 2; i * (i - 1) / 2 < num; i++) {
//            int m = 0;
//
//        /*
//        根据数学公式，从m 连续加到n，结果是 t = (m+n)(n-m+1)/2，
//        如果从 m 开始 加 i个数，即从 m 加到 m+i-1 ，得到 t = (2m+i-1)*i/2
//        因此推导出， m = (2*t/i - i + 1 )/ 2 ,
//        如果 m的计算公式中， 2*t/i 没有出现小数点，且 m也没出现小数点，则这就是一个可用的解
//        */
//            if (2 * num % i == 0 && (2 * num / i - i + 1) % 2 == 0) {
//                m = (2 * num / i - i + 1) / 2;
//                count++;
//                System.out.print(num + "=");
//                for (int j = 1; j < i; j++) {
//                    System.out.print(m++ + "+");
//                }
//                System.out.println(m);
//            }
//        }
//        System.out.println("Result:" + count);
//    }

    /**
     * 方法2
     * 使用遍历字符串
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num + "=" + num);
        List<String> list = new ArrayList<>();
        for(int i = 1;i <= num / 2;i++){//外层循环从1遍历到目标数的一半，如果遍历到整个数的话会出现两个num = num的情况
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = i;j <= num;j++){//内循环从i开始顺序累加，判断累加和sum是否等于num，等于就加入list中
                sum += j;
                sb.append(j).append("+");
                if(sum == num){
                    list.add(num + "=" + sb.substring(0,sb.length() - 1));
                    break;
                }else if(sum > num){
                    break;
                }
            }
        }
        for(int i = list.size() - 1;i >= 0;i--){
            System.out.println(list.get(i));
        }
        System.out.println("Result:" + (list.size() + 1));
    }
}
