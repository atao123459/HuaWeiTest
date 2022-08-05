import java.util.*;

/*
2022.7.11
给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母（区分大小写）出现的次数，并按照字母出现次数从大到小的顺序输出各个字母及其出现次数。如果次数相同，按照自然顺序进行排序，且小写字母在大写字母之前。
输入描述:
输入一行，为一个仅包含字母的字符串。
输出描述:
按照字母出现次数从大到小的顺序输出各个字母和字母次数，用英文分号分隔，注意末尾的分号；字母和次数间用英文冒号分隔。
示例1
输入
xyxyXX
输出
x:2;y:2;X:2;
说明
每个字符出现的个数都是2，故x排在y之前，而小写字母x在X之前
示例2
输入
abababb
输出
b:4;a:3;
说明
b的出现个数比a多，故b排在a之前
 */
public class CharCountAndResort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        List<Map.Entry<Character,Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1,o2) -> {
            if(o1.getValue().equals(o2.getValue())){
                Character key1 = o1.getKey();
                Character key2 = o2.getKey();
                //字符asc码与A相减大于25为小写，越往后差越大
                //两个小写与A比较
                if(key1 - 'A' > 25 && key2 - 'A' > 25){
                    return key1 - key2;
                }
                //字符asc码与A相减小于26为小写,越往后差越大
                //两个大写与A比较
                if(key1 - 'A' < 26 && key2 - 'A' < 26){
                    return key1 - key2;
                }
                //既有小写又有大写
                return -(key1 - key2);
            }
            return o2.getValue() - o1.getValue();
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : entryList){
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }
        sb.deleteCharAt(sb.length() - 1).append(";");
        System.out.println(sb);
    }
}
