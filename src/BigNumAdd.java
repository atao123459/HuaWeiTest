import java.util.*;

/*
两个超过int型的大数加法
 */
public class BigNumAdd{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            String s1 = str[0];
            String s2 = str[1];
            String s = "";
            int res = 0;
            int carry = 0,length = Math.max(s1.length(),s2.length());
            for(int i = 0;i < length;i++){
                char c1 = '0';
                char c2 = '0';
                if(s1.length() > i){
                    c1 = s1.charAt(s1.length() - i - 1);
                }
                if(s2.length() > i){
                    c2 = s2.charAt(s2.length() - i - 1);
                }
                int a = Integer.parseInt(String.valueOf(c1));
                int b = Integer.parseInt(String.valueOf(c2));
                res = a + b + carry;
                if(res >= 10){
                    carry = 1;
                    res %= 10;
                }else {
                    carry = 0;
                }
                s = res + s;
            }
            if(carry == 1){
                s = carry + s;
            }
            System.out.println(s);
        }
    }
}