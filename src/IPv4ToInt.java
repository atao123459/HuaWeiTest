import java.util.*;

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
