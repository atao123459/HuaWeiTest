import java.util.*;

/*
1.输入字符串s输出s中包含所有整数的最小和，
说明：1字符串s只包含a~z,A~Z,+,-，
2.合法的整数包括正整数，一个或者多个0-9组成，如：0,2,3,002,102
3.负整数，负号开头，数字部分由一个或者多个0-9组成，如-2,-012,-23,-00023
输入描述：包含数字的字符串
输出描述：所有整数的最小和
示例：
  输入：
    bb1234aa
　输出
    10
　输入：
    bb12-34aa
　输出：
    -31
说明：1+2-(34)=-31
 */
public class StringMinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] strChar = str.toCharArray();
        int res = 0;
        for (int i = 0; i < strChar.length; i++) {
            char c = strChar[i];
            if (c == '-') {
                i++;
                int start = i;//记下负号位置
                while (i < strChar.length && Character.isDigit(strChar[i])) {//下标一直后移，直到不是数字为止
                    i++;
                }
                String funum = str.substring(start, i);//截取负数
                res -= Integer.parseInt(funum);//res减负数  Integer.parseInt(funum)会得到一个无符号数
                i--;
                continue;
            }
            if (Character.isDigit(c)) {
                int num = Character.digit(c,10);//char转int，后面带着的是进制
                res += num;
            }
        }
        System.out.println(res);
    }
}
