import java.util.Scanner;

/*
非严格递增连续数字序列

给你一个字符串，长度题目好像给了， 最大不超过255个字符（这就看出来，暴力就行，不需要花里胡哨的算法），让你找出最长的一个连续的数字（要求非严格递增，即 12234 这种，递增但不要求严格递增，但不能递减），
比如  abasdf12234sdaf112 ， 最长连续数字是 12234，长度是5，让你返回这个长度。
 */
public class LongestSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = -1;
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            int temp = 1;
            if (Character.isDigit(c1)) {
                for (int j = i + 1; j < str.length(); j++) {
                    char c2 = str.charAt(j);
                    if (c1 <= c2 && Character.isDigit(c2)) {
                        temp++;
                    }else {
                        break;
                    }
                }
                count = Math.max(count, temp);
            }
        }
        if(count == -1){
            System.out.println(0);
        }else {
            System.out.println(count);
        }
    }
}
