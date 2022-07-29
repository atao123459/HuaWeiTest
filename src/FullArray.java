import java.util.*;

/*
2022.7.29

给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。

如：S为ABA，则不同的排列有ABA、AAB、BAA三种。

输入

输入一个长度不超过10的字符串S，我们确保都是大写的。

输出

输出S重新排列的所有不相同的排列数（包含自己本身）。

示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

ABA

输出

3

示例2 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

ABCDEFGHHA

输出

907200
 */
public class FullArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            char[] chars = sc.nextLine().toCharArray();
            List<String> res = new ArrayList<>();
            int n = chars.length;
            backTrack(n,res,chars,0);
            System.out.println(res.size());
        }
    }

    public static void backTrack(int n,List<String> res,char[] chars,int first){
        if(first == n){
            res.add(String.valueOf(chars));
        }
        Set<Character> set = new HashSet<>();
        for(int i = first;i < n;i++){
            if(set.contains(chars[i])){
                continue;
            }
            set.add(chars[i]);
            swap(chars,first,i);
            backTrack(n,res,chars,first + 1);
            swap(chars,first,i);
        }
    }

    public static void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
