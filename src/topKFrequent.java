import java.util.*;

/*
2022.8.1

给定一个字符串
 只包含大写字母
 求在包含同一字母的子串中
 长度第K长的子串
 相同字母只取最长的子串

 输入
 第一行 一个子串 1<len<=100
 只包含大写字母
 第二行为k的值

 输出
 输出连续出现次数第k多的字母的次数

 例子：
 输入
 AABAAA
 2
 输出
 1
 同一字母连续出现最多的A 3次
 第二多2次  但A出现连续3次

 输入
 AAAAHHHBBCDHHHH
 3
 输出
 2
 //如果子串中只包含同一字母的子串数小于k
 则输出-1

 */
public class topKFrequent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            int index = sc.nextInt();
            Map<Character,Integer> map = new HashMap<>();
            for(char c : str.toCharArray()){
                map.put(c,map.getOrDefault(c,0) + 1);
            }
            List<Map.Entry<Character,Integer>> entryList = new ArrayList<>(map.entrySet());
            entryList.sort((o1,o2) -> {
                int value1 = o1.getValue();
                int value2 = o2.getValue();
                return value2 - value1;
            });
            System.out.println(entryList.get(index - 1).getValue());
        }
    }
}
