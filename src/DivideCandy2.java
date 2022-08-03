import java.util.*;

/*
2022.8.3

【分糖果II】

Solo和koko是两兄弟，妈妈给了他们一大袋糖，每块糖上都有自己的重量。

现在他们想要将这些糖分成两堆。

分糖的任务当然落到了大哥Solo的身上，然而koko要求必须两个人获得的糖的总重量“相等”（根据Koko的逻辑），要不然就会哭的。

非常不幸的是，koko还非常小，并且他只会先将两个数转成二进制再进行加法，而且总会忘记进位。

如当12（1100）加5（101）时：

1100

+ 0101

————

1001

于是koko得到的计算结果是9（1001）。

此外还有一些例子：

5 + 4 = 1

7 + 9 = 14

50 + 10 = 56

现在Solo非常贪婪，他想要尽可能使自己得到的糖的总重量最大，且不让koko哭。

输入

输入的第一行是一个整数N(2 ≤ N ≤ 15)，表示有袋中多少块糖。

第二行包含N个用空格分开的整数Weighti (1 ≤ Weighti ≤ 10^6)，表示第i块糖的重量。

输出

如果能让koko不哭，输出Solo所能获得的糖的总重量，否则输出“NO”。

示例 1   输入输出示例仅供调试，后台判题数据一般不包含示例

输入

3

3 5 6

输出

11

思路：异或操作，遍历数组进行异或操作，如果最后结果得到0，说明能够成功分糖，数组元素之和减掉最小的元素就是答案
 */
public class DivideCandy2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] candys = new int[n];
            for(int i = 0;i < n;i++){
                candys[i] = sc.nextInt();
            }
            System.out.println(divide(candys));
        }
    }

    public static String divide(int[] candys){
        if(candys.length == 1 || candys.length == 0 || (candys.length == 2 && candys[0] != candys[1])){
            return "NO";
        }
        //先取第一个元素作为最小值
        int min = candys[0];
        int temp = min,sum = min;
        for(int i = 1;i < candys.length;i++){
            sum += candys[i];
            min = Math.min(min, candys[i]);
            //每一个数进行异或操作
            temp ^= candys[i];
        }
        if(temp != 0){
            return "NO";
        }else {
            return String.valueOf(sum - min);
        }
    }
}
