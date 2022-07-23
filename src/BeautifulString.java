import java.util.*;

/*
2022.7.11
给出一个名字，该名字有 26
个[字符串]组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。

每个字母都有一个“漂亮度”，范围在 1 到 26 之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。

给出多个名字，计算每个名字最大可能的“漂亮度”。
 */
public class BeautifulString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = sc.nextInt();
            String[] strs = new String[num];
            for (int i = 0; i < num; i++) {
                strs[i] = sc.next();
            }
            for (String s : strs) {
                s = s.toLowerCase();
                System.out.println(count(s));
            }
        }
    }

    public static int count(String s) {
        int res = 0;
        int[] agree = new int[26];//根据字母出现的次数分配权重
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            agree[c - 'a']++;//统计字母出现的次数
        }
        Arrays.sort(agree);
        for (int i = 0; i < 26; i++) {
            res += agree[i] * (i + 1);//权重由高到低分配，26、25、24...  根据出现次数相乘后累加
        }
        return res;
    }
}
