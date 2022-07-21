import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
字体解压缩

有一种简易压缩算法：针对全部由小写英文字母组成的字符串，将其中连续超过两个相同字母的部分压缩为连续个数加该字母，其他部分保持原样不变。例如：字符串“aaabbccccd”经过压缩成为字符串“3abb4cd”。 请您编写解压函数，根据输入的字符串，判断其是否为合法压缩过的字符串，若输入合法则输出解压缩后的字符串，否则输出字符串“!error”来报告错误。
输入描述:
输入一行，为一个ASCII字符串，长度不会超过100字符，用例保证输出的字符串长度也不会超过100字符
输出描述:
若判断输入为合法的经过压缩后的字符串，则输出压缩前的字符串；若输入不合法，则输出字符串“!error”。
示例1
输入
4dff
输出
ddddff
说明
4d扩展为dddd，故解压后的字符串为ddddff
示例2
输入
2dff
输出
!error
说明
两个d不需要压缩，故输入不合法
示例3
输入
4d@A
输出
!error
说明
全部由小写英文字母组成的字符串压缩后不会出现特殊字符@和大写字母A，故输入不合法
 */
public class StringUnzip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.contains("2")) {
            System.out.println("!error");
            System.exit(0);
        }
        List<String> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 1;
        while (index2 < str.length()) {
            int times = 0;
            char c1 = str.charAt(index1);
            char c2 = str.charAt(index2);

            if (!Character.isDigit(c1) && !Character.isLetter(c1)) {
                System.out.println("!error");
                System.exit(0);
            }
            if (Character.isDigit(c1)) {
                times = Integer.parseInt(String.valueOf(c1));
                for (int j = 0; j < times; j++) {
                    list.add(String.valueOf(c2));
                }
            }
            if (c1 == c2) {
                list.add(String.valueOf(c1));
            } else if (c1 != c2 && Character.isLetter(c1) && Character.isLetter(c2)) {
                list.add(String.valueOf(c2));
            }
            index1++;
            index2++;
        }
        for (String s : list) {
            System.out.print(s);
        }
    }
}
