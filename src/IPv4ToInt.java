import java.util.*;

/*
存在一种虚拟IPv4地址，由4小节组成，每节的范围为0~128，以#号间隔，格式如下：
(1~128)#(0~255)#(0~255)#(0~255)
请利用这个特性把虚拟IPv4地址转换为一个32位的整数，IPv4地址以字符串形式给出，要求每个IPvV4地址只能对应到唯一的整数上。
如果是非法IPv4，返回invalid IP。

输入描述

输入一行，虚拟IPv4地址格式字符串

输出描述

输出一行，按照要求输出整型或者特定字符

示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

100#101#1#5

输出

1684340997

示例2  输入输出示例仅供调试，后台判题数据一般不包含示例

输入

1#2#3

输出

invalid IP
 */
public class IPv4ToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] ip = sc.nextLine().split("#");
            long res = 0;
            if((Integer.parseInt(ip[0]) >= 1 && Integer.parseInt(ip[0]) <= 128) &&
                    (Integer.parseInt(ip[1]) >= 0 && Integer.parseInt(ip[1]) <= 255) &&
                    (Integer.parseInt(ip[2]) >= 0 && Integer.parseInt(ip[2]) <= 255) &&
                    (Integer.parseInt(ip[3]) >= 0 && Integer.parseInt(ip[3]) <= 255) && ip.length == 4){
                for(String s : ip){
                    //ip地址每一位由8位的二进制数组成，2的8次方等于256，所以需要用res乘于256再加上当前位的数据
                    res = res * 256 + Integer.parseInt(s);
                }
                System.out.println("" + res);
            }else {
                System.out.println("invalid IP");
            }
        }
    }
}
