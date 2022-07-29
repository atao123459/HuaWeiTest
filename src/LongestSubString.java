import java.util.*;

/*
2022.7.28

  输入一个字符串仅包含大小写字母和数字
  求字符串中包含的最长的非严格递增连续数字序列长度
  比如：
  12234属于非严格递增数字序列
  示例：
  输入
  abc2234019A334bc
  输出
  4
  说明：
  2234为最长的非严格递增连续数字序列，所以长度为4

  输入
  aaaaaa44ko543j123j7345677781
  输出
  8

  输入
  aaaaa34567778a44ko543j123j71
  输出
  8

  输入
  345678a44ko543j123j7134567778aa
  输出
  9

  输入
  fwefksoSKJF12S45DS3DSAJKSldsf565441345sd1f87151234657812154341543
  输出
  5

 */
public class LongestSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
//            char[] chars = sc.nextLine().toCharArray();
            int max = 0;
            int temp = 0;

            /*
            方法1
            如果用例全是数字会有bug
            如果最长串出现在结尾也会有bug
             */
//            char last = 'a';
//            for(char c : chars){
//                if(Character.isDigit(c)){
//                    if(temp == 0){
//                        temp++;
//                    }else if(c >= last){
//                        temp++;
//                    }else {
//                        max = Math.max(max,temp);
//                        temp = 1;
//                    }
//                    last = c;
//                }else {
//                    max = Math.max(max,temp);
//                    temp = 0;
//                }
//            }
//            System.out.println(max);

            /*
            方法2
            比方法1好一点，但是通过率未知
             */
            for(int i = 0;i < str.length();i++){
                char c = str.charAt(i);
                if(Character.isDigit(c)) {
                    int index = i;
                    while (index < str.length() && Character.isDigit(str.charAt(index)) && c <= str.charAt(index)) {
                        temp++;
                        c = str.charAt(index);
                        index++;
                    }
                }
                max = Math.max(max,temp);
                temp = 0;
            }
            System.out.println(max);
        }
    }
}
