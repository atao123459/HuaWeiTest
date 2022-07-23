import java.util.*;

/*
2022.7.15

游戏规则：输入一个只包含英文字母的[字符串]，字符串中的两个字母如果相邻且相同，就可以消除。

在字符串上反复执行消除的动作，直到无法继续消除为止，此时游戏结束。

输出最终得到的字符串长度。

# 示例 1

输入：
aaaaaaa

输出：
1

# 示例 2

输入：
abcaacba

输出：
0
 */
public class XiaoXiaoLe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = 0,index2 = 1;
        while(index2 < str.length()){
            if(str.charAt(index) == str.charAt(index2)){
                str = str.replace(str.substring(index,index2 + 1),"");
                //字符串发生改变时指针重置
                index = 0;
                index2 = 1;
            }else {
                index++;
                index2++;
            }
        }
        System.out.println(str.length());
    }
}
