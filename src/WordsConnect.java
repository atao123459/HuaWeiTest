import java.util.*;

/*
2022.7.17

单词接龙的规则是：
用于接龙的单词首字母必须要前一个单词的尾字母相同；
当存在多个首字母相同的单词时，取长度最长的单词，如果长度也相等，则取[字典序]最小的单词；
已经参与接龙的单词不能重复使用。
现给定一组全部由小写字母组成单词[数组]，并指定其中的一个单词作为起始单词，进行单词接龙。

请输出最长的单词串，单词串是单词拼接而成，中间没有空格。

**输入描述：**
输入的第一行为一个非负整数，表示起始单词在数组中的索引K，0 <= K < N。
输入的第二行为一个非负整数，表示单词的个数N。
接下来的N行，分别表示单词数组中的单词。

**输出描述：**
输出一个字符串，表示最终拼接的单词串。

**备注：**
单词个数N的取值范围为[1, 20]
单个单词的长度的取值范围为[1, 30]

# 示例 1

输入：
0
6
word
dd
da
dc
dword
d

输出：
worddwordda

> 说明：
>
> 先确定起始单词word，再接以d开头的且长度最长的单词dword，剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，所以最后输出worddwordda。

# 示例 2

输入：
4
6
word
dd
da
dc
dword
d

输出：
dwordda

> 说明：
> 先确定起始单词dword，剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，所以最后输出dwordda。
 */
public class WordsConnect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            int index = sc.nextInt();
            int nums = sc.nextInt();
            sc.nextLine();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < nums; i++) {
                list.add(sc.nextLine());
            }
            String start = list.get(index);
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            list.sort((o1,o2) -> {
               if(o1.length() == o2.length()){
                   return o1.compareTo(o2);
               }
               return o2.length() - o1.length();
            });
            char c = start.charAt(start.length() - 1);
            for(String s : list){
                if(s.charAt(0) == c && !s.equals(start)){
                    c = s.charAt(s.length() - 1);
                    sb.append(s);
                }
            }
            System.out.println(sb);
        }
    }
}
