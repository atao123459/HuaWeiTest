import java.util.*;

/*
2022.7.19

  定义当一个字符串只有元音字母(a,e,i,o,u,A,E,I,O,U)组成,
  称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，
  并返回其长度，如果找不到请返回0，
  字符串中任意一个连续字符组成的子序列称为该字符串的子串
  <p>
  输入描述：
  一个字符串其长度 0<length ,字符串仅由字符a-z或A-Z组成
  输出描述：
  一个整数，表示最长的元音字符子串的长度
  <p>
  示例1：
  输入
  asdbuiodevauufgh
  输出
  3
  说明：
  最长的元音字符子串为uio和auu长度都为3，因此输出3

 */
public class LongestVowelString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            char[] str = sc.nextLine().toCharArray();
            List<Character> vowelList = new ArrayList<>();
            //a,e,i,o,u,A,E,I,O,U
            vowelList.add('a');
            vowelList.add('e');
            vowelList.add('i');
            vowelList.add('o');
            vowelList.add('u');
            vowelList.add('A');
            vowelList.add('E');
            vowelList.add('I');
            vowelList.add('O');
            vowelList.add('U');
            int max = Integer.MIN_VALUE;
            int count = 0;
            for(int i = 0;i < str.length;i++){
                while(i < str.length && vowelList.contains(str[i])){
                    count++;
                    i++;
                }
                max = Math.max(max,count);
                count = 0;
            }
            System.out.println(max);
        }
    }
}
