import java.util.*;

/*
2022.7.14

描述
查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！

数据范围：字符串长度1\le length \le300 \1≤length≤300
进阶：时间复杂度：O(n^3)\O(n
3
 ) ，空间复杂度：O(n)\O(n)
输入描述：
输入两个字符串

输出描述：
返回重复出现的字符
示例1
输入：
abcdefghijklmnop
abcsafjklmnopqrstuvw
复制
输出：
jklmnop
复制
 */

/**
 * 使用滑动窗口的思想解决
 */
public class LongestCommonStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1;
        String str2;
        while(sc.hasNextLine()){
            str1 = sc.nextLine();
            str2 = sc.nextLine();
            if(str1.length() > str2.length()){
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            int index1 = 0,index2 = index1 + 1;//定义窗口范围
            String common = "";
            while(index2 <= str1.length()){//在较短串中查找
                String window = str1.substring(index1,index2);//截取窗口中的内容
                if(str2.contains(window)){//较长串中是否包含公共串
                    if(common.length() < window.length()){//判断长度，去较长者
                        common = window;
                    }
                    index2++;
                }else {//不包含缩小窗口
                    index1++;
                    index2 = index1 + 1;
                }
            }
            System.out.println(common);
        }
    }
}
