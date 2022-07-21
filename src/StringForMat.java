import java.util.*;

public class StringForMat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pre = str.substring(0,str.indexOf("-") + 1);
        int k = sc.nextInt();
        String[] strs = str.split("-");
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        res.append(pre);
        for(int i = 1;i < strs.length;i++){
            sb.append(strs[i]);
        }
        for(int i = 0;i < sb.length();i++){
            String s = sb.substring(i,3);
            char[] chars = s.toCharArray();
            int low = 0,up = 0;
            for (char aChar : chars) {
                if (Character.isUpperCase(aChar)) {
                    up++;
                } else if (Character.isLowerCase(aChar)) {
                    low++;
                }
            }
            if(low > up){
                s.toLowerCase();
            }else {
                s.toUpperCase();
            }
            res.append(s);
        }
        for(int i = 0;i < res.length();i++){
            System.out.println(sb.substring(0, res.indexOf("-") + 1));

        }
    }
}
