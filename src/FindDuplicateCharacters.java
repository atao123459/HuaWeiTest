import java.util.*;

/*
2022.7.23

题目描述：
给定两个字符串，
从字符串2中找出字符串1中的所有字符，
去重并按照ASCII码值从小到大排列，

输入描述
字符范围满足ASCII编码要求，
输入字符串1长度不超过1024，
字符串2长度不超过100

输出描述
按照ASCII由小到大排序

示例一
输入
bach
bbaaccddfg

输出
abc

示例二
输入
fach
bbaaccedfg

输出
acf

 */
public class FindDuplicateCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            List<Character> list = new ArrayList<>();
            for(char c: str2.toCharArray()){
                list.add(c);
            }
            List<Character> res = new ArrayList<>();
            for(int i = 0;i < str1.length();i++){
                char c = str1.charAt(i);
                if(list.contains(c) && !res.contains(c)){
                    res.add(c);
                }
            }
            Collections.sort(res);
            for(char c : res){
                System.out.print(c);
            }
        }
    }
}
