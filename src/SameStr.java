import org.w3c.dom.ls.LSException;

import java.util.*;

/*
给你两个字符串 t 和 p ，要求从 t 中找到一个和 p 相同的连续子串，并输出该字串第一个字符的下标。
输入描述:
输入文件包括两行，分别表示字符串 t 和 p ，保证 t 的长度不小于 p ，且 t 的长度不超过1000000，p 的长度不超过10000。
输出描述:
如果能从 t 中找到一个和 p 相等的连续子串，则输出该子串第一个字符在t中的下标（下标从左到右依次为1,2,3,…）；如果不能则输出”No”；如果含有多个这样的子串，则输出第一个字符下标最小的。
示例1
输入
AVERDXIVYERDIAN
RDXI
输出
4
 */
public class SameStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int left = 0,right = 0,valid = 0,res = 0;
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            need.put(c,need.getOrDefault(c,0) + 1);
        }
        //直接套用滑动窗口模板
        while(right < str1.length()){
            char c = str1.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while(right - left >= str2.length()){//窗口大于等于str2
                if (valid == need.size()){
                    list.add(left);//子串left下标加入集合
                }
                char d = str1.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0) - 1);
                }
            }
        }
        try{
            System.out.println(list.get(0) + 1);//集合中的第0个元素就是子串出现的第一个下标
        }catch (IndexOutOfBoundsException ex){//不存在时会出现异常，需要捕获
            System.out.println("NO");
        }
    }
}
